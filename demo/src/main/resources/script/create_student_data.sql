CREATE DATABASE IF NOT EXISTS `my_test`;
CREATE TABLE IF NOT EXISTS `my_test`.`student`
(
    `id`   varchar(100) NOT NULL,
    `name` varchar(100) DEFAULT NULL,
    `age`  int          DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

INSERT INTO my_test.student (id, name, age)
VALUES ('0', '张三0', 29),
       ('1', '张三1', 6),
       ('2', '张三2', 11),
       ('3', '张三3', 24),
       ('4', '张三4', 22),
       ('5', '张三5', 16),
       ('6', '张三6', 23),
       ('7', '张三7', 24),
       ('8', '张三8', 2),
       ('9', '张三9', 24);
