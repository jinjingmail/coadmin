/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.gitee.coadmin.modules.system.rest;

import cn.hutool.core.collection.CollectionUtil;
import com.gitee.coadmin.annotation.UnifiedAPI;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.modules.system.domain.vo.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import com.gitee.coadmin.modules.logging.annotation.Log;
import com.gitee.coadmin.modules.system.domain.Menu;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.modules.system.service.MenuService;
import com.gitee.coadmin.modules.system.service.dto.MenuDto;
import com.gitee.coadmin.modules.system.service.dto.MenuQueryParam;
import com.gitee.coadmin.modules.system.service.mapper.MenuMapper;
import com.gitee.coadmin.utils.ConvertUtil;
import com.gitee.coadmin.utils.PageUtil;
import com.gitee.coadmin.modules.tools.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Zheng Jie
 * @date 2018-12-03
 */
@UnifiedAPI
@RestController
@RequiredArgsConstructor
@Api(tags = "系统：菜单管理")
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;
    private final MenuMapper menuMapper;
    private static final String ENTITY_NAME = "menu";

    @Log("查询菜单")
    @ApiOperation("查询菜单")
    @GetMapping
    @PreAuthorize("@el.check('menu:list')")
    public PageInfo<MenuDto>  query(MenuQueryParam criteria) throws Exception {
        return menuService.buildTree(criteria);
    }

    @ApiOperation("返回全部的菜单")
    @GetMapping(value = "/lazy")
    @PreAuthorize("@el.check('menu:list','roles:list')")
    public List<MenuDto>  query(@RequestParam Long pid){
        return menuService.getMenus(pid);
    }

    @GetMapping(value = "/build")
    @ApiOperation("获取前端所需菜单")
    public List<MenuVo>  buildMenus(){
        List<MenuDto> menuDtoList = menuService.findByUser(SecurityUtils.getCurrentUserId());
        List<MenuDto> menuDtos = menuService.buildTree(menuDtoList);
        return menuService.buildMenus(menuDtos);
    }

    @Log("查询菜单")
    @ApiOperation("查询菜单:根据ID获取同级与上级数据")
    @PostMapping("/superior")
    @PreAuthorize("@el.check('menu:list')")
    public List<MenuDto>  getSuperior(@RequestBody List<Long> ids) {
        Set<MenuDto> menuDtos = new LinkedHashSet<>();
        if(CollectionUtil.isNotEmpty(ids)){
            for (Long id : ids) {
                MenuDto menuDto = menuService.findById(id);
                menuDtos.addAll(menuService.getSuperior(menuDto, new ArrayList<>()));
            }
            return menuService.buildTree(new ArrayList<>(menuDtos));
        }
        return menuService.getMenus(null);
    }

    @Log("新增菜单")
    @ApiOperation("新增菜单")
    @PostMapping
    @PreAuthorize("@el.check('menu:add')")
    public Integer create(@Validated @RequestBody Menu resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return menuService.save(resources)?1:0;
    }

    @Log("修改菜单")
    @ApiOperation("修改菜单")
    @PutMapping
    @PreAuthorize("@el.check('menu:edit')")
    public Integer update(@Validated(Menu.Update.class) @RequestBody Menu resources){
        return menuService.updateById(resources)?1:0;
    }

    @Log("删除菜单")
    @ApiOperation("删除菜单")
    @DeleteMapping
    @PreAuthorize("@el.check('menu:del')")
    public Integer delete(@RequestBody Set<Long> ids){
        Set<Menu> menuSet = new HashSet<>();
        for (Long id : ids) {
            List<MenuDto> menuList = menuService.getMenus(id);
            menuSet.add(menuService.getById(id));
            menuSet = menuService.getDeleteMenus(ConvertUtil.convertList(menuList, Menu.class), menuSet);
        }
        //return menuService.removeByIds(ids)?1:0;
        Set<Long> deleteIds = menuSet.stream().map(Menu::getId).collect(Collectors.toSet());
        return menuService.removeByIds(deleteIds)?1:0;
    }

    @Log("导出菜单数据")
    @ApiOperation("导出菜单数据")
    @UnifiedAPI(enable = false)
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('menu:list')")
    public void download(HttpServletResponse response, MenuQueryParam criteria) throws Exception {
        menuService.download(menuService.queryAll(criteria, false), response);
    }

}
