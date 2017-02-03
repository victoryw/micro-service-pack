CREATE DATABASE db_example;
CREATE USER 'springuser'@'%' IDENTIFIED BY 'r0ys1ngh4m';
GRANT ALL ON db_example.* to 'springuser'@'%';
