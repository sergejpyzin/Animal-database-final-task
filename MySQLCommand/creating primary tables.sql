DROP DATABASE IF EXISTS human_friends;

CREATE DATABASE Human_friends;
USE Human_friends;



CREATE TABLE IF NOT EXISTS Pets (
	`pet_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name_pet` VARCHAR (25),
    `animal_type` VARCHAR (25),
    `birthdate` DATE
);



CREATE TABLE IF NOT EXISTS Pack_animals (
	`pack_animal_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name_pack_animal` VARCHAR (25),
    `animal_type` VARCHAR (25),
    `birthdate` DATE
);



CREATE TABLE IF NOT EXISTS Commands (
	`command_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `command` VARCHAR (25)
);



CREATE TABLE IF NOT EXISTS Pets_execution_commands (
	`pet_id` INT NOT NULL,
    `command_id` INT NOT NULL,
    FOREIGN KEY (`pet_id`) REFERENCES Pets(`pet_id`),
    FOREIGN KEY (`command_id`) REFERENCES Commands (`command_id`),
    PRIMARY KEY (`pet_id`, `command_id`)
);



CREATE TABLE IF NOT EXISTS Pack_animal_execution_commands (
	`pack_animal_id` INT NOT NULL,
    `command_id` INT NOT NULL,
    FOREIGN KEY (`pack_animal_id`) REFERENCES Pets(`pet_id`),
    FOREIGN KEY (`command_id`) REFERENCES Commands (`command_id`),
    PRIMARY KEY (`pack_animal_id`, `command_id`)
);

