/*
SQLyog Ultimate v8.32
MySQL - 5.5.27 : Database - stu_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stu_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `stu_db`;

/*Table structure for table `teacher_student` */

DROP TABLE IF EXISTS `teacher_student`;

CREATE TABLE `teacher_student` (
                                   `id` int(32) NOT NULL AUTO_INCREMENT,
                                   `sid` int(32) DEFAULT NULL,
                                   `tid` int(32) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `teacher_student` */

insert  into `teacher_student`(`id`,`sid`,`tid`) values (1,2,8),(4,4,8),(5,5,8),(6,14,8);

/*Table structure for table `u_teacher` */

DROP TABLE IF EXISTS `u_teacher`;

CREATE TABLE `u_teacher` (
                             `id` int(32) NOT NULL AUTO_INCREMENT,
                             `uid` int(32) DEFAULT NULL,
                             `tid` int(32) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `u_teacher` */

insert  into `u_teacher`(`id`,`uid`,`tid`) values (3,2,3),(4,2,8),(5,2,8),(6,4,8),(7,14,3),(8,14,8),(9,14,13);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(32) NOT NULL AUTO_INCREMENT,
                        `username` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `sex` varchar(10) DEFAULT NULL,
                        `phone` varchar(255) DEFAULT NULL,
                        `nickname` varchar(255) DEFAULT NULL,
                        `type` int(2) DEFAULT NULL,
                        `number` varchar(32) DEFAULT '未指定',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`sex`,`phone`,`nickname`,`type`,`number`) values (1,'admin','admin','男','18565965847','管理员',2,NULL),(2,'jack','123','男','18565965841','欧文1',0,NULL),(3,'chenbo','123','女','18343246666','凯瑞',1,'未指定'),(4,'c0001','123','女','18343246666','王杰',0,NULL),(5,'c19010109','123','男','18622223652','李青',0,NULL),(6,'c19010108','123','女','18622223652','提莫',0,NULL),(8,'t0012','1232','女','18343246661','王导师1',1,'20'),(9,'t0021','1234561','男','18343246661','李学生1',0,NULL),(13,'t003','123456','男','18343246666','陈老师',1,'50'),(14,'s006','123456','男','18343246666','李旺1',0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
