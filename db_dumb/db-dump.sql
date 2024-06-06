-- MySQL dump 10.13  Distrib 8.4.0, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: hotel_booking_system
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `amenities`
--

DROP TABLE IF EXISTS `amenities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenities`
--

LOCK TABLES `amenities` WRITE;
/*!40000 ALTER TABLE `amenities` DISABLE KEYS */;
INSERT INTO `amenities` (`id`, `created_at`, `updated_at`, `description`, `title`) VALUES (1,'2024-06-05 16:04:43.000000','2024-06-05 16:04:43.000000','Free Wi-Fi available in all areas.','Free Wi-Fi'),(2,'2024-06-05 16:04:43.000000','2024-06-05 16:04:43.000000','Complimentary breakfast included.','Breakfast'),(3,'2024-06-05 16:04:43.000000','2024-06-05 16:04:43.000000','24-hour front desk service.','24-hour front desk'),(4,'2024-06-05 16:04:43.000000','2024-06-05 16:04:43.000000','Room service available.','Room Service'),(5,'2024-06-05 16:04:43.000000','2024-06-05 16:04:43.000000','Fitness center available.','Fitness Center'),(6,'2024-06-05 16:04:43.000000','2024-06-05 16:04:43.000000','Swimming pool access included.','Swimming Pool');
/*!40000 ALTER TABLE `amenities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_room_mapping`
--

DROP TABLE IF EXISTS `booking_room_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_room_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `number_of_rooms` int DEFAULT NULL,
  `booking_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcvxhjd5orft7ui7w04y1js0rf` (`booking_id`),
  KEY `FKthmreb7ggh9a2d9lddr4stvuw` (`room_id`),
  CONSTRAINT `FKcvxhjd5orft7ui7w04y1js0rf` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`id`),
  CONSTRAINT `FKthmreb7ggh9a2d9lddr4stvuw` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_room_mapping`
--

LOCK TABLES `booking_room_mapping` WRITE;
/*!40000 ALTER TABLE `booking_room_mapping` DISABLE KEYS */;
INSERT INTO `booking_room_mapping` (`id`, `created_at`, `updated_at`, `number_of_rooms`, `booking_id`, `room_id`) VALUES (1,'2024-06-05 12:46:52.390273',NULL,1,1,1),(2,'2024-06-05 12:51:26.462155',NULL,1,2,1),(3,'2024-06-05 13:10:00.563661',NULL,1,3,1),(4,'2024-06-05 13:25:58.593390',NULL,1,4,1),(5,'2024-06-05 13:28:10.175179',NULL,1,5,1),(6,'2024-06-05 14:05:12.739943',NULL,1,6,1),(7,'2024-06-05 14:05:19.767158',NULL,6,7,1),(8,'2024-06-05 14:22:15.155957',NULL,3,8,2),(9,'2024-06-05 14:22:44.846685',NULL,3,9,2),(10,'2024-06-05 14:23:02.042726',NULL,3,10,2);
/*!40000 ALTER TABLE `booking_room_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `booking_amount` double DEFAULT NULL,
  `booking_check_in_date` datetime(6) DEFAULT NULL,
  `booking_check_out_date` datetime(6) DEFAULT NULL,
  `booking_status` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `payment_id` bigint DEFAULT NULL,
  `total_guest` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `hotel_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7y09f5lun38jnooaw2hch0ke9` (`hotel_id`),
  KEY `bookings__index_checks_date` (`booking_check_in_date`,`booking_check_out_date`),
  CONSTRAINT `FK7y09f5lun38jnooaw2hch0ke9` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` (`id`, `created_at`, `updated_at`, `booking_amount`, `booking_check_in_date`, `booking_check_out_date`, `booking_status`, `order_id`, `payment_id`, `total_guest`, `user_id`, `hotel_id`) VALUES (1,'2024-06-05 12:46:52.382775',NULL,7000,'2024-06-05 00:00:00.000000','2024-06-10 00:00:00.000000','CONFIRMED','OR-11717591612367',1,2,1,1),(2,'2024-06-05 12:51:26.457169',NULL,7000,'2024-06-05 00:00:00.000000','2024-06-10 00:00:00.000000','CONFIRMED','OR-21717591886444',2,2,1,1),(3,'2024-06-05 13:10:00.556831',NULL,7000,'2024-06-05 00:00:00.000000','2024-06-10 00:00:00.000000','CONFIRMED','OR-31717593000540',3,2,1,1),(4,'2024-06-05 13:25:58.580605',NULL,7000,'2024-06-05 00:00:00.000000','2024-06-10 00:00:00.000000','CONFIRMED','OR-41717593958562',4,2,1,1),(5,'2024-06-05 13:28:10.168152',NULL,7000,'2024-06-06 00:00:00.000000','2024-06-10 00:00:00.000000','CONFIRMED','OR-51717594090154',5,2,1,1),(6,'2024-06-05 14:05:12.733537',NULL,7000,'2024-06-06 00:00:00.000000','2024-06-10 00:00:00.000000','CONFIRMED','OR-61717596312721',6,2,1,1),(7,'2024-06-05 14:05:19.765490',NULL,42000,'2024-06-06 00:00:00.000000','2024-06-10 00:00:00.000000','CONFIRMED','OR-71717596319763',7,2,1,1),(8,'2024-06-05 14:22:15.150359',NULL,15000,'2024-06-08 00:00:00.000000','2024-06-15 00:00:00.000000','CONFIRMED','OR-81717597335126',8,2,1,1),(9,'2024-06-05 14:22:44.843724',NULL,15000,'2024-06-06 00:00:00.000000','2024-06-08 00:00:00.000000','CONFIRMED','OR-91717597364837',9,2,1,1),(10,'2024-06-05 14:23:02.039604',NULL,15000,'2024-06-06 00:00:00.000000','2024-06-07 00:00:00.000000','CONFIRMED','OR-101717597382034',10,2,1,1);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_room_amenities_mapping`
--

DROP TABLE IF EXISTS `hotel_room_amenities_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_room_amenities_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `amenity_id` bigint DEFAULT NULL,
  `hotel_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8m9yip59gqfcnfaujhqq3p0gh` (`amenity_id`),
  KEY `FKcj84oyi7c8kxhjnwmi0x2dmwv` (`hotel_id`),
  KEY `FKjghlfiii90wfq2nocxmyqcxyu` (`room_id`),
  CONSTRAINT `FK8m9yip59gqfcnfaujhqq3p0gh` FOREIGN KEY (`amenity_id`) REFERENCES `amenities` (`id`),
  CONSTRAINT `FKcj84oyi7c8kxhjnwmi0x2dmwv` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`),
  CONSTRAINT `FKjghlfiii90wfq2nocxmyqcxyu` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_room_amenities_mapping`
--

LOCK TABLES `hotel_room_amenities_mapping` WRITE;
/*!40000 ALTER TABLE `hotel_room_amenities_mapping` DISABLE KEYS */;
INSERT INTO `hotel_room_amenities_mapping` (`id`, `created_at`, `updated_at`, `amenity_id`, `hotel_id`, `room_id`) VALUES (1,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,1,NULL),(2,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,1,NULL),(3,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',3,1,NULL),(4,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,1),(5,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,1),(6,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,1),(7,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,2),(8,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,2),(9,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,2),(10,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,2,NULL),(11,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,2,NULL),(12,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',5,2,NULL),(13,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,4),(14,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,4),(15,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,4),(16,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,5),(17,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,5),(18,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,5),(19,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,3,NULL),(20,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,3,NULL),(21,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',6,3,NULL),(22,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,7),(23,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,7),(24,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,7),(25,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,8),(26,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,8),(27,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,8),(28,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,4,NULL),(29,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,4,NULL),(30,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',3,4,NULL),(31,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,10),(32,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,10),(33,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,10),(34,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,11),(35,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,11),(36,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,11),(37,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,5,NULL),(38,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,5,NULL),(39,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',5,5,NULL),(40,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,13),(41,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,13),(42,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,13),(43,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,14),(44,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,14),(45,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,14),(46,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,6,NULL),(47,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,6,NULL),(48,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',6,6,NULL),(49,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,16),(50,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,16),(51,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,16),(52,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,17),(53,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,17),(54,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,17),(55,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,7,NULL),(56,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,7,NULL),(57,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',5,7,NULL),(58,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,19),(59,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,19),(60,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,19),(61,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,20),(62,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,20),(63,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,20),(64,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,8,NULL),(65,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,8,NULL),(66,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',3,8,NULL),(67,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,22),(68,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,22),(69,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,22),(70,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,23),(71,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,23),(72,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,23),(73,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,9,NULL),(74,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,9,NULL),(75,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',6,9,NULL),(76,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,25),(77,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,25),(78,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,25),(79,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,26),(80,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,26),(81,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,26),(82,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,27),(83,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,27),(84,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,27),(85,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,10,NULL),(86,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,10,NULL),(87,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',5,10,NULL),(88,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,28),(89,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,28),(90,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,28),(91,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,29),(92,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,29),(93,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,29),(94,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',1,NULL,30),(95,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',2,NULL,30),(96,'2024-06-05 16:16:07.000000','2024-06-05 16:16:07.000000',4,NULL,30);
/*!40000 ALTER TABLE `hotel_room_amenities_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotels` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `lan` double DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hotels_lat_lan_index` (`lat`,`lan`),
  KEY `hotels_location_index` (`location`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotels`
--

LOCK TABLES `hotels` WRITE;
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` (`id`, `created_at`, `updated_at`, `address`, `lan`, `lat`, `location`, `name`, `rating`) VALUES (1,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','123 MG Road, Bengaluru, Karnataka',77.5946,12.9716,'Bengaluru','Hotel Bengaluru Palace',4.5),(2,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','456 Marine Drive, Mumbai, Maharashtra',72.8258,18.944,'Mumbai','Marine Drive Hotel',4.7),(3,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','789 Park Street, Kolkata, West Bengal',88.3639,22.5726,'Kolkata','Park Street Hotel',4.2),(4,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','101 Anna Salai, Chennai, Tamil Nadu',80.2707,13.0827,'Chennai','Anna Salai Hotel',4.3),(5,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','202 Connaught Place, New Delhi, Delhi',77.209,28.6139,'New Delhi','Connaught Place Hotel',4.6),(6,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','303 MG Road, Pune, Maharashtra',73.8567,18.5204,'Pune','Pune Central Hotel',4.4),(7,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','404 Sector 29, Gurgaon, Haryana',77.0266,28.4595,'Gurgaon','Gurgaon Business Hotel',4.8),(8,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','505 MI Road, Jaipur, Rajasthan',75.7873,26.9124,'Jaipur','Jaipur Heritage Hotel',4.5),(9,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','606 Banjara Hills, Hyderabad, Telangana',78.4867,17.385,'Hyderabad','Banjara Hills Hotel',4.7),(10,'2024-06-05 16:03:30.000000','2024-06-05 16:03:30.000000','707 Koregaon Park, Pune, Maharashtra',73.905,18.5362,'Pune','Koregaon Park Hotel',4.9);
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `image_type` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `hotel_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlxlm2toc73mw5x7bxah8yi4bm` (`hotel_id`),
  KEY `FKdeh4h59nedlwji0j8e57hu9mf` (`room_id`),
  CONSTRAINT `FKdeh4h59nedlwji0j8e57hu9mf` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  CONSTRAINT `FKlxlm2toc73mw5x7bxah8yi4bm` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` (`id`, `created_at`, `updated_at`, `image_type`, `image_url`, `hotel_id`, `room_id`) VALUES (1,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/bengaluru_palace_hotel1.jpg',1,NULL),(2,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/bengaluru_palace_hotel2.jpg',1,NULL),(3,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/bengaluru_palace_hotel3.jpg',1,NULL),(4,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/bengaluru_palace_room1.jpg',1,1),(5,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/bengaluru_palace_bathroom1.jpg',1,1),(6,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/bengaluru_palace_view1.jpg',1,1),(7,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/bengaluru_palace_room2.jpg',1,2),(8,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/bengaluru_palace_bathroom2.jpg',1,2),(9,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/bengaluru_palace_view2.jpg',1,2),(10,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/marine_drive_hotel1.jpg',2,NULL),(11,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/marine_drive_hotel2.jpg',2,NULL),(12,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/marine_drive_hotel3.jpg',2,NULL),(13,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/marine_drive_room1.jpg',2,4),(14,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/marine_drive_bathroom1.jpg',2,4),(15,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/marine_drive_view1.jpg',2,4),(16,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/marine_drive_room2.jpg',2,5),(17,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/marine_drive_bathroom2.jpg',2,5),(18,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/marine_drive_view2.jpg',2,5),(19,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/park_street_hotel1.jpg',3,NULL),(20,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/park_street_hotel2.jpg',3,NULL),(21,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/park_street_hotel3.jpg',3,NULL),(22,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/park_street_room1.jpg',3,7),(23,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/park_street_bathroom1.jpg',3,7),(24,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/park_street_view1.jpg',3,7),(25,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/park_street_room2.jpg',3,8),(26,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/park_street_bathroom2.jpg',3,8),(27,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/park_street_view2.jpg',3,8),(28,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/anna_salai_hotel1.jpg',4,NULL),(29,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/anna_salai_hotel2.jpg',4,NULL),(30,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Hotel','https://example.com/anna_salai_hotel3.jpg',4,NULL),(31,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/anna_salai_room1.jpg',4,10),(32,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/anna_salai_bathroom1.jpg',4,10),(33,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/anna_salai_view1.jpg',4,10),(34,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Room','https://example.com/anna_salai_room2.jpg',4,11),(35,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','Bathroom','https://example.com/anna_salai_bathroom2.jpg',4,11),(36,'2024-06-05 16:06:05.000000','2024-06-05 16:06:05.000000','View','https://example.com/anna_salai_view2.jpg',4,11),(37,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','Hotel','https://example.com/connaught_place_hotel1.jpg',5,NULL),(38,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','Hotel','https://example.com/connaught_place_hotel2.jpg',5,NULL),(39,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','Hotel','https://example.com/connaught_place_hotel3.jpg',5,NULL),(40,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','Room','https://example.com/connaught_place_room1.jpg',5,13),(41,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','Bathroom','https://example.com/connaught_place_bathroom1.jpg',5,13),(42,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','View','https://example.com/connaught_place_view1.jpg',5,13),(43,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','Room','https://example.com/connaught_place_room2.jpg',5,14),(44,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','Bathroom','https://example.com/connaught_place_bathroom2.jpg',5,14),(45,'2024-06-05 16:07:07.000000','2024-06-05 16:07:07.000000','View','https://example.com/connaught_place_view2.jpg',5,14),(46,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','Hotel','https://example.com/pune_central_hotel1.jpg',6,NULL),(47,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','Hotel','https://example.com/pune_central_hotel2.jpg',6,NULL),(48,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','Hotel','https://example.com/pune_central_hotel3.jpg',6,NULL),(49,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','Room','https://example.com/pune_central_room1.jpg',6,16),(50,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','Bathroom','https://example.com/pune_central_bathroom1.jpg',6,16),(51,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','View','https://example.com/pune_central_view1.jpg',6,16),(52,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','Room','https://example.com/pune_central_room2.jpg',6,17),(53,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','Bathroom','https://example.com/pune_central_bathroom2.jpg',6,17),(54,'2024-06-05 16:07:11.000000','2024-06-05 16:07:11.000000','View','https://example.com/pune_central_view2.jpg',6,17),(55,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Hotel','https://example.com/pune_central_hotel1.jpg',6,NULL),(56,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Hotel','https://example.com/pune_central_hotel2.jpg',6,NULL),(57,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Hotel','https://example.com/pune_central_hotel3.jpg',6,NULL),(58,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Room','https://example.com/pune_central_room1.jpg',6,16),(59,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Bathroom','https://example.com/pune_central_bathroom1.jpg',6,16),(60,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','View','https://example.com/pune_central_view1.jpg',6,16),(61,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Room','https://example.com/pune_central_room2.jpg',6,17),(62,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Bathroom','https://example.com/pune_central_bathroom2.jpg',6,17),(63,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','View','https://example.com/pune_central_view2.jpg',6,17),(64,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Hotel','https://example.com/gurgaon_business_hotel1.jpg',7,NULL),(65,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Hotel','https://example.com/gurgaon_business_hotel2.jpg',7,NULL),(66,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Hotel','https://example.com/gurgaon_business_hotel3.jpg',7,NULL),(67,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Room','https://example.com/gurgaon_business_room1.jpg',7,19),(68,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Bathroom','https://example.com/gurgaon_business_bathroom1.jpg',7,19),(69,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','View','https://example.com/gurgaon_business_view1.jpg',7,19),(70,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Room','https://example.com/gurgaon_business_room2.jpg',7,20),(71,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','Bathroom','https://example.com/gurgaon_business_bathroom2.jpg',7,20),(72,'2024-06-05 16:07:15.000000','2024-06-05 16:07:15.000000','View','https://example.com/gurgaon_business_view2.jpg',7,20),(73,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','Hotel','https://example.com/jaipur_heritage_hotel1.jpg',8,NULL),(74,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','Hotel','https://example.com/jaipur_heritage_hotel2.jpg',8,NULL),(75,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','Hotel','https://example.com/jaipur_heritage_hotel3.jpg',8,NULL),(76,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','Room','https://example.com/jaipur_heritage_room1.jpg',8,22),(77,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','Bathroom','https://example.com/jaipur_heritage_bathroom1.jpg',8,22),(78,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','View','https://example.com/jaipur_heritage_view1.jpg',8,22),(79,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','Room','https://example.com/jaipur_heritage_room2.jpg',8,23),(80,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','Bathroom','https://example.com/jaipur_heritage_bathroom2.jpg',8,23),(81,'2024-06-05 16:07:20.000000','2024-06-05 16:07:20.000000','View','https://example.com/jaipur_heritage_view2.jpg',8,23),(82,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Hotel','https://example.com/banjara_hills_hotel1.jpg',9,NULL),(83,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Hotel','https://example.com/banjara_hills_hotel2.jpg',9,NULL),(84,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Hotel','https://example.com/banjara_hills_hotel3.jpg',9,NULL),(85,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Room','https://example.com/banjara_hills_room1.jpg',9,25),(86,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Bathroom','https://example.com/banjara_hills_bathroom1.jpg',9,25),(87,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','View','https://example.com/banjara_hills_view1.jpg',9,25),(88,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Room','https://example.com/banjara_hills_room2.jpg',9,26),(89,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Bathroom','https://example.com/banjara_hills_bathroom2.jpg',9,26),(90,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','View','https://example.com/banjara_hills_view2.jpg',9,26),(91,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Room','https://example.com/banjara_hills_room3.jpg',9,27),(92,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Bathroom','https://example.com/banjara_hills_bathroom3.jpg',9,27),(93,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','View','https://example.com/banjara_hills_view3.jpg',9,27),(94,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Hotel','https://example.com/koregaon_park_hotel1.jpg',10,NULL),(95,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Hotel','https://example.com/koregaon_park_hotel2.jpg',10,NULL),(96,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Hotel','https://example.com/koregaon_park_hotel3.jpg',10,NULL),(97,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Room','https://example.com/koregaon_park_room1.jpg',10,28),(98,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Bathroom','https://example.com/koregaon_park_bathroom1.jpg',10,28),(99,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','View','https://example.com/koregaon_park_view1.jpg',10,28),(100,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Room','https://example.com/koregaon_park_room2.jpg',10,29),(101,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Bathroom','https://example.com/koregaon_park_bathroom2.jpg',10,29),(102,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','View','https://example.com/koregaon_park_view2.jpg',10,29),(103,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Room','https://example.com/koregaon_park_room3.jpg',10,30),(104,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','Bathroom','https://example.com/koregaon_park_bathroom3.jpg',10,30),(105,'2024-06-05 16:08:02.000000','2024-06-05 16:08:02.000000','View','https://example.com/koregaon_park_view3.jpg',10,30);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`id`, `created_at`, `updated_at`, `order_id`, `payment_amount`, `payment_mode`, `payment_status`) VALUES (1,'2024-06-05 12:46:52.308920','2024-06-05 12:46:52.370293','OR-11717591612367',7000,'CARD','PAID'),(2,'2024-06-05 12:51:26.428640','2024-06-05 12:51:26.446129','OR-21717591886444',7000,'CARD','PAID'),(3,'2024-06-05 13:10:00.513658','2024-06-05 13:10:00.542645','OR-31717593000540',7000,'CARD','PAID'),(4,'2024-06-05 13:25:58.532610','2024-06-05 13:25:58.565511','OR-41717593958562',7000,'CARD','PAID'),(5,'2024-06-05 13:28:10.138452','2024-06-05 13:28:10.155631','OR-51717594090154',7000,'CARD','PAID'),(6,'2024-06-05 14:05:12.706631','2024-06-05 14:05:12.722993','OR-61717596312721',7000,'CARD','PAID'),(7,'2024-06-05 14:05:19.761833','2024-06-05 14:05:19.763896','OR-71717596319763',42000,'CARD','PAID'),(8,'2024-06-05 14:22:15.097362','2024-06-05 14:22:15.130509','OR-81717597335126',15000,'CARD','PAID'),(9,'2024-06-05 14:22:44.823287','2024-06-05 14:22:44.838275','OR-91717597364837',15000,'CARD','PAID'),(10,'2024-06-05 14:23:02.025201','2024-06-05 14:23:02.036591','OR-101717597382034',15000,'CARD','PAID');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `bed_type` varchar(255) DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `price_per_night` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `total_rooms` int DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `hotel_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp5lufxy0ghq53ugm93hdc941k` (`hotel_id`),
  CONSTRAINT `FKp5lufxy0ghq53ugm93hdc941k` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` (`id`, `created_at`, `updated_at`, `bed_type`, `capacity`, `price_per_night`, `title`, `total_rooms`, `type`, `hotel_id`) VALUES (1,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,7000,'Deluxe King Room',10,'Deluxe',1),(2,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,5000,'Standard Queen Room',15,'Standard',1),(3,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,9000,'Family Double Room',5,'Family',1),(4,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,8000,'Executive King Room',8,'Executive',2),(5,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,6000,'Superior Queen Room',12,'Superior',2),(6,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,10000,'Family Suite',4,'Suite',2),(7,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,7500,'Park View King Room',10,'Park View',3),(8,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,5500,'City Breeze Queen Room',15,'City Breeze',3),(9,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,9500,'Family Comfort Room',5,'Comfort',3),(10,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,7800,'Sea View King Room',9,'Sea View',4),(11,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,5800,'Garden View Queen Room',14,'Garden View',4),(12,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,9800,'Luxury Family Suite',4,'Luxury',4),(13,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,8500,'Palace King Room',7,'Palace',5),(14,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,6500,'Heritage Queen Room',10,'Heritage',5),(15,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,11000,'Premier Family Suite',3,'Premier',5),(16,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,7500,'Historic King Room',10,'Historic',6),(17,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,5500,'Colonial Queen Room',15,'Colonial',6),(18,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,9500,'Family Colonial Room',5,'Colonial',6),(19,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,9000,'Boulevard King Room',8,'Boulevard',7),(20,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,7000,'Cityscape Queen Room',12,'Cityscape',7),(21,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,12000,'Family Cityscape Suite',4,'Cityscape Suite',7),(22,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,7800,'Capital King Room',9,'Capital',8),(23,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,5800,'Business Queen Room',14,'Business',8),(24,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,10500,'Family Business Suite',4,'Business Suite',8),(25,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,9200,'Elite King Room',7,'Elite',9),(26,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,7200,'Elite Queen Room',10,'Elite',9),(27,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,12500,'Luxury Elite Suite',3,'Luxury Elite',9),(28,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','King',2,9400,'Royal King Room',6,'Royal',10),(29,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Queen',2,7400,'Royal Queen Room',9,'Royal',10),(30,'2024-06-05 16:04:14.000000','2024-06-05 16:04:14.000000','Double',4,13000,'Royal Family Suite',3,'Royal Suite',10);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_unique_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `created_at`, `updated_at`, `email`, `name`, `password`) VALUES (1,'2024-06-05 11:05:54.671286',NULL,'surajsararf@gmail.com','Suraj','$2a$10$KIOZnjIhQGnXy8JEZnBAyeockmKmIgfk6xqwQqojOCLPJpeiE2nj2'),(5,'2024-06-05 14:56:38.111708','2024-06-05 14:56:38.111759','surajsararf1@gmail.com','Suraj','$2a$10$M.L7m16XyvCwj5UlErvY0eGo390pfUfJ5bv4y15BQhatJjKui7qW2'),(6,'2024-06-05 14:57:48.971636','2024-06-05 14:57:48.971754','surajsararf1@gmail','Suraj','$2a$10$zuNbaHcWdDADhTQ4mL4QoeOsILErzYkDC1KHuY8NL3A4iG2UNS/US');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-06  9:43:43
