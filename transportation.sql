/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.22-MariaDB : Database - transportation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`transportation` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `transportation`;

/*Table structure for table `public_agency` */

DROP TABLE IF EXISTS `public_agency`;

CREATE TABLE `public_agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKogyjggqk155hqp3jcks1sn3xc` (`owner_id`),
  CONSTRAINT `FKogyjggqk155hqp3jcks1sn3xc` FOREIGN KEY (`owner_id`) REFERENCES `public_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_agency` */

insert  into `public_agency`(`id`,`code`,`details`,`name`,`owner_id`) values 
(1,'BCAF','Perusahaan Agency BCAF','BCA Finance',3),
(2,'PNJPRS','Perusahaan Agency Panji Prasetya','PANPRAZ',4),
(3,'FSPR','FSPR Galaxy','FSPR',1),
(4,'PNJPRS','pa nji prasdsad','Panji Prasetya',4);

/*Table structure for table `public_bus` */

DROP TABLE IF EXISTS `public_bus`;

CREATE TABLE `public_bus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `capacity` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `make` varchar(255) NOT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3u8kudoydvln9b2rosujbjh87` (`agency_id`),
  CONSTRAINT `FK3u8kudoydvln9b2rosujbjh87` FOREIGN KEY (`agency_id`) REFERENCES `public_agency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_bus` */

insert  into `public_bus`(`id`,`capacity`,`code`,`make`,`agency_id`) values 
(1,'100','BUS001','2019',1),
(2,'100','BUS002','2015',2),
(3,'100','BUS003','2012',3),
(4,'100','BUS004','2019',1),
(5,'100','BUS005','2019',4);

/*Table structure for table `public_roles` */

DROP TABLE IF EXISTS `public_roles`;

CREATE TABLE `public_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_roles` */

insert  into `public_roles`(`id`,`name`) values 
(1,'ADMIN'),
(2,'PASSENGER'),
(3,'OWNER');

/*Table structure for table `public_stop` */

DROP TABLE IF EXISTS `public_stop`;

CREATE TABLE `public_stop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `fare` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_stop` */

insert  into `public_stop`(`id`,`code`,`detail`,`fare`,`name`) values 
(1,'LEBBUL','Terminal di Lebak Bulus',10,'Lebak Bulus'),
(2,'KAMRAM','Terminal Kampung Rambutan',10,'Kampung Rambutan'),
(3,'PULGAD','Terminal Pulo Gadung',10,'Pulo Gadung');

/*Table structure for table `public_ticket` */

DROP TABLE IF EXISTS `public_ticket`;

CREATE TABLE `public_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cancellable` bit(1) NOT NULL,
  `journey_date` varchar(255) DEFAULT NULL,
  `seat_number` int(11) NOT NULL,
  `passenger_id` bigint(20) DEFAULT NULL,
  `tripschedule_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKburkp9n9w3mkqppwtc15s8fmj` (`passenger_id`),
  KEY `FKfc8l0b844doohu71nqv9bg648` (`tripschedule_id`),
  CONSTRAINT `FKburkp9n9w3mkqppwtc15s8fmj` FOREIGN KEY (`passenger_id`) REFERENCES `public_users` (`id`),
  CONSTRAINT `FKfc8l0b844doohu71nqv9bg648` FOREIGN KEY (`tripschedule_id`) REFERENCES `public_tripschedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_ticket` */

/*Table structure for table `public_trip` */

DROP TABLE IF EXISTS `public_trip`;

CREATE TABLE `public_trip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fare` int(11) NOT NULL,
  `journey_time` varchar(255) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  `bus_id` bigint(20) DEFAULT NULL,
  `deststop_id` bigint(20) DEFAULT NULL,
  `sourcestop_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK79tino3r1x0n07fgbberd7p7d` (`agency_id`),
  KEY `FKb1qv7jpuqgmjedpbgjb3a6exo` (`bus_id`),
  KEY `FKsmj4g1lgpnvqvl06ndnwod5pn` (`deststop_id`),
  KEY `FKrgp7xjs51hqf3g8le6525j9cq` (`sourcestop_id`),
  CONSTRAINT `FK79tino3r1x0n07fgbberd7p7d` FOREIGN KEY (`agency_id`) REFERENCES `public_agency` (`id`),
  CONSTRAINT `FKb1qv7jpuqgmjedpbgjb3a6exo` FOREIGN KEY (`bus_id`) REFERENCES `public_bus` (`id`),
  CONSTRAINT `FKrgp7xjs51hqf3g8le6525j9cq` FOREIGN KEY (`sourcestop_id`) REFERENCES `public_stop` (`id`),
  CONSTRAINT `FKsmj4g1lgpnvqvl06ndnwod5pn` FOREIGN KEY (`deststop_id`) REFERENCES `public_stop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_trip` */

insert  into `public_trip`(`id`,`fare`,`journey_time`,`agency_id`,`bus_id`,`deststop_id`,`sourcestop_id`) values 
(1,20,'60',1,2,1,3),
(2,20000,'30',2,2,1,2),
(3,100000,'60',2,2,2,1);

/*Table structure for table `public_tripschedule` */

DROP TABLE IF EXISTS `public_tripschedule`;

CREATE TABLE `public_tripschedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available_seat` int(11) NOT NULL,
  `fare` int(11) NOT NULL,
  `ticket_sold` int(11) NOT NULL,
  `trip_date` varchar(255) DEFAULT NULL,
  `trip_detail` varchar(255) DEFAULT NULL,
  `trip_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9nu51i5i5s9sfx3nyc893oabp` (`trip_id`),
  CONSTRAINT `FK9nu51i5i5s9sfx3nyc893oabp` FOREIGN KEY (`trip_id`) REFERENCES `public_trip` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_tripschedule` */

/*Table structure for table `public_user_roles` */

DROP TABLE IF EXISTS `public_user_roles`;

CREATE TABLE `public_user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKp7sdqh2jpscjh1utmmnqb9ang` (`role_id`),
  CONSTRAINT `FKkced4sdgxnlku0nqtkie7ppru` FOREIGN KEY (`user_id`) REFERENCES `public_users` (`id`),
  CONSTRAINT `FKp7sdqh2jpscjh1utmmnqb9ang` FOREIGN KEY (`role_id`) REFERENCES `public_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_user_roles` */

insert  into `public_user_roles`(`user_id`,`role_id`) values 
(1,1),
(1,3),
(2,2),
(3,3),
(4,3),
(9,2),
(10,3),
(11,2);

/*Table structure for table `public_users` */

DROP TABLE IF EXISTS `public_users`;

CREATE TABLE `public_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `firstname` varchar(120) DEFAULT NULL,
  `lastname` varchar(120) DEFAULT NULL,
  `mobilenumber` varchar(120) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK915us5wifsfjnmva4swt3oqpt` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `public_users` */

insert  into `public_users`(`id`,`email`,`firstname`,`lastname`,`mobilenumber`,`password`) values 
(1,'admin@gmail.com','admin','super','082113123213','$2a$10$qLudK60S6HPNCS31F0HxF.cSq8ZpIbEtZ4ltCZ4S.17wBRY2ndmnm'),
(2,'user@gmail.com','user','passenger','082113123213','$2a$10$/LbMchjr8ObNB/pEFqQ3lOq3bcjdHjDfH8GaHcCsVIBrXXvMUkm9y'),
(3,'owner@gmail.com','owner','agency','082113123213','$2a$10$7Vnuv/F/1WnXM2zrzg4bX.a4DS/UNPuiSkgIW7nUYzyg4l1cidueG'),
(4,'owner1@gmail.com','panji','prasetya','082113123213','$2a$10$1NUh4ib4A/Z6rjrd33lCI.ZD896v.dMNNYSuyD4z1ZpeXuNd7LCB.'),
(9,'panji@gmail.com','panji','prasetya','821212312','$2a$10$87974xL.DleU0xaxk1rHQOAeoEg8Q/x2oz/Jwh2tDlMXquPKDN9Su'),
(10,'panjiowner@gmail.com','panji','owner','921309123','$2a$10$PpXBFmt1B8v2/soWoHbBOuLmxZbJkQ4AvVir.GPc9y6MgP9bs8/cO'),
(11,'panjiprasetya999@gmail.com','Panjip','Prasetya','82123123','$2a$10$1I3g7rSpnIE.AAt.0Pf9w.ADGa01igBjuUvUalZ7VjCUF8R00Oic6');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
