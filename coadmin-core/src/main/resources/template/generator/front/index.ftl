<template>
  <div>
    <co-dialog title="查找" no-max seamless ref="search" @before-hide="crud.props.filterTable=''">
      <q-input style="width:180px" placeholder="在当前页查找" dense outlined v-model="crud.props.filterTable" clearable class="q-mx-sm q-mt-none q-mb-sm"/>
    </co-dialog>

    <!-- 编辑表单对话框 -->
    <co-dialog
      ref="formDialog"
      :value="crud.status.cu > 0"
      :title="crud.status.title"
      no-backdrop-dismiss
      @before-hide="crud.cancelCU"
      card-style="width:600px; max-width:95vw;"
    >
      <co-form
        ref="form"
        label-width="medium"
        label-align="right"
        class="q-pa-md row q-col-gutter-x-xl q-col-gutter-y-md">
<#if columns??>
  <#list columns as column>
    <#if column.formShow>
        <#assign formLabel="${column.changeColumnName}"/>
        <#if column.remark != ''><#assign formLabel="${column.remark}"/></#if>
      <#if column.formType = 'Input'>
        <co-input dense class="col-12" form-label="${formLabel}" v-model="form.${column.changeColumnName}" :disable="!!crud.status.view"
              <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Textarea'>
        <co-input dense class="col-12" form-label="${formLabel}" v-model="form.${column.changeColumnName}" :disable="!!crud.status.view" type="textarea"
              <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Radio'>
        <co-option-group
            class="col-12"
            dense
            form-label="${formLabel}"
            v-model="form.${column.changeColumnName}"
            value-to-string
            :disable="!!crud.status.view"
            inline
            :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Radio</#if>'
            type="radio"
            <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Checkbox'>
        <co-option-group
            class="col-12"
            dense
            form-label="${formLabel}"
            v-model="form.${column.changeColumnName}"
            value-to-string
            :disable="!!crud.status.view"
            inline
            :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Checkbox</#if>'
            type="checkbox"
            <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Select'>
        <co-select
            v-model="form.${column.changeColumnName}"
            class="col-12"
            dense
            options-dense
            form-label="${formLabel}"
            :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Select</#if>'
            :disable="!!crud.status.view"
            no-filter
            clearable
            emit-value
            map-options
            <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Date'>
        <co-date-select
            class="col-12"
            dense
            form-label="${formLabel}"
            :value="form.${column.changeColumnName}"
            @input="val => form.${column.changeColumnName}=val"
            clearable
            :disable="!!crud.status.view"
           <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if> >
          <template v-slot:append>
            <q-icon name="event" />
          </template>
        </co-date-select>
      <#elseif column.formType = 'DateRange'>
        <co-date-select
            class="col-12"
            form-label="${formLabel}"
            dense
            v-model="form.${column.changeColumnName}"
            range
            :default-time="[' 00:00:00', ' 23:59:59']"
            clearable
            :disable="!!crud.status.view"
           <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if> >
          <template v-slot:append>
            <q-icon name="event" />
          </template>
        </co-date-select>
      <#else>
        <co-field dense class="col-12" form-label="${formLabel}" readonly>
          <template v-slot:control><#if column.columnType = 'Date'>{{parseTime(form.${column.changeColumnName}}}<#else>{{form.${column.changeColumnName}}}</#if></template>
        </co-field>
      </#if>
    </#if>
  </#list>
</#if>
      </co-form>
      <q-card-actions class="q-pa-md" align="right">
        <q-btn label="取消" flat v-close-popup/>
        <q-btn label="保存" icon="check" color="primary" v-if="!crud.status.view" @click="crud.submitCU"
               :loading="crud.status.cu === crud.STATUS_PROCESSING" :disable="crud.status.cu === crud.STATUS_PROCESSING"/>
      </q-card-actions>
    </co-dialog>

    <co-table
        ref="table"
        row-key="id"
        dense
        :data="crud.data"
        :columns="crud.columns"
        :visible-columns="crud.visibleColumns"
        :title="crud.title"
        :loading="crud.loading"
        selection="single"
        :selected.sync="crud.selections"
        :filter="crud.props.filterTable"
        @row-click="(evt, row, index) => crud.selections = [row]"
    >
      <template v-slot:top-right="props">
        <div class='row q-col-gutter-x-sm q-col-gutter-y-xs q-pa-xs full-width'>
<#if hasQuery>
  <#list queryColumns as column>
    <#assign formLabel="${column.changeColumnName}"/>
    <#if column.remark != ''><#assign formLabel="${column.remark}"/></#if>

    <#if column.formType = 'Radio' || column.formType = 'Checkbox' || column.formType = 'Select'>
          <co-select
              v-model="query.${column.changeColumnName}"
              dense
              options-dense
              placeholder="${formLabel}"
              content-style="width:120px"
              no-filter
              use-input
              fill-input
              hide-selected
              :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Select</#if>'
              @input="crud.toQuery()"
              clearable
              emit-value
              map-options
          />
    <#elseif column.formType ='Date' || column.formType ='DateRange' || column.columnType = 'Date'>
      <#if column.queryType = 'BetWeen'>
          <co-date-select
              v-model="query.${column.changeColumnName}"
              dense
              placeholder="${formLabel}"
              content-style="width:200px"
              range
              :default-time="[' 00:00:00', ' 23:59:59']"
              @input="crud.toQuery()"
              clearable
          />
      <#else>
          <co-date-select
              v-model="query.${column.changeColumnName}"
              dense
              placeholder="${formLabel}"
              content-style="width:120px"
              @input="crud.toQuery()"
              clearable
          />
      </#if>
    <#else>
          <co-input
              v-model="query.${column.changeColumnName}"
              dense
              placeholder="${formLabel}"
              content-style="width:120px"
          />
    </#if>
  </#list>
          <div>
            <q-btn dense padding="xs sm" color="primary" icon="search" @click="crud.toQuery()" />
          </div>
          <q-space/>
</#if>
          <!--如果想在工具栏加入更多按钮，可以使用插槽方式， 'start' or 'end'-->
          <crud-operation dense :permission="permission" />
          <div>
            <q-btn-dropdown dense color="primary" class="btn-dropdown-hide-droparrow" icon="apps" auto-close>
              <crud-more :tableSlotTopProps="props">
                <template v-slot:start>
                  <q-btn flat align="left" label="在当前页查找" icon="find_in_page" @click.native="$refs.search.show()" />
                  <q-separator/>
                </template>
              </crud-more>
            </q-btn-dropdown>
          </div>
        </div>
      </template>

<#if columns??>
  <#list columns as column>
    <#if column.columnType = 'Date'>
      <template v-slot:body-cell-${column.changeColumnName}="props">
        <q-td key="${column.changeColumnName}" :props="props">
          {{formatTime(props.row.${column.changeColumnName})}}
        </q-td>
      </template>
      <#elseif (column.dictName)?? && (column.dictName)!="">
      <template v-slot:body-cell-${column.changeColumnName}="props">
        <q-td key="${column.changeColumnName}" :props="props">
          {{dict.label.${column.dictName}[props.row.${column.changeColumnName}]}}
        </q-td>
      </template>
    </#if>
  </#list>
</#if>

      <template v-slot:body-cell-action="props">
        <q-td key="action" :props="props">
          <crud-row
              flat
              dense
              :type="$q.screen.gt.xs?'button':'menu'"
              :data="props.row"
              :permission="permission"
              no-add
          />
        </q-td>
      </template>

      <template v-slot:pagination>
        <crud-pagination dense />
      </template>

    </co-table>
  </div>
</template>

<script>
<#if hasDict>import { mapGetters } from 'vuex'</#if>
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import crudOperation from '@crud/CRUD.operation'
import crudPagination from '@crud/CRUD.pagination'
import crudRow from '@crud/CRUD.row'
import crudMore from '@crud/CRUD.more'
import crud${className} from '@/api/${changeClassName}'

const defaultForm = { <#if columns??><#list columns as column>${column.changeColumnName}: null<#if column_has_next>, </#if></#list></#if> }

const visibleColumns = [<#if columns??><#list columns as column><#if column.listShow>'${column.changeColumnName}', </#if></#list></#if>'action']
// 参考：https://quasar.dev/vue-components/table#Defining-the-columns
const columns = [
<#if columns??><#list columns as column>
  <#assign formLabel="${column.changeColumnName}"/>
  <#if column.remark != ''><#assign formLabel="${column.remark}"/></#if>
  { name: '${column.changeColumnName}', field: '${column.changeColumnName}', label: '${formLabel}', align: 'left' },
</#list></#if>
  { name: 'action', label: '操作', align: 'center', required: false, sortable: false }
]

export default {
  name: '${className}',
  components: { crudOperation, crudMore, crudPagination, crudRow },
  cruds() {
    return CRUD({ columns, visibleColumns, title: '${apiAlias}', idField: '${pkChangeColName}', sort: ['${pkChangeColName},desc'], url: 'api/${changeClassName}', crudMethod: { ...crud${className} } })
  },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  data () {
    return {
      /*
      rules: {
        <#if isNotNullColumns??>
        <#list isNotNullColumns as column>
        <#if column.istNotNull>
        ${column.changeColumnName}: [
          { required: true, message: '<#if column.remark != ''>${column.remark}</#if>不能为空', trigger: 'blur' }
        ]<#if column_has_next>,</#if>
        </#if>
        </#list>
        </#if>
      },*/
      permission: {
        add: ['admin', '${changeClassName}:add'],
        edit: ['admin', '${changeClassName}:edit'],
        del: ['admin', '${changeClassName}:del']
      }
    }
  },
<#if hasDict>
  computed: {
    ...mapGetters('permission', [
      'dict'
    ])
  },
</#if>
  methods: {
  }
}
</script>

<style scoped>

</style>
