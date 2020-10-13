package com.gitee.coadmin.modules.system;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.gitee.coadmin.modules.system.domain.Dept;
import com.gitee.coadmin.modules.system.service.dto.DeptCompactDto;
import com.gitee.coadmin.utils.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ThinkPad on 2020-10-08.
 */
public class Test {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(12L);
        list.add(123L);
        list.add(212L);
        list.add(112L);

        String sql = "SELECT DISTINCT user_id FROM sys_users_depts WHERE dept_id IN(?) AND ?";

        System.out.println(StrUtil.replace(sql, "?", StringUtils.join(list, ",")));
    }
}
