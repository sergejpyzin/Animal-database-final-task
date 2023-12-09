DELETE FROM Pack_animal_execution_commands WHERE `pack_animal_id` IN (
    SELECT `pack_animal_id` FROM Pack_animals WHERE `animal_type` = 'Camel'
);

DELETE FROM Pack_animals WHERE `animal_type` = 'Camel';



-- Создание новой таблицы Union_horse_donkey для объединения данных о лошадях и осях
CREATE TABLE IF NOT EXISTS Union_horse_donkey AS
SELECT * FROM Pack_animals WHERE `animal_type` = 'Horse'
UNION ALL
SELECT * FROM Pack_animals WHERE `animal_type` = 'Donkey';


