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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`coadmin` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `coadmin`;

/*Data for the table `code_column_config` */

insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (3,'sys_user','username','varchar','dept_status','','',NULL,'UNI','','',NULL,'用户名',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (4,'sys_user','nick_name','varchar',NULL,'','\0',NULL,'','\0','\0',NULL,'昵称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (5,'sys_user','gender','varchar',NULL,'','',NULL,'','','',NULL,'性别',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (6,'sys_user','phone','varchar',NULL,'','',NULL,'','','\0',NULL,'手机号码',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (7,'sys_user','email','varchar',NULL,'','',NULL,'UNI','','\0',NULL,'邮箱',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (8,'sys_user','avatar_name','varchar',NULL,'','',NULL,'MUL','','\0',NULL,'头像地址',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (9,'sys_user','avatar_path','varchar',NULL,'','',NULL,'','','\0',NULL,'头像真实路径',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (10,'sys_user','password','varchar',NULL,'','',NULL,'','','\0',NULL,'密码',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (11,'sys_user','is_admin','bit',NULL,'','',NULL,'','','\0',NULL,'是否为admin账号',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (12,'sys_user','enabled','bigint','user_status','','','Select','MUL','','\0','=','状态：1启用、0禁用',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (13,'sys_user','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (14,'sys_user','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新着',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (15,'sys_user','pwd_reset_time','datetime',NULL,'','',NULL,'','','\0',NULL,'修改密码的时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (16,'sys_user','create_time','datetime',NULL,'','',NULL,'','','\0',NULL,'创建日期','CreationTimestamp');
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (17,'sys_user','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间','UpdateTimestamp');
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (18,'sys_log','log_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (19,'sys_log','description','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (20,'sys_log','log_type','varchar',NULL,'','','Input','MUL','','\0','=','',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (21,'sys_log','method','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (22,'sys_log','params','text',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (23,'sys_log','request_ip','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (24,'sys_log','time','bigint',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (25,'sys_log','username','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (26,'sys_log','address','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (27,'sys_log','browser','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (28,'sys_log','exception_detail','text',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (29,'sys_log','create_time','datetime',NULL,'','','Date','MUL','','\0','BetWeen','',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (30,'sys_dict','dict_id','bigint',NULL,'auto_increment','','Input','PRI','','\0','=','ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (31,'sys_dict','name','varchar',NULL,'','','Input','','','','Like','字典名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (32,'sys_dict','description','varchar',NULL,'','',NULL,'','','\0',NULL,'描述',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (33,'sys_dict','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (34,'sys_dict','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (35,'sys_dict','create_time','datetime',NULL,'','',NULL,'','','\0',NULL,'创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (36,'sys_dict','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (37,'sys_users_jobs','user_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'用户ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (38,'sys_users_jobs','job_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'岗位ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (40,'sys_dict_detail','dict_id','bigint',NULL,'','','Input','MUL','','','=','字典id',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (41,'sys_dict_detail','label','varchar',NULL,'','','Input','','','','Like','字典标签',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (42,'sys_dict_detail','value','varchar',NULL,'','',NULL,'','','',NULL,'字典值',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (44,'sys_dict_detail','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (45,'sys_dict_detail','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (46,'sys_dict_detail','create_time','datetime',NULL,'','',NULL,'','','\0',NULL,'创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (47,'sys_dict_detail','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (48,'sys_role','role_id','bigint',NULL,'auto_increment','','Input','PRI','','','=','ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (49,'sys_role','name','varchar',NULL,'','','Input','UNI','','','Like','名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (50,'sys_role','level','int',NULL,'','',NULL,'','','\0',NULL,'角色级别',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (51,'sys_role','description','varchar',NULL,'','',NULL,'','','\0',NULL,'描述',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (52,'sys_role','data_scope','varchar',NULL,'','',NULL,'','','\0',NULL,'数据权限',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (53,'sys_role','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (54,'sys_role','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (55,'sys_role','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (56,'sys_role','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (57,'sys_dept','dept_id','bigint',NULL,'auto_increment','','Input','PRI','','','=','ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (58,'sys_dept','pid','bigint',NULL,'','','Input','MUL','','','=','上级部门',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (59,'sys_dept','sub_count','int',NULL,'','',NULL,'','','\0',NULL,'子部门数目',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (60,'sys_dept','name','varchar',NULL,'','','Input','','','','Like','名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (61,'sys_dept','dept_sort','int',NULL,'','',NULL,'','','\0',NULL,'排序',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (62,'sys_dept','enabled','bit',NULL,'','','Input','MUL','','','=','状态',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (63,'sys_dept','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (64,'sys_dept','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (65,'sys_dept','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (66,'sys_dept','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (68,'sys_job','name','varchar',NULL,'','','Input','UNI','','','Like','岗位名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (69,'sys_job','enabled','bit',NULL,'','','Select','MUL','','','=','岗位状态',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (71,'sys_job','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (72,'sys_job','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (73,'sys_job','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (74,'sys_job','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (76,'sys_menu','pid','bigint',NULL,'','','Input','MUL','','\0','=','上级菜单ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (77,'sys_menu','sub_count','int',NULL,'','',NULL,'','','\0',NULL,'子菜单数目',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (78,'sys_menu','type','int',NULL,'','',NULL,'','','\0',NULL,'菜单类型',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (79,'sys_menu','title','varchar',NULL,'','',NULL,'UNI','','\0',NULL,'菜单标题',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (81,'sys_menu','component','varchar',NULL,'','',NULL,'','','\0',NULL,'组件',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (83,'sys_menu','icon','varchar',NULL,'','',NULL,'','','\0',NULL,'图标',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (84,'sys_menu','path','varchar',NULL,'','',NULL,'','','\0',NULL,'链接地址',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (85,'sys_menu','i_frame','bit',NULL,'','',NULL,'','','\0',NULL,'是否外链',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (86,'sys_menu','cache','bit',NULL,'','',NULL,'','','\0',NULL,'缓存',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (87,'sys_menu','hidden','bit',NULL,'','',NULL,'','','\0',NULL,'隐藏',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (88,'sys_menu','permission','varchar',NULL,'','',NULL,'','','\0',NULL,'权限',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (89,'sys_menu','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (90,'sys_menu','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (91,'sys_menu','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (92,'sys_menu','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (93,'tool_email_config','config_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (94,'tool_email_config','from_user','varchar',NULL,'','',NULL,'','','\0',NULL,'收件人',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (95,'tool_email_config','host','varchar',NULL,'','',NULL,'','','\0',NULL,'邮件服务器SMTP地址',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (96,'tool_email_config','pass','varchar',NULL,'','',NULL,'','','\0',NULL,'密码',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (97,'tool_email_config','port','varchar',NULL,'','',NULL,'','','\0',NULL,'端口',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (98,'tool_email_config','user','varchar',NULL,'','',NULL,'','','\0',NULL,'发件者用户名',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (99,'tool_local_storage','storage_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (100,'tool_local_storage','real_name','varchar',NULL,'','',NULL,'','','\0',NULL,'文件真实的名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (101,'tool_local_storage','name','varchar',NULL,'','',NULL,'','','\0',NULL,'文件名',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (102,'tool_local_storage','suffix','varchar',NULL,'','',NULL,'','','\0',NULL,'后缀',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (103,'tool_local_storage','path','varchar',NULL,'','',NULL,'','','\0',NULL,'路径',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (104,'tool_local_storage','type','varchar',NULL,'','',NULL,'','','\0',NULL,'类型',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (105,'tool_local_storage','size','varchar',NULL,'','',NULL,'','','\0',NULL,'大小',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (106,'tool_local_storage','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (107,'tool_local_storage','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (108,'tool_local_storage','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (109,'tool_local_storage','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (110,'tool_qiniu_config','config_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (111,'tool_qiniu_config','access_key','text',NULL,'','',NULL,'','','\0',NULL,'accessKey',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (112,'tool_qiniu_config','bucket','varchar',NULL,'','',NULL,'','','\0',NULL,'Bucket 识别符',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (113,'tool_qiniu_config','host','varchar',NULL,'','',NULL,'','','',NULL,'外链域名',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (114,'tool_qiniu_config','secret_key','text',NULL,'','',NULL,'','','\0',NULL,'secretKey',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (115,'tool_qiniu_config','type','varchar',NULL,'','',NULL,'','','\0',NULL,'空间类型',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (116,'tool_qiniu_config','zone','varchar',NULL,'','',NULL,'','','\0',NULL,'机房',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (117,'tool_qiniu_content','content_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (118,'tool_qiniu_content','bucket','varchar',NULL,'','',NULL,'','','\0',NULL,'Bucket 识别符',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (119,'tool_qiniu_content','name','varchar',NULL,'','',NULL,'UNI','','\0',NULL,'文件名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (120,'tool_qiniu_content','size','varchar',NULL,'','',NULL,'','','\0',NULL,'文件大小',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (121,'tool_qiniu_content','type','varchar',NULL,'','',NULL,'','','\0',NULL,'文件类型：私有或公开',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (122,'tool_qiniu_content','url','varchar',NULL,'','',NULL,'','','\0',NULL,'文件url',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (123,'tool_qiniu_content','suffix','varchar',NULL,'','',NULL,'','','\0',NULL,'文件后缀',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (124,'tool_qiniu_content','update_time','datetime',NULL,'','','Date','','','\0','BetWeen','上传或同步的时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (125,'tool_alipay_config','config_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (126,'tool_alipay_config','app_id','varchar',NULL,'','',NULL,'','','\0',NULL,'应用ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (127,'tool_alipay_config','charset','varchar',NULL,'','',NULL,'','','\0',NULL,'编码',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (128,'tool_alipay_config','format','varchar',NULL,'','',NULL,'','','\0',NULL,'类型 固定格式json',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (129,'tool_alipay_config','gateway_url','varchar',NULL,'','',NULL,'','','\0',NULL,'网关地址',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (130,'tool_alipay_config','notify_url','varchar',NULL,'','',NULL,'','','\0',NULL,'异步回调',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (131,'tool_alipay_config','private_key','text',NULL,'','',NULL,'','','\0',NULL,'私钥',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (132,'tool_alipay_config','public_key','text',NULL,'','',NULL,'','','\0',NULL,'公钥',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (133,'tool_alipay_config','return_url','varchar',NULL,'','',NULL,'','','\0',NULL,'回调地址',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (134,'tool_alipay_config','sign_type','varchar',NULL,'','',NULL,'','','\0',NULL,'签名方式',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (135,'tool_alipay_config','sys_service_provider_id','varchar',NULL,'','',NULL,'','','\0',NULL,'商户号',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (136,'sys_quartz_job','job_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (137,'sys_quartz_job','bean_name','varchar',NULL,'','',NULL,'','','\0',NULL,'Spring Bean名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (138,'sys_quartz_job','cron_expression','varchar',NULL,'','',NULL,'','','\0',NULL,'cron 表达式',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (139,'sys_quartz_job','is_pause','bit',NULL,'','',NULL,'MUL','','\0',NULL,'状态：1暂停、0启用',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (140,'sys_quartz_job','job_name','varchar',NULL,'','','Input','','','\0','Like','任务名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (141,'sys_quartz_job','method_name','varchar',NULL,'','',NULL,'','','\0',NULL,'方法名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (142,'sys_quartz_job','params','varchar',NULL,'','',NULL,'','','\0',NULL,'参数',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (143,'sys_quartz_job','description','varchar',NULL,'','',NULL,'','','\0',NULL,'备注',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (144,'sys_quartz_job','person_in_charge','varchar',NULL,'','',NULL,'','','\0',NULL,'负责人',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (145,'sys_quartz_job','email','varchar',NULL,'','',NULL,'','','\0',NULL,'报警邮箱',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (146,'sys_quartz_job','sub_task','varchar',NULL,'','',NULL,'','','\0',NULL,'子任务ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (147,'sys_quartz_job','pause_after_failure','bit',NULL,'','',NULL,'','','\0',NULL,'任务失败后是否暂停',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (148,'sys_quartz_job','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (149,'sys_quartz_job','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (150,'sys_quartz_job','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (151,'sys_quartz_job','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (152,'sys_quartz_log','log_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (153,'sys_quartz_log','bean_name','varchar',NULL,'','','Input','','','\0','=','',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (154,'sys_quartz_log','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (155,'sys_quartz_log','cron_expression','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (156,'sys_quartz_log','exception_detail','text',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (157,'sys_quartz_log','is_success','bit',NULL,'','','Input','','','\0','=','',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (158,'sys_quartz_log','job_name','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (159,'sys_quartz_log','method_name','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (160,'sys_quartz_log','params','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (161,'sys_quartz_log','time','bigint',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (162,'mnt_deploy_server','deploy_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'部署ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (163,'mnt_deploy_server','server_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'服务ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (164,'mnt_database','db_id','varchar',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (165,'mnt_database','name','varchar',NULL,'','','Input','','','','Like','名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (166,'mnt_database','jdbc_url','varchar',NULL,'','','Input','','','','=','jdbc连接',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (167,'mnt_database','user_name','varchar',NULL,'','',NULL,'','','',NULL,'账号',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (168,'mnt_database','pwd','varchar',NULL,'','',NULL,'','','',NULL,'密码',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (169,'mnt_database','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (170,'mnt_database','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (171,'mnt_database','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (172,'mnt_database','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (173,'mnt_app','app_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (174,'mnt_app','name','varchar',NULL,'','','Input','','','\0','Like','应用名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (175,'mnt_app','upload_path','varchar',NULL,'','',NULL,'','','\0',NULL,'上传目录',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (176,'mnt_app','deploy_path','varchar',NULL,'','',NULL,'','','\0',NULL,'部署路径',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (177,'mnt_app','backup_path','varchar',NULL,'','',NULL,'','','\0',NULL,'备份路径',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (178,'mnt_app','port','int',NULL,'','',NULL,'','','\0',NULL,'应用端口',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (179,'mnt_app','start_script','varchar',NULL,'','',NULL,'','','\0',NULL,'启动脚本',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (180,'mnt_app','deploy_script','varchar',NULL,'','',NULL,'','','\0',NULL,'部署脚本',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (181,'mnt_app','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (182,'mnt_app','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (183,'mnt_app','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (184,'mnt_app','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (185,'mnt_server','server_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (186,'mnt_server','account','varchar',NULL,'','',NULL,'','','\0',NULL,'账号',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (187,'mnt_server','ip','varchar',NULL,'','',NULL,'MUL','','\0',NULL,'IP地址',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (188,'mnt_server','name','varchar',NULL,'','',NULL,'','','\0',NULL,'名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (189,'mnt_server','password','varchar',NULL,'','',NULL,'','','\0',NULL,'密码',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (190,'mnt_server','port','int',NULL,'','',NULL,'','','\0',NULL,'端口',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (191,'mnt_server','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (192,'mnt_server','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (193,'mnt_server','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','创建时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (194,'mnt_server','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (195,'mnt_deploy_history','history_id','varchar',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (196,'mnt_deploy_history','app_name','varchar',NULL,'','',NULL,'','','',NULL,'应用名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (197,'mnt_deploy_history','deploy_date','datetime',NULL,'','','Date','','','','BetWeen','部署日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (198,'mnt_deploy_history','deploy_user','varchar',NULL,'','',NULL,'','','',NULL,'部署用户',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (199,'mnt_deploy_history','ip','varchar',NULL,'','',NULL,'','','',NULL,'服务器IP',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (200,'mnt_deploy_history','deploy_id','bigint',NULL,'','','Input','','','\0','=','部署编号',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (201,'mnt_deploy','deploy_id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (202,'mnt_deploy','app_id','bigint',NULL,'','',NULL,'MUL','','\0',NULL,'应用编号',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (203,'mnt_deploy','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'创建者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (204,'mnt_deploy','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'更新者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (205,'mnt_deploy','create_time','datetime',NULL,'','','Date','','','\0','BetWeen','',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (206,'mnt_deploy','update_time','datetime',NULL,'','',NULL,'','','\0',NULL,'更新时间',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (232,'test_table1','id','bigint',NULL,'','','Input','PRI','','','=','ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (233,'test_table1','name','varchar',NULL,'','','Input','','','','Like','姓名',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (234,'test_table1','age','int',NULL,'','',NULL,'','','\0',NULL,'年龄',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (235,'test_table1','create_time','date',NULL,'','','Date','','','\0','BetWeen','',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (236,'test_table1','create_by','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1332139752774762499,'sys_users_roles','user_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'用户ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1332139752913174530,'sys_users_roles','role_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'角色ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1332140017103994882,'sys_roles_depts','role_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1332140017120772097,'sys_roles_depts','dept_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346001203672813569,'sys_job','id','bigint',NULL,'auto_increment','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346001203798642689,'sys_job','sort','int',NULL,'','',NULL,'','','\0',NULL,'排序',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346001234882629634,'sys_users_depts','user_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346001234882629635,'sys_users_depts','dept_id','bigint',NULL,'','',NULL,'PRI','','',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346098703138197506,'sys_dict_detail','id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346098703138197507,'sys_dict_detail','sort','int',NULL,'','',NULL,'','','\0',NULL,'排序',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346099779589541890,'sys_user','id','bigint',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346099779589541891,'sys_user','username_letter','varchar',NULL,'','',NULL,'','','\0',NULL,'用户名首字母',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346110176413519874,'sys_menu','id','bigint',NULL,'auto_increment','',NULL,'PRI','','\0',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346110176413519875,'sys_menu','title_letter','varchar',NULL,'','',NULL,'','','\0',NULL,'标题首字母',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346110176476434433,'sys_menu','component_name','varchar',NULL,'','',NULL,'UNI','','\0',NULL,'组件名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346110176476434434,'sys_menu','sort','int',NULL,'','',NULL,'','','\0',NULL,'排序',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626177,'code_gen_config','id','bigint',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626178,'code_gen_config','table_name','varchar',NULL,'','',NULL,'MUL','','',NULL,'表名',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626179,'code_gen_config','author','varchar',NULL,'','',NULL,'','','\0',NULL,'作者',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626180,'code_gen_config','cover','bit',NULL,'','',NULL,'','','\0',NULL,'是否覆盖',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626181,'code_gen_config','module_name','varchar',NULL,'','',NULL,'','','\0',NULL,'模块名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626182,'code_gen_config','pack','varchar',NULL,'','',NULL,'','','\0',NULL,'至于哪个包下',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626183,'code_gen_config','path','varchar',NULL,'','',NULL,'','','\0',NULL,'前端代码生成的路径',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626184,'code_gen_config','api_path','varchar',NULL,'','',NULL,'','','\0',NULL,'前端Api文件路径',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172040626185,'code_gen_config','prefix','varchar',NULL,'','',NULL,'','','\0',NULL,'表前缀',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111172103540738,'code_gen_config','api_alias','varchar',NULL,'','',NULL,'','','\0',NULL,'接口名称',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123394,'code_column_config','id','bigint',NULL,'','',NULL,'PRI','','',NULL,'ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123395,'code_column_config','table_name','varchar',NULL,'','',NULL,'MUL','','',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123396,'code_column_config','column_name','varchar',NULL,'','',NULL,'','','',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123397,'code_column_config','column_type','varchar',NULL,'','',NULL,'','','',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123398,'code_column_config','dict_name','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123399,'code_column_config','extra','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123400,'code_column_config','form_show','bit',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123401,'code_column_config','form_type','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206136123402,'code_column_config','key_type','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206199037953,'code_column_config','list_show','bit',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206199037954,'code_column_config','not_null','bit',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206199037955,'code_column_config','query_type','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206199037956,'code_column_config','remark','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1346111206199037957,'code_column_config','date_annotation','varchar',NULL,'','',NULL,'','','\0',NULL,'',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476123123714,'test_person','id','bigint',NULL,'','','showOnly','PRI','\0','','=','ID',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476186038273,'test_person','name','varchar',NULL,'','','Input','','','',NULL,'姓名',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476186038274,'test_person','gender','varchar','gender','','','Radio','','','\0','=','性别',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476186038275,'test_person','birthday','date',NULL,'','','Date','','','\0','=','出生日期',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476186038276,'test_person','create_time','date',NULL,'','\0',NULL,'','','','BetWeen','创建时间','CreationTimestamp');
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476186038277,'test_person','create_by','varchar',NULL,'','',NULL,'','\0','\0',NULL,'创建人',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476248952834,'test_person','update_time','date',NULL,'','',NULL,'','\0','\0',NULL,'修改时间','UpdateTimestamp');
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347073476248952835,'test_person','update_by','varchar',NULL,'','',NULL,'','','\0',NULL,'修改人',NULL);
insert  into `code_column_config`(`id`,`table_name`,`column_name`,`column_type`,`dict_name`,`extra`,`form_show`,`form_type`,`key_type`,`list_show`,`not_null`,`query_type`,`remark`,`date_annotation`) values (1347086544236400642,'test_person','remarks','varchar',NULL,'','',NULL,'','','\0',NULL,'备注',NULL);

/*Data for the table `code_gen_config` */

insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (1,'sys_user','jinjin2','\0','coadmin-system','com.gitee.coadmin.modules.mybatis','D:\\lvjinhua\\work\\demo\\coadmin\\coadmin-system\\src\\main\\java\\me\\zhengjie\\modules\\mybatis\\user','non\\','sys_','系统用户',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (2,'sys_dict','jinjin','\0','eladmin-system','me.zhengjie.modules.system','D:\\lvjinhua\\work\\demo\\eladmin\\eladmin-system\\src\\main\\java\\me\\zhengjie\\modules\\mybatis','D:\\lvjinhua\\work\\demo\\eladmin\\eladmin-system\\src\\api','sys_','字典',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (3,'sys_dict_detail','jinjin22','\0','eladmin-system','me.zhengjie.modules.system','xxx','xxx\\','sys_','字典值',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (4,'sys_role','jinjin','\0','eladmin-system','me.zhengjie.modules.mybatis','xxx','xxx\\','sys_','角色',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (5,'sys_dept','jinjin','\0','eladmin-system','me.zhengjie.modules.mybatis','xxx','xxx\\','sys_','部门',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (6,'sys_job','jinjin','\0','eladmin-system','me.zhengjie.modules.mybatis','xxx','xxx\\','sys_','岗位',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (7,'sys_menu','jinjin','\0','eladmin-system','me.zhengjie.modules.mybatis','xxx','xxx\\','sys_','菜单',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (8,'tool_email_config','jinjin','\0','eladmin-tools','me.zhengjie.mybatis','xxx','xxx\\','tool_','邮箱配置',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (9,'tool_local_storage','jinjin','\0','eladmin-tools','me.zhengjie.mybatis','xxx','xxx\\','tool_','本地存储',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (10,'tool_qiniu_config','jinjin','\0','eladmin-tools','me.zhengjie.mybatis','xxx','xxx\\','tool','七牛云配置',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (11,'tool_qiniu_content','jinjin','\0','eladmin-tools','me.zhengjie.mybatis','xxx','xxx\\','tool_','七牛云内容',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (12,'tool_alipay_config','jinjin','\0','eladmin-tools','me.zhengjie.mybatis','xxx','xxx\\','tool_','阿里云配置',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (13,'sys_log','jinjin','\0','eladmin-logging','me.zhengjie.mybatis','xxx','xxx\\','sys_','日志',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (14,'sys_quartz_job','jinjin','\0','eladmin-system','me.zhengjie.modules.quartz.mybatis','xxx','xxx\\','sys_','定时任务',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (15,'sys_quartz_log','jinjin','\0','eladmin-system','me.zhengjie.modules.quartz.mybatis','xxx','xxx\\','sys_','定时任务日志',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (16,'mnt_database','jinjin','\0','eladmin-system','me.zhengjie.modules.mnt.mybatis','xxx','xxx\\','mnt_','数据库管理',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (17,'mnt_app','jinjin','\0','eladmin-system','me.zhengjie.modules.mnt.mybatis','xxx','xxx\\','mnt_','应用管理',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (18,'mnt_server','jinjin','\0','eladmin-system','me.zhengjie.modules.mnt.mybatis','xxx','xxx\\','mnt_','服务器管理',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (19,'mnt_deploy_history','jinjin','\0','eladmin-system','me.zhengjie.modules.mnt.mybatis','xxx','xxx\\','mnt_','部署历史',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (20,'mnt_deploy','jinjin','\0','eladmin-system','me.zhengjie.modules.mnt.mybatis','xxx','xxx\\','mnt_','部署管理',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (21,'test_table1','jinjin','','coadmin-system','com.gitee.coadmin.modules.test','xxx','xxx\\','test_','测试',NULL);
insert  into `code_gen_config`(`id`,`table_name`,`author`,`cover`,`module_name`,`pack`,`path`,`api_path`,`prefix`,`api_alias`,`menu_pid`) values (1347075276712665089,'test_person','jinjin','','coadmin-core','com.gitee.coadmin.modules.test','D:\\lvjinhua\\work\\admin\\coadmin-web-quasar\\src\\pages\\test','D:\\lvjinhua\\work\\admin\\coadmin-web-quasar\\src\\api\\','','演示',121);

/*Data for the table `mnt_app` */

insert  into `mnt_app`(`id`,`name`,`upload_path`,`deploy_path`,`backup_path`,`port`,`start_script`,`deploy_script`,`create_by`,`update_by`,`create_time`,`update_time`) values (1,'eladmin-system-2.3.jar','/opt/upload','/opt/eladmin','/opt/eladmin/backup',8080,'cd /opt/eladmin\nnohup java -jar eladmin-system-2.3.jar --spring.profiles.active=prod >nohup.out 2>&1 &','mv -f /opt/upload/eladmin-system-2.3.jar /opt/eladmin/\ncd /opt/eladmin\nnohup java -jar eladmin-system-2.3.jar --spring.profiles.active=prod >nohup.out 2>&1 &','admin','admin','2020-09-30 22:38:57','2020-10-06 18:03:20');
insert  into `mnt_app`(`id`,`name`,`upload_path`,`deploy_path`,`backup_path`,`port`,`start_script`,`deploy_script`,`create_by`,`update_by`,`create_time`,`update_time`) values (1313396562110550017,'test','/opt/upload','/opt/app','/opt/backup',8080,'x2','xt','admin','admin','2020-10-06 16:31:57','2020-10-06 16:38:28');

/*Data for the table `mnt_database` */

insert  into `mnt_database`(`id`,`name`,`jdbc_url`,`user_name`,`pwd`,`create_by`,`update_by`,`create_time`,`update_time`) values ('1311310071339253762','localhost','jdbc:mysql://localhost:3306/eladmin?serverTimezone=GMT%2B8&characterEncoding=utf8&useSSL=false','root','123456','admin','admin','2020-09-30 22:20:58','2020-10-06 18:03:46');

/*Data for the table `mnt_deploy` */

insert  into `mnt_deploy`(`id`,`app_id`,`create_by`,`update_by`,`create_time`,`update_time`) values (4,1313396562110550017,'admin','admin','2020-10-01 18:31:32','2020-10-06 19:03:50');

/*Data for the table `mnt_deploy_history` */

/*Data for the table `mnt_deploy_server` */

insert  into `mnt_deploy_server`(`deploy_id`,`server_id`) values (4,1);
insert  into `mnt_deploy_server`(`deploy_id`,`server_id`) values (4,2);

/*Data for the table `mnt_server` */

insert  into `mnt_server`(`id`,`account`,`ip`,`name`,`password`,`port`,`create_by`,`update_by`,`create_time`,`update_time`) values (1,'test','127.0.0.1','aliyun','test',22,'admin','admin','2020-09-30 22:38:27','2020-10-06 16:30:51');
insert  into `mnt_server`(`id`,`account`,`ip`,`name`,`password`,`port`,`create_by`,`update_by`,`create_time`,`update_time`) values (2,'root','127.0.0.1','localhost','222222',22,'admin','admin','2020-10-06 16:31:09','2020-10-06 18:03:15');

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (5,0,'运维部','ywb',3,NULL,'/','/运维部','/ywb','/00003',0,'\0','','admin','admin','2019-03-25 09:20:44','2020-11-07 16:19:04');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (6,8,'测试部2','csb',2,NULL,'/8/','/华北分部/测试部2','/hbfb/csb2','/00001/00002',1,'','\0','admin','admin','2019-03-25 09:52:18','2020-12-26 11:39:16');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (7,0,'华南分部',NULL,5,NULL,'/','/华南分部',NULL,'/00005',0,'\0','','admin','admin','2019-03-25 11:04:50','2020-10-08 11:41:14');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (8,0,'华北分部','hbfb',1,NULL,'/','/华北分部','/hbfb','/00001',0,'\0','','admin','admin','2019-03-25 11:04:53','2020-10-12 12:23:40');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (19,5,'运维一组','ywyz',999,NULL,'/5/','/运维部/运维一组','/ywb/ywyz','/00003/00999',1,'','','admin','admin','2020-10-06 18:25:01','2020-11-07 16:19:04');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (21,7,'华南之家','hnzj',1,NULL,'/7/','/华南分部/华南之家','hnfbhnzj','/00005/00001',1,'\0','','admin','admin','2020-10-08 09:01:17','2020-10-09 19:44:47');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (33,7,'华南2','hn2',999,NULL,'/7/','/华南分部/华南2','hnfbhn2','/00005/00999',1,'','','admin','admin','2020-10-09 19:42:45','2020-10-09 19:44:47');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (34,21,'华南之家1','hnzj1',2,NULL,'/7/21/','/华南分部/华南之家/华南之家1','/hnfb/hnzj/hnzj1','/00005/00001/00002',2,'','','admin','admin','2020-10-09 19:44:04','2020-11-07 16:24:02');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (35,0,'东北公司','dbgs',999,NULL,'/','/东北公司','dbgs','/00999',0,'\0','','admin','admin','2020-10-09 19:52:45','2020-10-09 19:55:18');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (36,35,'吉林','jl',5,NULL,'/35/','/东北公司/吉林','/dbgs/jl','/00999/00005',1,'\0','','admin','admin','2020-10-09 19:55:18','2020-10-09 19:58:58');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (37,36,'运维部吉林','ywbjl',333,NULL,'/35/36/','/东北公司/吉林/运维部吉林','/dbgs/jl/ywbjl','/00999/00005/00333',2,'','','admin','admin','2020-10-09 19:58:58','2020-10-09 19:58:58');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (38,36,'财务部吉林','cwbjl',999,NULL,'/35/36/','/东北公司/吉林/财务部吉林','/dbgs/jl/cwbjl','/00999/00005/00999',2,'','','admin','admin','2020-10-09 20:31:36','2020-10-09 20:31:36');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (39,7,'华南之家5','hnzj5',999,NULL,'/7/','/华南分部/华南之家5','/hnfb/hnzj5','/00005/00999',1,'\0','','admin','admin','2020-11-07 16:16:09','2020-11-07 16:25:09');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (40,0,'华东','hd',555,NULL,'/','/华东','/hd','/00555',0,'','','admin','admin','2020-11-07 16:17:07','2020-11-07 16:17:07');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (41,0,'西南','xn',333,NULL,'/','/西南','/xn','/00333',0,'\0','','admin','西南用户1','2020-11-07 16:17:43','2020-11-07 17:55:57');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (42,21,'华南之家2','hnzj2',3,NULL,'/7/21/','/华南分部/华南之家/华南之家2','/hnfb/hnzj/hnzj2','/00005/00001/00003',2,'','','admin','admin','2020-11-07 16:24:19','2020-11-07 16:24:19');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (43,21,'华南之家3','hnzj3',4,NULL,'/7/21/','/华南分部/华南之家/华南之家3','/hnfb/hnzj/hnzj3','/00005/00001/00004',2,'','','admin','admin','2020-11-07 16:24:31','2020-11-07 16:24:31');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (44,39,'华南之家5.1','hnzj51',999,NULL,'/7/39/','/华南分部/华南之家5/华南之家5.1','/hnfb/hnzj5/hnzj51','/00005/00999/00999',2,'','','admin','admin','2020-11-07 16:25:09','2020-11-07 16:25:09');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (45,39,'华南之家5.2','hnzj52',3,NULL,'/7/39/','/华南分部/华南之家5/华南之家5.2','/hnfb/hnzj5/hnzj52','/00005/00999/00003',2,'','','admin','admin','2020-11-07 16:25:18','2020-11-07 16:25:18');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (46,5,'运维二组','ywez',999,NULL,'/5/','/运维部/运维二组','/ywb/ywez','/00003/00999',1,'','','admin','admin','2020-11-07 16:46:18','2020-11-07 16:46:18');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (48,8,'研发部','yfb',3,NULL,'/8/','/华北分部/研发部','/hbfb/yfb','/00001/00003',1,'','','admin','admin','2020-11-07 16:59:17','2020-11-07 16:59:17');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (49,0,'西北','xb',444,NULL,'/','/西北','/xb','/00444',0,'','','admin','admin','2020-11-07 17:50:57','2020-11-07 17:50:57');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (50,41,'财务部','cwb',999,NULL,'/41/','/西南/财务部','/xn/cwb','/00333/00999',1,'','','西南用户1','西南用户1','2020-11-07 17:55:57','2020-11-07 17:56:18');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (51,41,'商务部','swb',999,NULL,'/41/','/西南/商务部','/xn/swb','/00333/00999',1,'','','西南用户1','admin','2020-11-07 17:56:12','2020-12-27 05:59:06');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (52,8,'财务部2','csb',13,NULL,'/8/','/华北分部/财务部2','/hbfb/cwb2','/00001/00013',1,'','','admin','admin','2020-12-26 11:39:51','2020-12-26 11:39:51');
insert  into `sys_dept`(`id`,`pid`,`name`,`name_letter`,`sort`,`dept_code`,`tree_pids`,`tree_names`,`tree_names_letter`,`tree_sorts`,`tree_level`,`tree_leaf`,`enabled`,`create_by`,`update_by`,`create_time`,`update_time`) values (53,8,'总裁办','zcb',12,NULL,'/8/','/华北分部/总裁办','/hbfb/zcb','/00001/00012',1,'','\0','admin','admin','2020-12-26 14:35:17','2020-12-26 14:35:17');

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`name`,`description`,`create_by`,`update_by`,`create_time`,`update_time`) values (1,'user_status','用户状态',NULL,NULL,'2019-10-27 20:31:36',NULL);
insert  into `sys_dict`(`id`,`name`,`description`,`create_by`,`update_by`,`create_time`,`update_time`) values (4,'dept_status','部门状态',NULL,'demo','2019-10-27 20:31:36','2021-06-24 19:33:37');
insert  into `sys_dict`(`id`,`name`,`description`,`create_by`,`update_by`,`create_time`,`update_time`) values (5,'job_status','岗位状态',NULL,'admin','2019-10-27 20:31:36','2020-12-25 17:58:06');
insert  into `sys_dict`(`id`,`name`,`description`,`create_by`,`update_by`,`create_time`,`update_time`) values (7,'gender','性别','admin','admin','2020-12-31 10:29:09','2020-12-31 10:29:09');
insert  into `sys_dict`(`id`,`name`,`description`,`create_by`,`update_by`,`create_time`,`update_time`) values (8,'jobs_status','定时任务状态','demo','admin','2021-01-03 21:36:34','2021-01-03 22:04:42');

/*Data for the table `sys_dict_detail` */

insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (1,1,'激活','true',1,NULL,'admin','2019-10-27 20:31:36','2020-12-25 10:07:25');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (2,1,'禁用','false',2,NULL,'admin',NULL,'2020-12-25 10:07:36');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (3,4,'启用','true',1,NULL,'demo',NULL,'2021-06-24 19:17:22');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (4,4,'停用','false',2,NULL,'admin','2019-10-27 20:31:36','2020-10-06 18:02:16');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (5,5,'启用','true',1,NULL,NULL,NULL,NULL);
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (6,5,'停用','false',2,NULL,NULL,'2019-10-27 20:31:36',NULL);
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (7,NULL,'label1','value1',10,'admin','admin','2020-12-25 11:03:59','2020-12-25 11:03:59');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (13,7,'男','男',10,'admin','admin','2020-12-31 10:30:22','2020-12-31 10:30:22');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (14,7,'女','女',20,'admin','admin','2020-12-31 10:30:53','2020-12-31 10:30:53');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (15,8,'运行中','true',10,'demo','admin','2021-01-03 21:36:56','2021-01-03 22:05:12');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (16,8,'已暂停','false',20,'admin','admin','2021-01-03 22:05:22','2021-01-03 22:05:22');
insert  into `sys_dict_detail`(`id`,`dict_id`,`label`,`value`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (17,5,'333','33',12,'demo','demo','2021-06-24 19:33:26','2021-06-24 19:33:26');

/*Data for the table `sys_job` */

insert  into `sys_job`(`id`,`name`,`enabled`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (8,'人事专员','',3,NULL,NULL,'2019-03-29 14:52:28','2020-09-26 18:17:23');
insert  into `sys_job`(`id`,`name`,`enabled`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (10,'产品经理','\0',4,NULL,'admin','2019-03-29 14:55:51','2020-12-27 23:25:42');
insert  into `sys_job`(`id`,`name`,`enabled`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (11,'全栈开发','',2,NULL,'admin','2019-03-31 13:39:30','2020-10-06 18:02:07');
insert  into `sys_job`(`id`,`name`,`enabled`,`sort`,`create_by`,`update_by`,`create_time`,`update_time`) values (12,'软件测试','',5,NULL,'admin','2019-03-31 13:39:43','2020-05-10 19:56:26');

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (1,NULL,8,0,'系统管理','xtgl',NULL,NULL,900,'how_to_reg','system','\0','\0','\0',NULL,NULL,'admin','2021-01-07 20:35:27','2021-01-07 20:35:28');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (2,1,4,1,'用户管理','yhgl','User','system/user/index',2,'people_alt','user','\0','\0','\0','user:list',NULL,'admin','2021-06-24 18:05:54','2021-06-24 18:05:55');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (3,1,4,1,'角色管理','jsgl','Role','system/role/index',3,'add','role','\0','','\0','roles:list',NULL,'admin','2021-06-24 18:06:20','2021-06-24 18:06:21');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (5,1,4,1,'菜单管理','cdgl','Menu','system/menu/index',5,'menu','menu','\0','','\0','menu:list',NULL,'admin','2021-06-24 18:06:38','2021-06-24 18:06:39');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (6,NULL,5,0,'系统监控','xtjk',NULL,NULL,910,'monitor','monitor','\0','\0','\0',NULL,NULL,'admin','2018-12-18 15:17:48','2021-01-07 08:54:29');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (7,6,0,1,'操作日志','czrz','Log','monitor/log/index',11,'remove','logs','\0','','\0',NULL,NULL,'admin','2018-12-18 15:18:26','2020-12-30 14:52:33');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (9,6,0,1,'SQL监控','SQLjk','Sql','monitor/sql/index',18,'Q','druid','\0','\0','\0',NULL,NULL,'admin','2018-12-18 15:19:34','2020-12-30 15:25:44');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (10,NULL,5,0,'组件管理','zjgl',NULL,NULL,950,'category','components','\0','\0','',NULL,NULL,'admin','2018-12-19 13:38:16','2021-01-07 08:54:44');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (11,10,0,1,'图标库',NULL,'Icons','components/icons/index',51,'icon','icon','\0','\0','\0',NULL,NULL,NULL,'2018-12-19 13:38:49',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (14,36,0,1,'邮件工具',NULL,'Email','tools/email/index',35,'email','email','\0','\0','\0',NULL,NULL,NULL,'2018-12-27 10:13:09',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (15,10,0,1,'富文本',NULL,'Editor','components/Editor',52,'fwb','tinymce','\0','\0','\0',NULL,NULL,NULL,'2018-12-27 11:58:25',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (18,36,3,1,'存储管理','ccgl','Storage','tools/storage/index',34,'S','storage','\0','\0','\0','storage:list',NULL,'admin','2018-12-31 11:12:15','2020-12-30 16:28:52');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (19,36,0,1,'支付宝工具','zfbgj','AliPay','tools/aliPay/index',37,'A','aliPay','\0','\0','\0',NULL,NULL,'admin','2018-12-31 14:52:38','2020-12-30 16:28:32');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (21,NULL,2,0,'多级菜单','djcd',NULL,'',100,'menu','nested','\0','\0','\0',NULL,NULL,'admin','2019-01-04 16:22:03','2021-01-07 08:54:18');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (22,21,2,1,'二级菜单1','ejcd1',NULL,'nested/menu1/index',2,'menu','menu1','\0','\0','\0',NULL,NULL,'admin','2019-01-04 16:23:29','2020-12-30 17:42:01');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (23,21,1,1,'二级菜单2',NULL,NULL,'nested/menu2/index',999,'menu','menu2','\0','\0','\0',NULL,NULL,'admin','2019-01-04 16:23:57','2020-12-30 17:01:46');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (24,22,0,1,'三级菜单1',NULL,NULL,'nested/menu1/menu1-1',999,'menu','menu1-1','\0','\0','\0',NULL,NULL,NULL,'2019-01-04 16:24:48',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (27,22,0,1,'三级菜单2三级菜单2三级菜单2','sjcd2sjcd2sjcd2',NULL,'nested/menu1/menu1-2',999,'menu','menu1-2','\0','\0','\0',NULL,NULL,'admin','2019-01-07 17:27:32','2020-12-30 17:42:01');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (28,1,4,1,'任务调度','rwtd','Timing','system/timing/index',999,'J','timing','\0','\0','\0','timing:list',NULL,'admin','2021-06-24 18:07:47','2021-06-24 18:07:47');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (30,36,0,1,'代码生成','dmsc','GeneratorIndex','generator/index',32,'code','generator','\0','','\0',NULL,NULL,'admin','2019-01-11 15:45:55','2020-12-30 16:28:02');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (32,6,0,1,'异常日志',NULL,'ErrorLog','monitor/log/errorLog',12,'error','errorLog','\0','\0','\0',NULL,NULL,NULL,'2019-01-13 13:49:03',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (33,10,0,1,'Markdown',NULL,'Markdown','components/MarkDown',53,'markdown','markdown','\0','\0','\0',NULL,NULL,NULL,'2019-03-08 13:46:44',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (34,10,0,1,'Yaml编辑器',NULL,'YamlEdit','components/YamlEdit',54,'dev','yaml','\0','\0','\0',NULL,NULL,NULL,'2019-03-08 15:49:40',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (35,1,4,1,'机构管理','jggl','Dept','system/dept/index',6,'perm_contact_calendar','dept','\0','','\0','dept:list',NULL,'admin','2021-06-24 18:07:00','2021-06-24 18:07:01');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (36,NULL,7,0,'系统工具','xtgj',NULL,'',930,'build','sys-tools','\0','\0','\0',NULL,NULL,'admin','2019-03-29 10:57:35','2021-01-07 08:54:38');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (37,1,4,1,'岗位管理','gwgl','Job','system/job/index',7,'A','job','\0','','\0','job:list',NULL,'admin','2021-06-24 18:07:14','2021-06-24 18:07:14');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (38,36,0,1,'接口文档','jkwd','Swagger','tools/swagger/index',36,'D','swagger2','\0','\0','\0',NULL,NULL,'admin','2019-03-29 19:57:53','2020-12-30 16:28:44');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (39,1,4,1,'字典管理','zdgl','Dict','system/dict/index',8,'典','dict','\0','','\0','dict:list',NULL,'admin','2021-06-24 18:07:33','2021-06-24 18:07:34');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (41,6,0,1,'在线用户','zxyh','OnlineUser','monitor/online/index',10,'supervised_user_circle','online','\0','\0','\0',NULL,NULL,'admin','2019-10-26 22:08:43','2020-12-30 15:26:13');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (44,2,0,2,'用户新增',NULL,NULL,'',2,'','','\0','\0','\0','user:add',NULL,NULL,'2019-10-29 10:59:46',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (45,2,0,2,'用户编辑',NULL,NULL,'',3,'','','\0','\0','\0','user:edit',NULL,NULL,'2019-10-29 11:00:08',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (46,2,0,2,'用户删除',NULL,NULL,'',4,'','','\0','\0','\0','user:del',NULL,NULL,'2019-10-29 11:00:23',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (48,3,0,2,'角色创建',NULL,NULL,'',2,'','','\0','\0','\0','roles:add',NULL,NULL,'2019-10-29 12:45:34',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (49,3,0,2,'角色修改',NULL,NULL,'',3,'','','\0','\0','\0','roles:edit',NULL,NULL,'2019-10-29 12:46:16',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (50,3,0,2,'角色删除',NULL,NULL,'',4,'','','\0','\0','\0','roles:del',NULL,NULL,'2019-10-29 12:46:51',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (52,5,0,2,'菜单新增',NULL,NULL,'',2,'','','\0','\0','\0','menu:add',NULL,NULL,'2019-10-29 12:55:07',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (53,5,0,2,'菜单编辑','cdbj',NULL,'',3,'','','\0','\0','\0','menu:edit',NULL,'admin','2019-10-29 12:55:40','2020-12-31 09:28:38');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (54,5,0,2,'菜单删除',NULL,NULL,'',4,'','','\0','\0','\0','menu:del',NULL,NULL,'2019-10-29 12:56:00',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (56,35,0,2,'机构新增','jgxz',NULL,'',2,'','','\0','\0','\0','dept:add',NULL,'admin','2019-10-29 12:57:09','2020-10-12 12:22:40');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (57,35,0,2,'机构编辑','jgbj',NULL,'',3,'','','\0','\0','\0','dept:edit',NULL,'admin','2019-10-29 12:57:27','2020-10-12 12:22:51');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (58,35,0,2,'机构删除','jgsc',NULL,'',4,'','','\0','\0','\0','dept:del',NULL,'admin','2019-10-29 12:57:41','2020-10-12 12:23:02');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (60,37,0,2,'岗位新增',NULL,NULL,'',2,'','','\0','\0','\0','job:add',NULL,NULL,'2019-10-29 12:58:27',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (61,37,0,2,'岗位编辑',NULL,NULL,'',3,'','','\0','\0','\0','job:edit',NULL,NULL,'2019-10-29 12:58:45',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (62,37,0,2,'岗位删除',NULL,NULL,'',4,'','','\0','\0','\0','job:del',NULL,NULL,'2019-10-29 12:59:04',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (64,39,0,2,'字典新增',NULL,NULL,'',2,'','','\0','\0','\0','dict:add',NULL,NULL,'2019-10-29 13:00:17',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (65,39,0,2,'字典编辑',NULL,NULL,'',3,'','','\0','\0','\0','dict:edit',NULL,NULL,'2019-10-29 13:00:42',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (66,39,0,2,'字典删除',NULL,NULL,'',4,'','','\0','\0','\0','dict:del',NULL,NULL,'2019-10-29 13:00:59',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (73,28,0,2,'任务新增',NULL,NULL,'',2,'','','\0','\0','\0','timing:add',NULL,NULL,'2019-10-29 13:07:28',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (74,28,0,2,'任务编辑',NULL,NULL,'',3,'','','\0','\0','\0','timing:edit',NULL,NULL,'2019-10-29 13:07:41',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (75,28,0,2,'任务删除',NULL,NULL,'',4,'','','\0','\0','\0','timing:del',NULL,NULL,'2019-10-29 13:07:54',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (77,18,0,2,'上传文件',NULL,NULL,'',2,'','','\0','\0','\0','storage:add',NULL,NULL,'2019-10-29 13:09:09',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (78,18,0,2,'文件编辑',NULL,NULL,'',3,'','','\0','\0','\0','storage:edit',NULL,NULL,'2019-10-29 13:09:22',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (79,18,0,2,'文件删除',NULL,NULL,'',4,'','','\0','\0','\0','storage:del',NULL,NULL,'2019-10-29 13:09:34',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (80,6,0,1,'服务监控','fwjk','ServerMonitor','monitor/server/index',14,'S','server','\0','\0','\0','monitor:list',NULL,'admin','2019-11-07 13:06:39','2020-12-30 15:25:33');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (82,36,0,1,'生成配置','scpz','GeneratorConfig','generator/config',33,'C','generator/config/:tableName','\0','','','',NULL,'admin','2019-11-17 20:08:56','2020-12-30 16:28:20');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (83,10,0,1,'图表库',NULL,'Echarts','components/Echarts',50,'chart','echarts','\0','','\0','',NULL,NULL,'2019-11-21 09:04:32',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (92,90,3,1,'服务器','fwq','ServerDeploy','mnt/server/index',22,'vpn_lock','mnt/serverDeploy','\0','\0','\0','serverDeploy:list',NULL,'admin','2019-11-10 10:29:25','2020-12-30 15:28:07');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (93,90,3,1,'应用管理','yygl','App','mnt/app/index',23,'A','mnt/app','\0','\0','\0','app:list',NULL,'admin','2019-11-10 11:05:16','2020-12-30 17:16:01');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (94,90,3,1,'部署管理','bsgl','Deploy','mnt/deploy/index',24,'B','mnt/deploy','\0','\0','\0','deploy:list',NULL,'admin','2019-11-10 15:56:55','2020-12-30 16:27:32');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (97,90,1,1,'部署备份',NULL,'DeployHistory','mnt/deployHistory/index',25,'backup','mnt/deployHistory','\0','\0','\0','deployHistory:list',NULL,NULL,'2019-11-10 16:49:44',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (98,90,3,1,'数据库管理','sjkgl','Database','mnt/database/index',26,'D','mnt/database','\0','\0','\0','database:list',NULL,'admin','2019-11-10 20:40:04','2020-12-30 16:26:20');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (102,97,0,2,'删除',NULL,NULL,'',999,'','','\0','\0','\0','deployHistory:del',NULL,NULL,'2019-11-17 09:32:48',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (103,92,0,2,'服务器新增',NULL,NULL,'',999,'','','\0','\0','\0','serverDeploy:add',NULL,NULL,'2019-11-17 11:08:33',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (104,92,0,2,'服务器编辑',NULL,NULL,'',999,'','','\0','\0','\0','serverDeploy:edit',NULL,'admin','2019-11-17 11:08:57','2020-10-06 16:24:24');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (105,92,0,2,'服务器删除',NULL,NULL,'',999,'','','\0','\0','\0','serverDeploy:del',NULL,NULL,'2019-11-17 11:09:15',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (106,93,0,2,'应用新增',NULL,NULL,'',999,'','','\0','\0','\0','app:add',NULL,NULL,'2019-11-17 11:10:03',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (107,93,0,2,'应用编辑',NULL,NULL,'',999,'','','\0','\0','\0','app:edit',NULL,NULL,'2019-11-17 11:10:28',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (108,93,0,2,'应用删除',NULL,NULL,'',999,'','','\0','\0','\0','app:del',NULL,NULL,'2019-11-17 11:10:55',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (109,94,0,2,'部署新增',NULL,NULL,'',999,'','','\0','\0','\0','deploy:add',NULL,NULL,'2019-11-17 11:11:22',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (110,94,0,2,'部署编辑',NULL,NULL,'',999,'','','\0','\0','\0','deploy:edit',NULL,NULL,'2019-11-17 11:11:41',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (111,94,0,2,'部署删除',NULL,NULL,'',999,'','','\0','\0','\0','deploy:del',NULL,NULL,'2019-11-17 11:12:01',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (112,98,0,2,'数据库新增',NULL,NULL,'',999,'','','\0','\0','\0','database:add',NULL,NULL,'2019-11-17 11:12:43',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (113,98,0,2,'数据库编辑',NULL,NULL,'',999,'','','\0','\0','\0','database:edit',NULL,NULL,'2019-11-17 11:12:58',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (114,98,0,2,'数据库删除',NULL,NULL,'',999,'','','\0','\0','\0','database:del',NULL,NULL,'2019-11-17 11:13:14',NULL);
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (116,36,0,1,'生成预览','scyl','Preview','generator/preview',999,'P','generator/preview/:tableName','\0','','',NULL,NULL,'admin','2019-11-26 14:54:36','2020-12-30 16:28:39');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (118,23,0,2,'Test','Test',NULL,'demo/test',10,'T','test','\0','','','test:list','admin','admin','2020-12-30 15:31:09','2020-12-30 17:01:46');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (120,119,0,0,'一一级菜单','yyjcd',NULL,NULL,10,'S',NULL,'\0','\0','\0','first:second','admin','admin','2020-12-30 16:56:41','2020-12-30 16:58:29');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (121,NULL,1,0,'TESTTEST','TESTTEST',NULL,NULL,10,'T','testtest','\0','','\0',NULL,'admin','admin','2021-01-07 20:58:17','2021-06-24 18:11:15');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (153,121,4,1,'演示管理','ysgl','TestPerson','test/index',10,NULL,'testPerson','\0','','\0','testPerson:list',NULL,'admin','2021-06-24 20:00:53','2021-06-24 20:00:53');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (154,153,0,2,'演示查看','ysck',NULL,NULL,10,NULL,NULL,'\0','\0','\0','testPerson:view',NULL,'admin','2021-01-07 20:56:51','2021-06-24 19:54:48');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (155,153,0,2,'演示新增','ysxz',NULL,NULL,10,NULL,NULL,'\0','\0','\0','testPerson:add',NULL,'admin','2021-01-07 20:56:51','2021-06-24 20:00:18');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (156,153,0,2,'演示修改','ysxg',NULL,NULL,10,NULL,NULL,'\0','\0','\0','testPerson:edit',NULL,'admin','2021-01-07 20:56:51','2021-06-24 20:00:53');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (157,153,0,2,'演示删除','yssc',NULL,NULL,10,NULL,NULL,'\0','\0','\0','testPerson:del',NULL,'admin','2021-01-07 20:56:51','2021-06-24 20:00:31');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (158,2,0,2,'用户查看','yhck',NULL,NULL,1,NULL,NULL,'\0','\0','\0','user:list','admin','admin','2021-06-24 18:05:47','2021-06-24 18:05:55');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (159,3,0,2,'角色查看','yhbj',NULL,NULL,1,NULL,NULL,'\0','\0','\0','roles:list','admin','admin','2021-06-24 18:06:21','2021-06-24 18:06:21');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (160,5,0,2,'查到查看','yhbj',NULL,NULL,1,NULL,NULL,'\0','\0','\0','menu:list','admin','admin','2021-06-24 18:06:39','2021-06-24 18:06:39');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (161,35,0,2,'机构查看','yhbj',NULL,NULL,1,NULL,'','\0','\0','\0','dept:list','admin','admin','2021-06-24 18:07:01','2021-06-24 18:07:01');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (162,37,0,2,'岗位查看','yhbj',NULL,NULL,1,NULL,NULL,'\0','\0','\0','job:list','admin','admin','2021-06-24 18:07:14','2021-06-24 18:07:14');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (163,39,0,2,'字典查看','yhbj',NULL,NULL,1,NULL,NULL,'\0','\0','\0','dict:list','admin','admin','2021-06-24 18:07:34','2021-06-24 18:07:34');
insert  into `sys_menu`(`id`,`pid`,`sub_count`,`type`,`title`,`title_letter`,`component_name`,`component`,`sort`,`icon`,`path`,`i_frame`,`cache`,`hidden`,`permission`,`create_by`,`update_by`,`create_time`,`update_time`) values (164,28,0,2,'任务查看','yhbj',NULL,NULL,1,NULL,NULL,'\0','\0','\0','timing:list','admin','admin','2021-06-24 18:07:47','2021-06-24 18:07:47');

/*Data for the table `sys_quartz_job` */

insert  into `sys_quartz_job`(`id`,`bean_name`,`cron_expression`,`is_pause`,`job_name`,`method_name`,`params`,`description`,`person_in_charge`,`email`,`sub_task`,`pause_after_failure`,`create_by`,`update_by`,`create_time`,`update_time`) values (2,'testTask','0/5 * * * * ?','','测试1','run1','test','带参测试，多参使用json','测试',NULL,NULL,'\0',NULL,'admin','2019-08-22 14:08:29','2021-01-06 08:58:46');
insert  into `sys_quartz_job`(`id`,`bean_name`,`cron_expression`,`is_pause`,`job_name`,`method_name`,`params`,`description`,`person_in_charge`,`email`,`sub_task`,`pause_after_failure`,`create_by`,`update_by`,`create_time`,`update_time`) values (3,'testTask','0/5 * * * * ?','','测试','run','','不带参测试','Zheng Jie','','5,6','',NULL,'admin','2019-09-26 16:44:39','2021-06-24 18:01:55');

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`name_letter`,`level`,`description`,`data_scope`,`create_by`,`update_by`,`create_time`,`update_time`) values (1,'超级管理员','cjgly',1,'-','自定义',NULL,'admin','2018-11-23 11:04:37','2020-12-31 08:02:30');
insert  into `sys_role`(`id`,`name`,`name_letter`,`level`,`description`,`data_scope`,`create_by`,`update_by`,`create_time`,`update_time`) values (2,'普通用户','ptyh',2,'-','自定义',NULL,'admin','2018-11-23 13:09:06','2020-12-31 08:26:35');
insert  into `sys_role`(`id`,`name`,`name_letter`,`level`,`description`,`data_scope`,`create_by`,`update_by`,`create_time`,`update_time`) values (3,'最小权限','zxqx',3,NULL,'全部','admin','admin','2020-10-01 23:35:23','2020-12-31 08:08:11');
insert  into `sys_role`(`id`,`name`,`name_letter`,`level`,`description`,`data_scope`,`create_by`,`update_by`,`create_time`,`update_time`) values (4,'普通管理员','ptgly',2,NULL,'全部','admin','admin','2020-11-07 17:53:40','2020-12-31 08:27:22');
insert  into `sys_role`(`id`,`name`,`name_letter`,`level`,`description`,`data_scope`,`create_by`,`update_by`,`create_time`,`update_time`) values (5,'Demo2','Demo2',4,'test only2','本级','admin','admin','2020-12-30 21:31:47','2020-12-31 08:26:48');
insert  into `sys_role`(`id`,`name`,`name_letter`,`level`,`description`,`data_scope`,`create_by`,`update_by`,`create_time`,`update_time`) values (6,'test3','test3',3,NULL,'全部','admin','admin','2021-01-06 22:44:35','2021-01-06 22:44:35');

/*Data for the table `sys_roles_depts` */

/*Data for the table `sys_roles_menus` */

insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (1,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (2,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (3,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (5,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (6,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (7,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (9,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (10,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (11,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (14,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (15,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (18,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (19,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (21,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (22,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (23,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (24,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (27,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (28,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (30,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (32,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (33,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (34,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (35,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (36,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (37,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (38,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (39,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (41,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (44,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (45,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (46,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (48,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (49,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (50,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (52,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (53,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (54,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (56,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (57,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (58,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (60,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (61,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (62,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (64,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (65,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (66,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (73,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (74,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (75,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (77,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (78,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (79,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (80,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (82,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (83,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (92,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (93,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (94,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (97,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (98,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (102,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (103,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (104,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (105,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (106,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (107,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (108,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (109,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (110,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (111,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (112,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (113,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (114,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (116,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (118,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (121,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (153,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (154,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (155,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (156,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (157,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (158,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (159,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (160,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (161,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (162,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (163,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (164,1);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (1,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (2,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (3,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (5,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (6,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (7,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (10,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (11,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (14,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (15,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (18,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (19,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (21,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (22,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (23,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (24,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (27,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (28,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (32,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (33,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (34,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (35,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (36,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (37,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (38,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (39,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (41,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (44,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (60,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (61,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (64,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (80,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (83,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (92,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (118,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (121,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (153,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (154,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (155,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (156,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (157,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (158,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (159,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (160,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (161,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (163,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (164,2);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (1,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (2,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (3,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (6,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (21,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (36,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (121,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (153,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (154,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (155,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (156,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (158,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (159,3);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (1,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (2,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (3,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (5,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (6,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (7,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (21,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (22,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (23,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (24,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (27,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (30,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (32,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (35,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (36,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (37,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (39,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (41,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (44,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (45,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (48,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (49,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (53,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (56,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (57,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (61,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (80,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (118,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (121,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (153,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (154,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (155,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (156,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (157,4);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (1,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (3,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (6,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (7,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (35,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (37,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (48,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (49,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (50,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (92,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (93,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (94,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (97,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (98,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (102,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (103,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (104,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (105,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (106,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (107,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (108,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (109,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (110,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (111,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (112,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (113,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (114,5);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (14,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (18,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (19,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (30,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (36,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (38,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (77,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (78,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (79,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (82,6);
insert  into `sys_roles_menus`(`menu_id`,`role_id`) values (116,6);

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1,'admin','admin','admin','男','18888888888','201507802','avatar-2021010504071782.png','C:\\coadmin\\avatar\\avatar-2021010504071782.png','$2a$10$teIV/KA8s2lqN/Gaiqxnm.dK5d8Ld/mH/NYtMGQVIF3Yhb/xrAif2','',1,'admin','admin','2021-01-05 16:09:45','2018-08-23 09:11:56','2021-01-05 16:09:45');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (4,'jinjin','jinjin','吕进华','男','13800138002','jinjin@gmail.com','avatar-20201011111043576.png','C:\\coadmin\\avatar\\avatar-20201011111043576.png','$2a$10$vklJaXZ6mUbYc9ulI0uuVOUVUHBr/49l7jYifZdXadLM84cdh9Qjm','\0',1,'admin','admin',NULL,'2020-09-26 17:19:53','2021-06-24 18:00:06');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1314466299762499585,'t2','t2','t2','男','13800138005','t2@x.cn','avatar-20201009075909548.png','C:\\coadmin\\avatar\\avatar-20201009075909548.png','$2a$10$b6n6SGp25vFOHfsJnOgnBO8EsrZBzvToVGDO/SZVHTG0ySGq4n3sm','\0',1,'admin','admin','2020-10-09 08:00:22','2020-10-09 15:22:42','2021-06-24 20:19:08');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1314466586531258369,'t3','t3','t3','女','18618343102','t3@x.cn','avatar-20201012121236789.png','C:\\coadmin\\avatar\\avatar-20201012121236789.png','$2a$10$e.q6ThYOxMpiwnjEdtcoDeRnD5mb6Sa9AJLJvnn.ZffsVRWLB5Q8W','\0',1,'admin','t3','2020-10-09 08:00:22','2020-10-09 15:23:50','2020-10-12 12:12:37');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1314466748175540225,'t4','t4','t4','男','13800138004','t4@x.cn',NULL,NULL,'$2a$10$b4hTCxWIx8wbIycOCSTshO5eEioJayafiKPmcuWglHhgcpuK0Bd7q','\0',0,'admin','admin',NULL,'2020-10-09 15:24:29','2021-06-24 20:04:45');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1314467243212464130,'t5','t5','t5','男','13800138003','t5@x.cn','avatar-20201009075909548.png','C:\\coadmin\\avatar\\avatar-20201009075909548.png','$2a$10$r6I/dwhJBpFKsldIJU10Y.xTzuBqBGqIgCAbmK8og7ABJMXuzUtba','\0',0,'admin','admin','2020-10-09 08:00:22','2020-10-09 15:26:27','2021-06-24 20:04:31');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1325012704440709121,'西南用户1','xnyh1','西南用户1','男','13800138012',NULL,'avatar-20201009075909548.png','C:\\coadmin\\avatar\\avatar-20201009075909548.png','$2a$10$Rp9avpKzep/E7w/OFZ/6g.e0ZiTimHvm.aJenrwtCFC7l4R6rKaoO','\0',1,'admin','admin','2020-10-09 08:00:22','2020-11-07 17:50:21','2021-01-03 21:19:58');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1345721913572020225,'demo','demo',NULL,'女',NULL,NULL,'avatar-20201009075909548.png','C:\\coadmin\\avatar\\avatar-20201009075909548.png','$2a$10$FwiQUYoJ.mpgSOtrB9gHqezgF8.9wPqGq8ImPc3/VZM6UR0DD4QEy','\0',1,'admin','admin','2020-10-09 08:00:22','2021-01-03 21:21:21','2021-01-03 21:40:10');
insert  into `sys_user`(`id`,`username`,`username_letter`,`nick_name`,`gender`,`phone`,`email`,`avatar_name`,`avatar_path`,`password`,`is_admin`,`enabled`,`create_by`,`update_by`,`pwd_reset_time`,`create_time`,`update_time`) values (1408020940352172033,'哈哈','t4',NULL,'男',NULL,NULL,NULL,NULL,'$2a$10$NCfkdiMm7z5tgEaQxSBNLuua73aqSa0ONUXgcAGl6wJioeb4GWbIm','\0',0,'demo','demo',NULL,'2021-06-24 19:15:27','2021-06-24 19:15:27');

/*Data for the table `sys_users_depts` */

insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1,7);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1,8);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1,41);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (4,7);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1314466299762499585,5);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1314466299762499585,33);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1314466748175540225,5);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1314466748175540225,38);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1314467243212464130,6);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1314467243212464130,50);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1314467243212464130,51);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1325012704440709121,41);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1345721913572020225,5);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1345721913572020225,7);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1345721913572020225,8);
insert  into `sys_users_depts`(`user_id`,`dept_id`) values (1408020940352172033,5);

/*Data for the table `sys_users_jobs` */

insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1,11);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (4,8);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (4,12);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1314466299762499585,8);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1314466586531258369,11);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1314467243212464130,8);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1314467243212464130,11);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1325012704440709121,8);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1345721913572020225,8);
insert  into `sys_users_jobs`(`user_id`,`job_id`) values (1408020940352172033,8);

/*Data for the table `sys_users_roles` */

insert  into `sys_users_roles`(`user_id`,`role_id`) values (1,1);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (4,1);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1314466586531258369,2);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1314467243212464130,2);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1325012704440709121,2);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1345721913572020225,2);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1408020940352172033,2);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1314466299762499585,3);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1314466748175540225,3);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1314467243212464130,3);
insert  into `sys_users_roles`(`user_id`,`role_id`) values (1325012704440709121,4);

/*Data for the table `test_person` */

insert  into `test_person`(`id`,`name`,`gender`,`birthday`,`create_time`,`create_by`,`update_time`,`update_by`,`remarks`) values (1347171188143263745,'我是谁','女','2001-05-04','2021-01-07 21:20:15',NULL,'2021-06-24 18:14:50',NULL,NULL);
insert  into `test_person`(`id`,`name`,`gender`,`birthday`,`create_time`,`create_by`,`update_time`,`update_by`,`remarks`) values (1408005766186577922,'路人甲','男','2021-06-01','2021-06-24 18:15:09',NULL,'2021-06-24 20:22:52',NULL,NULL);

/*Data for the table `tool_alipay_config` */

insert  into `tool_alipay_config`(`id`,`app_id`,`charset`,`format`,`gateway_url`,`notify_url`,`private_key`,`public_key`,`return_url`,`sign_type`,`sys_service_provider_id`) values (1,'2016091700532697','utf-8','JSON','https://openapi.alipaydev.com/gateway.do','http://api.auauz.net/api/aliPay/notify','MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC5js8sInU10AJ0cAQ8UMMyXrQ+oHZEkVt5lBwsStmTJ7YikVYgbskx1YYEXTojRsWCb+SH/kDmDU4pK/u91SJ4KFCRMF2411piYuXU/jF96zKrADznYh/zAraqT6hvAIVtQAlMHN53nx16rLzZ/8jDEkaSwT7+HvHiS+7sxSojnu/3oV7BtgISoUNstmSe8WpWHOaWv19xyS+Mce9MY4BfseFhzTICUymUQdd/8hXA28/H6osUfAgsnxAKv7Wil3aJSgaJczWuflYOve0dJ3InZkhw5Cvr0atwpk8YKBQjy5CdkoHqvkOcIB+cYHXJKzOE5tqU7inSwVbHzOLQ3XbnAgMBAAECggEAVJp5eT0Ixg1eYSqFs9568WdetUNCSUchNxDBu6wxAbhUgfRUGZuJnnAll63OCTGGck+EGkFh48JjRcBpGoeoHLL88QXlZZbC/iLrea6gcDIhuvfzzOffe1RcZtDFEj9hlotg8dQj1tS0gy9pN9g4+EBH7zeu+fyv+qb2e/v1l6FkISXUjpkD7RLQr3ykjiiEw9BpeKb7j5s7Kdx1NNIzhkcQKNqlk8JrTGDNInbDM6inZfwwIO2R1DHinwdfKWkvOTODTYa2MoAvVMFT9Bec9FbLpoWp7ogv1JMV9svgrcF9XLzANZ/OQvkbe9TV9GWYvIbxN6qwQioKCWO4GPnCAQKBgQDgW5MgfhX8yjXqoaUy/d1VjI8dHeIyw8d+OBAYwaxRSlCfyQ+tieWcR2HdTzPca0T0GkWcKZm0ei5xRURgxt4DUDLXNh26HG0qObbtLJdu/AuBUuCqgOiLqJ2f1uIbrz6OZUHns+bT/jGW2Ws8+C13zTCZkZt9CaQsrp3QOGDx5wKBgQDTul39hp3ZPwGNFeZdkGoUoViOSd5Lhowd5wYMGAEXWRLlU8z+smT5v0POz9JnIbCRchIY2FAPKRdVTICzmPk2EPJFxYTcwaNbVqL6lN7J2IlXXMiit5QbiLauo55w7plwV6LQmKm9KV7JsZs5XwqF7CEovI7GevFzyD3w+uizAQKBgC3LY1eRhOlpWOIAhpjG6qOoohmeXOphvdmMlfSHq6WYFqbWwmV4rS5d/6LNpNdL6fItXqIGd8I34jzql49taCmi+A2nlR/E559j0mvM20gjGDIYeZUz5MOE8k+K6/IcrhcgofgqZ2ZED1ksHdB/E8DNWCswZl16V1FrfvjeWSNnAoGAMrBplCrIW5xz+J0Hm9rZKrs+AkK5D4fUv8vxbK/KgxZ2KaUYbNm0xv39c+PZUYuFRCz1HDGdaSPDTE6WeWjkMQd5mS6ikl9hhpqFRkyh0d0fdGToO9yLftQKOGE/q3XUEktI1XvXF0xyPwNgUCnq0QkpHyGVZPtGFxwXiDvpvgECgYA5PoB+nY8iDiRaJNko9w0hL4AeKogwf+4TbCw+KWVEn6jhuJa4LFTdSqp89PktQaoVpwv92el/AhYjWOl/jVCm122f9b7GyoelbjMNolToDwe5pF5RnSpEuDdLy9MfE8LnE3PlbE7E5BipQ3UjSebkgNboLHH/lNZA5qvEtvbfvQ==','MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAut9evKRuHJ/2QNfDlLwvN/S8l9hRAgPbb0u61bm4AtzaTGsLeMtScetxTWJnVvAVpMS9luhEJjt+Sbk5TNLArsgzzwARgaTKOLMT1TvWAK5EbHyI+eSrc3s7Awe1VYGwcubRFWDm16eQLv0k7iqiw+4mweHSz/wWyvBJVgwLoQ02btVtAQErCfSJCOmt0Q/oJQjj08YNRV4EKzB19+f5A+HQVAKy72dSybTzAK+3FPtTtNen/+b5wGeat7c32dhYHnGorPkPeXLtsqqUTp1su5fMfd4lElNdZaoCI7osZxWWUo17vBCZnyeXc9fk0qwD9mK6yRAxNbrY72Xx5VqIqwIDAQAB','http://api.auauz.net/api/aliPay/return','RSA2','2088102176044281');

/*Data for the table `tool_email_config` */

insert  into `tool_email_config`(`id`,`from_user`,`host`,`pass`,`port`,`user`) values (1,'test@gmail.com','http://smtp.test.cn','85A6CF07C91D9DAB','33','test');

/*Data for the table `tool_local_storage` */

insert  into `tool_local_storage`(`id`,`real_name`,`name`,`suffix`,`path`,`type`,`size`,`create_by`,`update_by`,`create_time`,`update_time`) values (1408005497130364929,'qq-tencent-20210624061404656.png','qq-tencent.png','png','C:\\coadmin\\file\\图片\\qq-tencent-20210624061404656.png','图片','8.90KB   ','admin','admin','2021-06-24 18:14:05','2021-06-24 18:14:05');

/*Data for the table `tool_qiniu_config` */

insert  into `tool_qiniu_config`(`id`,`access_key`,`bucket`,`host`,`secret_key`,`type`,`zone`) values (1,'33333','test','http://test.com','44444','私有','华北');

/*Data for the table `tool_qiniu_content` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
