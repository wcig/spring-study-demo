-- 1.数据库
CREATE
DATABASE `spring_study_demo` DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;

-- 2.用户信息表
CREATE TABLE `spring_study_demo`.`user`
(
    `id`          int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
    `phone`       varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '手机号',
    `password`    varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `create_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';

-- 3.连表映射
-- 一对一映射 student-card
-- 一对多映射 grade-student
-- 多对多映射 student-course
-- 学生信息表
CREATE TABLE `spring_study_demo`.`student`
(
    `student_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`       varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
    `card_id`    int(11) unsigned NOT NULL DEFAULT '0' COMMENT '身份证id',
    `grade_id`   int(11) unsigned NOT NULL DEFAULT '0' COMMENT '班级id',
    PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='学生信息表';

-- 身份证信息表
CREATE TABLE `spring_study_demo`.`card`
(
    `card_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `num`     varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '身份证号',
    PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='身份证信息表';

-- 班级信息表
CREATE TABLE `spring_study_demo`.`grade`
(
    `grade_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
    `name`     varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级名称',
    PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='班级信息表';

-- 课程信息表
CREATE TABLE `spring_study_demo`.`course`
(
    `course_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
    `name`      varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名称',
    PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='课程信息表';

-- 学生课程映射表
CREATE TABLE `spring_study_demo`.`student_course_mapping`
(
    `student_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
    `course_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '主键id',
    PRIMARY KEY (`student_id`, `course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='学生课程映射表';

-- 插入记录
insert into student (student_id, name, card_id, grade_id) values ('1', 'tom', '1', '1');
insert into student (student_id, name, card_id, grade_id) values ('2', 'jerry', '2', '1');
insert into card (card_id, num) values ('1', '001');
insert into card (card_id, num) values ('2', '002');
insert into grade (grade_id, name) values ('1', '一班');
insert into course (course_id, name) value ('1', '数学');
insert into course (course_id, name) value ('2', '语文');
insert into student_course_mapping (student_id, course_id) value ('1', '1');
insert into student_course_mapping (student_id, course_id) value ('1', '2');
insert into student_course_mapping (student_id, course_id) value ('2', '1');
insert into student_course_mapping (student_id, course_id) value ('2', '2');

-- 4.类型测试表
CREATE TABLE `spring_study_demo`.`int_type_test`
(
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    tinyint_t tinyint,
    smallint_t smallint,
    middleint_t middleint,
    int_t int,
    bigint_t bigint,
    float_t float,
    double_t double,
    decimal_t decimal(6,2),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='数字类型测试表';

CREATE TABLE `spring_study_demo`.`string_type_test`
(
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    char_t char(32),
    varchar_t varchar(32),
    tinytext_t tinytext,
    text_t text,
    mediumtext_t mediumtext,
    longtext_t longtext,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='字符串类型测试表';

CREATE TABLE `spring_study_demo`.`time_type_test`
(
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    year_t year,
    date_t date,
    time_t time,
    datetime_t datetime,
    timestamp_t timestamp,
    bigint_t bigint,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='时间类型测试表';

CREATE TABLE `spring_study_demo`.`enum_type_test`
(
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    enum_t enum('f', 'm'),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='枚举类型测试表';
