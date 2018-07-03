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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `lecturerId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `designation` varchar(100) NOT NULL,
  `academicQulifications` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `areaOfInterest` text NOT NULL,
  `professionalQualifications` text CHARACTER SET big5,
  `modulesTought` text,
  `publications` text,
  `ishead` int(11) DEFAULT '0',
  `imageName` varchar(45) DEFAULT NULL,
  `isDisable` int(11) DEFAULT '0',
  `sortOrder` int(11) NOT NULL,
  `linkedin` varchar(100) DEFAULT NULL,
  `googlePlus` varchar(100) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lecturerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Dr. P. D.C.Perera','Dean, Senior Lecturer','BSc (China) PhD (Denmark)','chandana@eie.ruh.ac.lk ','(+949)12245766 (1000)','Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent SystemsSpecialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems','Computer Architecture and Operating Systems :: Image Processing :: Cloud Computing :: AI :: Data mining','IEEE IESL','EE5208	Advanced Electronics::EE5302 Computer Networks::EE5304 Power Electronics','S.M.George, w.zhou, H.Chenji,M.Won,Y.O.Lee, A.Pazarloglou and R.Stoleru, DistressNet:A wireless Adhoc and Sensor Network Architecture for situation Management in Disaster ResponseIEEEE Communications Magzine ,PP:-128-136, March 2010.:: Yoshitaka Shibata, Daisuke Nakamura, Noriki Uchida, Kazuo Takahata, Ã¢ÂÂResidents Oriented Disaster Information NetworkÃ¢ÂÂ, IEEE Proc on SAINTÃ¢ÂÂ2003, pp. 317-322, January 2003.::Noriki Uchida, Hideaki Asahi, Yoshitaka Shibata, \"Disaster Information System and I',0,'1.jpg',0,1,'https://lk.linkedin.com/in/jcs-kadupitiya-7676964b','https://plus.google.com/','https://www.facebook.com/kadupitiya'),(2,'Dr. S.H.K.K. Gunawickrama','Head of the Department, Senior Lecturer','PhD, M.Sc.(Gdansk)',' headeie@eie.ruh.ac.lk ','(+94)912200000 (3000)','Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent SystemsSpecialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems','Computer Architecture and Operating Systems :: Image Processing :: Cloud Computing :: AI :: Data mining','IEEE IESL','EE5208	Advanced Electronics::EE5302 Computer Networks::EE5304 Power Electronics','S.M.George, w.zhou, H.Chenji,M.Won,Y.O.Lee, A.Pazarloglou and R.Stoleru, DistressNet:A wireless Adhoc and Sensor Network Architecture for situation Management in Disaster ResponseIEEEE Communications Magzine ,PP:-128-136, March 2010.:: Yoshitaka Shibata, Daisuke Nakamura, Noriki Uchida, Kazuo Takahata, ÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂ¢ÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂResidents Oriented Disaster Information NetworkÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂ¢ÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂ, IEEE Proc on SAINTÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂ¢ÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂÃÂ2003, pp. 317-322, January 2003.::Noriki Uchida, Hideaki Asahi, Yoshitaka Shibata, \"Disaster Information System and I',1,'2.jpg',0,2,'https://lk.linkedin.com/in/jcs-kadupitiya-7676964b','https://plus.google.com/','https://www.facebook.com/kadupitiya'),(3,'Dr. N.D. Jayasundere','Senior Lecturer','BSc (Hon) (UK), MSc (UK), MPhil (UK), PhD (UK)','jayasundere@eie.ruh.ac.lk ','(+94)912200000 (3031)','Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent SystemsSpecialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems','Computer Architecture and Operating Systems :: Image Processing :: Cloud Computing :: AI :: Data mining','IEEE IESL','EE5208	Advanced Electronics::EE5302 Computer Networks::EE5304 Power Electronics','S.M.George, w.zhou, H.Chenji,M.Won,Y.O.Lee, A.Pazarloglou and R.Stoleru, DistressNet:A wireless Adhoc and Sensor Network Architecture for situation Management in Disaster ResponseIEEEE Communications Magzine ,PP:-128-136, March 2010.:: Yoshitaka Shibata, Daisuke Nakamura, Noriki Uchida, Kazuo Takahata, “Residents Oriented Disaster Information Network”, IEEE Proc on SAINT’2003, pp. 317-322, January 2003.::Noriki Uchida, Hideaki Asahi, Yoshitaka Shibata, \"Disaster Information System and I',0,'3.jpg',0,3,'https://lk.linkedin.com/in/jcs-kadupitiya-7676964b','https://plus.google.com/','https://www.facebook.com/kadupitiya'),(4,'Dr. C. Kariyawasam','Senior Lecturer','PhD (Texas), BSc (Eng) (Ceylon)','jayasundere@eie.ruh.ac.lk ','(+94)912200000 (3031)','Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent SystemsSpecialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems','Computer Architecture and Operating Systems :: Image Processing :: Cloud Computing :: AI :: Data mining','IEEE IESL','EE5208	Advanced Electronics::EE5302 Computer Networks::EE5304 Power Electronics','S.M.George, w.zhou, H.Chenji,M.Won,Y.O.Lee, A.Pazarloglou and R.Stoleru, DistressNet:A wireless Adhoc and Sensor Network Architecture for situation Management in Disaster ResponseIEEEE Communications Magzine ,PP:-128-136, March 2010.:: Yoshitaka Shibata, Daisuke Nakamura, Noriki Uchida, Kazuo Takahata, “Residents Oriented Disaster Information Network”, IEEE Proc on SAINT’2003, pp. 317-322, January 2003.::Noriki Uchida, Hideaki Asahi, Yoshitaka Shibata, \"Disaster Information System and I',0,'4.jpg',0,4,'https://lk.linkedin.com/in/jcs-kadupitiya-7676964b','https://plus.google.com/','https://www.facebook.com/kadupitiya'),(5,'Dr. R. Udawalpola','Senior Lecturer','PhD(Uppsala), BSc(SL)','jayasundere@eie.ruh.ac.lk ','(+94)912200000 (3031)','Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent SystemsSpecialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems','Computer Architecture and Operating Systems :: Image Processing :: Cloud Computing :: AI :: Data mining','IEEE IESL','EE5208	Advanced Electronics::EE5302 Computer Networks::EE5304 Power Electronics','S.M.George, w.zhou, H.Chenji,M.Won,Y.O.Lee, A.Pazarloglou and R.Stoleru, DistressNet:A wireless Adhoc and Sensor Network Architecture for situation Management in Disaster ResponseIEEEE Communications Magzine ,PP:-128-136, March 2010.:: Yoshitaka Shibata, Daisuke Nakamura, Noriki Uchida, Kazuo Takahata, Ã¢ÂÂResidents Oriented Disaster Information NetworkÃ¢ÂÂ, IEEE Proc on SAINTÃ¢ÂÂ2003, pp. 317-322, January 2003.::Noriki Uchida, Hideaki Asahi, Yoshitaka Shibata, \"Disaster Information System and I',0,'5.jpg',0,5,'https://lk.linkedin.com/in/jcs-kadupitiya-7676964b','https://plus.google.com/','https://www.facebook.com/kadupitiya'),(6,'Mr. E.H. Jayathunga','Senior Lecturer','M.Eng. (Thailand), B.Sc. (Eng.)','jayasundere@eie.ruh.ac.lk ','(+94)912200000 (3031)','Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent SystemsSpecialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems','Computer Architecture and Operating Systems :: Image Processing :: Cloud Computing :: AI :: Data mining','IEEE IESL','EE5208	Advanced Electronics::EE5302 Computer Networks::EE5304 Power Electronics','S.M.George, w.zhou, H.Chenji,M.Won,Y.O.Lee, A.Pazarloglou and R.Stoleru, DistressNet:A wireless Adhoc and Sensor Network Architecture for situation Management in Disaster ResponseIEEEE Communications Magzine ,PP:-128-136, March 2010.:: Yoshitaka Shibata, Daisuke Nakamura, Noriki Uchida, Kazuo Takahata, “Residents Oriented Disaster Information Network”, IEEE Proc on SAINT’2003, pp. 317-322, January 2003.::Noriki Uchida, Hideaki Asahi, Yoshitaka Shibata, \"Disaster Information System and I',0,'6.jpg',0,6,'https://lk.linkedin.com/in/jcs-kadupitiya-7676964b','https://plus.google.com/','https://www.facebook.com/kadupitiya'),(7,'Mr. S De. Silva','Senior Lecturer','MSc. (Norway), BSc.(SL)','jayasundere@eie.ruh.ac.lk ','(+94)912200000 (3031)','Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems Specialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent SystemsSpecialized in Computer Architecture Parallel Computation Fault Detection and Isolation Intelligent Systems','Computer Architecture and Operating Systems :: Image Processing :: Cloud Computing :: AI :: Data mining','IEEE IESL','EE5208	Advanced Electronics::EE5302 Computer Networks::EE5304 Power Electronics','S.M.George, w.zhou, H.Chenji,M.Won,Y.O.Lee, A.Pazarloglou and R.Stoleru, DistressNet:A wireless Adhoc and Sensor Network Architecture for situation Management in Disaster ResponseIEEEE Communications Magzine ,PP:-128-136, March 2010.:: Yoshitaka Shibata, Daisuke Nakamura, Noriki Uchida, Kazuo Takahata, “Residents Oriented Disaster Information Network”, IEEE Proc on SAINT’2003, pp. 317-322, January 2003.::Noriki Uchida, Hideaki Asahi, Yoshitaka Shibata, \"Disaster Information System and I',0,'7.jpg',0,7,'https://lk.linkedin.com/in/jcs-kadupitiya-7676964b','https://plus.google.com/','https://www.facebook.com/kadupitiya'),(8,'Name Updated','Designation Updated','Acadamic Qualifications Updated','Email Updated','Telephone Updated','Description Updated','Area of Interest Updated','Professional Qualifications Updated','Module Tought Updated','Publications Updated',0,'8.jpg',1,8,'LinkedIn Address Updated','Google Plus Address Updated',' Facebook Address Updated');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
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
