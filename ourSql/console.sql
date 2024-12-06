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
    constraint fk_d_id foreign key (doctor_id) references doctor(id) on delete cascade on update cascade -- 外键
)comment '患者表';
-- 抑郁自评量表
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
    constraint fk_p_id foreign key (patient_id) references patient(id) on delete cascade on update cascade -- 外键
)comment '抑郁自评量表';
create table ces_d(
                    id int unsigned primary key auto_increment comment 'ID',
                    patient_id int unsigned comment '患者id',
                    patient_nickname varchar(64) default '' comment '患者姓名',
                    createTime datetime not null comment '创建时间',
                    updateTime datetime not null comment '修改时间',
                    grade int unsigned comment '测试分数',
                    result varchar(10) default '' comment '测试结果',
                    ces_d_1 int unsigned comment '第1问',
                    ces_d_2 int unsigned comment '第2问',
                    ces_d_3 int unsigned comment '第3问',
                    ces_d_4 int unsigned comment '第4问',
                    ces_d_5 int unsigned comment '第5问',
                    ces_d_6 int unsigned comment '第6问',
                    ces_d_7 int unsigned comment '第7问',
                    ces_d_8 int unsigned comment '第8问',
                    ces_d_9 int unsigned comment '第9问',
                    ces_d_10 int unsigned comment '第10问',
                    ces_d_11 int unsigned comment '第11问',
                    ces_d_12 int unsigned comment '第12问',
                    ces_d_13 int unsigned comment '第13问',
                    ces_d_14 int unsigned comment '第14问',
                    ces_d_15 int unsigned comment '第15问',
                    ces_d_16 int unsigned comment '第16问',
                    ces_d_17 int unsigned comment '第17问',
                    ces_d_18 int unsigned comment '第18问',
                    ces_d_19 int unsigned comment '第19问',
                    ces_d_20 int unsigned comment '第20问',
                    constraint fk_p_id_1 foreign key (patient_id) references patient(id) on delete cascade on update cascade -- 外键
)comment '流调用抑郁自评量表';
create table madrs(
                      id int unsigned primary key auto_increment comment 'ID',
                      patient_id int unsigned comment '患者id',
                      patient_nickname varchar(64) default '' comment '患者姓名',
                      createTime datetime not null comment '创建时间',
                      updateTime datetime not null comment '修改时间',
                      grade int unsigned comment '测试分数',
                      result varchar(128) default '' comment '测试结果',
                      madrs_1 int unsigned comment '第1问',
                      madrs_2 int unsigned comment '第2问',
                      madrs_3 int unsigned comment '第3问',
                      madrs_4 int unsigned comment '第4问',
                      madrs_5 int unsigned comment '第5问',
                      madrs_6 int unsigned comment '第6问',
                      madrs_7 int unsigned comment '第7问',
                      madrs_8 int unsigned comment '第8问',
                      madrs_9 int unsigned comment '第9问',
                      madrs_10 int unsigned comment '第10问',
                      constraint fk_p_id_2 foreign key (patient_id) references patient(id) on delete cascade on update cascade -- 外键
)comment '蒙哥马利抑郁评定量表';