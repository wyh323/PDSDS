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
-- 抑郁自评量表
USE pdsds;
create table sds(
    id int unsigned primary key auto_increment comment 'ID',
    patient_id int unsigned comment '患者id',
    patient_nickname varchar(64) default '' comment '患者姓名',
    createTime datetime not null comment '创建时间',
    updateTime datetime not null comment '修改时间',
    grade int unsigned comment '测试分数',
    result varchar(10) default '' comment '测试结果',
    sds_1 int unsigned comment '第1问',
    sds_2 int unsigned comment '第2问',
    sds_3 int unsigned comment '第3问',
    sds_4 int unsigned comment '第4问',
    sds_5 int unsigned comment '第5问',
    sds_6 int unsigned comment '第6问',
    sds_7 int unsigned comment '第7问',
    sds_8 int unsigned comment '第8问',
    sds_9 int unsigned comment '第9问',
    sds_10 int unsigned comment '第10问',
    sds_11 int unsigned comment '第11问',
    sds_12 int unsigned comment '第12问',
    sds_13 int unsigned comment '第13问',
    sds_14 int unsigned comment '第14问',
    sds_15 int unsigned comment '第15问',
    sds_16 int unsigned comment '第16问',
    sds_17 int unsigned comment '第17问',
    sds_18 int unsigned comment '第18问',
    sds_19 int unsigned comment '第19问',
    sds_20 int unsigned comment '第20问',
    constraint fk_p_id foreign key (patient_id) references patient(id)-- 外键
)comment '抑郁自评量表';
USE pdsds;
create table ces_d(
                    id int unsigned primary key auto_increment comment 'ID',
                    patient_id int unsigned comment '患者id',
                    patient_nickname varchar(64) default '' comment '患者姓名',
                    createTime datetime not null comment '创建时间',
                    updateTime datetime not null comment '修改时间',
                    grade int unsigned comment '测试分数',
                    result varchar(10) default '' comment '测试结果',
                    sds_1 int unsigned comment '第1问',
                    sds_2 int unsigned comment '第2问',
                    sds_3 int unsigned comment '第3问',
                    sds_4 int unsigned comment '第4问',
                    sds_5 int unsigned comment '第5问',
                    sds_6 int unsigned comment '第6问',
                    sds_7 int unsigned comment '第7问',
                    sds_8 int unsigned comment '第8问',
                    sds_9 int unsigned comment '第9问',
                    sds_10 int unsigned comment '第10问',
                    sds_11 int unsigned comment '第11问',
                    sds_12 int unsigned comment '第12问',
                    sds_13 int unsigned comment '第13问',
                    sds_14 int unsigned comment '第14问',
                    sds_15 int unsigned comment '第15问',
                    sds_16 int unsigned comment '第16问',
                    sds_17 int unsigned comment '第17问',
                    sds_18 int unsigned comment '第18问',
                    sds_19 int unsigned comment '第19问',
                    sds_20 int unsigned comment '第20问',
                    constraint fk_p_id_1 foreign key (patient_id) references patient(id)-- 外键
)comment '流调用抑郁自评量表';