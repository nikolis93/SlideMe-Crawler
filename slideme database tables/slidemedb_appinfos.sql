-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: slidemedb
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

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
-- Table structure for table `appinfos`
--

DROP TABLE IF EXISTS `appinfos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appinfos` (
  `appUrl` varchar(190) COLLATE utf8mb4_bin NOT NULL,
  `appName` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `appVersion` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `price` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `developer` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `lastSubmision` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `averageRating` varchar(5) COLLATE utf8mb4_bin NOT NULL,
  `ratingsPerStar` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `numberOfReviews` varchar(5) COLLATE utf8mb4_bin NOT NULL,
  `categories` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `tags` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `language` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  `hasAdvertisments` varchar(5) COLLATE utf8mb4_bin NOT NULL,
  `imageUrl` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `apkUrl` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `reviewsUrl` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `DiscussionsUrl` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `parentalRating` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `totalDownloads` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`appUrl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-02 16:37:11
