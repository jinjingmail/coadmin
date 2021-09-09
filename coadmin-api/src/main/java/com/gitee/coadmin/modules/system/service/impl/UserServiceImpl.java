package com.gitee.coadmin.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.gitee.coadmin.modules.system.domain.UsersDepts;
import com.gitee.coadmin.modules.system.service.mapper.UsersDeptsMapper;
import com.gitee.coadmin.utils.SecurityUtils;
import com.gitee.coadmin.utils.FileUtil;
import lombok.AllArgsConstructor;
import com.gitee.coadmin.base.PageInfo;
import com.gitee.coadmin.utils.QueryHelpMybatisPlus;
import com.gitee.coadmin.base.impl.BaseServiceImpl;
import com.gitee.coadmin.config.FileProperties;
import com.gitee.coadmin.exception.BadRequestException;
import com.gitee.coadmin.exception.EntityExistException;
import com.gitee.coadmin.modules.system.domain.User;
import com.gitee.coadmin.modules.system.domain.UsersJobs;
import com.gitee.coadmin.modules.system.domain.UsersRoles;
import com.gitee.coadmin.modules.system.service.mapper.UsersJobsMapper;
import com.gitee.coadmin.modules.system.service.mapper.UsersRolesMapper;
import com.gitee.coadmin.modules.system.service.*;
import com.gitee.coadmin.modules.system.service.dto.UserDto;
import com.gitee.coadmin.modules.system.service.dto.UserQueryParam;
import com.gitee.coadmin.modules.security.service.OnlineUserService;
import com.gitee.coadmin.modules.security.service.UserCacheClean;
import com.gitee.coadmin.modules.system.service.mapper.UserMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author jinjin
* @date 2020-09-25
*/
@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "user")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final FileProperties properties;
    private final com.gitee.coadmin.utils.RedisUtils redisUtils;
    private final UserCacheClean userCacheClean;
    private final OnlineUserService onlineUserService;

    private final UserMapper userMapper;
    private final DeptService deptService;
    private final UsersRolesService usersRolesService;
    private final UsersJobsService usersJobsService;
    private final UsersDeptsService usersDeptsService;

    private final UsersRolesMapper usersRolesMapper;
    private final UsersJobsMapper usersJobsMapper;
    private final UsersDeptsMapper usersDeptsMapper;

    @Override
    //@Cacheable
    public PageInfo<UserDto> queryAll(UserQueryParam query, Pageable pageable) {
        IPage<User> page = com.gitee.coadmin.utils.PageUtil.toMybatisPage(pageable);
        IPage<User> pageData = userMapper.selectPage(page, QueryHelpMybatisPlus.getPredicate(query));
        List<UserDto> userDtos = com.gitee.coadmin.utils.ConvertUtil.convertList(pageData.getRecords(), UserDto.class);
        if (pageData.getTotal() > 0) {
            QueryWrapper<UsersDepts> userDeptWrapper = new QueryWrapper<>();
            userDeptWrapper.lambda().in(UsersDepts::getUserId, userDtos.stream().map(UserDto::getId).collect(Collectors.toSet()));
            Map<Long, Set<UsersDepts>> usersDeptsMap = usersDeptsMapper.selectList(userDeptWrapper).stream()
                    .collect(Collectors.groupingBy(UsersDepts::getUserId, Collectors.toSet()));

            QueryWrapper<UsersRoles> userRoleWrapper = new QueryWrapper<>();
            userRoleWrapper.lambda().in(UsersRoles::getUserId, userDtos.stream().map(UserDto::getId).collect(Collectors.toSet()));
            Map<Long, Set<UsersRoles>> usersRolesMap = usersRolesMapper.selectList(userRoleWrapper).stream()
                    .collect(Collectors.groupingBy(UsersRoles::getUserId, Collectors.toSet()));

            QueryWrapper<UsersJobs> userJobWrapper = new QueryWrapper<>();
            userJobWrapper.lambda().in(UsersJobs::getUserId, userDtos.stream().map(UserDto::getId).collect(Collectors.toList()));
            Map<Long, List<UsersJobs>> usersJobsMap = usersJobsMapper.selectList(userJobWrapper).stream()
                    .collect(Collectors.groupingBy(UsersJobs::getUserId));

            userDtos.forEach(user -> {
                if (usersDeptsMap.containsKey(user.getId())) {
                    user.setDepts(usersDeptsMap.get(user.getId()).stream().map(UsersDepts::getDeptId).collect(Collectors.toSet()));
                }

                if (usersRolesMap.containsKey(user.getId())) {
                    user.setRoles(usersRolesMap.get(user.getId()).stream().map(UsersRoles::getRoleId).collect(Collectors.toSet()));
                }
                if (usersJobsMap.containsKey(user.getId())) {
                    user.setJobs(usersJobsMap.get(user.getId()).stream().map(UsersJobs::getJobId).collect(Collectors.toSet()));
                }
            });
        }
        return new PageInfo<>(pageData.getTotal(), userDtos);
    }

    @Override
    //@Cacheable
    public List<UserDto> queryAll(UserQueryParam query){
        return com.gitee.coadmin.utils.ConvertUtil.convertList(userMapper.selectList(QueryHelpMybatisPlus.getPredicate(query)), UserDto.class);
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    @Cacheable(key = "'id:' + #p0")
    public UserDto findById(Long id) {
        return com.gitee.coadmin.utils.ConvertUtil.convert(getById(id), UserDto.class);
    }

    @Override
    public User getByUsername(String userName) {
        if (StrUtil.isBlank(userName)) {
            return null;
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, userName);
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    @Override
    @Cacheable(key = "'username:' + #p0")
    public UserDto findByName(String userName) {
        if (StrUtil.isBlank(userName)) {
            return null;
        }
        UserDto dto = com.gitee.coadmin.utils.ConvertUtil.convert(getByUsername(userName), UserDto.class);
        //TODO dto.setDepts();
        //dto.setRoles();
        //dto.setJobs();
        return dto;
    }

    private User getByEmail(String email) {
        if (StrUtil.isBlank(email)) {
            return null;
        }
        Wrapper<User> wrapper = new QueryWrapper<User>().eq("email", email);
        return userMapper.selectOne(wrapper);
    }
    private User getByPhone(String phone) {
        if (StrUtil.isBlank(phone)) {
            return null;
        }
        Wrapper<User> wrapper = new QueryWrapper<User>().eq("phone", phone);
        return userMapper.selectOne(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(UserDto resources) {
        User user = getByUsername(resources.getUsername());
        if (user != null) {
            throw new EntityExistException(User.class, "username", user.getUsername());
        }
        if (StrUtil.isNotBlank(resources.getEmail())) {
            user = getByEmail(resources.getEmail());
            if (user != null) {
                throw new EntityExistException(User.class, "email", resources.getEmail());
            }
        }
        if (StrUtil.isNotBlank(resources.getEmail())) {
            user = getByPhone(resources.getPhone());
            if (user != null) {
                throw new EntityExistException(User.class, "phone", resources.getPhone());
            }
        }

        user = com.gitee.coadmin.utils.ConvertUtil.convert(resources, User.class);

        /*if (resources.getDept() != null) {
            user.setDeptId(resources.getDept().getId());
        }*/

        int ret = userMapper.insert(user);
        final Long userId = user.getId();

        if (CollectionUtils.isNotEmpty(resources.getDepts())) {
            resources.getDepts().forEach(deptId -> {
                UsersDepts ud = new UsersDepts();
                ud.setUserId(userId);
                ud.setDeptId(deptId);
                usersDeptsMapper.insert(ud);
            });
        }

        if (CollectionUtils.isNotEmpty(resources.getRoles())) {
            resources.getRoles().forEach(roleId -> {
                UsersRoles ur = new UsersRoles();
                ur.setUserId(userId);
                ur.setRoleId(roleId);
                usersRolesMapper.insert(ur);
            });
        }
        if (CollectionUtils.isNotEmpty(resources.getJobs())) {
            resources.getJobs().forEach(jobId -> {
                UsersJobs uj = new UsersJobs();
                uj.setUserId(userId);
                uj.setJobId(jobId);
                usersJobsMapper.insert(uj);
            });
        }
        return ret > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(UserDto resources){
        User user = getById(resources.getId());
        User user1 = getByUsername(user.getUsername());
        User user2 = getByEmail(user.getEmail());
        User user3 = getByPhone(user.getPhone());
        if (user1 != null && !user.getId().equals(user1.getId())) {
            throw new EntityExistException(User.class, "username", user.getUsername());
        }
        if (user2 != null && !user.getId().equals(user2.getId())) {
            throw new EntityExistException(User.class, "email", user.getEmail());
        }
        if (user3 != null && !user.getId().equals(user3.getId())) {
            throw new EntityExistException(User.class, "phone", user.getPhone());
        }

        //usersRolesService.getUsersRoleList(resources.getId());
        // 如果用户的角色改变
        //if (!resources.getRoles().equals(xxxx.getRoles())) {
            redisUtils.del(com.gitee.coadmin.utils.CacheKey.DATE_USER + resources.getId());
            redisUtils.del(com.gitee.coadmin.utils.CacheKey.MENU_USER + resources.getId());
            redisUtils.del(com.gitee.coadmin.utils.CacheKey.ROLE_AUTH + resources.getId());
        //}

        // 如果用户名称修改
        if(!resources.getUsername().equals(user.getUsername())){
            throw new BadRequestException("不能修改用户名");
        }
        // 如果用户被禁用，则清除用户登录信息
        if(!resources.getEnabled()){
            onlineUserService.kickOutForUsername(resources.getUsername());
        }
        if (CollectionUtils.isNotEmpty(resources.getRoles())) {
            usersRolesService.removeByUserId(resources.getId());
            resources.getRoles().forEach(roleId -> {
                UsersRoles ur = new UsersRoles();
                ur.setUserId(resources.getId());
                ur.setRoleId(roleId);
                usersRolesMapper.insert(ur);
            });
        }

        if (CollectionUtils.isNotEmpty(resources.getJobs())) {
            usersJobsService.removeByUserId(resources.getId());
            resources.getJobs().forEach(jobId -> {
                UsersJobs uj = new UsersJobs();
                uj.setUserId(resources.getId());
                uj.setJobId(jobId);
                usersJobsMapper.insert(uj);
            });
        }

        if (CollectionUtils.isNotEmpty(resources.getDepts())) {
            usersDeptsService.removeByUserId(resources.getId());
            resources.getDepts().forEach(deptId -> {
                UsersDepts ud = new UsersDepts();
                ud.setUserId(resources.getId());
                ud.setDeptId(deptId);
                usersDeptsMapper.insert(ud);
            });
        }

        user.setUsername(resources.getUsername());
        user.setEmail(resources.getEmail());
        user.setEnabled(resources.getEnabled());

        user.setPhone(resources.getPhone());
        user.setNickName(resources.getNickName());
        user.setGender(resources.getGender());

        delCaches(user.getId(), user.getUsername());
        return userMapper.updateById(user) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePass(String username, String encryptPassword) {
        UpdateWrapper<User> updater = new UpdateWrapper<>();
        updater.lambda().eq(User::getUsername, username);
        User user = new User();
        user.setPassword(encryptPassword);
        user.setPwdResetTime(new Date());
        userMapper.update(user, updater);
        redisUtils.del("user::username:" + username);
        flushCache(username);
    }

    @Override
    public Map<String, String> updateAvatar(MultipartFile multipartFile) {
        User user = getByUsername(SecurityUtils.getCurrentUsername());
        String oldPath = user.getAvatarPath();
        File file = com.gitee.coadmin.utils.FileUtil.upload(multipartFile, properties.getPath().getAvatar());
        user.setAvatarName(file.getName());
        user.setAvatarPath(Objects.requireNonNull(file).getPath());
        userMapper.updateById(user);
        if (StrUtil.isNotBlank(oldPath)) {
            com.gitee.coadmin.utils.FileUtil.del(oldPath);
        }
        delCaches(user.getId(), user.getUsername());
        return new HashMap<String, String>() {
            {
                put("avatar", file.getName());
            }
        };
    }

    @Override
    public void updateEmail(String username, String email) {
        User user = getByUsername(username);
        User user2 = getByEmail(email);
        if (user2 != null && ObjectUtil.notEqual(user.getId(), user2.getId())) {
            throw new EntityExistException(User.class, "email", email);
        }
        UpdateWrapper<User> updater = new UpdateWrapper<>();
        updater.lambda().eq(User::getUsername, username);
        User userUpdate = new User();
        userUpdate.setEmail(email);
        userMapper.update(userUpdate, updater);
        delCaches(user.getId(), user.getUsername());
    }

    @Override
    public void updateCenter(User resources) {
        User user2 = getByPhone(resources.getPhone());
        if (user2 != null && ObjectUtil.notEqual(resources.getId(), user2.getId())) {
            throw new EntityExistException(User.class, "phone", resources.getPhone());
        }
        UpdateWrapper<User> updater = new UpdateWrapper<>();
        updater.lambda().eq(User::getId, resources.getId());
        User userUpdate = new User();
        userUpdate.setPhone(resources.getPhone());
        userUpdate.setGender(resources.getGender());
        userUpdate.setNickName(resources.getNickName());
        userMapper.update(userUpdate, updater);
        redisUtils.del("user::username:" + resources.getUsername());
        delCaches(resources.getId(), resources.getUsername());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Set<Long> ids){
        for (Long id: ids) {
            User user = getById(id);
            delCaches(user.getId(), user.getUsername());
            usersRolesService.removeByUserId(id);
            usersJobsService.removeByUserId(id);
            usersDeptsService.removeByUserId(id);
        }
        return userMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    @Transactional
    public boolean removeById(Long id){
        Set<Long> ids = new HashSet<>(1);
        ids.add(id);
        return this.removeByIds(ids);
    }

    @Override
    public void download(List<UserDto> all, HttpServletResponse response) throws IOException {
      List<Map<String, Object>> list = new ArrayList<>();
      for (UserDto user : all) {
        Map<String,Object> map = new LinkedHashMap<>();
              map.put("用户名", user.getUsername());
              map.put("昵称", user.getNickName());
              map.put("性别", user.getGender());
              map.put("手机号码", user.getPhone());
              map.put("邮箱", user.getEmail());
              map.put("头像地址", user.getAvatarName());
              map.put("头像真实路径", user.getAvatarPath());
              map.put("密码", user.getPassword());
              map.put("是否为admin账号", user.getIsAdmin());
              map.put("状态：1启用、0禁用", user.getEnabled());
              map.put("创建者", user.getCreateBy());
              map.put("更新着", user.getUpdateBy());
              map.put("修改密码的时间", user.getPwdResetTime());
              map.put("创建日期", user.getCreateTime());
              map.put("更新时间", user.getUpdateTime());
        list.add(map);
      }
      FileUtil.downloadExcel(list, response);
    }

    /**
     * 清理缓存
     *
     * @param id /
     */
    public void delCaches(Long id, String username) {
        redisUtils.del(com.gitee.coadmin.utils.CacheKey.USER_ID + id);
        redisUtils.del(com.gitee.coadmin.utils.CacheKey.USER_NAME + username);
        flushCache(username);
    }

    /**
     * 清理 登陆时 用户缓存信息
     *
     * @param username /
     */
    private void flushCache(String username) {
        userCacheClean.cleanUserCache(username);
    }
}
