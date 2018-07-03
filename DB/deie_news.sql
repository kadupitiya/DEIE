CREATE DATABASE  IF NOT EXISTS `deie` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `deie`;
-- MySQL dump 10.13  Distrib 5.6.26, for Win64 (x86_64)
--
-- Host: localhost    Database: deie
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `newsId` int(11) NOT NULL,
  `imageName` varchar(45) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `isDisable` int(11) NOT NULL DEFAULT '0',
  `imageCount` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'1.jpg','ICIAfS-pre-conference international workshop','ICIAfS, Sri Lanka\'s premier international engineering conference ICIAfS joins hands with the Faculty of Engineering, ICIAfS, Sri Lanka\'s premier international engineering conference ICIAfS joins hands with the Faculty of Engineering.',0,1),(2,'2.jpg','EIE students has won Awards','The undergraduate project \"Multi Stage Dimmable Smart Fluorescent Lamp” has won the E.W.Karunarathna Award-2013-IESL conducted annaual national competition for the',0,1),(3,'3.jpg','EIE Alumina','The First Meetup and the Annual General Meeting of Alumni Association of Ruhuna Electrical and Information Engineering (AAREIE) was held on 23rd  March 2014 at',0,1),(4,'4.jpg','Demonstrations of Undergraduate Projects 2013','Demonstrations of undergraduate projects were held at Department premises on 19th December 2013. The demonstrations were opened to staff and students.',0,1),(5,'5.jpg','NEW ELECTORAL SYSTEM BEFORE END OF THIS YEAR; SAYS PRIME MINISTER ','Prime Minister Ranil Wickremesinghe said the new electoral system is expected to be introduced before the end of this year.',0,1),(6,'6.jpg','3 YEAR OLD GIRL MISSING FROM KARUWALAGASWAWA RECOVERED FROM THABBOWA RESERVATION.','The three-year girl who had gone missing from Kaluwaragaswewa in Puttalam was found yesterday by police while she was in the Thabbowa Reservation.',0,1),(7,'7.jpg','HUMAN RIGHTS REPORT ON SRI LANKA TAKEN UP FOR DEBATE; SUPPORT FROM 29 COUNTRIES.','Sri Lanka assured that the report of Office of the High Commissioner for Human Rights on \"promoting reconciliation, accountability and human rights in Sri Lanka\" presented to the 30th session of the UN Human Rights Council in Geneva and its recommendations will receive due attention.',0,1),(8,'8.jpg','RESOLUTION ABOUT SRI LANKA DISCUSSED AT UNHCR TODAY. ','Member States are scheduled to express their views at the Geneva Human Rights Conference today with regard to UN HRC Commissioner’s Recommendations in reference to the country’s Human Rights situation and the resolution put forward by US supporting the Sri Lankan Government.',0,1),(9,'9.jpg','AUSTRALIA TO SEEK BANGLADESH TOUR SECURITY ASSURANCES','Cricket Australia said it would seek assurances from its Bangladesh counterpart before proceeding with the team\'s October tour, amid government fears that \"militants may be planning to target Australian interests\".',0,1),(10,'10.jpg','SEPP BLATTER TO RESIGN AS FIFA PRESIDENT AMID CORRUPTION SCANDAL ','Sepp Blatter is to resign as president of football\'s governing body Fifa amid a corruption scandal and is reportedly under investigation in the US.',0,1),(11,'11.jpg','FIFA WORLD CUP 2026 BIDDING PROCESS DELAYED ','The bidding process for the 2026 World Cup has been postponed amid allegations around the 2018 and 2022 tournaments.',0,1),(12,'12.jpg','SEPP BLATTER TO RESIGN AS FIFA PRESIDENT AMID CORRUPTION SCANDAL ','Sepp Blatter is to resign as president of football\'s governing body Fifa amid a corruption scandal and is reportedly under investigation in the US.',0,1),(13,'13.jpg','iPhone 6s vs iPhone 6 - Comparison!','Available in gold, silver, space grey and rose gold, iPhone 6s Plus features an A9 chip, 3D Touch, ultra-fast wireless, a 12MP iSight camera and iOS 9.\r\n\r\nAvailable in gold, silver, space grey and rose gold, iPhone 6s features an A9 chip, 3D Touch, ultra-fast wireless, a 12MP iSight camera and iOS 9.\r\n\r\nAvailable in silver and space grey, iPhone 6 Plus features an A8 chip, a Touch ID ï¬ngerprint identity sensor, ultra-fast wireless, an 8MP iSight camera and iOS 9.',0,2);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-14 13:40:11
