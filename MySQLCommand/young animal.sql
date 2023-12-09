
-- Создание таблицы Young_animals
CREATE TABLE IF NOT EXISTS Young_animals (
    `Young_animals_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `Young_animals_name` VARCHAR(25),
    `animal_type` VARCHAR(25),
    `birthdate` DATE,
    `age` VARCHAR(25)
);


-- Вставка данных из таблиц Pets и Pack_animals в таблицу Young_animals с возрастом животных в формате "годы - месяцы"
INSERT INTO Young_animals (`Young_animals_name`, `animal_type`, `birthdate`, `age`)
	SELECT
		`name_pet` AS `Young_animals_name`,
		`animal_type`,
		`birthdate`,
		CONCAT(
			TIMESTAMPDIFF(YEAR , `birthdate`, CURRENT_DATE()), ' года ',
			TIMESTAMPDIFF(MONTH , `birthdate`, CURRENT_DATE()) - TIMESTAMPDIFF(YEAR , `birthdate`, CURRENT_DATE()) * 12, ' месяцев'
		) AS `age`
	FROM
		Pets
	WHERE
		TIMESTAMPDIFF(YEAR , `birthdate`, CURRENT_DATE()) BETWEEN 1 AND 3
UNION ALL
	SELECT
		`name_pack_animal` AS `Young_animals_name`,
		`animal_type`,
		`birthdate`,
		CONCAT(
			TIMESTAMPDIFF(YEAR , `birthdate`, CURRENT_DATE()), ' года ',
			TIMESTAMPDIFF(MONTH , `birthdate`, CURRENT_DATE()) - TIMESTAMPDIFF(YEAR , `birthdate`, CURRENT_DATE()) * 12, ' месяцев'
		) AS `age`
	FROM
		Pack_animals
	WHERE
		TIMESTAMPDIFF(YEAR , `birthdate`, CURRENT_DATE()) BETWEEN 1 AND 3;

SELECT * FROM Young_animals;