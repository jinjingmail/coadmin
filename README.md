# coadmin
在 eladmin-mybatisplus-dao 2.6的基础上，增加和修改一些东西。

管理系统的功能，跟eladmin几乎一样：
- 用户管理：提供用户的相关配置，新增用户后，默认密码为123456
- 角色管理：对权限与菜单进行分配，可根据部门设置角色的数据权限
- 菜单管理：已实现菜单动态路由，后端可配置化，支持多级菜单
- 部门管理：可配置系统组织架构，树形表格展示
- 岗位管理：配置各个部门的职位
- 字典管理：可维护常用一些固定的数据，如：状态，性别等
- 系统日志：记录用户操作日志与异常日志，方便开发人员定位排错
- SQL监控：采用druid 监控数据库访问性能，默认用户名admin，密码123456
- 定时任务：整合Quartz做定时任务，加入任务日志，任务运行情况一目了然
- 代码生成：高灵活度生成前后端代码，减少大量重复的工作任务
- 邮件工具：配合富文本，发送html格式的邮件
- 七牛云存储：可同步七牛云存储的数据到系统，无需登录七牛云直接操作云数据
- 支付宝支付：整合了支付宝支付
- 服务监控：监控服务器的负载情况

## 代码仓库
[Github](https://github.com/jinjingmail/coadmin)
[Gitee](https://gitee.com/jinjinge/coadmin)

## 对应前端 coadmin-web-quasar
[Github](https://github.com/jinjingmail/coadmin-web-quasar)
[Gitee](https://gitee.com/jinjinge/coadmin-web-quasar)

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

# DEMO
管理系统的功能，跟eladmin几乎是一样的，所以可以看 [eladmin](https://gitee.com/elunez/eladmin) 的 DEMO。
跟eladmin不同的是，前端UI基于 [quasar-admin-template](https://gitee.com/jinjinge/quasar-admin-template) 开发，所以前端UI的样子可以看这个的DEMO。

# 界面截图
## PC上的效果
![user](https://gitee.com/jinjinge/coadmin-web-quasar/raw/main/public/img/screen.jpg)
