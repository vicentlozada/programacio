CREATE DATABASE  IF NOT EXISTS `catering` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `catering`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: catering
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleatfix`
--

DROP TABLE IF EXISTS `empleatfix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleatfix` (
  `nom` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL,
  `dni` varchar(9) COLLATE utf8mb4_spanish_ci NOT NULL,
  `datanaixement` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `edat` int(11) DEFAULT NULL,
  `soubase` float DEFAULT NULL,
  `sou` float DEFAULT NULL,
  `login` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `tipus` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `estat` tinyint(1) DEFAULT NULL,
  `avatar` varchar(150) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `datacontratacio` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `antiguitat` int(11) DEFAULT NULL,
  `percent` float DEFAULT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleatfix`
--

LOCK TABLES `empleatfix` WRITE;
/*!40000 ALTER TABLE `empleatfix` DISABLE KEYS */;
INSERT INTO `empleatfix` VALUES ('Josep Vinyes Boronat','01159062T','22/12/1963',51,2230.34,2230.34,NULL,NULL,NULL,'user',0,'src/images/avatar.png','28/11/2014',0,0),('Violant Soler Borrull','01208991L','15/10/1985',29,611.93,611.93,NULL,NULL,NULL,'user',0,'src/images/avatar.png','27/01/2011',4,0),('Jaume MartÃƒÂ­ Estruch','01315102P','12/08/1964',50,643.77,643.77,NULL,NULL,NULL,'user',0,'src/images/avatar.png','05/10/2010',4,0),('Sara MartÃƒÂ­ Estruch','01571247W','11/04/1978',36,441.33,441.33,NULL,NULL,NULL,'user',0,'src/images/avatar.png','13/05/2010',4,0),('Francesc Santonja Canet','03419944M','25/02/1959',56,2500,2575,NULL,NULL,NULL,'user',0,'src/images/avatar.png','13/07/2007',7,3),('Josep Valls Castell','04942306C','23/08/1961',53,2800.47,2800.47,NULL,NULL,NULL,'user',0,'src/images/avatar.png','16/08/2012',2,0),('Josep MartÃƒÂ­ Castell','05081067E','12/06/1984',30,2465.42,2539.38,NULL,NULL,NULL,'user',0,'src/images/avatar.png','01/07/2007',7,3),('Sara AragÃƒÂ³ Estruch','06852184R','09/11/1977',37,2785.84,2785.84,NULL,NULL,NULL,'user',0,'src/images/avatar.png','29/10/2011',3,0),('Francesc Santonja Vives','08327993S','19/04/1957',57,1440.17,1440.17,NULL,NULL,NULL,'user',0,'src/images/avatar.png','22/09/2012',2,0),('Joan Ferrer Pons','10628899R','06/07/1982',32,750.21,772.716,NULL,NULL,NULL,'user',0,'src/images/avatar.png','06/09/2006',8,3),('Joan Valls Borja ','12034313T','03/02/1967',48,421.3,446.578,NULL,NULL,NULL,'user',0,'src/images/avatar.png','06/08/2004',10,6),('Maria MartÃƒÂ­ Borrull','12262177A','19/02/1989',26,1123.44,1190.85,NULL,NULL,NULL,'user',0,'src/images/avatar.png','13/09/2000',14,6),('Pepito Cordero','12343278Y','11/03/1970',45,1000,1090,NULL,NULL,NULL,'user',0,'src/images/avatar.png','08/03/2000',15,9),('Joan Carbonell Fuster','12349826E','10/04/1965',49,900,954,NULL,NULL,NULL,'user',0,'src/images/avatar.png','17/02/2001',14,6),('Sandro Rey Tercer','12478952A','11/06/1956',58,1000,1060,NULL,NULL,NULL,'user',0,'src/images/avatar.png','11/06/2000',14,6),('Jaume Fuster Borrull','14296773L','24/09/1976',38,2058.21,2119.96,NULL,NULL,NULL,'user',0,'src/images/avatar.png','09/11/2006',8,3),('Rosa Valls Ferriol','14904213Y','27/01/1983',32,2011.3,2131.98,NULL,NULL,NULL,'user',0,'src/images/avatar.png','05/07/2000',14,6),('Violant Ferrer Boronat','18432016T','11/05/1976',38,2683.07,2844.05,NULL,NULL,NULL,'user',0,'src/images/avatar.png','30/09/2002',12,6),('Maria MartÃƒÂ­ Pons','20124376C','09/09/1990',24,2804.97,2804.97,NULL,NULL,NULL,'user',0,'src/images/avatar.png','05/05/2011',3,0),('Vicent AragÃƒÂ³ Ferriol','27677629G','03/08/1983',31,2828,2997.68,NULL,NULL,'email@email.com','user',0,'src/images/avatar.png','03/03/2003',12,6),('Joan Valls Ferriol','29893789E','13/11/1966',48,2681.84,2681.84,NULL,NULL,NULL,'user',0,'src/images/avatar.png','21/12/2014',0,0),('Josep Ferrer Ferriol','29899073Q','06/04/1989',25,2990,2990,NULL,NULL,NULL,'user',0,'src/images/avatar.png','16/03/2012',3,0),('Josep Lluch Borrull','30014493E','18/01/1971',44,1353.65,1394.26,NULL,NULL,NULL,'user',0,'src/images/avatar.png','17/01/2007',8,3),('Josep Esplugues Borrull','31460791B','30/08/1960',54,1087.14,1119.75,NULL,NULL,NULL,'user',0,'src/images/avatar.png','31/08/2008',6,3),('Josep Soler Vives','31562852K','04/04/1962',52,2856.26,3027.64,NULL,NULL,NULL,'user',0,'src/images/avatar.png','25/07/2004',10,6),('Rosa Lluch Castell','32804890J','30/11/1987',27,496.61,496.61,NULL,NULL,NULL,'user',0,'src/images/avatar.png','02/05/2013',1,0),('Violant Esplugues Castell','35048482R','25/06/1970',44,2328.98,2468.72,NULL,NULL,NULL,'user',0,'src/images/avatar.png','29/09/2003',11,6),('Violant Valls Borja','42714135F','08/11/1961',53,665.38,685.341,NULL,NULL,NULL,'user',0,'src/images/avatar.png','19/07/2006',8,3),('Josep MartÃƒÂ­ Pons','42786988L','01/02/1975',40,951.64,1008.74,NULL,NULL,NULL,'user',0,'src/images/avatar.png','11/11/2004',10,6),('Vicent Ferrer Boronat','43658033P','16/12/1969',45,1535.99,1535.99,NULL,NULL,NULL,'user',0,'src/images/avatar.png','07/09/2011',3,0),('Jaume MartÃ­  Cots','47297889E','05/07/1969',45,1857.9,1913.64,NULL,NULL,'email@email.com','user',0,'src/images/avatar.png','14/04/2006',9,3),('Yolanda','48287734Q','04/04/1980',35,1000,1090,NULL,NULL,'yomogan@gmail.com','user',0,'src/images/avatar.png','16/04/2000',15,9),('Violant Lozada Ferri','48607483l','07/12/1995',19,2000,2120,NULL,NULL,NULL,'user',0,'src/images/avatar.png','28/08/2001',13,6),('Josep Vinyes Castell','49578634H','17/09/1983',31,1878.71,1935.07,NULL,NULL,NULL,'user',0,'src/images/avatar.png','03/12/2007',7,3),('Jaume Fuster Borja','49831617R','12/10/1984',30,1991.37,1991.37,NULL,NULL,NULL,'user',0,'src/images/avatar.png','10/05/2014',0,0),('Vicent Fuster Pons','50099598D','25/07/1970',44,477.41,477.41,NULL,NULL,NULL,'user',0,'src/images/avatar.png','29/11/2013',1,0),('Sara Vinyes Estruch','50420375M','03/09/1987',27,1690.95,1792.41,NULL,NULL,NULL,'user',0,'src/images/avatar.png','06/10/2004',10,6),('Maria MartÃƒÂ­ Cots','52835698Y','03/12/1969',45,1801.53,1801.53,NULL,NULL,NULL,'user',0,'src/images/avatar.png','21/02/2014',1,0),('Jaume Vinyes Pon','53147226E','09/06/1956',58,759.62,827.986,NULL,NULL,'email@email.com','user',0,'','14/05/1993',22,9),('Violant Santonja Vives','54026333T','16/01/1965',50,1253.95,1329.19,NULL,NULL,NULL,'user',0,'src/images/avatar.png','23/02/2001',14,6),('Vicent Soler Canet','60989475F','20/04/1957',57,2716.81,2716.81,NULL,NULL,NULL,'user',0,'src/images/avatar.png','09/08/2013',1,0),('Francesc Vinyes Ferriol','62170109M','04/06/1963',51,1064.54,1064.54,NULL,NULL,NULL,'user',0,'src/images/avatar.png','04/05/2011',3,0),('Sara Santonja Castell','62522597H','09/10/1979',35,614.41,632.842,NULL,NULL,NULL,'user',0,'src/images/avatar.png','09/01/2007',8,3),('Maria Santonja Bo','62766669Z','18/08/1972',42,2477.93,2552.27,NULL,NULL,NULL,'user',0,'src/images/avatar.png','08/08/2008',6,3),('Josep AragÃƒÂ³ Canet','63817293K','25/02/1958',57,1143.17,1177.47,NULL,NULL,NULL,'user',0,'src/images/avatar.png','21/06/2007',7,3),('Vicent Soler Vives','65842055R','16/11/1959',55,679.58,679.58,NULL,NULL,NULL,'user',0,'src/images/avatar.png','28/08/2012',2,0),('Rosa Santonja Canet','66070845X','02/10/1969',45,1704.22,1806.47,NULL,NULL,NULL,'user',0,'src/images/avatar.png','20/05/2003',11,6),('Francesc Valls Canet','66827983B','04/11/1988',26,1358.27,1399.02,NULL,NULL,NULL,'user',0,'src/images/avatar.png','17/03/2010',5,3),('Rosa Ferrer Vives','66901555Y','12/12/1982',32,2828.68,2913.54,NULL,NULL,NULL,'user',0,'src/images/avatar.png','01/08/2005',9,3),('Jaume Fuster LaGuarda','70460697J','05/03/1979',36,797.75,797.75,NULL,NULL,NULL,'user',0,'src/images/avatar.png','06/03/2014',1,0),('Vicent Lluch Pons','71040025V','26/01/1958',57,558.74,558.74,NULL,NULL,NULL,'user',0,'src/images/avatar.png','22/08/2011',3,0),('Jaume MartÃƒÂ­ Ferriol','71746094D','20/08/1967',47,2500,2650,NULL,NULL,NULL,'user',0,'src/images/avatar.png','26/06/2000',14,6),('Violant AragÃƒÂ³ Ferriol','72329202K','10/07/1972',42,1785.64,1892.78,NULL,NULL,NULL,'user',0,'src/images/avatar.png','28/10/2001',13,6),('Violant MartÃƒÂ­ Estruch','76528200R','12/12/1966',48,1785.85,1946.58,NULL,NULL,NULL,'user',0,'src/images/avatar.png','05/03/2000',15,9),('Rosa Soler Boronat','76740560W','25/11/1972',42,569.17,569.17,NULL,NULL,NULL,'user',0,'src/images/avatar.png','04/04/2014',0,0),('Anna Valls Cots','77472955P','09/05/1971',43,724.3,746.029,NULL,NULL,'email@email.com','user',0,'C:\\Users\\Virtual\\Documents\\Avatar 1.png','26/07/2007',7,3),('Joan Vinyes Castell','77653408A','21/03/1968',46,2471.84,2471.84,NULL,NULL,NULL,'user',0,'src/images/avatar.png','13/08/2014',0,0),('Rosa MartÃƒÂ­ Estruch','78687867Z','11/01/1986',29,1793.72,1793.72,NULL,NULL,NULL,'user',0,'src/images/avatar.png','22/06/2012',2,0),('Vicent Esplugues Ferriol','78722046S','17/08/1972',42,2843.26,3013.86,NULL,NULL,NULL,'user',0,'src/images/avatar.png','25/09/2001',13,6),('Vicent Lluch Castell','79205245F','28/06/1958',56,2744.62,2909.3,NULL,NULL,NULL,'user',0,'src/images/avatar.png','04/08/2002',12,6),('Maria Soler Pons','81737077E','10/09/1956',58,846.08,896.845,NULL,NULL,NULL,'user',0,'src/images/avatar.png','17/10/2001',13,6),('Joan Esplugues Borrull','82006567K','31/08/1973',41,2274,2274,NULL,NULL,NULL,'user',0,'src/images/avatar.png','09/05/2013',1,0),('Maria Esplugues Boronat','82948741T','19/12/1988',26,2221.34,2221.34,NULL,NULL,NULL,'user',0,'src/images/avatar.png','18/03/2010',4,0),('Sara Santonja Ferri','85448939Y','16/10/1957',57,1722.05,1825.37,NULL,NULL,NULL,'user',0,'src/images/avatar.png','06/06/2000',14,6),('Josep AragÃƒÂ³ Borrull','85479833B','25/03/1974',40,2905.3,2905.3,NULL,NULL,NULL,'user',0,'src/images/avatar.png','26/05/2013',1,0),('Jaume Vinyes Borja ','86137211A','28/02/1967',48,2873.37,3131.97,NULL,NULL,'email@email.com','user',0,'src/images/avatar.png','20/12/1990',24,9),('Rosa Vinyes Pons','86294545V','31/03/1981',33,1074.91,1107.16,NULL,NULL,NULL,'user',0,'src/images/avatar.png','07/01/2006',9,3),('Joan Fuster Boronat','87760831F','31/03/1961',53,2887.49,2887.49,NULL,NULL,NULL,'user',0,'src/images/avatar.png','15/11/2013',1,0),('Sara MartÃƒÂ­ Borrull','87954070T','27/08/1958',56,2687.03,2848.25,NULL,NULL,NULL,'user',0,'src/images/avatar.png','11/03/2001',14,6),('Francesc Santonja Cots','88946702K','25/07/1964',50,1304.62,1422.04,NULL,NULL,NULL,'user',0,'src/images/avatar.png','15/03/2000',15,9),('Francesc Fuster Borrull','89015286L','24/03/1970',45,778.65,778.65,NULL,NULL,'email@email.com','user',0,'C:\\Users\\Virtual\\Documents\\uytpKUG.png','15/09/2012',2,0),('Maria Lluch Castell','90813875P','11/08/1970',44,2230.81,2364.66,NULL,NULL,NULL,'user',0,'src/images/avatar.png','25/08/2003',11,6),('Joan Santonja Vives','92823572B','27/08/1973',41,2035.31,2035.31,NULL,NULL,NULL,'user',0,'src/images/avatar.png','10/01/2014',1,0),('Violant MartÃƒÂ­ Castell','93279207Q','11/08/1975',39,1849.59,1849.59,NULL,NULL,NULL,'user',0,'src/images/avatar.png','28/01/2013',2,0),('Maria AragÃƒÂ³ Boronat','93811420D','29/05/1989',25,2426.96,2645.39,NULL,NULL,NULL,'user',0,'src/images/avatar.png','06/02/2000',15,9),('Violant Esplugues Cots','94500720E','03/01/1981',34,1201.67,1237.72,NULL,NULL,NULL,'user',0,'src/images/avatar.png','25/08/2009',5,3),('Josep AragÃƒÂ³ Borrull','99819572D','16/12/1960',54,1810.77,1865.09,NULL,NULL,NULL,'user',0,'src/images/avatar.png','09/12/2005',9,3);
/*!40000 ALTER TABLE `empleatfix` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `catering`.`empleatfix_NOM_AFTER_INSERT` AFTER INSERT ON `empleatfix` FOR EACH ROW
BEGIN

INSERT INTO tlogcanvinomef( datacanvi, usuari, dni, nomOld, nomNew )
values( Now(), USER(), new.dni, null , new.nom );

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `catering`.`empleatfix_NOM_AFTER_UPDATE` AFTER UPDATE ON `empleatfix` FOR EACH ROW
BEGIN

insert into tlogcanvinomef( datacanvi, usuari, dni, nomOld, nomNew )
values( Now(), USER(), new.dni, old.nom , new.nom );

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `catering`.`empleatfix_NOM_AFTER_DELETE` AFTER DELETE ON `empleatfix` FOR EACH ROW
BEGIN

insert into tlogcanvinomef( datacanvi, usuari, dni, nomOld, nomNew )
values( Now(), USER(), old.dni, old.nom , null );

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `new_view`
--

DROP TABLE IF EXISTS `new_view`;
/*!50001 DROP VIEW IF EXISTS `new_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `new_view` AS SELECT 
 1 AS `nom`,
 1 AS `dni`,
 1 AS `datanaixement`,
 1 AS `edat`,
 1 AS `sou`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tlogcanviestatuser`
--

DROP TABLE IF EXISTS `tlogcanviestatuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tlogcanviestatuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datacanvi` datetime NOT NULL,
  `usuari` varchar(45) NOT NULL,
  `login` varchar(9) NOT NULL,
  `estatOld` int(1) DEFAULT NULL,
  `estatNew` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tlogcanviestatuser`
--

LOCK TABLES `tlogcanviestatuser` WRITE;
/*!40000 ALTER TABLE `tlogcanviestatuser` DISABLE KEYS */;
INSERT INTO `tlogcanviestatuser` VALUES (1,'2015-05-18 03:45:40','catering@localhost','usuari01',1,0),(2,'2015-05-18 03:46:16','catering@localhost','usuari01',0,1),(3,'2015-05-18 03:47:45','catering@localhost','usuari01',1,0),(4,'2015-05-18 10:38:29','root@localhost','usuari',0,0),(5,'2015-05-18 10:38:29','root@localhost','viccent',0,0),(6,'2015-05-18 10:38:29','root@localhost','violant',0,0),(8,'2015-05-18 10:54:40','root@localhost','usuari01',0,0),(9,'2015-05-18 10:55:29','catering@localhost','usuari07',0,1),(10,'2015-05-18 10:57:08','catering@localhost','usuari07',1,0),(11,'2015-05-18 11:18:29','catering@localhost','usuari07',0,1),(12,'2015-05-18 11:18:37','catering@localhost','usuari07',1,0),(13,'2015-05-18 11:18:53','catering@localhost','usuari07',0,1),(14,'2015-05-18 11:20:14','catering@localhost','usuari07',1,0),(15,'2015-05-18 11:23:46','catering@localhost','usuari07',0,1),(16,'2015-05-18 11:24:16','catering@localhost','usuari07',1,1),(17,'2015-05-18 11:27:57','catering@localhost','usuari07',1,0),(18,'2015-05-18 11:36:23','catering@localhost','usuari07',0,1),(19,'2015-05-18 11:37:07','catering@localhost','usuari07',1,0),(20,'2015-05-18 11:45:50','catering@localhost','usuari07',0,1),(21,'2015-05-18 11:46:52','catering@localhost','usuari07',1,1),(22,'2015-05-18 11:47:32','catering@localhost','usuari07',1,0),(23,'2015-05-18 12:02:31','catering@localhost','usuari07',0,1),(24,'2015-05-18 12:03:10','catering@localhost','usuari07',1,1),(25,'2015-05-18 12:03:33','catering@localhost','usuari07',1,0),(26,'2015-05-18 12:04:41','catering@localhost','Vicent',0,0),(27,'2015-05-18 12:05:47','catering@localhost','Vicent',0,1),(28,'2015-05-18 12:28:46','catering@localhost','usuari07',0,1),(29,'2015-05-18 12:28:59','catering@localhost','usuari07',1,0),(30,'2015-05-18 12:29:28','catering@localhost','Vicent',1,1),(31,'2015-05-18 13:09:37','catering@localhost','Vicent',1,1),(32,'2015-05-18 13:13:32','catering@localhost','Vicent',1,1),(33,'2015-05-18 13:15:01','catering@localhost','usuari07',0,1),(34,'2015-05-18 13:15:16','catering@localhost','usuari07',1,0),(35,'2015-05-18 13:18:15','catering@localhost','Vicent',1,1),(36,'2015-05-18 13:19:09','catering@localhost','Vicent',1,0),(37,'2015-05-18 13:19:44','catering@localhost','Vicent',0,1),(38,'2015-05-18 13:22:36','catering@localhost','Vicent',1,0),(39,'2015-05-18 13:27:45','catering@localhost','usuari07',0,1),(40,'2015-05-18 13:27:56','catering@localhost','usuari07',1,0),(41,'2015-05-18 13:28:16','catering@localhost','Vicent',0,1),(42,'2015-05-18 13:28:50','catering@localhost','Vicent',1,0),(43,'2015-05-18 13:29:05','catering@localhost','Vicent',0,1),(44,'2015-05-18 13:54:16','catering@localhost','Vicent',1,1),(45,'2015-05-18 13:55:35','catering@localhost','Vicent',1,1),(46,'2015-05-18 14:52:30','catering@localhost','Vicent',1,1),(47,'2015-05-18 15:02:11','catering@localhost','Vicent',1,1),(48,'2015-05-18 15:12:40','catering@localhost','Vicent',1,1),(49,'2015-05-18 15:13:47','catering@localhost','Vicent',1,1),(50,'2015-05-18 15:57:33','catering@localhost','Vicent',1,1),(51,'2015-05-18 16:41:38','catering@localhost','Vicent',1,1),(52,'2015-05-18 19:28:13','catering@localhost','Vicent',1,1),(53,'2015-05-18 19:29:29','catering@localhost','Vicent',1,0);
/*!40000 ALTER TABLE `tlogcanviestatuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tlogcanvinomef`
--

DROP TABLE IF EXISTS `tlogcanvinomef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tlogcanvinomef` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datacanvi` datetime NOT NULL,
  `usuari` varchar(45) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nomOld` varchar(60) DEFAULT NULL,
  `nomNew` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tlogcanvinomef`
--

LOCK TABLES `tlogcanvinomef` WRITE;
/*!40000 ALTER TABLE `tlogcanvinomef` DISABLE KEYS */;
INSERT INTO `tlogcanvinomef` VALUES (5,'2015-04-25 19:39:47','catering@localhost','20409792Y','Vicent Lozada','Vicent Lozada MartÃƒÂ­'),(6,'2015-04-25 19:42:05','catering@localhost','20409792Y','Vicent Lozada MartÃƒÂ­',NULL),(7,'2015-04-25 19:51:26','catering@localhost','20409792Y',NULL,'Vicent Lozada Mari'),(8,'2015-04-25 19:53:16','catering@localhost','20409792Y','Vicent Lozada Mari','Vicent Lozada MartÃƒÂ­'),(9,'2015-04-25 19:54:40','catering@localhost','20409792Y','Vicent Lozada MartÃƒÂ­',NULL),(10,'2015-04-27 20:52:25','catering@localhost','77472955P','Anna Valls Cots','Anna Valls Cots'),(11,'2015-04-27 20:53:31','catering@localhost','77472955P','Anna Valls Cots','Anna Valls Cots'),(12,'2015-04-28 14:12:02','catering@localhost','53147226E','Jaume Vinyes Pons','Jaume Vinyes Pons'),(13,'2015-04-28 14:14:30','catering@localhost','53147226E','Jaume Vinyes Pons','Jaume Vinyes Pon'),(14,'2015-04-28 14:15:45','catering@localhost','86137211A','Jaume Vinyes Borja ','Jaume Vinyes Borja '),(15,'2015-04-29 18:02:02','catering@localhost','94412851J','Rosa Santonja Pons','Rosa Santonja Ponsa'),(16,'2015-04-29 18:04:56','catering@localhost','94412851J','Rosa Santonja Ponsa',NULL),(17,'2015-04-29 18:06:16','catering@localhost','48287734Q',NULL,'Yolanda'),(18,'2015-05-01 20:03:30','catering@localhost','47297889E','Jaume MartÃƒÂ­ Cots','Jaume MartÃ­  Cots'),(19,'2015-05-15 02:22:00','catering@localhost','53147226E','Jaume Vinyes Pon','Jaume Vinyes Pon');
/*!40000 ALTER TABLE `tlogcanvinomef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tlogcanvipassuser`
--

DROP TABLE IF EXISTS `tlogcanvipassuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tlogcanvipassuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datacanvi` datetime NOT NULL,
  `usuari` varchar(45) NOT NULL,
  `login` varchar(9) NOT NULL,
  `passOld` varchar(45) DEFAULT NULL,
  `passNew` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tlogcanvipassuser`
--

LOCK TABLES `tlogcanvipassuser` WRITE;
/*!40000 ALTER TABLE `tlogcanvipassuser` DISABLE KEYS */;
INSERT INTO `tlogcanvipassuser` VALUES (1,'2015-05-15 13:09:57','catering@localhost','Vicent','f9d34c7af416db8780ca6e2217a6178d','34abbc8498fced356a9e3c3a934af906'),(2,'2015-05-16 21:53:52','catering@localhost','Aina',NULL,'bf37a561db63281ec0a8dee0e5e802b0'),(3,'2015-05-16 23:24:07','catering@localhost','Aina','bf37a561db63281ec0a8dee0e5e802b0','beb174ac5311c0b85cf10c9b18673086'),(4,'2015-05-16 23:57:01','root@localhost','dsafswdef','abcdegr3','abcdegr3'),(5,'2015-05-16 23:57:01','root@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(6,'2015-05-16 23:57:01','root@localhost','sdfsad','dfasdf44','dfasdf44'),(7,'2015-05-16 23:57:01','root@localhost','sedfwsef','qwewerfewr5','qwewerfewr5'),(8,'2015-05-16 23:57:01','root@localhost','usuari','807e04ad8e3a43589ccf54c0a7c807ff','807e04ad8e3a43589ccf54c0a7c807ff'),(9,'2015-05-16 23:57:01','root@localhost','viccent','asdfsd','asdfsd'),(10,'2015-05-16 23:57:01','root@localhost','violant','aba57d878ca27f5ffb85b62e96cd3ebf','aba57d878ca27f5ffb85b62e96cd3ebf'),(11,'2015-05-17 00:14:47','catering@localhost','usuari01',NULL,'db303fce047d78f180dc21b6ce445561'),(12,'2015-05-17 06:34:29','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(13,'2015-05-17 06:51:10','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(14,'2015-05-17 06:59:40','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(15,'2015-05-17 13:35:28','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(16,'2015-05-17 15:11:11','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(17,'2015-05-17 15:13:26','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(18,'2015-05-17 15:15:49','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','c4c90cae85685a2473306eef887c961f'),(19,'2015-05-17 15:18:54','catering@localhost','usuari01','c4c90cae85685a2473306eef887c961f','c4c90cae85685a2473306eef887c961f'),(20,'2015-05-17 16:02:20','catering@localhost','usuari01','c4c90cae85685a2473306eef887c961f','c4c90cae85685a2473306eef887c961f'),(21,'2015-05-17 16:03:38','catering@localhost','usuari01','c4c90cae85685a2473306eef887c961f','c4c90cae85685a2473306eef887c961f'),(22,'2015-05-17 16:08:37','catering@localhost','usuari01','c4c90cae85685a2473306eef887c961f','c4c90cae85685a2473306eef887c961f'),(23,'2015-05-17 16:10:31','catering@localhost','usuari01','c4c90cae85685a2473306eef887c961f','c4c90cae85685a2473306eef887c961f'),(24,'2015-05-17 16:12:26','root@localhost','Vicent','34abbc8498fced356a9e3c3a934af906','34abbc8498fced356a9e3c3a934af906'),(25,'2015-05-17 16:12:51','catering@localhost','usuari01','c4c90cae85685a2473306eef887c961f','c4c90cae85685a2473306eef887c961f'),(26,'2015-05-17 16:13:41','catering@localhost','usuari01','c4c90cae85685a2473306eef887c961f','8d1719b946951874fdaa84b8b2970b94'),(27,'2015-05-17 16:49:54','root@localhost','usuari01','8d1719b946951874fdaa84b8b2970b94','8d1719b946951874fdaa84b8b2970b94'),(28,'2015-05-17 16:50:13','catering@localhost','usuari01','8d1719b946951874fdaa84b8b2970b94','6c7808e9191ee93970b9b89d48369007'),(29,'2015-05-17 16:51:33','catering@localhost','usuari01','6c7808e9191ee93970b9b89d48369007','db303fce047d78f180dc21b6ce445561'),(30,'2015-05-17 18:09:23','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','850ae4a16976c46fa112763b7ffbe8a8'),(31,'2015-05-17 18:20:37','catering@localhost','usuari01','850ae4a16976c46fa112763b7ffbe8a8','6f79d95a0c4bdaf83a366834c47ea4be'),(32,'2015-05-17 19:10:45','catering@localhost','usuari01','6f79d95a0c4bdaf83a366834c47ea4be','ba5532fac7913643f4dfb9f7c7975fcd'),(33,'2015-05-17 19:21:05','catering@localhost','usuari01','ba5532fac7913643f4dfb9f7c7975fcd','d41d8cd98f00b204e9800998ecf8427e'),(34,'2015-05-17 19:26:27','catering@localhost','usuari01','d41d8cd98f00b204e9800998ecf8427e','d41d8cd98f00b204e9800998ecf8427e'),(35,'2015-05-17 19:28:55','catering@localhost','usuari01','d41d8cd98f00b204e9800998ecf8427e','d41d8cd98f00b204e9800998ecf8427e'),(36,'2015-05-17 19:32:40','catering@localhost','usuari01','d41d8cd98f00b204e9800998ecf8427e','6706ec73bb2cec34a7048917e42f8759'),(37,'2015-05-17 19:56:28','catering@localhost','usuari01','6706ec73bb2cec34a7048917e42f8759','9ba8c39306476436cc83844de8d0c802'),(38,'2015-05-17 19:57:20','catering@localhost','usuari01','9ba8c39306476436cc83844de8d0c802','e9a27513738bfaad78f8b04ada43d164'),(39,'2015-05-17 20:08:41','catering@localhost','usuari01','e9a27513738bfaad78f8b04ada43d164','7fdfd75d585944f63f2605667171249d'),(40,'2015-05-17 21:21:00','catering@localhost','usuari01','7fdfd75d585944f63f2605667171249d','9115f29468756025ce9809ef7df0c3b1'),(41,'2015-05-17 22:47:18','root@localhost','viccent','asdfsd','asdfsd1'),(42,'2015-05-17 22:48:11','root@localhost','viccent','asdfsd1','qwewerfewr53'),(43,'2015-05-17 22:48:47','root@localhost','usuari01','9115f29468756025ce9809ef7df0c3b1','9115f29468756025ce9809ef7df0c3b1'),(44,'2015-05-17 23:08:10','catering@localhost','usuari01','9115f29468756025ce9809ef7df0c3b1','9115f29468756025ce9809ef7df0c3b1'),(45,'2015-05-17 23:12:29','root@localhost','usuari01','9115f29468756025ce9809ef7df0c3b1','9115f29468756025ce9809ef7df0c3b1'),(46,'2015-05-17 23:13:36','catering@localhost','usuari01','9115f29468756025ce9809ef7df0c3b1','9115f29468756025ce9809ef7df0c3b1'),(47,'2015-05-17 23:15:57','catering@localhost','usuari01','9115f29468756025ce9809ef7df0c3b1','9115f29468756025ce9809ef7df0c3b1'),(48,'2015-05-17 23:19:36','catering@localhost','usuari01','9115f29468756025ce9809ef7df0c3b1','db303fce047d78f180dc21b6ce445561'),(49,'2015-05-17 23:20:21','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(50,'2015-05-17 23:31:23','catering@localhost','Aina','beb174ac5311c0b85cf10c9b18673086','505e4756540faf060eee03d7f7e80899'),(51,'2015-05-17 23:50:38','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','8c632185d47db74b532f99898c068474'),(52,'2015-05-17 23:51:39','catering@localhost','usuari01','8c632185d47db74b532f99898c068474','8c632185d47db74b532f99898c068474'),(53,'2015-05-17 23:52:49','catering@localhost','usuari01','8c632185d47db74b532f99898c068474','8c632185d47db74b532f99898c068474'),(54,'2015-05-18 00:09:13','catering@localhost','usuari01','8c632185d47db74b532f99898c068474','8c632185d47db74b532f99898c068474'),(55,'2015-05-18 00:09:49','catering@localhost','usuari01','8c632185d47db74b532f99898c068474','db303fce047d78f180dc21b6ce445561'),(56,'2015-05-18 00:11:38','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(57,'2015-05-18 00:13:08','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(58,'2015-05-18 00:18:00','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(59,'2015-05-18 00:19:24','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(60,'2015-05-18 00:19:32','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(61,'2015-05-18 00:28:44','catering@localhost','Aina','505e4756540faf060eee03d7f7e80899','505e4756540faf060eee03d7f7e80899'),(62,'2015-05-18 00:29:46','catering@localhost','Aina','505e4756540faf060eee03d7f7e80899','505e4756540faf060eee03d7f7e80899'),(63,'2015-05-18 00:30:25','catering@localhost','Aina','505e4756540faf060eee03d7f7e80899','505e4756540faf060eee03d7f7e80899'),(64,'2015-05-18 00:30:45','catering@localhost','Aina','505e4756540faf060eee03d7f7e80899','505e4756540faf060eee03d7f7e80899'),(65,'2015-05-18 00:31:10','catering@localhost','Aina','505e4756540faf060eee03d7f7e80899','e0ee3e1a0a7a298cba129ae6747bf9f9'),(66,'2015-05-18 00:31:13','catering@localhost','Aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(67,'2015-05-18 00:31:20','catering@localhost','Aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(68,'2015-05-18 01:56:20','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(69,'2015-05-18 02:33:04','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(70,'2015-05-18 02:33:11','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(71,'2015-05-18 02:33:31','root@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(72,'2015-05-18 02:33:50','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(73,'2015-05-18 02:36:15','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(74,'2015-05-18 02:37:09','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(75,'2015-05-18 02:40:19','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(76,'2015-05-18 02:45:36','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(77,'2015-05-18 02:47:59','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(78,'2015-05-18 02:52:08','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(79,'2015-05-18 02:52:32','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(80,'2015-05-18 03:01:05','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(81,'2015-05-18 03:01:47','root@localhost','Aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(82,'2015-05-18 03:02:27','root@localhost','Vicent','34abbc8498fced356a9e3c3a934af906','34abbc8498fced356a9e3c3a934af906'),(83,'2015-05-18 03:10:41','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(84,'2015-05-18 03:10:57','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(85,'2015-05-18 03:13:42','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(86,'2015-05-18 03:16:53','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(87,'2015-05-18 03:17:08','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(88,'2015-05-18 03:25:58','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(89,'2015-05-18 03:26:53','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(90,'2015-05-18 03:42:10','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(91,'2015-05-18 03:45:40','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(92,'2015-05-18 03:46:16','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(93,'2015-05-18 03:47:45','catering@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(94,'2015-05-18 10:38:29','root@localhost','usuari','807e04ad8e3a43589ccf54c0a7c807ff','807e04ad8e3a43589ccf54c0a7c807ff'),(95,'2015-05-18 10:38:29','root@localhost','viccent','qwewerfewr53','qwewerfewr53'),(96,'2015-05-18 10:38:29','root@localhost','violant','aba57d878ca27f5ffb85b62e96cd3ebf','aba57d878ca27f5ffb85b62e96cd3ebf'),(98,'2015-05-18 10:52:58','catering@localhost','usuari07',NULL,'de88e3e4ab202d87754078cbb2df6063'),(99,'2015-05-18 10:53:27','root@localhost','dsafswdef','abcdegr3',NULL),(100,'2015-05-18 10:53:58','root@localhost','sdfsad','dfasdf44',NULL),(101,'2015-05-18 10:53:58','root@localhost','sedfwsef','qwewerfewr5',NULL),(102,'2015-05-18 10:53:58','root@localhost','usuari','807e04ad8e3a43589ccf54c0a7c807ff',NULL),(103,'2015-05-18 10:54:12','root@localhost','viccent','qwewerfewr53',NULL),(104,'2015-05-18 10:54:40','root@localhost','usuari01','db303fce047d78f180dc21b6ce445561','db303fce047d78f180dc21b6ce445561'),(105,'2015-05-18 10:55:29','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(106,'2015-05-18 10:57:08','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(107,'2015-05-18 11:18:29','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(108,'2015-05-18 11:18:37','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(109,'2015-05-18 11:18:53','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(110,'2015-05-18 11:20:14','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(111,'2015-05-18 11:23:46','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(112,'2015-05-18 11:24:16','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(113,'2015-05-18 11:27:57','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(114,'2015-05-18 11:36:23','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(115,'2015-05-18 11:37:07','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(116,'2015-05-18 11:45:50','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(117,'2015-05-18 11:46:52','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(118,'2015-05-18 11:47:32','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(119,'2015-05-18 12:02:31','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(120,'2015-05-18 12:03:10','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(121,'2015-05-18 12:03:33','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(122,'2015-05-18 12:04:41','catering@localhost','Vicent','34abbc8498fced356a9e3c3a934af906','50b0fae193044c41baef2e116220a60a'),(123,'2015-05-18 12:05:47','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(124,'2015-05-18 12:28:46','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(125,'2015-05-18 12:28:59','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(126,'2015-05-18 12:29:28','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(127,'2015-05-18 13:09:37','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(128,'2015-05-18 13:13:32','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(129,'2015-05-18 13:15:01','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(130,'2015-05-18 13:15:16','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(131,'2015-05-18 13:18:15','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(132,'2015-05-18 13:19:09','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(133,'2015-05-18 13:19:44','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(134,'2015-05-18 13:22:36','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(135,'2015-05-18 13:27:45','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(136,'2015-05-18 13:27:56','catering@localhost','usuari07','de88e3e4ab202d87754078cbb2df6063','de88e3e4ab202d87754078cbb2df6063'),(137,'2015-05-18 13:28:16','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(138,'2015-05-18 13:28:50','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(139,'2015-05-18 13:29:05','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(140,'2015-05-18 13:54:16','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(141,'2015-05-18 13:55:35','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(142,'2015-05-18 14:52:30','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(143,'2015-05-18 15:02:11','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(144,'2015-05-18 15:12:40','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(145,'2015-05-18 15:13:47','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(146,'2015-05-18 15:57:33','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(147,'2015-05-18 16:41:38','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(148,'2015-05-18 19:28:13','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(149,'2015-05-18 19:29:29','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(150,'2015-05-19 09:28:35','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(151,'2015-05-19 09:29:12','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(152,'2015-05-19 09:46:41','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(153,'2015-05-19 09:48:36','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(154,'2015-05-19 10:04:28','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(155,'2015-05-19 10:04:47','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(156,'2015-05-19 10:10:23','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(157,'2015-05-19 10:10:49','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(158,'2015-05-19 10:13:23','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(159,'2015-05-19 10:14:54','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(160,'2015-05-19 10:16:12','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(161,'2015-05-19 10:21:08','catering@localhost','Vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(162,'2015-05-19 10:25:24','root@localhost','aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(163,'2015-05-19 10:25:24','root@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(164,'2015-05-19 10:34:24','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(165,'2015-05-19 10:37:48','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(166,'2015-05-19 10:40:35','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(167,'2015-05-19 10:43:40','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(168,'2015-05-19 10:51:34','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(169,'2015-05-19 10:53:30','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(170,'2015-05-19 10:54:56','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(171,'2015-05-19 11:17:33','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(172,'2015-05-19 11:25:39','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(173,'2015-05-19 11:25:56','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(174,'2015-05-19 11:26:31','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(175,'2015-05-19 11:26:33','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(176,'2015-05-19 11:27:28','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(177,'2015-05-19 11:35:10','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(178,'2015-05-19 11:35:45','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(179,'2015-05-19 11:35:54','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(180,'2015-05-19 11:45:14','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(181,'2015-05-19 12:13:12','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(182,'2015-05-19 12:17:11','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(183,'2015-05-19 12:18:05','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(184,'2015-05-19 12:18:09','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(185,'2015-05-19 12:20:05','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(186,'2015-05-19 12:20:13','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(187,'2015-05-19 12:21:20','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(188,'2015-05-19 12:29:36','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(189,'2015-05-19 12:41:06','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(190,'2015-05-19 12:42:41','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(191,'2015-05-19 12:42:51','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(192,'2015-05-19 12:48:32','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(193,'2015-05-19 12:49:09','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(194,'2015-05-19 12:49:42','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(195,'2015-05-19 12:49:47','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(196,'2015-05-19 12:50:15','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(197,'2015-05-19 12:50:29','root@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(198,'2015-05-19 12:50:45','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(199,'2015-05-19 12:51:31','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(200,'2015-05-19 12:53:50','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(201,'2015-05-19 13:21:15','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(202,'2015-05-19 13:23:28','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(203,'2015-05-19 13:23:53','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(204,'2015-05-19 13:26:15','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(205,'2015-05-19 13:26:33','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(206,'2015-05-19 13:28:05','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(207,'2015-05-19 13:28:32','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(208,'2015-05-19 13:29:48','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(209,'2015-05-19 13:30:18','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(210,'2015-05-19 15:18:47','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(211,'2015-05-19 15:18:57','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(212,'2015-05-19 15:20:06','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','50b0fae193044c41baef2e116220a60a'),(213,'2015-05-19 15:20:36','catering@localhost','vicent','50b0fae193044c41baef2e116220a60a','ef3cdfec9a1a443b6c670a4a92561016'),(214,'2015-05-19 15:20:42','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(215,'2015-05-19 15:29:13','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(216,'2015-05-19 15:29:50','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(217,'2015-05-19 15:29:58','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(218,'2015-05-19 15:30:04','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(219,'2015-05-19 15:30:57','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(220,'2015-05-19 15:45:03','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(221,'2015-05-19 15:45:13','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(222,'2015-05-19 15:45:27','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(223,'2015-05-19 15:46:31','root@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(224,'2015-05-19 15:46:44','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(225,'2015-05-19 15:47:06','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(226,'2015-05-19 15:47:33','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(227,'2015-05-19 15:48:03','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','5d6b26a67f2db52ac6ebaa810a9effa1'),(228,'2015-05-19 15:50:11','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(229,'2015-05-19 15:55:03','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(230,'2015-05-19 15:55:50','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(231,'2015-05-19 15:56:29','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(232,'2015-05-19 16:04:17','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(233,'2015-05-19 16:04:50','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(234,'2015-05-19 16:05:06','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(235,'2015-05-19 16:06:12','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(236,'2015-05-19 16:06:51','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(237,'2015-05-19 16:07:30','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(238,'2015-05-19 16:08:01','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(239,'2015-05-19 16:08:08','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(240,'2015-05-19 16:08:13','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(241,'2015-05-19 16:10:56','catering@localhost','violant','aba57d878ca27f5ffb85b62e96cd3ebf','aba57d878ca27f5ffb85b62e96cd3ebf'),(242,'2015-05-19 16:12:29','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(243,'2015-05-19 16:12:42','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(244,'2015-05-19 16:12:57','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(245,'2015-05-19 16:14:08','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(246,'2015-05-19 16:14:12','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(247,'2015-05-19 16:15:19','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(248,'2015-05-19 16:15:29','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(249,'2015-05-19 16:15:36','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(250,'2015-05-19 16:17:15','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(251,'2015-05-19 16:17:28','catering@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(252,'2015-05-19 16:17:34','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(253,'2015-05-19 16:18:53','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(254,'2015-05-19 16:19:06','catering@localhost','aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(255,'2015-05-19 16:19:13','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(256,'2015-05-19 16:20:06','root@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(257,'2015-05-19 16:20:19','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(258,'2015-05-19 16:20:33','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(259,'2015-05-19 16:20:55','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(260,'2015-05-19 16:21:54','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(261,'2015-05-19 16:22:35','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(262,'2015-05-19 16:22:49','root@localhost','luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','34b16f38c4f1e9f58e0490e105a26f2a'),(263,'2015-05-19 16:22:49','root@localhost','violant','aba57d878ca27f5ffb85b62e96cd3ebf','aba57d878ca27f5ffb85b62e96cd3ebf'),(264,'2015-05-19 16:23:04','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(265,'2015-05-19 16:24:10','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(266,'2015-05-19 16:24:27','root@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(267,'2015-05-19 16:24:35','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(268,'2015-05-19 16:25:23','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','5d6b26a67f2db52ac6ebaa810a9effa1'),(269,'2015-05-19 16:26:34','catering@localhost','vicent','5d6b26a67f2db52ac6ebaa810a9effa1','ef3cdfec9a1a443b6c670a4a92561016'),(270,'2015-05-19 16:26:40','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(271,'2015-05-19 16:26:46','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(272,'2015-05-19 16:27:01','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(273,'2015-05-19 16:31:55','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(274,'2015-05-19 16:32:12','catering@localhost','aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(275,'2015-05-19 16:32:40','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(276,'2015-05-19 16:33:37','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(277,'2015-05-19 16:33:56','catering@localhost','aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(278,'2015-05-19 16:35:58','root@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(279,'2015-05-19 16:36:14','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(280,'2015-05-19 16:36:25','catering@localhost','aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(281,'2015-05-19 16:36:41','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(282,'2015-05-19 16:37:22','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(283,'2015-05-19 16:37:39','catering@localhost','aina','e0ee3e1a0a7a298cba129ae6747bf9f9','e0ee3e1a0a7a298cba129ae6747bf9f9'),(284,'2015-05-19 16:38:27','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(285,'2015-05-19 16:38:36','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(286,'2015-05-19 16:39:05','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(287,'2015-05-19 16:39:52','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016'),(288,'2015-05-19 16:41:17','catering@localhost','vicent','ef3cdfec9a1a443b6c670a4a92561016','ef3cdfec9a1a443b6c670a4a92561016');
/*!40000 ALTER TABLE `tlogcanvipassuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuari`
--

DROP TABLE IF EXISTS `usuari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuari` (
  `nom` varchar(60) CHARACTER SET utf8mb4 DEFAULT NULL,
  `dni` varchar(9) CHARACTER SET utf8mb4 DEFAULT NULL,
  `datanaixement` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `edat` int(11) DEFAULT NULL,
  `login` varchar(9) CHARACTER SET utf8mb4 NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `datalta` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `tipus` varchar(15) CHARACTER SET utf8mb4 NOT NULL,
  `estat` tinyint(1) DEFAULT NULL,
  `avatar` varchar(150) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `password_UNIQUE` (`password`),
  KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuari`
--

LOCK TABLES `usuari` WRITE;
/*!40000 ALTER TABLE `usuari` DISABLE KEYS */;
INSERT INTO `usuari` VALUES ('Aina Lozada Ferri','48606333L','28/05/1993',21,'aina','e0ee3e1a0a7a298cba129ae6747bf9f9','16/05/2015','aina_13girl@hotmail.com','user',0,'src/images/Nw5eB.jpg'),('violant','23456358S','05/02/1953',62,'luksilvia','34b16f38c4f1e9f58e0490e105a26f2a','10/05/2015','email3@email.com','user',0,'src/images/mKEN1.jpg'),('Nom de usuari01','23432345Z','01/01/1980',35,'usuari01','db303fce047d78f180dc21b6ce445561','17/05/2015','vicentlozada@hotmail.com','admin',0,'src/images/8dxWp.jpg'),('nom usuari zero set','89745623Z','07/05/1977',38,'usuari07','de88e3e4ab202d87754078cbb2df6063','18/05/2015','jaume1r@hotmail.com','user',0,'src/images/7zr$5.jpg'),('Vicent','32345678L','15/05/1970',45,'vicent','ef3cdfec9a1a443b6c670a4a92561016','03/05/2015','jjcale_62@hotmail.com','admin',0,'src/images/miM$_.jpg'),('violant lozada ferri','62726277X','07/01/1999',16,'violant','aba57d878ca27f5ffb85b62e96cd3ebf','10/05/2015','email8@email.com','admin',0,'src/images/luq7P.jpg');
/*!40000 ALTER TABLE `usuari` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `catering`.`usuari_AFTER_INSERT_PASS` AFTER INSERT ON `usuari` FOR EACH ROW
BEGIN
INSERT INTO tlogcanvipassuser( datacanvi, usuari, login, passOld, passNew )
values( Now(), USER(), new.login, null , new.password );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `catering`.`usuari_AFTER_UPDATE_PASS` AFTER UPDATE ON `usuari` FOR EACH ROW BEGIN
insert into tlogcanvipassuser( datacanvi, usuari, login, passOld, passNew )
values( Now(), USER(), new.login, old.password , new.password );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `catering`.`usuari_AFTER_DELETE_PASS` AFTER DELETE ON `usuari` FOR EACH ROW
BEGIN
insert into tlogcanvipassuser( datacanvi, usuari, login, passOld, passNew )
values( Now(), USER(), old.login, old.password , null );
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping routines for database 'catering'
--
/*!50003 DROP PROCEDURE IF EXISTS `empleat_amb_ant` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `empleat_amb_ant`()
BEGIN
	DECLARE l_last_row INT DEFAULT 0;
	DECLARE contador int default 0;
	DECLARE rdo VARCHAR(500) default '';
	
    DECLARE eldni char(9);
	DECLARE elnom char(60);
	DECLARE ldatanti char(12);
    DECLARE lanti int(11);
    
    DECLARE cursor1 CURSOR FOR
    SELECT dni, nom, datacontratacio, antiguitat
    FROM empleatfix
    WHERE antiguitat >= 3;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET l_last_row = 1;
    OPEN cursor1;
    c1_loop: LOOP
		FETCH cursor1 INTO eldni, elnom, ldatanti, lanti;
        IF (l_last_row = 1) THEN
			LEAVE c1_loop;
		END IF;
        SET rdo = CONCAT(rdo, elnom, ' - ', ldatanti, ' - ', lanti, ' | ');
        SET contador = contador + 1;
	END LOOP c1_loop;
    CLOSE cursor1;
    IF (contador = 0) THEN
		SET rdo = 'No hi ha registres que complisquen la condiciÃƒÂ³';
	END IF;
    SELECT rdo;    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `empleat_mes_antic` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `empleat_mes_antic`(OUT `elnom` VARCHAR(60), 
OUT `eldni` VARCHAR(9), OUT `ladata` VARCHAR(12))
    READS SQL DATA
BEGIN
declare max_ant int(11);
set max_ant = (
select max(antiguitat)
from empleatfix
);

set @max_ant=max_ant;

select nom, dni, datacontratacio into elnom, eldni, ladata
from empleatfix
where antiguitat = max_ant
order by antiguitat limit 1;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `new_view`
--

/*!50001 DROP VIEW IF EXISTS `new_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `new_view` AS select `empleatfix`.`nom` AS `nom`,`empleatfix`.`dni` AS `dni`,`empleatfix`.`datanaixement` AS `datanaixement`,`empleatfix`.`edat` AS `edat`,`empleatfix`.`sou` AS `sou` from `empleatfix` where (`empleatfix`.`edat` > 30) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-20 18:05:13