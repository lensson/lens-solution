drop database platform;
CREATE DATABASE platform character set utf8 collate utf8_general_ci;
GRANT ALL PRIVILEGES ON `platform`.* TO 'lens'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

drop database naocs;
CREATE DATABASE naocs character set utf8 collate utf8_general_ci;
GRANT ALL PRIVILEGES ON `naocs`.* TO 'naocs'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;