-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2021 at 04:36 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `servis`
--

-- --------------------------------------------------------

--
-- Table structure for table `item_dmg`
--

CREATE TABLE `item_dmg` (
  `kerusakan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item_dmg`
--

INSERT INTO `item_dmg` (`kerusakan`) VALUES
('Baterai'),
('Fan'),
('Touchpad');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_konten`
--

CREATE TABLE `tbl_konten` (
  `brand` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_konten`
--

INSERT INTO `tbl_konten` (`brand`) VALUES
('ACER'),
('ACER - NITRO'),
('ACER - PREDATOR'),
('ASUS'),
('ASUS - ROG'),
('ASUS - TUF'),
('DELL'),
('DELL - ALIENWARE'),
('FUJITSU'),
('LENOVO'),
('MSI'),
('TOSHIBA');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_msg`
--

CREATE TABLE `tbl_msg` (
  `msg_id` int(50) NOT NULL,
  `msgnya` text NOT NULL,
  `tipe` varchar(50) NOT NULL,
  `rd_stts` varchar(50) NOT NULL DEFAULT 'Sent'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_msg`
--

INSERT INTO `tbl_msg` (`msg_id`, `msgnya`, `tipe`, `rd_stts`) VALUES
(3, 'tambahkan brand baru\nLaptop fujitsu', 'Brand Request Update', 'Read'),
(4, 'laptop fujitsu', 'Brand Request Update', 'Read');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_servis`
--

CREATE TABLE `tbl_servis` (
  `no_resi` int(50) NOT NULL,
  `nama_client` varchar(50) NOT NULL,
  `no_telp` varchar(50) NOT NULL,
  `email_client` varchar(50) NOT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `kerusakan` varchar(50) DEFAULT NULL,
  `tgl_masuk` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` varchar(50) NOT NULL,
  `laptop_loc` varchar(50) NOT NULL DEFAULT 'Service Place',
  `penerima` varchar(50) DEFAULT NULL,
  `notel_penerima` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_servis`
--

INSERT INTO `tbl_servis` (`no_resi`, `nama_client`, `no_telp`, `email_client`, `brand`, `kerusakan`, `tgl_masuk`, `status`, `laptop_loc`, `penerima`, `notel_penerima`, `price`) VALUES
(4, 'jono', '1231', 'sfadsad', 'ACER', 'Baterai', '2020-09-18 10:15:08', 'DONE', 'Service Place', 'ikho', NULL, ''),
(5, 'Della', '081398257848', '51323', 'ACER - NITRO', 'Baterai', '2020-09-21 12:27:37', 'DONE', 'On Customer - Owner Hand', 'dian', '081311091000', '650.000'),
(6, 'jono', '081311091000', 'bintangpratomo@gmail.com', 'ASUS - ROG', 'Baterai', '2020-09-18 10:15:02', 'DONE', 'Service Place', NULL, NULL, ''),
(11, 'adsdaasda', '081398257848', 'sdasdasda', 'ACER', 'Baterai', '2020-09-21 12:25:12', ' RECEIVED', 'Service Place', NULL, NULL, ''),
(13, 'septian', '082112944767', 'dfsdfsfsdf', 'ASUS - ROG', 'Baterai', '2020-09-20 15:05:10', 'DONE', 'Service Place', NULL, NULL, '650.000'),
(14, 'jono', '081413494309', 'annisa.sadimah@gmail.com', 'ACER', 'Baterai', '2020-09-18 10:15:13', 'DONE', 'Service Place', NULL, NULL, ''),
(15, 'jojo', '085741889248', 'amar@smktelkom-jkt.sch.id', 'ACER', 'Baterai', '2020-12-22 17:20:53', 'DONE', 'Service Place', NULL, NULL, '50000'),
(16, 'aan', '081311091000', 'gatau', 'ACER', 'Baterai', '2020-09-29 15:49:57', ' RECEIVED', 'Service Place', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_staff`
--

CREATE TABLE `tbl_staff` (
  `no_id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `staff_stts` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_staff`
--

INSERT INTO `tbl_staff` (`no_id`, `username`, `password`, `staff_stts`) VALUES
(1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Admin'),
(2, 'andi456', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Staff'),
(6, 'nathan', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Technision'),
(7, 'ikhsan', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Technision'),
(8, 'jojo', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Staff');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_status`
--

CREATE TABLE `tbl_status` (
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_status`
--

INSERT INTO `tbl_status` (`status`) VALUES
(' RECEIVED'),
('DONE'),
('IN PROCESS'),
('INCOMPLETE'),
('PENDING');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item_dmg`
--
ALTER TABLE `item_dmg`
  ADD PRIMARY KEY (`kerusakan`);

--
-- Indexes for table `tbl_konten`
--
ALTER TABLE `tbl_konten`
  ADD PRIMARY KEY (`brand`);

--
-- Indexes for table `tbl_msg`
--
ALTER TABLE `tbl_msg`
  ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `tbl_servis`
--
ALTER TABLE `tbl_servis`
  ADD PRIMARY KEY (`no_resi`),
  ADD KEY `brand` (`brand`),
  ADD KEY `tbl_servis_ibfk_2` (`status`),
  ADD KEY `tbl_servis_ibfk_3` (`kerusakan`);

--
-- Indexes for table `tbl_staff`
--
ALTER TABLE `tbl_staff`
  ADD PRIMARY KEY (`no_id`),
  ADD UNIQUE KEY `username_id` (`username`);

--
-- Indexes for table `tbl_status`
--
ALTER TABLE `tbl_status`
  ADD PRIMARY KEY (`status`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_msg`
--
ALTER TABLE `tbl_msg`
  MODIFY `msg_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_servis`
--
ALTER TABLE `tbl_servis`
  MODIFY `no_resi` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_staff`
--
ALTER TABLE `tbl_staff`
  MODIFY `no_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_servis`
--
ALTER TABLE `tbl_servis`
  ADD CONSTRAINT `tbl_servis_ibfk_1` FOREIGN KEY (`brand`) REFERENCES `tbl_konten` (`brand`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_servis_ibfk_2` FOREIGN KEY (`status`) REFERENCES `tbl_status` (`status`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_servis_ibfk_3` FOREIGN KEY (`kerusakan`) REFERENCES `item_dmg` (`kerusakan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
