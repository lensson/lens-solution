CREATE USER 'lens'@'%' IDENTIFIED BY 'lens';

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON `ry-vue`.* TO 'lens'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;