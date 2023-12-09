INSERT INTO Pets (`name_pet`, `animal_type` , `birthdate`)
VALUES
    ('Fido', 'Dog', '2020-01-01'),
    ('Whiskers', 'Cat', '2019-05-15'),
    ('Hammy', 'Hamster', '2021-03-10'),
    ('Buddy', 'Dog', '2018-12-10'),
    ('Smudge', 'Cat', '2020-02-20'),
    ('Peanut', 'Hamster', '2021-08-01'),
    ('Bella', 'Dog', '2019-11-11'),
    ('Oliver','Cat','2020-06-30');
   
   
   -- Добавление данных в таблицу PackAnimals
INSERT INTO Pack_animals (`name_pack_animal`, `animal_type` , `birthdate`) 
VALUES
    ('Thunder', 'Horse', '2015-07-21'),
    ('Sandy', 'Camel', '2016-11-03'),
    ('Eeyore', 'Donkey', '2017-09-18'),
    ('Storm', 'Horse', '2014-05-05'),
    ('Dune', 'Camel', '2020-12-12'),
    ('Burro', 'Donkey', '2022-01-23'),
    ('Blaze', 'Horse', '2016-02-29'),
    ('Sahara', 'Camel', '2015-08-14');
   
   -- Добавление данных в таблицу Commands
INSERT INTO Commands (`command`) 
VALUES
    ('Sit'), 
    ('Stay'), 
    ('Bark'), 
    ('Paw'),  
    ('Fetch'), 
    ('Roll'), 
    ('Pounce'), 
    ('Scratch'), 
    ('Meow'), 
    ('Jump'), 
    ('Hide'), 
    ('Spin'), 
    ('Trot'), 
    ('Canter'), 
    ('Run'),
    ('Walk'), 
    ('Carry Load'), 
    ('Bray'), 
    ('Kick'), 
    ('Gallop');
   
   -- Добавление связей между животными и командами в таблицу Pets_execution_commands
INSERT INTO Pets_execution_commands (`pet_id`, `command_id`) 
VALUES
    (1, 1), 
    (1, 2),  
    (1, 5),  
    (2, 1), 
    (2, 7), 
    (3, 6), 
    (3, 11), 
    (4, 1), 
    (4, 4), 
    (4, 3), 
    (5, 1), 
    (5, 7), 
    (5, 8), 
    (6, 6), 
    (6, 12), 
    (7, 1), 
    (7, 2), 
    (7, 6), 
    (8, 9), 
    (8, 8), 
    (8, 10); 
    
INSERT INTO Pack_animal_execution_commands (`pack_animal_id`, `command_id`)
VALUES
    (1, 13), 
    (1, 14), 
    (1, 20), 
    (2, 16), 
    (2, 17), 
    (3, 16),
    (3, 17), 
    (3, 18), 
    (4, 13), 
    (4, 14), 
    (5, 16), 
    (5, 1), 
    (6, 16), 
    (6, 18), 
    (6, 19), 
    (7, 13), 
    (7, 10), 
    (7, 20), 
    (8, 16), 
    (8, 15); 
    
    