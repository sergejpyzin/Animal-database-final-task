package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    public static void creatingTable(){
        try(Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();

            String createTablePets = "CREATE TABLE IF NOT EXISTS Pets (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, animal_name VARCHAR (25), animal_type VARCHAR (25), birthdate DATE, commands VARCHAR(100));";
            statement.executeUpdate(createTablePets);

            String createTablePackAnimals = "CREATE TABLE IF NOT EXISTS Pack_animals (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, animal_name VARCHAR (25), animal_type VARCHAR (25), birthdate DATE, commands VARCHAR(100));";
            statement.executeUpdate(createTablePackAnimals);

            System.out.println("Таблицы Pets и Pack_Animals созданы успешно!");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблиц: " + e.getMessage());
        }
    }
}
