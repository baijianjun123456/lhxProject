--系统用户表:001_001
drop table if exists LHX_T_SYS_USER;
create table LHX_T_SYS_USER
(
   ID_                  varchar(64) not null comment '用户ID',
   ORG_ID               varchar(100) not null comment '机构ID',
   ORG_LEVEL            varchar(40) not null comment '机构层级码',
   ORG_IDENTY           varchar(40) not null comment '机构识别码',
   PASSWORD             varchar(64) not null comment '机构识别码',
   ACCOUNTS             varchar(20) not null comment '密码',
   NAME                 varchar(40) not null comment '姓名',
   NAME_SPELL           varchar(100) comment '用户名全拼',
   SEX                  varchar(32) default '1' comment '性别（0：女，1：男）',
   THEM_ID              varchar(32)  comment '主题ID',
   HEAD_IMAGE_ID        varchar(64) comment '用户头像ID',
   BIND_ID              varchar(20) comment '绑定IP',
   EFFECT_DATE          varchar(20) comment '生效日期',
   CANCEL_DATE          varchar(20) comment '失效日期',
   PHONE                varchar(15) comment '座机电话',
   MOBILE               varchar(20) comment '移动电话',
   QQ                   varchar(15) comment 'QQ',
   WX                   varchar(25) comment '微信',
   Email                varchar(50) comment '邮箱',
   IS_OLINE             varchar(2) comment '是否在线',
   ORDER_BY             varchar(3) comment '排序',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) default '1' comment '状态（0：删除，1：正常，2：停用，3：失效）',
   primary key (ID_)
);
alter table LHX_T_SYS_USER comment '系统用户表';

--组织机构表:001_002
drop table if exists LHX_T_SYS_ORG;
create table LHX_T_SYS_ORG
(
   ID_                  varchar(32) not null comment '组织机构ID',
   PID                  varchar(32) comment '上级机构ID',
   FLAG                 varchar(2) not null comment '部门机构标识(1：机构；0部门)',
   NAME                 varchar(50) not null comment '机构/部门名称',
   SPELL                varchar(50) comment '机构/部门名称全拼',
   LEVEL_               varchar(40) not null comment '机构层级码',
   IDENTY               varchar(40) not null comment '机构识别码',
   ORDER_BY             varchar(3) comment '排序',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) default '1' comment '状态（0：删除，1：正常，2：停用，3：失效）',
   primary key (ID_)
);
alter table LHX_T_SYS_ORG comment '组织机构表';


--系统角色表:001_003
drop table if exists LHX_T_SYS_ROLE;
create table LHX_T_SYS_ROLE
(
   ID_                  varchar(32) not null comment '角色ID',
   NAME                 varchar(50) not null comment '角色名称',
   NAME_SPELL           varchar(50) comment '角色名称全拼',
   ORG_ID               varchar(32) comment '机构ID',
   ORG_LEVEL            varchar(40) comment '机构层级码',
   ORG_IDENTY           varchar(40) comment '机构识别码',
   DESC_                varchar(300) comment '角色描述',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) default '1' comment '状态（0：删除，1：正常，2：停用，3：失效）',
   primary key (ID_)
);
alter table LHX_T_SYS_ROLE comment '系统角色表';

--用户组织机构表:001_004
drop table if exists LHX_T_SYS_USER_ORG;
create table LHX_T_SYS_USER_ORG
(
   ID_                  varchar(32) not null comment '用户组织机构ID',
   ORG_ID               varchar(32) not null comment '机构ID',
   SHOW_NAME            varchar(40) not null comment '用户展示名称',
   ORDER_BY             varchar(3) comment '排序',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) default '1' comment '状态（0：删除，1：正常，2：停用，3：失效）',
   primary key (ID_)
);
alter table LHX_T_SYS_USER_ORG comment '用户组织机构表';


--用户角色表:001_005
drop table if exists LHX_T_SYS_USER_ROLE;
create table LHX_T_SYS_USER_ROLE
(
   ID_                  varchar(32) not null comment '用户角色ID',
   USER_ID              varchar(32) not null comment '用户ID',
   ROLE_ID              varchar(32) not null comment '角色ID',
   ORDER_BY             varchar(3) comment '排序',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) default '1' comment '状态（0：删除，1：正常，2：停用，3：失效）',
   primary key (ID_)
);
alter table LHX_T_SYS_USER_ROLE comment '用户角色表';

--系统菜单表:001_006
drop table if exists LHX_T_SYS_MENU;
create table LHX_T_SYS_MENU
(
   ID_                  varchar(32) not null comment '菜单ID',
   PID                  varchar(32) comment '父菜单',
   NAME                 varchar(45) not null comment '菜单名称',
   NAME_SPELL           varchar(45) comment '菜单名称全拼',
   CODE                 varchar(25) not null comment '菜单编码',
   URL                  varchar(300) comment '菜单URL',
   LEVEL_               varchar(2) not null comment '菜单级别(1:显示一级菜单；2：显示为二级菜单)',
   ICO                  varchar(20) comment '菜单图标',
   ORDER_BY             varchar(3) comment '排序',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) default '1' comment '状态（0：删除，1：正常，2：停用，3：失效）',
   primary key (ID_)
);
alter table LHX_T_SYS_MENU comment '系统菜单表';

--系统角色菜单表:001_007
drop table if exists LHX_T_SYS_ROLE_MENU;
create table LHX_T_SYS_ROLE_MENU
(
   ID_                  varchar(32) not null comment '角色菜单ID',
   ROLE_ID              varchar(32) not null comment '角色ID',
   MENU_ID              varchar(32) not null comment '菜单ID',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) default '1' comment '状态（0：删除，1：正常，2：停用，3：失效）',
   primary key (ID_)
);
alter table LHX_T_SYS_ROLE_MENU comment '角色菜单表';

--系统资源访问表:001_008
drop table if exists LHX_T_SYS_RESOURCE;
create table LHX_T_SYS_RESOURCE
(
   ID_                  varchar(64) not null comment '资源ID',
   URL                  varchar(300) comment '资源访问路径',
   MENU_ID              varchar(64) comment '菜单ID',
   CREATET              varchar(25) comment '创建时间',
   CREATEP              varchar(64) comment '创建人',
   STATUS               varchar(2) comment '状态',
   primary key (ID_)
);

alter table LHX_T_SYS_RESOURCE comment '系统资源访问表';
