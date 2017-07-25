-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.45 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 likai.admin_log 结构
CREATE TABLE IF NOT EXISTS `admin_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actionDesc` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `actionDetail` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `actionId` int(11) NOT NULL,
  `actionTime` datetime NOT NULL,
  `userId` int(11) NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 likai.admin_permission 结构
CREATE TABLE IF NOT EXISTS `admin_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catLog` varchar(255) CHARACTER SET utf8 NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `subCatLog` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wildcard` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 likai.admin_role 结构
CREATE TABLE IF NOT EXISTS `admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 likai.admin_role_permission 结构
CREATE TABLE IF NOT EXISTS `admin_role_permission` (
  `permissionId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `FK_hb87xp9ypilwo06y4hrqv752r` (`permissionId`),
  CONSTRAINT `FK_he0oclmbu93yd7o2at4or0guf` FOREIGN KEY (`roleId`) REFERENCES `admin_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 likai.admin_user 结构
CREATE TABLE IF NOT EXISTS `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `plainPassword` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 likai.admin_user_role 结构
CREATE TABLE IF NOT EXISTS `admin_user_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`userId`),
  KEY `FK_rro158htgi8ofr9tg3s5cb7m4` (`userId`),
  CONSTRAINT `FK_q1px3r0hcp9bnq4yye4ef1wqf` FOREIGN KEY (`roleId`) REFERENCES `admin_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 likai.admin_user_role_time 结构
CREATE TABLE IF NOT EXISTS `admin_user_role_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `roleId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_a1j7o8ow0gj8w66m4cebhopy0` (`roleId`),
  KEY `FK_k7h7g0wwlkh2iwluaj6oyvw6w` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 数据导出被取消选择。


-- 导出  表 likai.user_test 结构
CREATE TABLE IF NOT EXISTS `user_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `edit_time` datetime NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
