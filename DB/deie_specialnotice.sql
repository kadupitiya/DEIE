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
-- Table structure for table `specialnotice`
--

DROP TABLE IF EXISTS `specialnotice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialnotice` (
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
-- Dumping data for table `specialnotice`
--

LOCK TABLES `specialnotice` WRITE;
/*!40000 ALTER TABLE `specialnotice` DISABLE KEYS */;
INSERT INTO `specialnotice` VALUES (1,'1.jpg','Welcome to the International Conference on Advances in Electrical and Information Engineering 2014','President Maithripala Sirisena said today the Death Penalty would be introduced from next year with the approval of Parliament. Addressing the national Drugs and Alcohol Temperance programme held at the main hall of the Galle Municipal Council, he said the decision to introduce the death penalty was taken in the aftermath of the several incidents of rape and the recent killing and sexual abuse of Seya Sandevmi. “I am in a position to impose the death penalty using the executive powers vested in me. But, I thought that the better option was to discuss it with Parliament before introducing the death penalty,” the President has said.',1,1),(2,'2.jpg','The three streams comes under the Dept.of Electrical and Information','A Colombo court yesterday ordered the management of Lanka Hospital Corporation PLC that a body of a deceased person be immediately released to the close relatives, which was reportedly retained under hospital custody for seven days until the hospital bill was settled. The deceased Tilak Daluwatta of Ragama, Batuwatta (62) had died in the Hospital on September 11 while he was receiving in-house treatment at the hospital following a by-pass surgery. While ordering the hospital management to release the body of the deceased person to a close relative, Colombo Additional Magistrate Nishantha Peiris observed that respecting the dead was a matter of paramount importance. He further maintained that there was no legal provision to retain a body under anyone’s custody and stated that the hospital could take civil action against the parties over defaulting the hospital bill, if the need arose. A sibling of the deceased had made a complaint with the Narahenpita Police alleging that the hospital management had retained the body under hospital custody since the relatives of the deceased had not paid the bill amounting to Rs.1.4 million. The complainant told police that his brother was admitted to the hospital on August 25 for a by-pass surgery since they had been informed that the surgery would cost Rs.650,000. He further stated that they took measures to pay a sum of Rs.300,000 at the beginning. He said his brother’s health condition started to deteriorate even after the surgery was performed on August 25. He further stated that hospital authorities did not take notice on his request that the patient be transferred to the National Hospital in Colombo.',1,1),(3,'3.jpg','ICACIT','Sri Lanka’s world cup winning cricket captain Arjuna Ranatunga who is presently the country’s Minister of Ports and Shipping, took a dig at two recently-retired cricket greats Kumar Sangakkara and Mahela Jayawardene at a public ceremony in Nittambuwa yesterday.',0,1),(4,'4.jpg','Welcome to SavidZone - The Science Zone','The Kaduwela - Kadawatha section of the Colombo Outer Circular Expressway, which is scheduled to be opened today, will be open to the public after 9 pm today (17), the Ministry of Highways said. The government has spent 44 billion to construct this section which is 9 kilometres in length. A toll of Rs. 100 will be charged from light vehicles that travel from Kadawatha to Kaduwela on the Expressway while Rs. 200 will be charged from heavy vehicles. Rs. 650 will be charged from light vehicles travelling from Kadawatha to Matara and Rs. 1,750 will be charged from heavy vehicles including busses. The toll charge from Kadawatha to Pinnaduwa is Rs. 500 for light vehicles. Bus fare is Rs. 400 per person to Galle from Kadawatha while Rs. 500 will be charged from passengers to Matara.  Bus service will be available from 8.30 in the morning to 4.30 in the evening for passengers travelling to Matara. Bus service for passengers travelling to Galle will be available from 7.00 a.m. to 3.00 p.m. daily.',0,1),(5,'5.jpg','President to address the 70th UN General Assembly on Sep. 30','President Maithripala Sirisena will address the General Assembly of the United Nations on September 30, during the 70th Session of the UN General Assembly Meeting, held at the UN Headquarters, New York, USA from September 15 to October 04.',0,1),(6,'6.jpg','Suspect injured in shooting at Kaduwela court','A person was wounded and hospitalised following a shooting incident which occurred at the Kaduwela Magistrate’s Court premises this morning. ',0,1),(7,'7.jpg','CoI records statement from Mahinda','The Presidential Commission of Inquiry (CoI) is currently recording a statement from former President Mahinda Rajapaksa at his residence in Mirihana.',0,1),(8,'8.jpg','President intervenes on behalf of Wijeweera’s family','President Maithripala Sirisena has instructed relevant authorities to allow the family of the late Rohana Wijeweera, founding leader of the Janatha Vimukthi Peramuna (JVP), to stay six more months at a house belonging to the Welisara navy camp.',0,1),(9,'9.jpg','Anura wants answers on Avant Garde issue','JVP Leader Anura Kumara Dissanayake raised concerns about the legality of the decision by the former Defence Secretary to transfer the powers to the Avant Garde Maritime Services (Pvt) Ltd to maintain a commercial floating armoury.',0,1),(10,'10.jpg','Special commodity levy on imported big onions','The special commodity levy on imported big onions has been increased from Rs.10 to 30 per KG with effective from today, the Finance Ministry says.   ',0,1),(11,'11.jpg','Navy arrests 15 Tamil Nadu fishermen','Sri Lanka Navy arrested 15 fishermen from Tamil Nadu and seized their two boats on Monday night for allegedly fishing in Lankan waters at Karainagar, 20 km from Jaffna, according to the PTI.',0,1),(12,'12.jpg','fdsf Kadda ','kadda ',1,1),(13,'13.jpg','Test 13','hjdsajdlksajdkljaslkdj',1,1),(14,'14.jpg','asdsadsad afffffffff kadda','sadas  kaddddadadadasd kadda',1,2);
/*!40000 ALTER TABLE `specialnotice` ENABLE KEYS */;
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
