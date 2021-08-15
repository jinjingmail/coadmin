<template>
  <div>
    <co-dialog title="查找" no-max ref="search" @before-hide="crud.props.filterTable=''" @show="$refs.findInCurrentPage.focus()">
      <co-input ref="findInCurrentPage" style="width:180px" placeholder="在当前页查找" outlined v-model="crud.props.filterTable" clearable class="q-mx-sm q-mt-none q-mb-sm"/>
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
        label-width="small"
        label-align="right"
        class="q-pa-md row q-col-gutter-x-md q-col-gutter-y-md">
<#if columns??>
  <#list columns as column>
    <#if column.formShow>
        <#assign formLabel="${column.changeColumnName}"/>
        <#if column.remark != ''><#assign formLabel="${column.remark}"/></#if>
      <#if column.formType = 'Input'>
        <co-input class="col-12" form-label="${formLabel}" v-model="form.${column.changeColumnName}" :disable="!!crud.status.view"
                  <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Textarea'>
        <co-input class="col-12" form-label="${formLabel}" v-model="form.${column.changeColumnName}" :disable="!!crud.status.view" autogrow
                  <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Radio'>
        <co-field class="col-12" form-label="${formLabel}" :disable="!!crud.status.view" :value="form.${column.changeColumnName}" <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>>
          <template v-slot:control>
            <co-option-group
                v-model="form.${column.changeColumnName}"
                value-to-string
                :disable="!!crud.status.view"
                inline
                :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Radio</#if>'
                type="radio"
            />
          </template>
        </co-field>
      <#elseif column.formType = 'Checkbox'>
        <co-field class="col-12" form-label="${formLabel}" :disable="!!crud.status.view" :value="form.${column.changeColumnName}" <#if column.istNotNull>:rules="[ val => (val && val.length > 0) || '必填' ]"</#if>>
          <template v-slot:control>
            <co-option-group
                v-model="form.${column.changeColumnName}"
                value-to-string
                :disable="!!crud.status.view"
                inline
                :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Checkbox</#if>'
                type="checkbox"
            />
          </template>
        </co-field>
      <#elseif column.formType = 'Select'>
        <co-select
            v-model="form.${column.changeColumnName}"
            class="col-12"
            form-label="${formLabel}"
            :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Select</#if>'
            :disable="!!crud.status.view"
            no-filter
            emit-value
            map-options
            <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if>/>
      <#elseif column.formType = 'Date'>
        <co-date-select
            class="col-12"
            form-label="${formLabel}"
            :value="formatTime(form.${column.changeColumnName}, '{y}-{m}-{d}')"
            date-mask="YYYY-MM-DD"
            @input="val => form.${column.changeColumnName}=val"
            :disable="!!crud.status.view"
           <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if> />
      <#elseif column.formType = 'DateRange'>
        <co-date-select
            class="col-12"
            form-label="${formLabel}"
            v-model="form.${column.changeColumnName}"
            range
            :default-time="['00:00:00', '23:59:59']"
            date-mask="YYYY-MM-DD"
            :disable="!!crud.status.view"
           <#if column.istNotNull>:rules="[ val => (!!val) || '必填' ]"</#if> />
      <#else>
        <co-field class="col-12" form-label="${formLabel}" :value="<#if column.columnType = 'Date'>parseTime(form.${column.changeColumnName}, '{y}-{m}-{d} {h}:{i}:{s}')<#else>form.${column.changeColumnName}</#if>" readonly borderless v-show="form.${column.changeColumnName}"/>
      </#if>
    </#if>
  </#list>
</#if>
      </co-form>
      <q-card-actions class="q-pa-md" align="right">
        <co-btn label="取消" flat v-close-popup/>
        <co-btn label="保存" color="primary"
                v-if="!crud.status.view"
                @click="crud.submitCU"
               :loading="crud.status.cu === crud.STATUS_PROCESSING"
               :disable="crud.status.cu === crud.STATUS_PROCESSING"/>
      </q-card-actions>
    </co-dialog>

    <co-table
        ref="table"
        row-key="id"
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
      <template v-slot:top-left>
        <div class='row q-col-gutter-x-sm q-col-gutter-y-xs q-pa-xs full-width'>
<#if hasQuery>
  <#list queryColumns as column>
          <#assign formLabel="${column.changeColumnName}"/>
          <#if column.remark != ''><#assign formLabel="${column.remark}"/></#if>
          <#if column.formType = 'Radio' || column.formType = 'Checkbox' || column.formType = 'Select'>
          <co-select
              v-model="query.${column.changeColumnName}"
              label="${formLabel}"
              content-style="width:160px"
              no-filter
              use-input
              fill-input
              hide-selected
              :options='dict.<#if (column.dictName)?? && (column.dictName)!="">${column.dictName}<#else>未设置字典，请手动设置 Select</#if>'
              @input="crud.toQuery()"
              emit-value
              map-options
              clearable
          />
          <#elseif column.formType = 'Date' || column.formType = 'DateRange' || column.columnType = 'Date'>
            <#if column.queryType = 'BetWeen'>
          <co-date-select
              v-model="query.${column.changeColumnName}"
              label="${formLabel}"
              content-style="width:230px"
              range
              edit-time
              :default-time="['00:00:00', '23:59:59']"
              date-mask="YYYY-MM-DD"
              clearable
              @input="crud.toQuery()"
          />
            <#else>
          <co-date-select
              v-model="query.${column.changeColumnName}"
              label="${formLabel}"
              content-style="width:160px"
              @input="crud.toQuery()"
              date-mask="YYYY-MM-DD"
              clearable
          />
            </#if>
          <#else>
          <co-input
              v-model="query.${column.changeColumnName}"
              label="${formLabel}"
              content-style="width:160px"
              @keyup.enter="crud.toQuery()"
          />
          </#if>
  </#list>
          <!-- 点击“更多..”才显示的搜索项 -->
          <template v-if="crud.props.queryMore">
          </template>
          <div>
            <co-btn icon="search" color="primary" @click="crud.toQuery()" />
            <co-btn label="重置" flat @click="crud.resetQuery()" />
            <co-btn :label="crud.props.queryMore?'«更少':'更多»'" flat @click="crud.props.queryMore = !crud.props.queryMore"/>
          </div>
          <q-space/>
</#if>
        </div>
      </template>
      <template v-slot:top-right="props">
        <div class='row q-col-gutter-x-sm q-col-gutter-y-xs q-pa-xs full-width'>
          <!--如果想在工具栏加入更多按钮，可以使用插槽方式， 'start' or 'end'-->
          <crud-operation :permission="permission" no-label no-view no-edit/>
          <div>
            <co-btn-dropdown color="primary" class="btn-dropdown-hide-droparrow" icon="apps" auto-close>
              <crud-more :tableSlotTopProps="props">
                <template v-slot:start>
                  <co-btn flat align="left" label="在当前页查找" icon="find_in_page" @click.native="$refs.search.show()" />
                  <q-separator/>
                </template>
              </crud-more>
            </co-btn-dropdown>
          </div>
        </div>
      </template>

      <template v-slot:body-cell-action="props">
        <q-td key="action" :props="props">
          <crud-row
              type="button"
              :data="props.row"
              :permission="permission"
              no-add
              no-icon
          />
        </q-td>
      </template>

      <template v-slot:pagination>
        <crud-pagination />
      </template>

    </co-table>
  </div>
</template>

<script>
<#if hasDict>
import { mapGetters } from 'vuex'
import { getDictLabel } from '@/utils/store'
</#if>
<#if hasDate>import { formatTime } from '@/utils/index'</#if>
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import CrudOperation from '@crud/crud-operation'
import CrudPagination from '@crud/crud-pagination'
import CrudRow from '@crud/crud-row'
import CrudMore from '@crud/crud-more'
import Crud${className} from '@/api/${minusClassName}'

const defaultForm = { <#if columns??><#list columns as column>${column.changeColumnName}: null<#if column_has_next>, </#if></#list></#if> }

const visibleColumns = [<#if columns??><#list columns as column><#if column.listShow>'${column.changeColumnName}', </#if></#list></#if>'action']
// 参考：https://quasar.dev/vue-components/table#Defining-the-columns
const columns = [
<#if columns??><#list columns as column>
  <#assign formLabel="${column.changeColumnName}"/>
  <#if column.remark != ''><#assign formLabel="${column.remark}"/></#if>
  { name: '${column.changeColumnName}', field: '${column.changeColumnName}', label: '${formLabel}', align: 'left'<#if column.columnType = 'Date'>, format: val => formatTime(val)<#elseif (column.dictName)?? && (column.dictName)!="">, format: val => getDictLabel('${column.dictName}', val)</#if> },
</#list></#if>
  { name: 'action', label: '操作', align: 'center', required: false, sortable: false }
]

export default {
  name: '${className}',
  components: { CrudOperation, CrudMore, CrudPagination, CrudRow },
  cruds() {
    return CRUD({ columns, visibleColumns, title: '${apiAlias}', idField: '${pkChangeColName}', sort: ['${pkChangeColName},desc'], url: 'api/${minusClassName}', crudMethod: { ...Crud${className} } })
  },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  data () {
    return {
      permission: {
        view: ['admin', '${changeClassName}:list'],
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
  created () {
    this.crud.updateProp('queryMore', false)
  },
  mounted () {
  },
  methods: {
    [CRUD.HOOK.beforeRefresh] () {
      console.log('${changeClassName} CRUD.HOOK.beforeRefresh')
    }
  }
}
</script>

<style scoped>

</style>
