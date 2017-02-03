CREATE DATABASE db_example;
CREATE USER 'springuser'@'%' IDENTIFIED BY 'r0ys1ngh4m';
GRANT ALL ON db_example.* to 'springuser'@'%';
use db_example -A
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
