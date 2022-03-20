DROP TABLE IF EXISTS `customer`

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

DROP TABLE IF EXISTS `account`

CREATE TABLE `account` (
  `id` int NOT NULL,
  `nrb` varchar(150) NOT NULL,
  `currency` varchar(150) DEFAULT NULL,
  `available_funds` decimal(19,2) DEFAULT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_accountt_idx` (`customer_id`),
  CONSTRAINT `customer_account` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
);