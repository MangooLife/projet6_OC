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
-- Table structure for table `voie`
--

DROP TABLE IF EXISTS `voie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cotation` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `width` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `secteur_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_secteur_id_idx` (`secteur_id`),
  CONSTRAINT `FK9c23usd7pix4gtu2jfbseh4dq` FOREIGN KEY (`secteur_id`) REFERENCES `secteur` (`id`),
  CONSTRAINT `fk_secteur_id` FOREIGN KEY (`secteur_id`) REFERENCES `secteur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voie`
--

LOCK TABLES `voie` WRITE;
/*!40000 ALTER TABLE `voie` DISABLE KEYS */;
INSERT INTO `voie` VALUES (5,'Les flèches','4a','50',15),(6,'Zig zag','4c','50',15),(7,'Petit surplom','4c','50',15),(8,'Le dièdre jaune','4b, 4c','100',15),(9,'Mystère','6a+','80',15),(10,'Boule de gomme','6a','70',15),(11,'Happy new year','6b, 6a','200',16),(12,'Le plaisir des yeux','6a','150',16),(13,'La valise','6a','90',16),(14,'Telegraph road','6b','80',16),(15,'Echec aux nains','6c+',NULL,16),(16,'A tora','6a','50',21),(17,'di Seneca','5c','100',21),(18,'E torre del sol','6c','100',22),(19,'Torre e zeus','7a','100',22),(20,'I monti de','7a','200',27),(21,'or de ','5a','100',28),(22,'Ambata de Corsica','7c','150',29),(23,'Boni','5a','50',24),(24,'Fato','5a','50',24),(25,'La bi','5a','50',25),(26,'bibli','5c','100',25),(27,'Suareee','6a','100',26);
/*!40000 ALTER TABLE `voie` ENABLE KEYS */;
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
