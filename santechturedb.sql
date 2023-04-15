-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.14 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             6.0.0.4014
-- Date/time:                    2023-04-15 21:54:27
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for santechturedb
CREATE DATABASE IF NOT EXISTS `santechturedb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `santechturedb`;


-- Dumping structure for table santechturedb.department
CREATE TABLE IF NOT EXISTS `department` (
  `id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table santechturedb.department: ~3 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `name`) VALUES
	(1, 'CS'),
	(2, 'IS'),
	(3, 'IT');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


-- Dumping structure for table santechturedb.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` int(10) NOT NULL,
  `dept_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_employee_department` (`dept_id`),
  CONSTRAINT `FK_employee_department` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table santechturedb.employee: ~0 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `name`, `gender`, `dept_id`) VALUES
	(1, 'ahmed', 1, 1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
