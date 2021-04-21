-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: shoes
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Adidas','/image/brand/adidas.png'),(2,'Air Jordan','/image/brand/air_jordan.png'),(3,'Asics','/image/brand/asics.png'),(4,'Converse','/image/brand/converse.png'),(5,'Nike','/image/brand/nike.png'),(6,'Vans','/image/brand/vans.png');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Nam'),(2,'Nữ'),(3,'Trẻ em');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` text,
  `discount` int DEFAULT '0',
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `total_sold` int DEFAULT '0',
  `brand_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'',10,'\\image\\product\\adidas\\Adidas-Human-Race-NMD-Pharrell-x-Chanel-Black.jpeg','Adidas NMD Hu Pharrell Solar Pack Mother',1000000,0,1),(2,'',0,'\\image\\product\\adidas\\adidas-NMD-Hu-Pharrell-Mother-Product.jpg','Adidas Ultra Boost 4.0 Game of Thrones White Walkers',2000000,0,1),(3,NULL,0,'\\image\\product\\adidas\\Adidas-NMD-R1-Japan-Triple-White-Product.jpg','Adidas Yeezy Boost 350 V2 Lundmark (Non Reflective)',1350000,0,1),(4,NULL,20,'\\image\\product\\adidas\\adidas-Ultra-Boost-4-Game-of-Thrones-White-Walkers-1.jpg','Adidas Yeezy 500 Bone White',960000,0,1),(5,NULL,0,'\\image\\product\\adidas\\Adidas-Yeezy-Boost-350-V2-Core-Black-Red-Product.jpg','Adidas Yeezy Boost 700 Wave Runner Solid Grey',900000,0,1),(6,NULL,0,'\\image\\product\\converse\\Converse-Chuck-Taylor-All-Star-70s-Hi-Kith-Coca-Cola-Denim-2019.jpeg','Converse Chuck Taylor All-Star 70s Hi Comme des Garcons PLAY White',700000,0,4),(7,NULL,0,'\\image\\product\\converse\\Converse-Chuck-Taylor-All-Star-70s-Hi-Off-White-Product.jpg','Converse Chuck Taylor All-Star 70s Hi Kith Coca-Cola Denim (2019)',1200000,0,4),(8,NULL,0,'\\image\\product\\converse\\Converse-Chuck-Taylor-All-Star-70s-Hi-Undercover-New-Warriors-White-Product.jpg','Converse Chuck Taylor All-Star 70s Hi Off-White',2500000,0,4),(9,NULL,0,'\\image\\product\\converse\\Converse-Run-Star-Hike-Hi-JW-Anderson-Black-Product.jpg','Converse Chuck Taylor All-Star 70s Hi Undercover New Warriors White',6500000,0,4),(10,NULL,30,'\\image\\product\\converse\\Converse-Chuck-Taylor-All-Star-70s-Hi-Comme-des-Garcons-PLAY-White-Product.jpg','Converse Chuck Taylor All-Star 70s Hi Undercover New Warriors White',9500000,0,4),(11,NULL,0,'\\image\\product\\converse\\Converse-Chuck-Taylor-All-Star-Hi-Off-White-Product.jpg','Converse Chuck Taylor All-Star 70s Hi Undercover New Warriors White',2100000,0,4),(12,NULL,0,'\\image\\product\\air-jordan\\Air-Jordan-1-Low-SB-UNC-v2.jpg','Air Jordan 1 Retro High Satin Black Toe',8900000,0,2),(13,NULL,0,'\\image\\product\\air-jordan\\Air-Jordan-1-Retro-High-Travis-Scott-Product.jpg','Nike Air Jordan 1 Retro High Twist Panda',1200000,0,2),(14,NULL,0,'\\image\\product\\air-jordan\\Air-Jordan-4-Retro-Cool-Grey-2019-Product.jpg','Air Jordan 1 Retro High Tokyo Bio Hack',1190000,0,2),(15,NULL,0,'\\image\\product\\air-jordan\\Air-Jordan-11-Retro-Low-Snake-Navy-2019-Product.jpg','Air Jordan 1 Low White Camo',120000,0,2),(16,NULL,0,'\\image\\product\\air-jordan\\Air-Jordan-12-Retro-Fiba-2019.jpeg','Air Jordan 1 Low White Camo',1200000,0,2),(17,NULL,0,'\\image\\product\\vans\\Vans-Era-Patchwork.jpeg','Vans Authentic 44 DX Anaheim Factory Hoffman Fabrics',1950000,0,6),(18,NULL,0,'\\image\\product\\vans\\Vans-OG-Sk8-Hi-Odd-Future-Donut-Product.jpg','Vans Old Skool David Bowie Aladdin Sane',890000,0,6),(19,NULL,0,'\\image\\product\\vans\\Vans-Old-Skool-Colorblock-Multi-Product.jpg','Vans Old Skool David Bowie Aladdin Sane',1000000,0,6),(20,NULL,0,'\\image\\product\\vans\\Vans-Old-Skool-David-Bowie-Aladdin-Sane-Product.jpg','Vans Old Skool David Bowie Aladdin Sane',110000,0,6),(21,NULL,0,'\\image\\product\\nike\\Nike-Adapt-BB-Mag-Product.jpg','Nike Air Zoom Structure 23',200000,0,5),(22,NULL,0,'\\image\\product\\nike\\Nike-Kyrie-5-Spongebob-Product.jpg','Nike Air Zoom Pegasus',250000,0,5),(23,NULL,0,'\\image\\product\\nike\\Nike-Air-Max-1-Tinker-Sketch.jpg','Nike Air Max Excee ',300000,0,5),(24,NULL,0,'\\image\\product\\nike\\Nike-Air-Max-90-Off-White-Product.jpg','Nike Downshifter',210000,0,5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `product_id` int NOT NULL,
  `category_id` int NOT NULL,
  KEY `FKkud35ls1d40wpjb5htpp14q4e` (`category_id`),
  KEY `FK2k3smhbruedlcrvu6clued06x` (`product_id`),
  CONSTRAINT `FK2k3smhbruedlcrvu6clued06x` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKkud35ls1d40wpjb5htpp14q4e` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,1),(1,2),(2,1);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-21 11:08:52
