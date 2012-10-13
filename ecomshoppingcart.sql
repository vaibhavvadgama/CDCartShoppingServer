-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2012 at 07:42 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ecomshoppingcart`
--

-- --------------------------------------------------------

--
-- Table structure for table `adressmains`
--

CREATE TABLE IF NOT EXISTS `adressmains` (
  `adress_id` int(11) NOT NULL AUTO_INCREMENT,
  `adress_type` varchar(10) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `adress_streetno` varchar(10) NOT NULL,
  `adress_streetname` varchar(255) NOT NULL,
  `adress_city` varchar(255) NOT NULL,
  `adress_state` varchar(255) NOT NULL,
  `adress_zip` varchar(10) NOT NULL,
  `adress_phone` varchar(20) NOT NULL,
  `isactive` tinyint(4) NOT NULL,
  `createddate` datetime NOT NULL,
  `modifieddate` datetime NOT NULL,
  PRIMARY KEY (`adress_id`),
  UNIQUE KEY `adress_streetno` (`adress_streetno`,`adress_streetname`,`adress_city`,`adress_state`),
  UNIQUE KEY `adress_streetno_2` (`adress_streetno`,`adress_streetname`,`adress_city`,`adress_state`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `adressmains`
--

INSERT INTO `adressmains` (`adress_id`, `adress_type`, `user_id`, `adress_streetno`, `adress_streetname`, `adress_city`, `adress_state`, `adress_zip`, `adress_phone`, `isactive`, `createddate`, `modifieddate`) VALUES
(1, 'ship', 1, '4', 'albert road', 'toronto', 'on', 'k1v9t4', '263726372', 1, '2012-10-08 00:00:00', '0000-00-00 00:00:00'),
(2, 'bill', 1, '45', 'robert street', 'ottawa', 'on', 'k2c4g7', '899892332', 1, '2012-10-08 00:00:00', '0000-00-00 00:00:00'),
(12, 'ship', 1, '24', 'Mccarthy', 'toronto', 'ON', 'K1v9h8', '387483748', 1, '2012-10-09 19:24:51', '2012-10-09 19:24:51'),
(13, 'ship', 1, '97', 'Unisecto', 'montrial', 'QC', 'K167H9', '37483748', 1, '2012-10-10 00:53:49', '2012-10-10 00:53:49');

-- --------------------------------------------------------

--
-- Table structure for table `categorymains`
--

CREATE TABLE IF NOT EXISTS `categorymains` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `category_desc` varchar(500) NOT NULL,
  `isactive` tinyint(4) NOT NULL,
  `createddate` datetime NOT NULL,
  `modifieddate` datetime NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `categorymains`
--

INSERT INTO `categorymains` (`category_id`, `category_name`, `category_desc`, `isactive`, `createddate`, `modifieddate`) VALUES
(1, 'Rock', 'It is a rock category', 1, '2012-09-21 02:00:00', '2012-09-21 02:00:00'),
(2, 'Jazz', 'It is a Jazz project.', 1, '2012-10-11 00:00:00', '2012-10-25 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `cdmains`
--

CREATE TABLE IF NOT EXISTS `cdmains` (
  `cd_id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_title` varchar(256) NOT NULL,
  `cd_price` double NOT NULL DEFAULT '0',
  `category_id` int(11) NOT NULL DEFAULT '0',
  `cd_image` varchar(255) NOT NULL,
  `cd_publisheddate` datetime NOT NULL,
  `cd_taxper` float NOT NULL,
  `isactive` tinyint(4) NOT NULL,
  `createddate` datetime NOT NULL,
  `modifieddate` datetime NOT NULL,
  PRIMARY KEY (`cd_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `cdmains`
--

INSERT INTO `cdmains` (`cd_id`, `cd_title`, `cd_price`, `category_id`, `cd_image`, `cd_publisheddate`, `cd_taxper`, `isactive`, `createddate`, `modifieddate`) VALUES
(1, 'taylor swift', 5, 1, 'images\\ts,jpg', '2012-10-17 00:00:00', 8, 1, '2012-10-11 00:00:00', '2012-10-25 00:00:00'),
(2, 'dil laggi', 7, 1, 'images\\js.png', '2012-10-23 00:00:00', 12, 1, '2012-10-17 00:00:00', '2012-10-26 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `processedorderitemsmains`
--

CREATE TABLE IF NOT EXISTS `processedorderitemsmains` (
  `poitems_id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_id` int(11) NOT NULL,
  `cd_price` double NOT NULL,
  `orderid` int(11) NOT NULL,
  PRIMARY KEY (`poitems_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `processedorderitemsmains`
--

INSERT INTO `processedorderitemsmains` (`poitems_id`, `cd_id`, `cd_price`, `orderid`) VALUES
(1, 1, 2.5, 1),
(2, 2, 3.09, 1);

-- --------------------------------------------------------

--
-- Table structure for table `processedordermains`
--

CREATE TABLE IF NOT EXISTS `processedordermains` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `shipping_addressid` int(11) NOT NULL DEFAULT '0',
  `order_date` datetime NOT NULL,
  `order_status` varchar(10) NOT NULL DEFAULT 'Ordered',
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `processedordermains`
--

INSERT INTO `processedordermains` (`orderid`, `userid`, `shipping_addressid`, `order_date`, `order_status`) VALUES
(1, 1, 13, '2012-10-10 00:53:49', 'Denied');

-- --------------------------------------------------------

--
-- Table structure for table `usermains`
--

CREATE TABLE IF NOT EXISTS `usermains` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_firstname` varchar(255) NOT NULL,
  `user_lastname` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_cardtype` varchar(50) NOT NULL,
  `user_cardnumber` varchar(20) NOT NULL,
  `user_cvv` int(4) NOT NULL,
  `user_cardexpdate` varchar(10) NOT NULL,
  `isactive` tinyint(4) NOT NULL,
  `createddate` datetime NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `usermains`
--

INSERT INTO `usermains` (`user_id`, `user_firstname`, `user_lastname`, `user_email`, `user_password`, `user_cardtype`, `user_cardnumber`, `user_cvv`, `user_cardexpdate`, `isactive`, `createddate`) VALUES
(1, 'Vaibhav', 'Vadgama', 'vvadgama@connect.carleton.ca', 'v2vaibhav', '', '', 0, '', 1, '2012-10-08 00:00:00'),
(2, 'vkama', 'lingam', 'vvkam@gmail.com', 'vkama13', 'visa', '414141414141414', 1234, '12/18', 1, '2012-10-09 19:45:12');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
