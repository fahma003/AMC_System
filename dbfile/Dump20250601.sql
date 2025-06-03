-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: amc_system
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `add_amc`
--

DROP TABLE IF EXISTS `add_amc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `add_amc` (
  `amc_id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_email` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `company_phone` varchar(255) DEFAULT NULL,
  `contract_name` varchar(255) DEFAULT NULL,
  `cost` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`amc_id`),
  KEY `FKkwua2r6btlhuiyc1wlutah2pe` (`user_id`),
  CONSTRAINT `FKkwua2r6btlhuiyc1wlutah2pe` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_amc`
--

LOCK TABLES `add_amc` WRITE;
/*!40000 ALTER TABLE `add_amc` DISABLE KEYS */;
INSERT INTO `add_amc` VALUES (8,'Web Application','Colombo','nibm@gmail.com','NIBM','0987656443','Library System',4332223,'online library management systems','2025-04-09','2024-12-18',14),(9,'Mobile Application','Colombo','nsbm@gmail.com','NSBM','0763456887','Cafe System',213456,'online cafe management system','2025-01-22','2024-12-12',14),(10,'Web Application','123, Main Street, Colombo, Sri Lanka','contact@techsolutions.com','Tech Solutions Pvt Ltd','94123456789','Cafe System',3424242,'use blue, green and white colour ranges','2025-02-04','2024-12-11',3),(11,'Web Application','789 Cloud Avenue, Austin, TX 73301, USA','info@codecrafters.com','CodeCrafters Inc','0987656443','Cloud Application Development Contract',25000,'Development and deployment of a scalable cloud-based application tailored to client needs.','2025-01-21','2024-12-22',19),(12,'Desktop Application','456 Tech Park, Seattle, WA 98101, USA','contact@bytefix.com','ByteFix Technologies','0763434222','IT Infrastructure Management Agreement',180000,'Management of IT infrastructure, including server maintenance, network monitoring, and security enhancements.','2025-01-30','2024-12-21',17),(13,'Mobile Application','321 Enterprise Lane, Boston, MA 02110, USA','projects@softmatrix.com','SoftMatrix Solutions','0975656774','Custom ERP Development Contract',5000000,'End-to-end development of a customized ERP solution for streamlined business operations.\n','2025-03-13','2025-01-02',18),(14,'Hybrid Application','123, Main Street, Colombo, Sri Lanka','contact@techsolutions.com','Tech Solutions Pvt Ltd','94123456789','SaaS Subscription and Support Agreement',678900,'Subscription to our flagship SaaS product with priority technical support and updates.','2025-01-31','2024-12-27',3),(15,'Mobile Application','321 Enterprise Lane, Boston, MA 02110, USA','projects@softmatrix.com','SoftMatrix Solutions','0975656774','Mobile App Development Contract',345600,'Design, development, and deployment of a cross-platform mobile application.','2025-03-12','2025-01-04',18),(16,'Web Application','456 Tech Park, Seattle, WA 98101, USA','contact@bytefix.com','ByteFix Technologies','0763434222','AI Integration Services Contract',5678000,'ntegration of AI-powered solutions, including chatbots and predictive analytics, into existing software systems.','2025-03-11','2025-01-10',17),(17,'Web Application','123, Main Street, Colombo, Sri Lanka','contact@techsolutions.com','Tech Solutions Pvt Ltd','94123456789','Website Redesign and Optimization Agreement',456000,'Redesign and performance optimization of the client’s website to enhance user experience and SEO.','2025-05-29','2025-02-12',3),(18,'Web Application','321 Enterprise Lane, Boston, MA 02110, USA','projects@softmatrix.com','SoftMatrix Solutions','0975656774','DevOps Implementation Services Contract',780000,'Implementation of DevOps practices, including CI/CD pipeline setup and automated testing for agile development.','2025-02-04','2024-12-26',18),(19,'Web Application','123 Silicon Valley, San Jose, CA 95110','contact@techinnovators.com','Tech Innovators Ltd.','0786543214','E-Commerce Platform Development',890000,'Build a secure platform with user login, product management, payments, and order tracking.','2025-05-29','2025-01-01',20),(20,'Hybrid Application','45 Elm Street, Springfield, IL 62701','info@greenearth.com','Green Earth Supplies','0712323445','Custom CRM Solution',349999,'Develop a CRM for customer tracking, sales analysis, and team collaboration.','2025-06-27','2025-03-05',20),(21,'Mobile Application',' 789 Industrial Blvd, Houston, TX 77001','support@rapidlogistics.com','Rapid Logistics Co.','0112323445','Mobile App for Task Management',199000,'Create a mobile app for scheduling, team tasks, and real-time updates.','2025-06-24','2025-03-25',21),(22,'Mobile Application','789 Industrial Blvd, Houston, TX 77001','support@rapidlogistics.com','Rapid Logistics Co.','0112323445','HR Management System',234555,'Develop a cloud HR platform for payroll, employee data, and reviews.','2025-08-20','2025-03-20',21),(23,'Web Application','200 Cloud Drive, Seattle, WA 98101','services@skywardit.com','Skyward IT Services','1555210098','AI Chatbot Integration',455555,'Add an AI chatbot for customer support and query handling.','2025-07-24','2025-04-02',22),(26,'Web Application','321 Enterprise Lane, Boston, MA 02110, USA','projects@softmatrix.com','SoftMatrix Solutions','0975656774','Gateway Library Management System',129000,'Develop a library management system','2025-06-25','2025-03-06',18),(27,'Web Application','123, Main Street, Colombo, Sri Lanka','contact@techsolutions.com','Tech Solutions Pvt Ltd','94123456789','E-Commerce Platform',134000,'Build a secure platform with user login, product management, payments, and order tracking.','2025-07-16','2025-03-07',3),(30,'Web Application','gtn,colombo','gtn@gmail.com','GTN pvt ltd','671152434167','Bus booking system',340000,'designing a web application','2025-10-15','2025-05-07',25);
/*!40000 ALTER TABLE `add_amc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'Tech Solutions Pvt Ltd','Great!'),(2,'CodeCrafters Inc','Incredible and well satisfied '),(3,'NIBM','Great Job done by NexaSoft'),(4,'ByteFix Technologies','We greatly appreciate your team\'s dedication to delivering the project on time while maintaining high-quality standards'),(5,'SoftMatrix Solutions','Your meticulous attention to detail has ensured a flawless implementation of all requirements.'),(6,'NSBM','We were impressed by the innovative solutions your team proposed, which added significant value to our business.'),(7,'CodeCrafters Inc','Good JOB!'),(8,'Tech solutions Pvt Ltd','I appreciate your support');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_items`
--

DROP TABLE IF EXISTS `invoice_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_items` (
  `item_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` decimal(38,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `amcinvoice_id` bigint NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK44xut2w5tjht6fipbtyr6qxab` (`amcinvoice_id`),
  CONSTRAINT `FK44xut2w5tjht6fipbtyr6qxab` FOREIGN KEY (`amcinvoice_id`) REFERENCES `invoices` (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_items`
--

LOCK TABLES `invoice_items` WRITE;
/*!40000 ALTER TABLE `invoice_items` DISABLE KEYS */;
INSERT INTO `invoice_items` VALUES (1,500.00,'Software Maintenance',2),(2,500.00,'Technical Support',2),(3,56000.00,'Software Maintenance',3),(4,56000.00,'Technical Support',3),(5,67000.00,'Security Patches',3),(6,34000.00,'Data Backup & Recovery',3),(7,45000.00,'System Performance Checks',3),(8,5000.00,'Others',3),(9,78000.00,'Software Maintenance',4),(10,23000.00,'Technical Support',4),(11,56000.00,'Security Patches',4),(12,34000.00,'Data Backup & Recovery',4),(13,45000.00,'System Performance Checks',4),(14,5600.00,'Others',4),(15,67000.00,'Software Maintenance',5),(16,89000.00,'Technical Support',5),(17,45000.00,'Security Patches',5),(18,34000.00,'Data Backup & Recovery',5),(19,23000.00,'System Performance Checks',5),(20,2300.00,'Others',5),(21,89000.00,'Software Maintenance',6),(22,45000.00,'Technical Support',6),(23,45000.00,'Security Patches',6),(24,20000.00,'Data Backup & Recovery',6),(25,20000.00,'System Performance Checks',6),(26,7999.00,'Others',6),(27,50000.00,'Software Maintenance',7),(28,60000.00,'Technical Support',7),(29,40000.00,'Security Patches',7),(30,40000.00,'Data Backup & Recovery',7),(31,23000.00,'System Performance Checks',7),(32,8000.00,'Others',7),(33,34000.00,'Software Maintenance',8),(34,34000.00,'Technical Support',8),(35,67000.00,'Security Patches',8),(36,23000.00,'Data Backup & Recovery',8),(37,89000.00,'System Performance Checks',8),(38,3000.00,'Others',8),(39,22000.00,'Software Maintenance',9),(40,18000.00,'Technical Support',9),(41,12000.00,'Security Patches',9),(42,9000.00,'Data Backup & Recovery',9),(43,34000.00,'System Performance Checks',9),(44,2000.00,'Others',9),(45,34000.00,'Software Maintenance',10),(46,56000.00,'Technical Support',10),(47,20000.00,'Security Patches',10),(48,13000.00,'Data Backup & Recovery',10),(49,23000.00,'System Performance Checks',10),(50,33998.00,'Others',10),(51,23455.00,'Software Maintenance',11),(52,34000.00,'Technical Support',11),(53,12999.00,'Security Patches',11),(54,34000.00,'Data Backup & Recovery',11),(55,23000.00,'System Performance Checks',11),(56,21000.00,'Others',11),(57,23455.00,'Software Maintenance',12),(58,34000.00,'Technical Support',12),(59,12999.00,'Security Patches',12),(60,34000.00,'Data Backup & Recovery',12),(61,23000.00,'System Performance Checks',12),(62,21000.00,'Others',12),(63,23455.00,'Software Maintenance',13),(64,34000.00,'Technical Support',13),(65,12999.00,'Security Patches',13),(66,34000.00,'Data Backup & Recovery',13),(67,23000.00,'System Performance Checks',13),(68,21000.00,'Others',13),(69,23455.00,'Software Maintenance',14),(70,34000.00,'Technical Support',14),(71,12999.00,'Security Patches',14),(72,34000.00,'Data Backup & Recovery',14),(73,23000.00,'System Performance Checks',14),(74,21000.00,'Others',14),(75,23455.00,'Software Maintenance',15),(76,34000.00,'Technical Support',15),(77,12999.00,'Security Patches',15),(78,34000.00,'Data Backup & Recovery',15),(79,23000.00,'System Performance Checks',15),(80,21000.00,'Others',15),(81,34000.00,'Software Maintenance',16),(82,34000.00,'Technical Support',16),(83,67000.00,'Security Patches',16),(84,23000.00,'Data Backup & Recovery',16),(85,89000.00,'System Performance Checks',16),(86,3000.00,'Others',16),(87,34000.00,'Software Maintenance',17),(88,34000.00,'Technical Support',17),(89,67000.00,'Security Patches',17),(90,23000.00,'Data Backup & Recovery',17),(91,89000.00,'System Performance Checks',17),(92,3000.00,'Others',17),(93,11000.00,'Software Maintenance',18),(94,23000.00,'Technical Support',18),(95,9000.00,'Security Patches',18),(96,10000.00,'Data Backup & Recovery',18),(97,34000.00,'System Performance Checks',18),(98,7000.00,'Others',18),(99,34500.00,'Software Maintenance',19),(100,20000.00,'Technical Support',19),(101,12000.00,'Security Patches',19),(102,11000.00,'Data Backup & Recovery',19),(103,17000.00,'System Performance Checks',19),(104,9000.00,'Others',19),(105,NULL,'Software Maintenance',20),(106,NULL,'Technical Support',20),(107,NULL,'Security Patches',20),(108,NULL,'Data Backup & Recovery',20),(109,NULL,'System Performance Checks',20),(110,NULL,'Others',20),(111,23000.00,'Software Maintenance',21),(112,89000.00,'Technical Support',21),(113,78000.00,'Security Patches',21),(114,67000.00,'Data Backup & Recovery',21),(115,56000.00,'System Performance Checks',21),(116,7000.00,'Others',21),(117,45666.00,'Software Maintenance',22),(118,33333.00,'Technical Support',22),(119,3333.00,'Security Patches',22),(120,55555.00,'Data Backup & Recovery',22),(121,4444.00,'System Performance Checks',22),(122,56666.00,'Others',22);
/*!40000 ALTER TABLE `invoice_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoices` (
  `invoice_id` bigint NOT NULL AUTO_INCREMENT,
  `grand_total` decimal(38,2) DEFAULT NULL,
  `notes` text,
  `subtotal` decimal(38,2) DEFAULT NULL,
  `tax` decimal(38,2) DEFAULT NULL,
  `terms_conditions` text,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoices`
--

LOCK TABLES `invoices` WRITE;
/*!40000 ALTER TABLE `invoices` DISABLE KEYS */;
INSERT INTO `invoices` VALUES (2,2000.00,'This is a test invoice.',1000.00,100.00,'Payment due in 30 days.'),(3,17807730.00,'Notes',263000.00,6671.00,NULL),(4,13959648.00,'Notes',241600.00,5678.00,NULL),(5,17700400.00,'Notes',260300.00,6700.00,NULL),(6,2496989.00,'Notes',226999.00,1000.00,NULL),(7,13481000.00,'payments',221000.00,6000.00,'terms'),(8,3995000.00,'Notes',250000.00,1498.00,'T&C'),(9,3004090.00,'',97000.00,2997.00,''),(10,3779958.00,'',179998.00,2000.00,''),(11,6086614.00,'',148454.00,4000.00,''),(12,6086614.00,'',148454.00,4000.00,''),(13,6086614.00,'',148454.00,4000.00,''),(14,6086614.00,'',148454.00,4000.00,''),(15,6086614.00,'',148454.00,4000.00,''),(16,3995000.00,'Notes',250000.00,1498.00,'T&C'),(17,3995000.00,'Notes',250000.00,1498.00,'T&C'),(18,2820000.00,'',94000.00,2900.00,''),(19,9418500.00,'',103500.00,9000.00,''),(20,0.00,'',0.00,0.00,''),(21,6713600.00,'',320000.00,1998.00,''),(22,8158877.00,'',198997.00,4000.00,'');
/*!40000 ALTER TABLE `invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total_amc_data`
--

DROP TABLE IF EXISTS `total_amc_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `total_amc_data` (
  `amcid` bigint NOT NULL AUTO_INCREMENT,
  `count` int DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`amcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total_amc_data`
--

LOCK TABLES `total_amc_data` WRITE;
/*!40000 ALTER TABLE `total_amc_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `total_amc_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contacts` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Matara','0784343540','dilki@gmail.com','Dilki','dilki123','ACCOUNTANT'),(2,'Matara','0784343542','fahma@gmail.com','Fahma','fahma123','ADMIN'),(3,'Colombo','0763434222','dani@gmail.com','Dhaniya','daniya123','CLIENT'),(4,'colombo','2345678987','zaina@gmail.com','zaina','zaina1234','ACCOUNTANT'),(5,'colombo','0763434220','shahina@gmail.com','Shahina','shahina123','CLIENT'),(6,'Matara,Sri lanka','0123456789','ravini@gmail.com','Ravini','ravini123','ACCOUNTANT'),(13,'Colombo','0765454330','nadee@gmail.com','Nadeeshani','nadee1234','ACCOUNTANT'),(14,'Matara,Sri lanka','0745678665','bums@gmail.com','Bumini','bums1234','CLIENT'),(15,'Matara,Sri lanka','0745678670','saf@gmail.com','Safra','safra123','AMC COORDINATOR'),(16,'Colmbo 07','0765443222','imandi@gmail.com','Imandi','imandi1234','AMC COORDINATOR'),(17,'Matara,Sri lanka','0774534880','hansi@gmail.com','Hansi','hansi123','CLIENT'),(18,'Colombo','0776565443','shazi@gmail.com','Shazna','shazna123','CLIENT'),(19,'Matara,Sri lanka','0775432112','dhananga@gmail.com','Dhananga','dhananga123','CLIENT'),(20,'Urubokka, Matara','0784545334','amalja@gmail.com','Amalja','amalja123','CLIENT'),(21,'Matara,Sri lanka','0775656998','kashmi@gmail.com','Kashmi','kashmi123','CLIENT'),(22,'Colombo','0763434550','mariam@gmail.com','Mariam','mariam123','CLIENT'),(23,'Colombo','0775634990','dinali@gmail.com','Dinali','dinali123','CLIENT'),(24,'Matara,Sri lanka','0712323559','ramesha@gmail.com','Ramesha','ramesha123','CLIENT'),(25,'Matara','0763434220','t@gmail.com','Taniya','12345678','CLIENT');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (201);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-01 18:14:26
