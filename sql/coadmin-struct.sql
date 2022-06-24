/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.12 : Database - coadmin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `app_user` */

CREATE TABLE `app_user` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `is_enabled` bit(1) NOT NULL COMMENT '状态',
  `channel` tinyint(3) unsigned NOT NULL COMMENT '渠道(1=wxmp;2=wxliteapp;...)',
  `openid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'openid',
  `unionid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信unionid',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号（已注册标识）',
  `nickname` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `nickname_letter` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称首字母',
  `gender` tinyint(3) unsigned DEFAULT NULL COMMENT '1男、2女、3未知',
  `headimgurl` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像URL',
  `country` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '国家',
  `province` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '省份',
  `city` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '城市',
  `lang` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '国家地区语言版本',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_OPENID` (`openid`),
  UNIQUE KEY `UNI_MOBILE` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='APP用户';

/*Table structure for table `code_column_config` */

CREATE TABLE `code_column_config` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `table_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `column_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `column_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `extra` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `form_show` bit(1) DEFAULT NULL,
  `form_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `key_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `list_show` bit(1) DEFAULT NULL,
  `not_null` bit(1) DEFAULT NULL,
  `query_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date_annotation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_table_name` (`table_name`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='代码生成字段信息存储';

/*Table structure for table `code_gen_config` */

CREATE TABLE `code_gen_config` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `table_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作者',
  `cover` bit(1) DEFAULT NULL COMMENT '是否覆盖',
  `module_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模块名称',
  `sub_module_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子模块名称',
  `pack` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '至于哪个包下',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '前端代码生成的路径',
  `api_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '前端Api文件路径',
  `prefix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表前缀',
  `api_alias` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '接口名称',
  `menu_pid` bigint(20) DEFAULT NULL COMMENT '父级菜单（用于自动生成sql）',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_table_name` (`table_name`(100))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='代码生成器配置';

/*Table structure for table `sys_dept` */

CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` bigint(20) NOT NULL COMMENT '上级id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构名称',
  `name_letter` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称首字母',
  `sort` int(11) NOT NULL DEFAULT '999' COMMENT '本节点排序',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '机构编码',
  `tree_pids` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所有上级id,''/''分隔',
  `tree_names` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '含所有父节点的名称,''/''分隔',
  `tree_names_letter` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '首字母',
  `tree_sorts` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '含所有父节点的排序,''/''分隔',
  `tree_level` int(11) NOT NULL COMMENT '层级，从0开始',
  `tree_leaf` bit(1) NOT NULL COMMENT '是否叶子节点1=是0=否',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime NOT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `inx_pid` (`pid`),
  KEY `inx_enabled` (`enabled`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='公司&部门';

/*Table structure for table `sys_dict` */

CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='数据字典';

/*Table structure for table `sys_dict_detail` */

CREATE TABLE `sys_dict_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dict_id` bigint(20) DEFAULT NULL COMMENT '字典id',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典标签',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK5tpkputc6d9nboxojdbgnpmyb` (`dict_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='数据字典详情';

/*Table structure for table `sys_job` */

CREATE TABLE `sys_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位名称',
  `enabled` bit(1) NOT NULL COMMENT '岗位状态',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_name` (`name`),
  KEY `inx_enabled` (`enabled`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='岗位';

/*Table structure for table `sys_log` */

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `log_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `request_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `browser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `exception_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `log_create_time_index` (`create_time`),
  KEY `inx_log_type` (`log_type`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='系统日志';

/*Table structure for table `sys_menu` */

CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级菜单ID',
  `sub_count` int(11) DEFAULT '0' COMMENT '子菜单数目',
  `type` int(11) DEFAULT NULL COMMENT '0=目录，1=菜单，2=按钮',
  `title` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单标题',
  `title_letter` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题首字母',
  `component_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件名称',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图标',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '链接地址',
  `i_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `cache` bit(1) DEFAULT b'0' COMMENT '缓存',
  `hidden` bit(1) DEFAULT b'0' COMMENT '隐藏',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_componentname` (`component_name`),
  KEY `inx_pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='系统菜单';

/*Table structure for table `sys_quartz_job` */

CREATE TABLE `sys_quartz_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bean_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Spring Bean名称',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'cron 表达式',
  `is_pause` bit(1) DEFAULT NULL COMMENT '状态：true暂停、false启用',
  `job_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务名称',
  `method_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '方法名称',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '参数',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `person_in_charge` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '负责人',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '报警邮箱',
  `sub_task` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子任务ID',
  `pause_after_failure` bit(1) DEFAULT NULL COMMENT '任务失败后是否暂停',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `inx_is_pause` (`is_pause`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='定时任务';

/*Table structure for table `sys_quartz_log` */

CREATE TABLE `sys_quartz_log` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `bean_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `exception_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `is_success` bit(1) DEFAULT NULL,
  `job_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `method_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='定时任务日志';

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `name_letter` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称首字母',
  `level` int(11) DEFAULT NULL COMMENT '角色级别',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `data_scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据权限',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_name` (`name`),
  KEY `role_name_index` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='角色表';

/*Table structure for table `sys_roles_depts` */

CREATE TABLE `sys_roles_depts` (
  `role_id` bigint(20) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`dept_id`) USING BTREE,
  KEY `FK7qg6itn5ajdoa9h9o78v9ksur` (`dept_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='角色-机构关联';

/*Table structure for table `sys_roles_menus` */

CREATE TABLE `sys_roles_menus` (
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`menu_id`,`role_id`) USING BTREE,
  KEY `FKcngg2qadojhi3a651a5adkvbq` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='角色菜单关联';

/*Table structure for table `sys_setting` */

CREATE TABLE `sys_setting` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `key` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '键',
  `value` varchar(256) COLLATE utf8mb4_general_ci NOT NULL COMMENT '值',
  `role_level` tinyint(4) NOT NULL COMMENT '角色级别（role.level小于等于该值可修改或删除）',
  `sort` int(11) NOT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_KEY` (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统参数';

/*Table structure for table `sys_user` */

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `username` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `username_letter` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名首字母',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `email` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `avatar_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像地址',
  `avatar_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像真实路径',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `is_admin` bit(1) DEFAULT b'0' COMMENT '是否为admin账号',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `pwd_reset_time` datetime DEFAULT NULL COMMENT '修改密码的时间',
  `create_time` datetime NOT NULL COMMENT '创建日期',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新着',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_username` (`username`),
  UNIQUE KEY `uniq_email` (`email`),
  KEY `inx_enabled` (`enabled`),
  KEY `key_avatar_name` (`avatar_name`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='系统用户';

/*Table structure for table `sys_users_depts` */

CREATE TABLE `sys_users_depts` (
  `user_id` bigint(20) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户-机构关联';

/*Table structure for table `sys_users_jobs` */

CREATE TABLE `sys_users_jobs` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `job_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `sys_users_roles` */

CREATE TABLE `sys_users_roles` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE,
  KEY `FKq4eq273l04bpu4efj0jd0jb98` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='用户角色关联';

/*Table structure for table `test_person` */

CREATE TABLE `test_person` (
  `id` bigint(20) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `gender` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别（男、女、未知）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `mysql_engine` tinyint(4) DEFAULT NULL COMMENT '测试enum',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='测试表';

/*Table structure for table `tool_alipay_config` */

CREATE TABLE `tool_alipay_config` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '应用ID',
  `charset` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编码',
  `format` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型 固定格式json',
  `gateway_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '网关地址',
  `notify_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '异步回调',
  `private_key` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '私钥',
  `public_key` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '公钥',
  `return_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '回调地址',
  `sign_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '签名方式',
  `sys_service_provider_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商户号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='支付宝配置类';

/*Table structure for table `tool_email_config` */

CREATE TABLE `tool_email_config` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `from_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收件人',
  `host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮件服务器SMTP地址',
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `port` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '端口',
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发件者用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='邮箱配置';

/*Table structure for table `tool_local_storage` */

CREATE TABLE `tool_local_storage` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件真实的名称',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件名',
  `suffix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '后缀',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路径',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  `size` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '大小',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='本地存储';

/*Table structure for table `tool_qiniu_config` */

CREATE TABLE `tool_qiniu_config` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `access_key` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT 'accessKey',
  `bucket` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Bucket 识别符',
  `host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '外链域名',
  `secret_key` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT 'secretKey',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '空间类型',
  `zone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '机房',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='七牛云配置';

/*Table structure for table `tool_qiniu_content` */

CREATE TABLE `tool_qiniu_content` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `bucket` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'Bucket 识别符',
  `name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件名称',
  `size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件大小',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件类型：私有或公开',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件url',
  `suffix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文件后缀',
  `update_time` datetime DEFAULT NULL COMMENT '上传或同步的时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='七牛云文件存储';

/*Table structure for table `trace_cma` */

CREATE TABLE `trace_cma` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `viewed` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'true=已阅',
  `receipt_date` date DEFAULT NULL COMMENT '核收日期',
  `report_status` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '报告状态',
  `report_date` date DEFAULT NULL COMMENT '报告日期',
  `report_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流水号',
  `patient_name` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `patient_name_letter` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名首字母',
  `patient_gender` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `patient_age` char(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '年龄',
  `patient_no` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登记号',
  `speciman_no` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标本号',
  `speciman_type` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标本类型',
  `contact_tel` char(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系电话',
  `department_name` varchar(60) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '科室',
  `diagnosis` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '诊断',
  `doctor_advice` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '医嘱',
  `chip_id` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '芯片ID',
  `report_tip` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '报告提示',
  `result` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结果',
  `report_analysis_opinion` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分析意见',
  `conclusion` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结论',
  `conclusion_details` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '提示',
  `suggest` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '建议',
  `chromosome_region` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '染色体区域',
  `dna_chip` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'DNA CHip',
  `result2` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结果2',
  `chromosome_region2` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '染色体区域2',
  `conclusion2` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结论2',
  `result3` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结果3',
  `chromosome_region3` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '染色体区域3',
  `conclusion3` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结论3',
  `result4` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结果4',
  `chromosome_region4` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '染色体区域4',
  `conclusion4` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结论4',
  `inspection_time` datetime DEFAULT NULL COMMENT '检验时间',
  `times_of_pregnancy` tinyint(3) unsigned DEFAULT NULL COMMENT '孕次',
  `times_of_birth` tinyint(3) unsigned DEFAULT NULL COMMENT '产次',
  `sign_consent` tinyint(1) DEFAULT NULL COMMENT '签署同意书',
  `apply_doctor` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '申请医生',
  `apply_date` date DEFAULT NULL COMMENT '申请日期',
  `remarks` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) unsigned DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` bigint(20) unsigned DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='诊断：染色体微整列分析';

/*Table structure for table `trace_cs` */

CREATE TABLE `trace_cs` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `viewed` tinyint(1) DEFAULT '0' COMMENT 'true=已阅',
  `report_time` datetime DEFAULT NULL COMMENT '报告时间',
  `report_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流水号',
  `patient_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登记号',
  `patient_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `patient_name_letter` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名首字母',
  `patient_gender` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `patient_age` char(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '年龄',
  `department_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '科室',
  `doctor_advice` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '医嘱',
  `speciman_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标本类型',
  `diagnosis` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '诊断',
  `karyotype_result` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '染色体核型结果',
  `first_pregency_report_time` datetime DEFAULT NULL COMMENT '早筛报告时间',
  `first_pappmom` decimal(5,2) DEFAULT NULL COMMENT 'PAPPMOM(早筛)',
  `first_fhcgmom` decimal(5,2) DEFAULT NULL COMMENT 'FHCGMOM(早筛)',
  `first_t21_risk` int(11) DEFAULT NULL COMMENT 'T21风险值(早筛)',
  `first_t18_risk` int(11) DEFAULT NULL COMMENT 'T18风险值(早筛)',
  `second_pregency_report_time` datetime DEFAULT NULL COMMENT '中筛报告时间',
  `second_afpmom` decimal(5,2) DEFAULT NULL COMMENT 'AFPMOM(中筛)',
  `second_fhcgmom` decimal(5,2) DEFAULT NULL COMMENT 'FHCGMOM(中筛)',
  `second_e3mom` decimal(5,2) DEFAULT NULL COMMENT 'E3MOM(中筛)',
  `second_t21_risk` int(11) DEFAULT NULL COMMENT 'T21风险值(中筛)',
  `second_t18_risk` int(11) DEFAULT NULL COMMENT 'T18风险值(中筛)',
  `nipt_report_time` datetime DEFAULT NULL COMMENT '无创报告时间',
  `nipt_screening` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '无创筛查',
  `nipt_replenish_report_time` datetime DEFAULT NULL COMMENT '无创补充报告时间',
  `nipt_screening_replenish` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '无创筛查补充',
  `remarks` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) unsigned DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` bigint(20) unsigned DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='诊断：染色体核型结果';

/*Table structure for table `trace_nipt` */

CREATE TABLE `trace_nipt` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'ID',
  `viewed` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'true=已阅',
  `receipt_date` date DEFAULT NULL COMMENT '核收日期',
  `report_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '报告状态',
  `report_date` date DEFAULT NULL COMMENT '报告日期',
  `report_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流水号',
  `patient_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `patient_name_letter` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名首字母',
  `patient_gender` char(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `patient_age` char(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '年龄',
  `patient_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登记号',
  `patient_id_no` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证',
  `patient_health_no` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '保健号',
  `case_no` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '病案号',
  `speciman_no` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标本号',
  `speciman_type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标本类型',
  `contact_tel` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系电话',
  `department_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '科室',
  `diagnosis` varchar(2000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '诊断',
  `doctor_advice` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '医嘱',
  `t13` decimal(5,3) DEFAULT NULL COMMENT '13-三体',
  `t18` decimal(5,3) DEFAULT NULL COMMENT '18-三体',
  `t21` decimal(5,3) DEFAULT NULL COMMENT '21-三体',
  `report_details` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '结果描述',
  `addition1` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '补充内容1',
  `addition1_remark` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '补充内容1说明',
  `addition2` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '补充内容2',
  `addition2_remark` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '补充内容2说明',
  `t13_risk` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'T13风险',
  `t18_risk` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'T18风险',
  `t21_risk` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'T21风险',
  `report_evaluation` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '报告评价',
  `times_of_pregnancy` tinyint(3) unsigned DEFAULT NULL COMMENT '孕次',
  `times_of_birth` tinyint(3) unsigned DEFAULT NULL COMMENT '产次',
  `patient_weight` decimal(4,1) unsigned DEFAULT NULL COMMENT '体重(Kg)',
  `patient_height` decimal(4,1) unsigned DEFAULT NULL COMMENT '身高(cm)',
  `weight_index` decimal(4,2) DEFAULT NULL COMMENT '体重指数',
  `last_menstruation` date DEFAULT NULL COMMENT '末次月经',
  `mcgw` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '月经计算孕周',
  `bdgw` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '抽血当天孕周',
  `nature_conceived` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '自然受孕',
  `ovulation_induction` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '促排卵',
  `iui` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'IUI',
  `ivf` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'IVF',
  `allogenetic_transfusion` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '异体输血',
  `family_diseases` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '家族史',
  `screening_model` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '筛查模式',
  `nt_gw` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '超声NT测定孕周',
  `nt_mm` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'NT测定值(mm)',
  `mssr` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '母体血清筛查风险',
  `t21_syndrome` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '21三体综合征',
  `t18_syndrome` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '18三体综合征',
  `t13_syndrome` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '13三体综合征',
  `sign_consent` tinyint(1) DEFAULT NULL COMMENT '签署同意书',
  `apply_doctor` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '申请医生',
  `apply_date` date DEFAULT NULL COMMENT '申请日期',
  `remarks` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) unsigned DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_user` bigint(20) unsigned DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_REPORT_NO` (`report_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='诊断：无创产前筛查';

/*Table structure for table `trace_patient` */

CREATE TABLE `trace_patient` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登记号',
  `name` varchar(64) COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `name_letter` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '首字母',
  `gender` char(6) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `id_no` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号',
  `health_no` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '保健号',
  `contact_no` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系方式',
  `remarks` varchar(2600) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNI_NO` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
