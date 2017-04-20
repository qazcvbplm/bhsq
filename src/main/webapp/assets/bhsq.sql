# Host: 127.0.0.1  (Version: 5.5.29)
# Date: 2017-04-20 17:14:25
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;

DROP DATABASE IF EXISTS `bhsq`;
CREATE DATABASE `bhsq` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bhsq`;

#
# Source for table "article"
#

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT '',
  `text` text,
  `visitor` int(11) DEFAULT '0',
  `userid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `sort` varchar(20) DEFAULT '0',
  `parent` int(11) DEFAULT '0',
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "article"
#

INSERT INTO `article` VALUES (5,'宁波某高校姚某离奇失踪3','<p style=\"text-align: center;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;宁波某高校姚某离奇失踪宁波某高校姚某离奇失踪宁波某高校姚某离奇失踪宁波某高校姚某离奇失踪\t\t\t </p><p style=\"text-align: center;\"><img src=\"http://localhost:8080/bhsq/ue/jsp/upload/20170420/55391492663170676.jpg\"/></p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\t\t\t</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\t\t\t</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\t\t\t</p>',0,0,1,'2017-04-20 12:39:33','',2,'upload/u20170420143208-0.jpg,upload/u20170420143154-1.jpg,'),(6,'宁波某高校姚某离奇失踪2下篇','<p style=\"text-align: center;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇宁波某高校姚某离奇失踪2下篇\t\t\t </p><p style=\"text-align: center;\"><img src=\"http://localhost:8080/bhsq/ue/jsp/upload/20170420/89801492663209266.jpg\"/></p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\t\t\t</p>',10,0,1,'2017-04-20 12:44:21','001',2,'upload/u20170420124421-0.jpg,upload/u20170420124421-1.jpg,');

#
# Source for table "config"
#

DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `admin` varchar(20) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL,
  `simage` varchar(255) DEFAULT NULL,
  `qimage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "config"
#


#
# Source for table "level"
#

DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(100) DEFAULT '',
  `number` tinyint(3) DEFAULT '0',
  `ex` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

#
# Data for table "level"
#

INSERT INTO `level` VALUES (1,'level/level_00.jpg',0,99),(2,'level/level_01.jpg',0,200),(3,'level/level_02.jpg',0,500),(4,'level/level_03.jpg',0,1000),(5,'level/level_04.jpg',0,2000),(6,'level/level_05.jpg',0,5000),(7,'level/level_06.jpg',0,10000),(8,'level/level_07.jpg',0,20000),(9,'level/level_08.jpg',0,50000),(10,'level/level_09.jpg',0,100000),(11,'level/level_10.jpg',0,200000),(12,'level/level_11.jpg',0,500000),(13,'level/level_12.jpg',0,1000000),(14,'level/level_13.jpg',0,2000000),(15,'level/level_14.jpg',0,4000000),(16,'level/level_15.jpg',0,6000000),(17,'level/level_16.jpg',0,8000000),(18,'level/level_17.jpg',0,10000000),(19,'level/level_18.jpg',0,20000000),(20,'level/level_19.jpg',0,50000000),(21,'level/level_20.jpg',0,100000000);

#
# Source for table "plate"
#

DROP TABLE IF EXISTS `plate`;
CREATE TABLE `plate` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(100) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `visitor` int(11) DEFAULT NULL,
  `sort` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "plate"
#

INSERT INTO `plate` VALUES (2,'u20170420095729.jpg','滨海交通',100,'001');

#
# Source for table "ship"
#

DROP TABLE IF EXISTS `ship`;
CREATE TABLE `ship` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `articleid` int(11) DEFAULT '0',
  `userid` int(11) DEFAULT '0',
  `type` int(11) DEFAULT '0',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "ship"
#


#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT '',
  `head` varchar(200) DEFAULT '',
  `ex` int(11) DEFAULT '0',
  `introduction` varchar(255) DEFAULT '',
  `sex` int(1) DEFAULT '0',
  `birth` varchar(20) DEFAULT '',
  `wxnumber` varchar(20) DEFAULT '',
  `openid` varchar(100) DEFAULT '',
  `levelid` int(11) DEFAULT '1',
  `lasttime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'ops','http://wx.qlogo.cn/mmopen/vi_32/XzYJ7aMD4dlWzI7Ke494Hmb4OdvPNEMfibNBhfoe173xTEF4RCcjwNgClxg96mVupdzCMIMeicZEjb6m9eXRug8w/0',0,'我是',1,'','tzh205240','',1,'2017-04-20 16:14:00');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
