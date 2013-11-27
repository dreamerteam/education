ALTER TABLE t_course_type ADD ccode VARCHAR(500) NOT NULL; -- 代码
ALTER TABLE t_course_type ADD cstatus VARCHAR(1) NOT NULL; -- 状态【0：删除；1：启用】

-- 2013-10-28
ALTER TABLE t_course_type ADD cpinyin VARCHAR(100) NULL; -- 拼音

-- 2013-11-4
ALTER TABLE t_course MODIFY COLUMN cdescription VARCHAR(500)

-- 2013-11-4
ALTER TABLE t_student MODIFY COLUMN cname VARCHAR(36) NULL;
ALTER TABLE t_student MODIFY COLUMN csex VARCHAR(2) NULL;

-- 2013-11-18
ALTER TABLE t_resource ADD cfree VARCHAR(1) NOT NULL; -- 免费【0:不免费；1：免费】

-- 2013-11-19
ALTER TABLE t_lession CHANGE dlesson dlession datetime NOT NULL;
ALTER TABLE t_course ADD copen VARCHAR(1) NULL; -- 是否开课【0：待开课；1：开课】

-- 2013-11-20
ALTER TABLE t_lession CHANGE dlession dbgnlession datetime NOT NULL; -- 开课起始时间
ALTER TABLE t_lession ADD dendlession datetime NOT null; -- 开课结束时间
ALTER TABLE t_lession ADD cperiod VARCHAR(100) NOT NULL; -- 开课间隔时间【每天、周末、周一....】

-- 2013-11-21
ALTER TABLE t_lession_select RENAME TO t_course_favorite;

-- 2013-11-25
ALTER TABLE t_course add cpath VARCHAR(500) NULL; -- 课程图片路径
ALTER TABLE t_teacher ADD cdescription VARCHAR(500) NULL; -- 教师自我介绍

-- 2013-11-26
ALTER TABLE t_lession CHANGE cperiod ctime VARCHAR(100) NULL; -- 上课时间