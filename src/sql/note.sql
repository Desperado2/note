
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` varchar(36) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `authorId` varchar(36) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `liked` int(11) DEFAULT NULL,
  `commited` int(11) DEFAULT NULL,
  `readed` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `sex` int(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleteFlag` int(11) DEFAULT NULL,
  `activeFlag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
