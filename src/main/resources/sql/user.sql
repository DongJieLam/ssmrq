create table user
(
    id       int auto_increment comment '用户ID'
        primary key,
    email    varchar(255)           not null comment '用户邮箱',
    username varchar(255)           not null comment '用户昵称',
    role     varchar(255)           null comment '用户身份',
    password varchar(255)           not null comment '密码',
    mobile   varchar(50) default '' null comment '手机号码'
)
    comment '用户表';

INSERT INTO user (id, email, username, role, password, mobile) VALUES (1, 'doggie@163.com', 'doggie', 'admin', '123456', '17876662353');
INSERT INTO user (id, email, username, role, password, mobile) VALUES (2, 'jager@123.com', 'Jager', null, '123', null);
INSERT INTO user (id, email, username, role, password, mobile) VALUES (3, 'ela@123.com', 'Ela', null, '123456', null);