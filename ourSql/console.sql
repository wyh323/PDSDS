-- 创建数据库
CREATE database pdsds;
-- 使用pdsds
USE pdsds;
-- 管理员表
create table administrator (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(15) not null unique comment '用户名',
    password varchar(128) comment '密码',
    createTime datetime not null comment '创建时间',
    updateTime datetime not null comment '修改时间'
)comment '管理员表';
-- 医生表
create table doctor (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(15) not null unique comment '用户名',
    password varchar(128) comment '密码',
    nickname varchar(64) default '' comment '医生姓名',
    email varchar(256) default '' comment '医生邮箱',
    pic varchar(256) default '' comment '医生头像',
    address varchar(256) default '' comment '上班地点',
    createTime datetime not null comment '创建时间',
    updateTime datetime not null comment '修改时间'
)comment '医生表';
-- 患者表
create table patient (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(15) not null unique comment '患者用户名',
    password varchar(128) comment '密码',
    nickname varchar(64) default '' comment '患者姓名',
    email varchar(256) default '' comment '患者邮箱',
    pic varchar(256) default '' comment '患者头像',
    doctor_id int unsigned comment '医生id',
    doctor_nickname varchar(64) default '' comment '医生姓名',
    createTime datetime not null comment '创建时间',
    updateTime datetime not null comment '修改时间',
    constraint fk_d_id foreign key (doctor_id) references doctor(id)-- 外键
)comment '患者表';