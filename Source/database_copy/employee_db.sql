-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2017 at 10:57 PM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `employee_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins_tbl`
--

CREATE TABLE IF NOT EXISTS `admins_tbl` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins_tbl`
--

INSERT INTO `admins_tbl` (`id`, `username`, `password`, `creation_date`) VALUES
(1, 'admin', 'admin', '2017-08-15 20:36:42');

-- --------------------------------------------------------

--
-- Table structure for table `employers_tbl`
--

CREATE TABLE IF NOT EXISTS `employers_tbl` (
  `id` int(11) NOT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `education` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employers_tbl`
--

INSERT INTO `employers_tbl` (`id`, `fullname`, `department`, `age`, `gender`, `education`, `address`) VALUES
(2, 'abdulmuaz aqeel', 'Systems Developer Using Java, Python and C#', 20, 'male', 'Second Stage/College', 'Babil, Iraq'),
(7, 'muhammed essa', 'engineer', 33, 'male', 'google', 'karkuk');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins_tbl`
--
ALTER TABLE `admins_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employers_tbl`
--
ALTER TABLE `employers_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins_tbl`
--
ALTER TABLE `admins_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `employers_tbl`
--
ALTER TABLE `employers_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
