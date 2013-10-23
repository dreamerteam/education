create database education;
use education;

-- 用户登录表
create table t_user(
	uuid			varchar(36)			not null,	-- 主键id
	clogin			varchar(36)			not null,	-- 登录名
	cpassword		varchar(36)			not null,	-- 密码
	ctype			varchar(36)			not null, -- 用户类型【supermanager，manager，teacher，student】
	upersonid		varchar(36)			not null, -- 指向用户信息表【t_manager.uuid, t_teacher.uuid, t_student.uuid】
	cmemo			varchar(255)		null,		-- 备注
	cstatus			varchar(1)			not null,		-- 状态（0:停用	1:启用）
	dcreate			datetime			not null,	-- 创建日期
	dupdate			datetime			not null	-- 更新日期
);
alter table t_user add constraint PK_USER primary key (uuid);

-- 管理员信息表
create table t_manager(
	uuid			varchar(36)			not null,	-- 主键id
	cname			varchar(36)			not null,	-- 姓名
	csex			varchar(2)			not null,	-- 性别【男，女】
	cidcard			varchar(18)			null,	-- 身份证
	cnativeplace	varchar(36)			null,	-- 籍贯
	ceducation		varchar(36)			null,	-- 学历
	dbirthday		datetime			null,	-- 生日
	dentry			datetime			null,	-- 入职日期
	dmission		datetime			null,	-- 离职日期
	cmobile			varchar(11)			null,	-- 手机号
	cfixedline		varchar(36)			null,	-- 固话
	caddress		varchar(255)		null,	-- 住址
	cqq				varchar(36)			null,	-- QQ号
	cemail			varchar(100)		null,	-- 邮箱地址
	cmsn			varchar(36)			null,	-- MSN号
	ccountry		varchar(36)			null,	-- 国籍
	dcreate			datetime			not null,	-- 创建日期
	dupdate			datetime			not null	-- 更新日期
);
alter table t_manager add constraint PK_MANAGER primary key (uuid);

-- 教师信息表
create table t_teacher(
	uuid			varchar(36)			not null,	-- 主键id
	cname			varchar(36)			not null,	-- 姓名
	csex			varchar(2)			not null,	-- 性别【男，女】
	cidcard			varchar(18)			null,	-- 身份证
	cnativeplace	varchar(36)			null,	-- 籍贯
	ceducation		varchar(36)			null,	-- 学历
	dbirthday		datetime			null,	-- 生日
	dentry			datetime			null,	-- 入职日期
	dmission		datetime			null,	-- 离职日期
	cmobile			varchar(11)			null,	-- 手机号
	cfixedline		varchar(36)			null,	-- 固话
	caddress		varchar(255)		null,	-- 住址
	cqq				varchar(36)			null,	-- QQ号
	cmsn			varchar(36)			null,	-- MSN号
	cemail			varchar(100)		null,	-- 邮箱地址	
	ccountry		varchar(36)			null,	-- 国籍
	cno				varchar(36)			null,-- 教师编号
	cnickname		varchar(36)			null,-- 教师昵称
	dcreate			datetime			not null,	-- 创建日期
	dupdate			datetime			not null	-- 更新日期
);
alter table t_teacher add constraint PK_TEACHER primary key (uuid);

-- 学生信息表
create table t_student(
	uuid			varchar(36)			not null,	-- 主键id
	cname			varchar(36)			not null,	-- 姓名
	csex			varchar(2)			not null,	-- 性别【男，女】
	cidcard			varchar(18)			null,	-- 身份证
	cnativeplace	varchar(36)			null,	-- 籍贯
	ceducation		varchar(36)			null,	-- 学历
	dbirthday		datetime			null,	-- 生日
	cmobile			varchar(11)			null,	-- 手机号
	cfixedline		varchar(36)			null,	-- 固话
	caddress		varchar(255)		null,	-- 住址
	cqq				varchar(36)			null,	-- QQ号
	cmsn			varchar(36)			null,	-- MSN号
	cemail			varchar(100)		null,	-- 邮箱地址	
	ccountry		varchar(36)			null,	-- 国籍
	cno				varchar(36)			null,-- 学生编号
	cnickname		varchar(36)			null,-- 学生昵称
	dcreate			datetime			not null,	-- 创建日期
	dupdate			datetime			not null	-- 更新日期
);
alter table t_student add constraint PK_STUDENT primary key (uuid);

-- 操作日志表
create table t_operate_log(
	uuid				varchar(36)			not null,	-- 主键id
	uuserid				varchar(36)			not null,	-- 用户登录id【t_user.uuid】
	doperate			datetime			not null,	-- 操作时间
	cip					varchar(15)			not null,	-- ip地址
	curl				varchar(128)		not null,	-- 操作url
	ctype				varchar(36)			null,		-- 操作类型
 	cmemo				varchar(255)		null	-- 备注
);
alter table t_operate_log add constraint PK_OPERATE_LOG primary key (uuid);

-- 课程类型表
CREATE TABLE t_course_type(
	uuid 				VARCHAR(36)			NOT NULL,-- 主键id
	cname 				VARCHAR(36)			not NULL,-- 名称
	ilevel				INT					not NULL,-- 等级
	uparentid			VARCHAR(36)			NULL,-- 父级id
	uuserid             varchar(36)         not null,-- 操作人id【t_user.uuid】
	dcreate				datetime			NOT NULL,-- 创建时间
	dupdate				datetime			NOT NULL -- 更新时间
);
alter table t_course_type add constraint PK_COURSE_TYPE primary key (uuid);

-- 课程表
CREATE TABLE t_course(
	uuid 				VARCHAR(36)			NOT NULL,-- 主键id
	cname 				VARCHAR(36)			not NULL,-- 名称
	utypeid				VARCHAR(36)			NOT NULL, -- 课程类型id（t_course_type.uuid）
	cdescription      	VARCHAR(36)			null,-- 课程简介
	cstatus   			VARCHAR(1)			not null,-- 状态【0：未启用；1：启用】
	uuserid   			VARCHAR(36)			not null,-- 用户id【t_user.uuid】
	ihot				int					default 0 not null,-- 热门程度
	caudit   			VARCHAR(2)			not null,-- 审核状态【0：未审核；10：待审核；20：通过审核；30：未通过审核】
	ckeyword			VARCHAR(255)		null,-- 关键字
	cmemo				VARCHAR(255)		NULL,-- 备注
	dcreate				datetime			NOT NULL,-- 创建时间
	dupdate				datetime			NOT NULL -- 更新时间
);
alter table t_course add constraint PK_COURSE primary key (uuid);

-- 上课时间表
CREATE TABLE t_lession(
	uuid 				VARCHAR(36)			NOT NULL,-- 主键id
	uteacherid			VARCHAR(36)			NULL,-- 教师id【t_teacher.uuid】
	ustudentid 			VARCHAR(36)			NULL,-- 学生id【t_student.uuid】
	ucourseid			VARCHAR(36)			NOT NULL,-- 课程id【t_course.uuid】
	dlesson				datetime			NOT NULL,-- 上课时间
	uuserid				VARCHAR(36)			NOT NULL,-- 用户id【t_user.uuid】
	cobject				VARCHAR(36)			NOT NULL,-- 上课对象【teacher, student】
	dcreate				datetime			NOT NULL,-- 创建时间
	dupdate				datetime			NOT NULL -- 更新时间
);
alter table t_lession add constraint PK_LESSION primary key (uuid);

-- 选课表
CREATE TABLE t_lession_select(
	uuid 				VARCHAR(36)			NOT NULL,-- 主键id
	ucourseid			VARCHAR(36)			NOT NULL,-- 课程id【t_course.uuid】
	uuserid				VARCHAR(36)			NOT NULL,-- 用户id【t_user.uuid】
	dcreate				datetime			NOT NULL,-- 创建时间
	dupdate				datetime			NOT NULL -- 更新时间 
);
alter table t_lession_select add constraint PK_LESSION_SELECT primary key (uuid);

-- 资源上传表
CREATE TABLE t_resource(
	uuid 				VARCHAR(36)			NOT NULL,-- 主键id
	cname				VARCHAR(36)			NOT NULL,-- 名称
	ctype				VARCHAR(36)			NOT NULL,-- 类型【ppt、word、audio、video】
	cpath				VARCHAR(500)		NOT NULL,-- 文件上传路径
	cpictureurl  		VARCHAR(500)		null,-- 图片上传路径
	csize				VARCHAR(36)			NULL,-- 文件大小KB
	uuserid				VARCHAR(36)			NOT NULL,-- 用户id【t_user.uuid】
	cdescription		text				null,-- 简介
	ckeyword			VARCHAR(255)		null,-- 关键字
	dcreate				datetime			NOT NULL,-- 创建时间
	dupdate				datetime			NOT NULL -- 更新时间
);
alter table t_resource add constraint PK_RESOURCE primary key (uuid);





