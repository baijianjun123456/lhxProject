--系统用户表:001_001
create table LHX_T_SYS_USER  (
   ID_                  varchar2(64)                    not null,
   ORG_ID               varchar2(100)                   not null,
   ORG_LEVEL            varchar2(40)                    not null,
   ORG_IDENTY           varchar2(40)                    not null,
   PASSWORD             varchar2(64)                    not null,
   ACCOUNTS             varchar2(20)                    not null,
   NAME                 varchar2(40)                    not null,
   NAME_SPELL           varchar2(100),
   SEX                  varchar2(32)                   default '1' ,
   THEM_ID              varchar2(32)                   ,
   HEAD_IMAGE_ID        varchar2(64),
   BIND_ID              varchar2(20),
   EFFECT_DATE          varchar2(20),
   CANCEL_DATE          varchar2(20),
   PHONE                varchar2(15),
   MOBILE               varchar2(20),
   QQ                   varchar2(15),
   WX                   varchar2(25),
   Email             varchar2(50)                    not null,
   IS_OLINE             varchar2(2),
   ORDER_BY             varchar2(3),
   CREATET              varchar2(25),
   CREATEP              varchar2(64),
   STATUS               varchar2(2)                    default '1',
   constraint PK_LHX_T_SYS_USER primary key (ID_)
);

--组织机构表:001_002
create table LHX_T_SYS_ORG  (
   ID_                  varchar2(32)                    not null,
   PID                  varchar2(32),
   FLAG                 varchar2(2)                     not null,
   NAME                 varchar2(50)                    not null,
   SPELL                varchar2(50),
   LEVEL_               varchar2(40)                    not null,
   IDENTY               varchar2(40)                    not null,
   ORDER_BY             varchar2(3),
   CREATET              varchar2(25),
   CREATEP              varchar2(64),
   STATUS               varchar2(2)                    default '1',
   constraint PK_LHX_T_SYS_ORG primary key (ID_)
);

--系统角色表:001_003
create table LHX_T_SYS_ROLE  (
   ID_                  varchar2(32)                    not null,
   NAME                 varchar2(50)                    not null,
   NAME_SPELL           varchar2(50),
   ORG_ID               varchar2(32),
   ORG_LEVEL            varchar2(40),
   ORG_IDENTY           varchar2(40),
   DESC             varchar2(300),
   CREATET              varchar2(25),
   CREATEP              varchar2(64),
   STATUS               varchar2(2)                    default '1',
   constraint PK_LHX_T_SYS_ROLE primary key (ID_)
);

--用户组织机构表:001_004
create table LHX_T_SYS_USER_ORG  (
   ID_                  varchar2(32)                    not null,
   ORG_ID               varchar2(32)                    not null,
   SHOW_NAME            varchar2(40)                    not null,
   ORDER_BY             varchar2(3),
   CREATET              varchar2(25),
   CREATEP              varchar2(64),
   STATUS               varchar2(2)                    default '1',
   constraint PK_LHX_T_SYS_USER_ORG primary key (ID_)
);

--用户角色表:001_005
create table LHX_T_SYS_USER_ROLE  (
   ID_                  varchar2(32)                    not null,
   USER_ID              varchar2(32)                    not null,
   ROLE_ID              varchar2(32)                    not null,
   ORDER_BY             varchar2(3),
   CREATET              varchar2(25),
   CREATEP              varchar2(64),
   STATUS               varchar2(2)                    default '1',
   constraint PK_LHX_T_SYS_USER_ROLE primary key (ID_)
);

--系统菜单表:001_006
create table LHX_T_SYS_MENU  (
   ID_                  varchar2(32)                    not null,
   PID                  varchar2(32),
   NAME                 varchar2(45)                    not null,
   NAME_SPELL           varchar2(45),
   CODE                 varchar2(25)                    not null,
   URL                  varchar2(300),
   LEVEL_               varchar2(2)                     not null,
   ICO                  varchar2(20),
   ORDER_BY             varchar2(3),
   CREATET              varchar2(25),
   CREATEP              varchar2(64),
   STATUS               varchar2(2)                    default '1',
   constraint PK_LHX_T_SYS_MENU primary key (ID_)
);

--系统角色菜单表:001_007
create table LHX_T_SYS_ROLE_MENU  (
   ID_                  VARCHAR2(32)                    not null,
   ROLE_ID              VARCHAR2(32)                    not null,
   MENU_ID              VARCHAR2(32)                    not null,
   CREATET              VARCHAR2(25),
   CREATEP              VARCHAR2(64),
   STATUS               VARCHAR2(2)                    default '1',
   constraint PK_LHX_T_SYS_ROLE_MENU primary key (ID_)
);

--系统资源访问表:001_008
drop table LHX_T_SYS_RESOURCE cascade constraints;
create table LHX_T_SYS_RESOURCE 
(
   ID_                  VARCHAR2(64)         not null,
   URL                  VARCHAR2(300),
   MENU_ID              VARCHAR2(64),
   CREATET              VARCHAR2(25),
   CREATEP              VARCHAR2(64),
   STATUS               VARCHAR2(2),
   constraint LHX_T_SYS_RESOURCE primary key (ID_)
);

comment on table LHX_T_SYS_RESOURCE is
'系统资源访问表';

comment on column LHX_T_SYS_RESOURCE.ID_ is
'资源ID';

comment on column LHX_T_SYS_RESOURCE.URL is
'资源访问路径';

comment on column LHX_T_SYS_RESOURCE.MENU_ID is
'菜单ID';

comment on column LHX_T_SYS_RESOURCE.CREATET is
'创建时间';

comment on column LHX_T_SYS_RESOURCE.CREATEP is
'创建人';

comment on column LHX_T_SYS_RESOURCE.STATUS is
'状态';
