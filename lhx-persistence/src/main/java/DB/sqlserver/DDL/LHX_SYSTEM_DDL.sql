--系统用户表:001_001
create table LHX_T_SYS_USER (
   ID_                  varchar(64)          not null,
   ORG_ID               varchar(100)         not null,
   ORG_LEVEL            varchar(40)          not null,
   ORG_IDENTY           varchar(40)          not null,
   PASSWORD             varchar(64)          not null,
   ACCOUNTS             varchar(20)          not null
   NAME                 varchar(40)          not null,
   NAME_SPELL           varchar(100)         null,
   SEX                  varchar(32)          null default '1',
   THEM_ID              varchar(32)          ,
   HEAD_IMAGE_ID        varchar(64)          null,
   BIND_ID              varchar(20)          null,
   EFFECT_DATE          varchar(20)          null,
   CANCEL_DATE          varchar(20)          null,
   PHONE                varchar(15)          null,
   MOBILE               varchar(20)          null,
   QQ                   varchar(15)          null,
   WX                   varchar(25)          null,
   Email                varchar(50)          null,
   IS_OLINE             varchar(2)           null,
   ORDER_BY             varchar(3)           null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null default '1',
   constraint PK_LHX_T_SYS_USER primary key nonclustered (ID_)
)

--组织机构表:001_002
create table LHX_T_SYS_ORG (
   ID_                  varchar(32)          not null,
   PID                  varchar(32)          null,
   FLAG                 varchar(2)           not null,
   NAME                 varchar(50)          not null,
   SPELL                varchar(50)          null,
   LEVEL_               varchar(40)          not null,
   IDENTY               varchar(40)          not null,
   ORDER_BY             varchar(3)           null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null default '1',
   constraint PK_LHX_T_SYS_ORG primary key nonclustered (ID_)
)

--系统角色表:001_003
create table LHX_T_SYS_ROLE (
   ID_                  varchar(32)          not null,
   NAME                 varchar(50)          not null,
   NAME_SPELL           varchar(50)          null,
   ORG_ID               varchar(32)          null,
   ORG_LEVEL            varchar(40)          null,
   ORG_IDENTY           varchar(40)          null,
   DESC_                varchar(300)         null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null default '1',
   constraint PK_LHX_T_SYS_ROLE primary key nonclustered (ID_)
)

--用户组织机构表:001_004
create table LHX_T_SYS_USER_ORG (
   ID_                  varchar(32)          not null,
   ORG_ID               varchar(32)          not null,
   SHOW_NAME            varchar(40)          not null,
   ORDER_BY             varchar(3)           null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null default '1',
   constraint PK_LHX_T_SYS_USER_ORG primary key nonclustered (ID_)
)

--用户角色表:001_005
create table LHX_T_SYS_USER_ROLE (
   ID_                  varchar(32)          not null,
   USER_ID              varchar(32)          not null,
   ROLE_ID              varchar(32)          not null,
   ORDER_BY             varchar(3)           null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null default '1',
   constraint PK_LHX_T_SYS_USER_ROLE primary key nonclustered (ID_)
)

--系统菜单表:001_006
create table LHX_T_SYS_MENU (
   ID_                  varchar(32)          not null,
   PID                  varchar(32)          null,
   NAME                 varchar(45)          not null,
   NAME_SPELL           varchar(45)          null,
   CODE                 varchar(25)          not null,
   URL                  varchar(300)         null,
   LEVEL_               varchar(2)           not null,
   ICO                  varchar(20)          null,
   ORDER_BY             varchar(3)           null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null default '1',
   constraint PK_LHX_T_SYS_MENU primary key nonclustered (ID_)
)

--系统角色菜单表:001_007
create table LHX_T_SYS_ROLE_MENU (
   ID_                  varchar(32)          not null,
   ROLE_ID              varchar(32)          not null,
   MENU_ID              varchar(32)          not null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null default '1',
   constraint PK_LHX_T_SYS_ROLE_MENU primary key nonclustered (ID_)
)


---系统资源访问表:001_008
if exists (select 1
            from  sysobjects
           where  id = object_id('LHX_T_SYS_RESOURCE')
            and   type = 'U')
   drop table LHX_T_SYS_RESOURCE
go

create table LHX_T_SYS_RESOURCE (
   ID_                  varchar(64)          not null,
   URL                  varchar(300)         null,
   MENU_ID              varchar(64)          null,
   CREATET              varchar(25)          null,
   CREATEP              varchar(64)          null,
   STATUS               varchar(2)           null,
   constraint PK_LHX_T_SYS_RESOURCE primary key nonclustered (ID_)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '系统资源访问表',
   'user', @CurrentUser, 'table', 'LHX_T_SYS_RESOURCE'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '资源ID',
   'user', @CurrentUser, 'table', 'LHX_T_SYS_RESOURCE', 'column', 'ID_'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '资源访问路径',
   'user', @CurrentUser, 'table', 'LHX_T_SYS_RESOURCE', 'column', 'URL'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '菜单ID',
   'user', @CurrentUser, 'table', 'LHX_T_SYS_RESOURCE', 'column', 'MENU_ID'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'LHX_T_SYS_RESOURCE', 'column', 'CREATET'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建人',
   'user', @CurrentUser, 'table', 'LHX_T_SYS_RESOURCE', 'column', 'CREATEP'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '状态',
   'user', @CurrentUser, 'table', 'LHX_T_SYS_RESOURCE', 'column', 'STATUS'
go
