# coadmin
在 eladmin-mybatisplus-dao 2.6的基础上，增加和修改一些东西。

## 对应前端vue代码 coadmin-web-quasar
[Github](https://github.com/jinjingmail/coadmin-web-quasar)
[Gitee](https://gitee.com/jinjinge/coadmin-web-quasar)

## 代码仓库
[Github](https://github.com/jinjingmail/coadmin)
[Gitee](https://gitee.com/jinjinge/coadmin)

# 测试账号
demo/123456
admin/123456
其他用户的密码也是123456

** TODO **
  - TODO BUG 定时任务不能正常暂停
  - TODO RoleDto 的 menus和depts字段，使用简化的类型
  - TODO mybatis plus 不能通过 updateById 将一个值改为null
  - TODO 删除菜单，同步删除子菜单、菜单-角色关联
  - TODO 修改机构可用状态后，user.dataScopes 没有更新
  - TODO QueryParam.blurry 增加新配置，比如：@Query(blurry = "id=eq,treeNames,name=like,desc=like_right")

** 2020-10-09 **
- bug fix:修正用户缓存导致的修改头像不能正确显示问题
- 初步实现用户-机构多对多映射

# 界面截图
## PC上的效果
![user](https://gitee.com/jinjinge/coadmin-web-quasar/raw/main/public/img/screen.jpg)
