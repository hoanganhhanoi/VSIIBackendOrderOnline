-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2017 at 11:23 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vsiifood`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_oder`
--

CREATE TABLE `detail_oder` (
  `order_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detail_oder`
--

INSERT INTO `detail_oder` (`order_id`, `food_id`, `quantity`) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 2),
(1, 6, 2),
(3, 3, 1),
(3, 5, 3),
(3, 4, 1),
(3, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `food_id` int(11) NOT NULL,
  `food_name` varchar(255) NOT NULL,
  `new_price` varchar(45) NOT NULL,
  `old_price` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`food_id`, `food_name`, `new_price`, `old_price`, `description`, `created_at`, `updated_at`) VALUES
(1, 'Bún riêu cua bò', '30000', '30000', NULL, '2017-07-13 00:00:00', '2017-07-13 00:00:00'),
(2, 'Cơm rang dưa bò', '30000', '30000', NULL, '2017-07-13 00:00:00', '2017-07-13 00:00:00'),
(3, 'Vai sốt tiêu đen', '30000', '30000', NULL, '2017-07-13 00:00:00', '2017-07-13 00:00:00'),
(4, 'Tôm rang thịt', '30000', '30000', NULL, '2017-07-13 00:00:00', '2017-07-13 00:00:00'),
(5, 'Thịt kho dừa', '30000', '30000', NULL, '2017-07-13 00:00:00', '2017-07-13 00:00:00'),
(6, 'Sụn om sữa đặc', '30000', '30000', NULL, '2017-07-13 00:00:00', '2017-07-13 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  `quantity` int(11) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`order_id`, `order_date`, `quantity`, `description`, `updated_at`, `user_id`, `status_id`, `supplier_id`) VALUES
(1, '2017-07-17 00:00:00', 0, NULL, '2017-07-17 00:00:00', 1, 1, 1),
(3, '2017-07-18 00:00:00', 0, NULL, '2017-07-18 00:00:00', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `status_name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`status_id`, `status_name`, `created_at`, `updated_at`) VALUES
(1, 'new', '2017-07-17 00:00:00', '2017-07-17 00:00:00'),
(2, 'in progress', '2017-07-17 00:00:00', '2017-07-17 00:00:00'),
(3, 'done', '2017-07-17 00:00:00', '2017-07-17 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `suborder`
--

CREATE TABLE `suborder` (
  `suborder_id` int(11) NOT NULL,
  `food_name` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(45) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `address`, `created_at`, `updated_at`) VALUES
(1, 'Việt Phương', '', '2017-07-13 00:00:00', '2017-07-13 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `sup_food`
--

CREATE TABLE `sup_food` (
  `food_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sup_food`
--

INSERT INTO `sup_food` (`food_id`, `supplier_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `image` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `password`, `image`, `created_at`, `updated_at`) VALUES
(1, 'anhnh', 'hoanganh', '', '2017-07-08 00:00:00', '2017-07-08 00:00:00'),
(2, 'binhnh', 'hoangbinh', '', '2017-07-08 00:00:00', '2017-07-08 00:00:00'),
(3, 'anhnh2', '123456', '', '2012-04-24 01:25:43', '2012-04-24 01:25:43'),
(4, 'anhnh3', '123456', '', '2012-04-24 01:25:43', '2012-04-24 01:25:43'),
(5, 'anhnh4', '123456', '', '2012-04-24 01:25:43', '2012-04-24 01:25:43'),
(6, 'anhnh5', '123456', '', '2012-04-24 01:25:43', '2012-04-24 01:25:43'),
(7, 'anhnh9', '123456', '', '2012-04-24 01:25:43', '2012-04-24 01:25:43');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_oder`
--
ALTER TABLE `detail_oder`
  ADD KEY `fk_Detail_Oder_Order1` (`order_id`),
  ADD KEY `fk_Detail_Oder_Food1` (`food_id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`food_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `fk_Order_User1` (`user_id`),
  ADD KEY `fk_Order_Status1` (`status_id`),
  ADD KEY `fk_Order_Supplier1` (`supplier_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `suborder`
--
ALTER TABLE `suborder`
  ADD PRIMARY KEY (`suborder_id`),
  ADD KEY `fk_SubOrder_Order1` (`order_id`),
  ADD KEY `fk_SubOrder_User1` (`user_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Indexes for table `sup_food`
--
ALTER TABLE `sup_food`
  ADD KEY `fk_Sup_Food_Food` (`food_id`),
  ADD KEY `fk_Sup_Food_Supplier1` (`supplier_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id_UNIQUE` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `food_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `suborder`
--
ALTER TABLE `suborder`
  MODIFY `suborder_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_oder`
--
ALTER TABLE `detail_oder`
  ADD CONSTRAINT `fk_Detail_Oder_Food1` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detail_Oder_Order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_Order_Status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Order_Supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Order_User1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `suborder`
--
ALTER TABLE `suborder`
  ADD CONSTRAINT `fk_SubOrder_Order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_SubOrder_User1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sup_food`
--
ALTER TABLE `sup_food`
  ADD CONSTRAINT `fk_Sup_Food_Food` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Sup_Food_Supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
