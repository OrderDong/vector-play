drop table if exists t_sys_user;
drop table if exists t_war;

create table t_sys_user (
  id bigint auto_increment COMMENT '主键',
  username varchar(50) NOT NULL COMMENT '登录名',
  password varchar(100) NOT NULL COMMENT '密码',
  salt varchar(100),
  role_ids varchar(100) COMMENT '角色列表',
  name varchar(50) DEFAULT NULL COMMENT '员工姓名',
  organization_id bigint COMMENT '组织id',
  organization_name varchar(50) DEFAULT NULL COMMENT '组织名称',
  mobile varchar(50) DEFAULT NULL COMMENT '移动电话',
  email varchar(50) DEFAULT NULL COMMENT '邮箱',
  qq varchar(20) DEFAULT NULL COMMENT 'qq',
  remark varchar(500) DEFAULT NULL COMMENT '备注',
  create_user varchar(50) DEFAULT NULL COMMENT '创建人',
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL COMMENT '更新时间',
  update_user varchar(45) DEFAULT NULL COMMENT '更新人',
  locked bool default false COMMENT '是否有效',
  status int(1) DEFAULT NULL COMMENT '0未删除，1删除',
  constraint pk_t_sys_user primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_t_sys_user_username on t_sys_user(username);
create index idx_t_sys_user_organization_id on t_sys_user(organization_id);
create index idx_t_sys_user_status on t_sys_user(status);
create index idx_t_sys_user_mobile on t_sys_user(mobile);

create table t_war (
  id bigint auto_increment COMMENT '主键',
  tx_hash varchar(100) COMMENT '发起HASH',
  token_count int DEFAULT 0 COMMENT '获得20token数量',
  card_id varchar(100) DEFAULT NULL COMMENT '卡牌tokenId',
  card_type TINYINT COMMENT '卡牌类型',
  token_hash varchar(100) COMMENT '发起划转token tx',
  card_hash varchar(100) COMMENT '发起划转card tx',
  award_user varchar(100) DEFAULT NULL COMMENT '接受人',
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL COMMENT '更新时间',
  update_user varchar(100) DEFAULT NULL COMMENT '更新人',
  status_ddc int(1) DEFAULT NULL COMMENT '1:完成,2:未完成',
  status_card int(1) DEFAULT NULL COMMENT '1:完成,2:未完成',
  constraint pk_t_war primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_t_war_award_user_id on t_war(award_user);
