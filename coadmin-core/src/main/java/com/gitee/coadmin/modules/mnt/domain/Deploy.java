package com.gitee.coadmin.modules.mnt.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.gitee.coadmin.base.DataEntity;

import java.io.Serializable;

/**
* @author jinjin
* @date 2020-09-27
*/
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("mnt_deploy")
public class Deploy extends DataEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "ID")
    @TableId(value="id", type= IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "应用编号")
    private Long appId;

    public void copyFrom(Deploy source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
