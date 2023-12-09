CREATE TABLE Animals (
	`animal_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `animal_group` VARCHAR (25),
    `animal_name` VARCHAR (25),
    `animal_type` VARCHAR (25),
    `birthdate` DATE,
    `commands` VARCHAR (25)
);

INSERT INTO Animals (`animal_group`,`animal_name`, `animal_type`, `birthdate`, `commands`)
SELECT 
	'Pet' AS `animal_group`,
    `name_pet` AS `animal_name`,
    `animal_type`,
    `birthdate`,
    `commands`
FROM Pets
UNION ALL
SELECT 
    'PackAnimals' AS `animal_group`,
    `name_pack_animal` AS `animal_name`,
    `animal_type`,
    `birthdate`,
    `commands`
FROM Pack_animals;

SELECT * FROM Animals;
