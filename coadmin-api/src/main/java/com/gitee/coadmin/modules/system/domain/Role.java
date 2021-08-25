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
* @author jinjin
* @date 2020-09-25
*/
@Data
@TableName("sys_role")
public class Role extends DataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名称")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "名称首字母")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String nameLetter;

    @ApiModelProperty(value = "角色级别")
    private Integer level;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "数据权限")
    private String dataScope;

    public void copyFrom(Role source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
