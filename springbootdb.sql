SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `address_info` (
  `address_info_id` int(11) NOT NULL,
  `address1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `primry` bit(1) NOT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



CREATE TABLE `contact_info` (
  `contact_info_id` int(11) NOT NULL,
  `primry` bit(1) NOT NULL,
  `val` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `date_hired` date DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `marital_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `middle_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `position` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `address_info`
  ADD PRIMARY KEY (`address_info_id`),
  ADD KEY `FKaa68f1cxb92co8ehanfu8glp2` (`employee_id`);

ALTER TABLE `contact_info`
  ADD PRIMARY KEY (`contact_info_id`),
  ADD KEY `FKf0lmol2awvmfxp9n1v7b3slo2` (`employee_id`);

ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

ALTER TABLE `address_info`
  MODIFY `address_info_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `contact_info`
  MODIFY `contact_info_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `address_info`
  ADD CONSTRAINT `FKaa68f1cxb92co8ehanfu8glp2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);


ALTER TABLE `contact_info`
  ADD CONSTRAINT `FKf0lmol2awvmfxp9n1v7b3slo2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`);
COMMIT;
