ALTER TABLE t_course_type ADD ccode VARCHAR(500) NOT NULL; -- 代码
ALTER TABLE t_course_type ADD cstatus VARCHAR(1) NOT NULL; -- 状态【0：删除；1：启用】