package com.gitee.coadmin.modules.quartz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

import java.io.Serializable;
import java.util.Date;

/**
* @author jinjin
* @date 2020-09-27
*/
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_quartz_log")
public class QuartzLog implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type= IdType.ASSIGN_ID)
    @JsonSerialize(using= ToStringSerializer.class) // 防止精度丢失
    private Long id;

    private String beanName;

    @TableField(fill= FieldFill.INSERT)
    private Date createTime;

    private String cronExpression;

    private String exceptionDetail;

    private Boolean isSuccess;

    private String jobName;

    private String methodName;

    private String params;

    private Long time;

    public void copyFrom(QuartzLog source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
