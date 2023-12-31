package Services;

import Database.DataBaseConnection;
import Models.Animals;
import Models.PackAnimals;
import Models.Pets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddingToDatabase {

    /**
     * Метод добавления экземпляров классов Pets и PackAnimals в соответствующую таблицу.
     * На основании SQL-запроса добавляет экземпляр классаю
     * @param animal - экземпляр соответствующего класса
     */
    public void addAnimalDatabase(Animals animal) {
        String tableName;
        String insertAnimalQuery;

        if (animal instanceof Pets) {
            tableName = "Pets";
            insertAnimalQuery = "INSERT INTO Pets (animal_name, animal_type, birthdate, commands) VALUES (?, ?, ?, ?)";
        } else if (animal instanceof PackAnimals) {
            tableName = "PackAnimals";
            insertAnimalQuery = "INSERT INTO PackAnimals (animal_name, animal_type, birthdate, commands) VALUES (?, ?, ?, ?)";
        } else {
            System.out.println("\u001B[31m Невозможно определить таблицу для добавления животного.");
            return;
        }

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertAnimalQuery)) {

            preparedStatement.setString(1, animal.getAnimalName());
            preparedStatement.setString(2, animal.getAnimalType());
            preparedStatement.setString(3, animal.getBirthdate());

            if (animal instanceof Pets pet) {
                preparedStatement.setString(4, pet.getCommands());
            } else {
                PackAnimals packAnimal = (PackAnimals) animal;
                preparedStatement.setString(4, packAnimal.getCommands());
            }

            preparedStatement.executeUpdate();
            System.out.println("Животное " + animal.getAnimalName() + " успешно добавлено в таблицу " + tableName + " базы данных!");

        } catch (SQLException e) {
            System.out.println("\u001B[31m Ошибка при добавлении животного в базу данных: " + e.getMessage());
        }
    }
}
