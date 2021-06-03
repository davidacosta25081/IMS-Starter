drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
 `first_name` VARCHAR(40) DEFAULT NULL,
 `surname` VARCHAR(40) DEFAULT NULL,
 PRIMARY KEY(`id`)
 );
 
 CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) NOT NULL,
	`item_description` VARCHAR(40) NOT NULL,
	`item_price` DOUBLE(40,2) NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`)
);
 
 CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`costumer_id` INT(11),
	`date` VARCHAR(40) NULL ,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`costumer_id`) REFERENCES `ims`.`customers`(`id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`order_id` INT(11),
	`item_id` INT(11),
	`quantity` INT(100),
    PRIMARY KEY(`id`),
	FOREIGN KEY(`order_id`) REFERENCES `ims`.`orders`(`id`) ON DELETE CASCADE,
	FOREIGN KEY(`item_id`) REFERENCES `ims`.`items`(`id`) ON DELETE CASCADE
);