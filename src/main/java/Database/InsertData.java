package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void addPet(Pets pet) {
        String insertPetQuery = "INSERT INTO Pets (name_pet, animal_type, birthdate, commands) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
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
        String insertPetQuery = "INSERT INTO PackAnimals (name_pack_animal, animal_type, birthdate, commands) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
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
