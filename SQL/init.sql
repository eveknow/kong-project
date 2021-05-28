-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.25 - MySQL Community Server - GPL
-- Server OS:                    Linux
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for middle_api
CREATE DATABASE IF NOT EXISTS `middle_api` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `middle_api`;

-- Dumping structure for table middle_api.configuration
CREATE TABLE IF NOT EXISTS `configuration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cfg_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `cfg_value` text CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_vietnamese_ci;

-- Dumping data for table middle_api.configuration: ~0 rows (approximately)
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` (`id`, `cfg_key`, `cfg_value`) VALUES
	(4, 'app', 'middle-api'),
	(5, 'lazadaUrl', 'http://localhost:1006/lazada'),
	(6, 'tikiUrl', 'http://localhost:1006/tiki'),
	(7, 'shopeeUrl', 'http://localhost:1006/shopee');
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;


-- Dumping database structure for product_api
CREATE DATABASE IF NOT EXISTS `product_api` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `product_api`;

-- Dumping structure for table product_api.configuration
CREATE TABLE IF NOT EXISTS `configuration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cfg_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `cfg_value` text CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_vietnamese_ci;

-- Dumping data for table product_api.configuration: ~0 rows (approximately)
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` (`id`, `cfg_key`, `cfg_value`) VALUES
	(4, 'app', 'product_api'),
	(5, 'middleUrl', 'http://localhost:8020/');
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;


-- Dumping database structure for tracking_service
CREATE DATABASE IF NOT EXISTS `tracking_service` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tracking_service`;

-- Dumping structure for table tracking_service.configuration
CREATE TABLE IF NOT EXISTS `configuration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cfg_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `cfg_value` text CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_vietnamese_ci;

-- Dumping data for table tracking_service.configuration: ~0 rows (approximately)
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;

-- Dumping structure for table tracking_service.product_event
CREATE TABLE IF NOT EXISTS `product_event` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `product_id` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13635708 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_vietnamese_ci;

-- Dumping data for table tracking_service.product_event: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_event` DISABLE KEYS */;
INSERT INTO `product_event` (`id`, `user_name`, `product_id`) VALUES
	(13635701, 'thanhtk', '13635700'),
	(13635702, 'thanhtk', '13635700'),
	(13635703, 'thanhtk', '13635700'),
	(13635704, 'thanhtk', '13635700'),
	(13635705, 'thanhtk', '13635700'),
	(13635706, 'thanhtk', '13635700'),
	(13635707, 'thanhtk', '13635700');
/*!40000 ALTER TABLE `product_event` ENABLE KEYS */;


-- Dumping database structure for user_api
CREATE DATABASE IF NOT EXISTS `user_api` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_vietnamese_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `user_api`;

-- Dumping structure for table user_api.account
CREATE TABLE IF NOT EXISTS `account` (
  `id` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_vietnamese_ci;

-- Dumping data for table user_api.account: ~1 rows (approximately)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`id`, `name`, `password`) VALUES
	('c1ee4c87-62c6-4b43-a1b3-dd7d63456d6a', 'Tkt123', 'Aaa@123');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table user_api.account_oauth
CREATE TABLE IF NOT EXISTS `account_oauth` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `consumer_id` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `client_id` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `client_secret` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__account` (`account_id`),
  CONSTRAINT `FK__account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_vietnamese_ci;

-- Dumping data for table user_api.account_oauth: ~1 rows (approximately)
/*!40000 ALTER TABLE `account_oauth` DISABLE KEYS */;
INSERT INTO `account_oauth` (`id`, `account_id`, `consumer_id`, `client_id`, `client_secret`) VALUES
	(1, 'c1ee4c87-62c6-4b43-a1b3-dd7d63456d6a', 'd9b0b15c-d09f-41d6-b7a0-883f09d8d6a5', 'qgj858e5t4cdcPudFJM7BVN5SgnL31up', 'HNlJxmiwximFLJ8NhuXXOnuvw64G0DvU');
/*!40000 ALTER TABLE `account_oauth` ENABLE KEYS */;

-- Dumping structure for table user_api.configuration
CREATE TABLE IF NOT EXISTS `configuration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cfg_key` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `cfg_value` text COLLATE utf8_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_vietnamese_ci;

-- Dumping data for table user_api.configuration: ~3 rows (approximately)
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` (`id`, `cfg_key`, `cfg_value`) VALUES
	(1, 'app', 'user_api'),
	(2, 'kongAdminUrl', 'http://localhost:8001'),
	(3, 'kongProxyUrl', 'https://localhost:8443');
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
