package com.gitee.coadmin.modules.system.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
* @author jinjin
* @date 2020-09-24
*/
@Getter
@Setter
@NoArgsConstructor
public class DictDetailSmallDto implements Serializable {
    private Long id;
    private String label;
    private String value;
}
