SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Cross_Court_Tennis`
--
CREATE DATABASE IF NOT EXISTS `Cross_Court_Tennis` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `Cross_Court_Tennis`;

-- --------------------------------------------------------

--
-- Table structure for table `Players`
--

CREATE TABLE IF NOT EXISTS `Players` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `bio` varchar(350),
  `favorite_shot` varchar(30),
  `points` int(15) NOT NULL,
  `wins` int(5) NOT NULL,
  `losses` int(5) NOT NULL,
  `declines` int(1) DEFAULT 2, --How many matches one can decline before something happens
  `declined_reports` DEFAULT 2, --How many score reports someone can get declined before something happens
  `zip_code` int(11) NOT NULL, --Will use this to find courts nearby.
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Matches`
--

CREATE TABLE IF NOT EXISTS `matches` (
  `player_one` int(11) NOT NULL AUTO_INCREMENT,
  `player_two` varchar(60) NOT NULL,
  `product_img_name` varchar(60) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `typeOf` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;