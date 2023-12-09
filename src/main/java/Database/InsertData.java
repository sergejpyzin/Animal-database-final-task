package Database;

import Models.PackAnimals;
import Models.Pets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Database.DataBaseConnection.getConnection;

public class InsertData {
    public static void addPet(Pets pet) {
        String insertPetQuery = "INSERT INTO Pets (animal_name, animal_type, birthdate, commands) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertPetQuery)) {

            preparedStatement.setString(1, pet.getAnimalName());
            preparedStatement.setString(2, pet.getAnimalType());
            preparedStatement.setString(3, pet.getBirthdate());
            preparedStatement.setString(4, pet.getCommands());

            preparedStatement.executeUpdate();
            System.out.println("Животное успешно добавлено в базу данных!");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении животного в базу данных: " + e.getMessage());
        }
    }

    public static void addPackAnimal(PackAnimals packAnimal) {
        String insertPetQuery = "INSERT INTO PackAnimals (animal_name, animal_type, birthdate, commands) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertPetQuery)) {

            preparedStatement.setString(1, packAnimal.getAnimalName());
            preparedStatement.setString(2, packAnimal.getAnimalType());
            preparedStatement.setString(3, packAnimal.getBirthdate());
            preparedStatement.setString(4, packAnimal.getCommands());

            preparedStatement.executeUpdate();
            System.out.println("Животное успешно добавлено в базу данных!");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении животного в базу данных: " + e.getMessage());
        }
    }

}
