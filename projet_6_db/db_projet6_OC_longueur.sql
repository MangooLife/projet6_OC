CREATE DATABASE  IF NOT EXISTS `db_projet6_OC` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `db_projet6_OC`;
-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: db_projet6_OC
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `longueur`
--

DROP TABLE IF EXISTS `longueur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `longueur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cotation` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `spit` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `width` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `voie_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voie_id_idx` (`voie_id`),
  CONSTRAINT `FKk0nbogdkmsoru5wuals5bf849` FOREIGN KEY (`voie_id`) REFERENCES `voie` (`id`),
  CONSTRAINT `fk_voie_id` FOREIGN KEY (`voie_id`) REFERENCES `voie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `longueur`
--

LOCK TABLES `longueur` WRITE;
/*!40000 ALTER TABLE `longueur` DISABLE KEYS */;
INSERT INTO `longueur` VALUES (5,'L1','4c','10','30',8),(6,'L2','4b','25','35',8),(7,'L3','4c','15','30',8),(8,'L4','4b','17','35',8),(9,'L1','6b','30','100',11),(10,NULL,'6a','38','100',11),(11,'L1','6a','40','50',16),(12,'L2','6a','20','10',16),(13,'L1','6a','10','20',19),(14,'L2','7a','20','40',19),(15,'L1','5a','10','50',26),(16,'L2','5a','15','50',26);
/*!40000 ALTER TABLE `longueur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-10 11:45:57
