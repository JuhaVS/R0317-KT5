-- --------------------------------------------------------
-- Verkkotietokone:              sql7.freemysqlhosting.net
-- Palvelinversio:               5.5.58-0ubuntu0.14.04.1 - (Ubuntu)
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Versio:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sql7313303
CREATE DATABASE IF NOT EXISTS `sql7313303` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sql7313303`;

-- Dumping structure for taulu sql7313303.Kirjat
CREATE TABLE IF NOT EXISTS `Kirjat` (
  `ID` int(4) DEFAULT NULL,
  `Teos` varchar(50) DEFAULT NULL,
  `Tekijä` varchar(50) DEFAULT NULL,
  `vuosi` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sql7313303.Kirjat: ~5 rows (suunnilleen)
/*!40000 ALTER TABLE `Kirjat` DISABLE KEYS */;
INSERT INTO `Kirjat` (`ID`, `Teos`, `Tekijä`, `vuosi`) VALUES
	(1, 'javaa', 'matti', 1234),
	(2, 'lisää javaa', 'kalle', 1236),
	(3, 'hoi maailma', 'Juha Suvanto', 1777),
	(4, 'tadaaa', 'Simo', 1888),
	(5, 'hei', 'seppo', 1889);
/*!40000 ALTER TABLE `Kirjat` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
