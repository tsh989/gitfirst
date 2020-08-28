CREATE TABLE base_user(
id INT PRIMARY KEY AUTO_INCREMENT,
dept VARCHAR(32),
market VARCHAR(255)
)

SELECT u.*,bu.dept,bu.market FROM USER u,base_user bu 
WHERE u.id=bu.id

CREATE TABLE user_order(
order_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
prise DECIMAL(11,2),
create_time DATETIME
)
UPDATE user_order SET create_time=NOW()

SELECT * FROM USER u,user_order uo
WHERE u.id=uo.user_id

SELECT * FROM user_order uo,USER u
WHERE uo.user_id=u.id


CREATE TABLE USER (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '主键' ,
NAME VARCHAR(20) NOT NULL COMMENT '姓名',
pwd VARCHAR(20) NOT NULL COMMENT '密码',
age INT COMMENT '年龄',
sex VARCHAR(2) COMMENT '性别1：男 0：女',
tel VARCHAR(11) COMMENT '电话',
POINT INT NOT NULL DEFAULT 0 COMMENT '积分 默认值为0',
createtime DATETIME NOT NULL COMMENT '用户创建时间'
)
CREATE TABLE role(
role_id INT  PRIMARY KEY NOT NULL COMMENT '角色id',
role_name VARCHAR(20) NOT NULL COMMENT '角色名字',
role_desc VARCHAR(255) NOT NULL COMMENT '角色描述'
) 

CREATE TABLE user_role(
user_id INT  NOT NULL COMMENT '用户编号',
role_Id INT NOT NULL COMMENT '角色编号'
)
DROP TABLE user_role

SELECT * FROM USER 
SELECT * FROM USER WHERE NAME IN ('张三','李四')
DELETE FROM USER WHERE id IN(6,7)
INSERT INTO USER(NAME,PASSWORD,age,sex,tel,POINT,createtime) VALUES(1,1,1,1,1,1,NOW())

SELECT * FROM role,user_role ur,USER
WHERE role.role_id=1 AND role.role_id=ur.role_Id AND ur.user_id=user.id

SELECT * FROM `user`,user_role ur,role
WHERE user.id IN(4) AND user.id=ur.user_id AND ur.role_Id=role.role_id

SELECT * FROM `user`,user_role ur,role 
WHERE user.id IN( ? , ? ) AND user.id=ur.user_id AND ur.role_Id=role.role_id

SELECT * FROM `user`,user_role ur,role WHERE user.id IN( 1 ) AND user.id=ur.user_id AND ur.role_Id=role.role_id 
SELECT * FROM `user` WHERE `user`.id IN( 1) 