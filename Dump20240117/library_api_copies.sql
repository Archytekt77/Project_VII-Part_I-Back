CREATE DATABASE  IF NOT EXISTS `library_api` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `library_api`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: library_api
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `copies`
--

DROP TABLE IF EXISTS `copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `copies` (
  `id` int NOT NULL,
  `collection` varchar(255) DEFAULT NULL,
  `copies` int NOT NULL,
  `create_date` datetime NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  `publication_date` datetime DEFAULT NULL,
  `publisher_name` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKic2xn1usf0mywohvy5thj1m3l` (`book_id`),
  KEY `FK84fagyr763i67rh6uidbbmgoh` (`type_id`),
  CONSTRAINT `FK84fagyr763i67rh6uidbbmgoh` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`),
  CONSTRAINT `FKic2xn1usf0mywohvy5thj1m3l` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copies`
--

LOCK TABLES `copies` WRITE;
/*!40000 ALTER TABLE `copies` DISABLE KEYS */;
INSERT INTO `copies` VALUES (47,'Épopée des Destinées',4,'2023-11-24 17:03:10','Français','2023-02-15 01:00:00','Lumière Éternelle Éditions','2024-01-17 15:56:28',18,2),(48,'Intrigues Mortelles',2,'2023-11-24 17:06:39','Français','2023-04-10 02:00:00','Shadowbound Press','2023-12-09 12:38:37',19,10),(49,'Odyssée Temporelle',6,'2023-11-24 17:06:48','Français','2023-01-22 01:00:00','Stellar Publishing','2024-01-17 15:56:32',20,11),(50,'Contes Enchantés',2,'2023-11-24 17:06:57','Français','2023-03-08 01:00:00','Mystic Tales Publishing','2023-11-24 17:06:57',21,12),(51,'Mystères d\'Argent',3,'2023-11-24 17:07:06','Français','2023-05-18 02:00:00','Éditions Arc-en-Ciel','2024-01-17 15:56:38',22,13),(52,'Explorations Cosmiques',6,'2023-11-24 17:07:39','Français','2023-06-30 02:00:00','Lumière Éternelle Éditions','2023-11-24 17:07:39',23,1),(53,'Portraits de Vie',1,'2023-11-24 17:07:49','Français','2023-07-12 02:00:00','Shadowbound Press','2023-11-24 17:07:49',24,14),(54,'Rêves Lyriques',4,'2023-11-24 17:07:59','Français','2023-08-25 02:00:00','Stellar Publishing','2024-01-17 15:57:23',25,15),(55,'Tragédie Familiale',2,'2023-11-24 17:08:09','Français','2023-09-14 02:00:00','Mystic Tales Publishing','2024-01-17 15:57:20',26,16),(56,'Terreur Nocturne',5,'2023-11-24 17:08:19','Anglais','2023-10-06 02:00:00','Éditions Arc-en-Ciel','2024-01-17 15:57:14',27,17),(74,'Destins Croisés',5,'2024-01-17 15:44:27','Français','2023-03-15 01:00:00','Éditions Lumières','2024-01-17 15:44:27',18,1),(75,'Mystères Nocturnes',4,'2024-01-17 15:44:42','Français','2023-05-22 02:00:00','Noir Horizon Éditeurs','2024-01-17 15:44:42',19,2),(76,'Chroniques du Futur',3,'2024-01-17 15:44:52','Anglais','2023-02-10 01:00:00','Temps Éditions','2024-01-17 15:44:52',20,10),(77,'Contes de Féerie',6,'2024-01-17 15:45:03','Français','2023-07-30 02:00:00','Éditions Magiques','2024-01-17 15:45:03',21,11),(78,'Mystères Anciens',2,'2024-01-17 15:45:17','Français','2023-01-20 01:00:00','Histoires Cachées','2024-01-17 15:45:17',22,13),(79,'Cosmos et Connaissance',7,'2024-01-17 15:45:34','Français','2023-09-05 02:00:00','Étoiles Savantes','2024-01-17 15:45:34',23,11),(80,'Vies Inspirantes',1,'2024-01-17 15:45:44','Français','2023-11-17 01:00:00','Biographies Nouvelles','2024-01-17 15:45:44',24,14),(81,'Poésie du Coeur',3,'2024-01-17 15:45:54','Français','2023-04-28 02:00:00','Rimes Éditeurs','2024-01-17 15:45:54',25,15),(82,'Sentiments Profonds',5,'2024-01-17 15:46:06','Français','2023-06-15 02:00:00','Amour et Vie','2024-01-17 15:46:06',26,16),(83,'Ombres Invisibles',6,'2024-01-17 15:46:22','Français','2023-10-19 02:00:00','Frémissantes Éditions','2024-01-17 15:46:22',19,10),(84,'Aventures Intertemporelles',1,'2024-01-17 15:46:31','Français','2023-03-28 02:00:00','Sphères du Temps','2024-01-17 15:46:31',20,1),(85,'Secrets Anciens',4,'2024-01-17 15:46:41','Français','2023-05-11 02:00:00','Vestiges Éditions','2024-01-17 15:46:41',22,9),(86,'Figures Marquantes',5,'2024-01-17 15:46:50','Français','2023-08-22 02:00:00','Héros du Quotidien','2024-01-17 15:46:50',24,1),(87,'Crépuscule Mystérieux',3,'2024-01-17 15:46:58','Français','2023-07-14 02:00:00','Éditions Lunaire','2024-01-17 15:46:58',26,16);
/*!40000 ALTER TABLE `copies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-17 16:00:51
