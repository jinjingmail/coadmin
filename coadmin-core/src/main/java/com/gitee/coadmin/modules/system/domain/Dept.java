package com.gitee.coadmin.modules.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.gitee.coadmin.utils.PinyinUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.gitee.coadmin.base.DataEntity;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 机构
* @author jinjin
* @date 2020-09-25
*/
@Data
@TableName("sys_dept")
public class Dept extends DataEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "机构编码")
    private String deptCode;

    @ApiModelProperty(value = "名称")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "名称首字母")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String nameLetter;

    @ApiModelProperty(value = "排序")
    @NotNull
    private Integer sort;

    @ApiModelProperty(value = "上级ID")
    private Long pid;

    @ApiModelProperty(value = "所有上级ID,'/'分隔")
    private String treePids;

    @ApiModelProperty(value = "是否叶子节点1=是0=否")
    private Boolean treeLeaf;

    @ApiModelProperty(value = "含所有父节点的名称,'/'分隔")
    private String treeNames;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String treeNamesLetter;

    @ApiModelProperty(value = "含所有父节点的排序,'/'分隔")
    private String treeSorts;

    @ApiModelProperty(value = "层级，从0开始")
    private Integer treeLevel;

    @ApiModelProperty(value = "状态")
    @NotNull
    private Boolean enabled;

    public void copyFrom(Dept source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
