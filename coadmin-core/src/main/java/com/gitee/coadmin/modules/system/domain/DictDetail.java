package com.gitee.coadmin.modules.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.gitee.coadmin.modules.system.service.dto.DictSmallDto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
* @author jinjin
* @date 2020-09-24
*/
@Data
@TableName("sys_dict_detail")
public class DictDetail implements Serializable {

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type= IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "字典id")
    @NotNull
    private Long dictId;

    @ApiModelProperty(value = "字典标签")
    @NotBlank
    private String label;

    @ApiModelProperty(value = "字典值")
    @NotBlank
    private String value;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "创建者")
    @TableField(fill= FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "更新者")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private String updateBy;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill= FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public void copyFrom(DictDetail source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
