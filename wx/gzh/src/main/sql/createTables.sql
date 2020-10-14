/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.15 : Database - ry-vue
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `wx_auto_reply`;

CREATE TABLE `wx_auto_reply` (
                                 `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键',
                                 `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
                                 `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
                                 `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
                                 `del_flag` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
                                 `type` char(2) DEFAULT NULL COMMENT '类型（1、关注时回复；2、消息回复；3、关键词回复）',
                                 `req_key` varchar(64) DEFAULT NULL COMMENT '关键词',
                                 `req_type` char(10) DEFAULT NULL COMMENT '请求消息类型（text：文本；image：图片；voice：语音；video：视频；shortvideo：小视频；location：地理位置）',
                                 `rep_type` char(10) DEFAULT NULL COMMENT '回复消息类型（text：文本；image：图片；voice：语音；video：视频；music：音乐；news：图文）',
                                 `rep_mate` char(10) DEFAULT NULL COMMENT '回复类型文本匹配类型（1、全匹配，2、半匹配）',
                                 `rep_content` text COMMENT '回复类型文本保存文字',
                                 `rep_media_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复类型imge、voice、news、video的mediaID或音乐缩略图的媒体id',
                                 `rep_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复的素材名、视频和音乐的标题',
                                 `rep_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '视频和音乐的描述',
                                 `rep_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接',
                                 `rep_hq_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '高质量链接',
                                 `rep_thumb_media_id` varchar(64) DEFAULT NULL COMMENT '缩略图的媒体id',
                                 `rep_thumb_url` varchar(500) DEFAULT NULL COMMENT '缩略图url',
                                 `content` mediumtext COMMENT '图文消息的内容',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='微信自动回复';

/*Data for the table `wx_auto_reply` */

/*Table structure for table `wx_menu` */

DROP TABLE IF EXISTS `wx_menu`;

CREATE TABLE `wx_menu` (
                           `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID（click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、pic_weixin、location_select：保存key）',
                           `del_flag` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
                           `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           `sort` int(11) DEFAULT '1' COMMENT '排序值',
                           `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父菜单ID',
                           `type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单类型click、view、miniprogram、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、pic_weixin、location_select、media_id、view_limited等',
                           `name` varchar(20) DEFAULT NULL COMMENT '菜单名',
                           `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'view、miniprogram保存链接',
                           `ma_app_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '小程序的appid',
                           `ma_page_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '小程序的页面路径',
                           `rep_type` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复消息类型（text：文本；image：图片；voice：语音；video：视频；music：音乐；news：图文）',
                           `rep_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT 'Text:保存文字',
                           `rep_media_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'imge、voice、news、video：mediaID',
                           `rep_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '素材名、视频和音乐的标题',
                           `rep_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '视频和音乐的描述',
                           `rep_url` varchar(500) DEFAULT NULL COMMENT '链接',
                           `rep_hq_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '高质量链接',
                           `rep_thumb_media_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '缩略图的媒体id',
                           `rep_thumb_url` varchar(500) DEFAULT NULL COMMENT '缩略图url',
                           `content` mediumtext COMMENT '图文消息的内容',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='自定义菜单表';

/*Data for the table `wx_menu` */

/*Table structure for table `wx_msg` */

DROP TABLE IF EXISTS `wx_msg`;

CREATE TABLE `wx_msg` (
                          `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键',
                          `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
                          `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
                          `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
                          `del_flag` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
                          `app_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公众号名称',
                          `app_logo` varchar(500) DEFAULT NULL COMMENT '公众号logo',
                          `wx_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信用户ID',
                          `nick_name` varchar(200) DEFAULT NULL COMMENT '微信用户昵称',
                          `headimg_url` varchar(1000) DEFAULT NULL COMMENT '微信用户头像',
                          `type` char(2) DEFAULT NULL COMMENT '消息分类（1、用户发给公众号；2、公众号发给用户；）',
                          `rep_type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息类型（text：文本；image：图片；voice：语音；video：视频；shortvideo：小视频；location：地理位置；music：音乐；news：图文；event：推送事件）',
                          `rep_event` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '事件类型（subscribe：关注；unsubscribe：取关；CLICK、VIEW：菜单事件）',
                          `rep_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '回复类型文本保存文字、地理位置信息',
                          `rep_media_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复类型imge、voice、news、video的mediaID或音乐缩略图的媒体id',
                          `rep_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复的素材名、视频和音乐的标题',
                          `rep_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '视频和音乐的描述',
                          `rep_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接',
                          `rep_hq_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '高质量链接',
                          `content` mediumtext COMMENT '图文消息的内容',
                          `rep_thumb_media_id` varchar(64) DEFAULT NULL COMMENT '缩略图的媒体id',
                          `rep_thumb_url` varchar(500) DEFAULT NULL COMMENT '缩略图url',
                          `rep_location_x` double DEFAULT NULL COMMENT '地理位置维度',
                          `rep_location_y` double DEFAULT NULL COMMENT '地理位置经度',
                          `rep_scale` double DEFAULT NULL COMMENT '地图缩放大小',
                          `read_flag` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '已读标记（1：是；0：否）',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='微信消息';

/*Data for the table `wx_msg` */

/*Table structure for table `wx_user` */

DROP TABLE IF EXISTS `wx_user`;

CREATE TABLE `wx_user` (
                           `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键',
                           `create_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
                           `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新者',
                           `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户备注',
                           `del_flag` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
                           `app_type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '应用类型(1:小程序，2:公众号)',
                           `subscribe` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否订阅（1：是；0：否；2：网页授权用户）',
                           `subscribe_scene` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他',
                           `subscribe_time` datetime DEFAULT NULL COMMENT '关注时间',
                           `subscribe_num` int(11) DEFAULT NULL COMMENT '关注次数',
                           `cancel_subscribe_time` datetime DEFAULT NULL COMMENT '取消关注时间',
                           `open_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户标识',
                           `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
                           `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别（1：男，2：女，0：未知）',
                           `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在城市',
                           `country` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在国家',
                           `province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在省份',
                           `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
                           `language` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户语言',
                           `headimg_url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
                           `union_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'union_id',
                           `group_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户组',
                           `tagid_list` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签列表',
                           `qr_scene_str` varchar(64) DEFAULT NULL COMMENT '二维码扫码场景',
                           `latitude` double DEFAULT NULL COMMENT '地理位置纬度',
                           `longitude` double DEFAULT NULL COMMENT '地理位置经度',
                           `precision` double DEFAULT NULL COMMENT '地理位置精度',
                           `session_key` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会话密钥',
                           `mall_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商城用户ID',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='微信用户';

/*Data for the table `wx_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
