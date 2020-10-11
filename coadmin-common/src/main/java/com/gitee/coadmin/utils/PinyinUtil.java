package com.gitee.coadmin.utils;

import cn.hutool.core.util.StrUtil;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * 汉字转拼音（判断常见姓氏多音字）
 * Created by jinjin on 2020-04-05.
 */
public class PinyinUtil {
    public static void main(String[] args) {
        System.out.println(getAllFirstPinyin("订单"));
        System.out.println(getAllFirstPinyin("单露露"));
        System.out.println(getAllFirstPinyin("查良镛"));
        System.out.println(getAllFirstPinyin("长沙"));
        System.out.println(getAllFirstPinyin("长大"));
        System.out.println(getAllFirstPinyin("重庆"));
        System.out.println(getAllFirstPinyin("重慶"));
        System.out.println(getAllFirstPinyin("翟瑞光"));
        System.out.println(getAllFirstPinyin("梁女士"));
        System.out.println(getAllFirstPinyin("中國中華"));
        System.out.println(getAllFirstPinyin("欧阳在线"));
        System.out.println(getAllFirstPinyin("宝安妇幼保健院"));
        System.out.println(getAllFirstPinyin("abcde(f1)2（34）5"));
        System.out.println(getAllFirstPinyin("abcd单露露ef1号源的2345"));
    }

    public static String getAllFirstPinyin(String chinese) {
        if(StrUtil.isBlank(chinese)) {
            return null;
        }
        try {
            chinese = StrUtil.removeAll(chinese, '(', ')', '（', '）', '.', '。', '，','\'',
                    '"', '\\', '[', ']', '?', '<', '>', '*', ' ');
            if(chinese.length() <= 3) {
                // 姓氏多音字
                if (StrUtil.startWith(chinese, '单')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 's');
                } else if (StrUtil.startWith(chinese, '覃')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'q');
                } else if (StrUtil.startWith(chinese, '谌')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 's');
                } else if (StrUtil.startWith(chinese, '翟')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'z');
                } else if (StrUtil.startWith(chinese, '乐')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'y');
                } else if (StrUtil.startWith(chinese, '召')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 's');
                } else if (StrUtil.startWith(chinese, '隗')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'k');
                } else if (StrUtil.startWith(chinese, '种')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'c');
                } else if (StrUtil.startWith(chinese, '宓')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'f');
                } else if (StrUtil.startWith(chinese, '莘')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 's');
                } else if (StrUtil.startWith(chinese, '区')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'o');
                } else if (StrUtil.startWith(chinese, '行')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'h');
                } else if (StrUtil.startWith(chinese, '解')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'x');
                } else if (StrUtil.startWith(chinese, '查')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'z');
                } else if (StrUtil.startWith(chinese, '仇')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'q');
                } else if (StrUtil.startWith(chinese, '曾')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'z');
                } else if (StrUtil.startWith(chinese, '幺')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'y');
                } else if (StrUtil.startWith(chinese, '秘')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'b');
                } else if (StrUtil.startWith(chinese, '冼')) {
                    chinese = StrUtil.replace(chinese, 0, 1, 'x');
                }
            }
            return PinyinHelper.getShortPinyin(chinese);
        } catch (PinyinException e) {
            e.printStackTrace();
            return null;
        } catch (Throwable e) {
            return null;
        }
    }
}
