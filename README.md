# wx-garbage-backend

微信小程序--垃圾分类后端


# 小程序技术
样式:weui
深度学习框架:Paddle.js
位置插件:腾讯定位选点服务
代码地址https://github.com/0xiaoyu/wx-garbage

# 小程序后端代码
语言:java
依赖管理:maven
框架:springboot mybatis-plus
数据库:mysql

# 项目介绍
微信小程序期末作业--垃圾分类后端代码
由springboot和mybatis-plus快速开发

存储机器学习的数据库

# 项目缺陷
后台审核平台未做 懒得搞的，本来的设计是应该要有一个后台审核的，不可能说用户说添加就添加的。

# 数据库设计图
![1](https://github.com/0xiaoyu/wx-garbage-backend/assets/107329505/f6c8ed78-0d1c-4696-bcdb-3e31cdf68cd6)
sql小脚本
```sql
create table garbage_location
(
    latitude  double(8, 5) not null comment '纬度',
    longitude double(8, 5) not null comment '经度',
    name      char(10)     null comment '名字',
    type      varchar(10)  null comment '垃圾桶类型',
    id        int auto_increment comment '垃圾桶id'
        primary key
)
    comment '记录垃圾桶的位置信息';

create table sorted
(
    ID     int          not null comment '分类的ID'
        primary key,
    name   char(5)      not null comment '类型的名字',
    detail varchar(600) not null comment '类型的描述'
);

create table refuse
(
    id        int auto_increment
        primary key,
    name      varchar(10)   not null comment '垃圾的名字',
    sortId    int           not null comment '垃圾的类别',
    detail    varchar(1000) null comment '详细描述',
    imagePath varchar(50)   null comment '图片路径',
    constraint refuse_sorted_ID_fk
        foreign key (sortId) references sorted (ID)
);

create table history
(
    id       int auto_increment
        primary key,
    userId   char(30)     not null comment '用户id',
    his      varchar(100) not null comment '历史记录描述',
    type     int          not null comment '历史类型 1为查询 2为添加类别记录 3 为添加垃圾桶位置记录',
    refuseId int          null comment '垃圾的id',
    constraint history_refuse_id_fk
        foreign key (refuseId) references refuse (id)
);

create table requirements
(
    sortedID    int          not null comment '垃圾的主键',
    id          int auto_increment
        primary key,
    requirement varchar(100) null comment '建议',
    constraint requirements_sorted_ID_fk
        foreign key (sortedID) references sorted (ID)
);


```

