drop database gzh;
CREATE DATABASE gzh character set utf8 collate utf8_general_ci;
GRANT ALL PRIVILEGES ON `gzh`.* TO 'lens'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
