ALTER TABLE Pets ADD `commands` VARCHAR (255) NOT NULL;

UPDATE Pets p
SET p.commands = (
    SELECT GROUP_CONCAT(com.command SEPARATOR ', ')
    FROM Pets_execution_commands pec
    JOIN Commands com ON pec.command_id = com.command_id
    WHERE pec.pet_id = p.pet_id
    GROUP BY pec.pet_id
);

SELECT * FROM pets;

ALTER TABLE Pack_animals ADD `commands` VARCHAR (255) NOT NULL;

UPDATE Pack_animals pa
SET pa.commands = (
    SELECT GROUP_CONCAT(com.command SEPARATOR ', ')
    FROM Pack_animal_execution_commands paec
    JOIN Commands com ON paec.command_id = com.command_id
    WHERE paec.pack_animal_id = pa.pack_animal_id
    GROUP BY paec.pack_animal_id
);

SELECT * FROM Pack_animals;
