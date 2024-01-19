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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL,
  `create_date` datetime NOT NULL,
  `publication_date` datetime DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `author_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfjixh2vym2cvfj3ufxj91jem7` (`author_id`),
  CONSTRAINT `FKfjixh2vym2cvfj3ufxj91jem7` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (18,'2023-11-24 15:15:36','2022-01-15 01:00:00','Une saga familiale captivante','Les Liens du Destin','2023-11-24 15:15:36',28),(19,'2023-11-24 15:15:55','2021-12-03 01:00:00','Un thriller palpitant de manipulation et de trahison','Le Piège Obscur','2023-11-24 15:15:55',29),(20,'2023-11-24 15:16:06','2022-02-20 01:00:00','Exploration fascinante des voyages dans le temps','Voyageurs Temporels','2023-11-24 15:16:06',30),(21,'2023-11-24 15:16:17','2021-11-10 01:00:00','Épopée fantastique dans un monde magique','Le Royaume Enchanté','2023-11-24 15:16:17',31),(22,'2023-11-24 15:16:28','2022-03-08 01:00:00','Un mystère à résoudre dans une vieille demeure','L\'Énigme du Manoir','2023-11-24 15:16:28',32),(23,'2023-11-24 15:16:48','2021-10-25 02:00:00','Une exploration des mystères de l\'espace','L\'Univers Expliqué','2023-11-24 15:16:48',33),(24,'2023-11-24 15:16:57','2022-04-12 02:00:00','La vie inspirante de Nelson Mandela','Un Homme Exceptionnel','2023-11-24 15:16:57',34),(25,'2023-11-24 15:17:06','2021-09-18 02:00:00','Recueil de poèmes explorant l\'amour et la nature','Éclats de Vers','2023-11-24 15:17:06',35),(26,'2023-11-24 15:17:17','2022-05-05 02:00:00','Drame familial poignant sur la résilience','L\'Épreuve du Cœur','2023-11-24 15:17:17',36),(27,'2023-11-24 15:17:29','2022-06-22 02:00:00','Un roman d\'horreur explorant les terreurs nocturnes','Les Ombres de la Nuit','2023-11-24 15:17:29',37);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
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
