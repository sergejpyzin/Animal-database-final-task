package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    /**
     * Статический метод создания таблиц Pets и Pack_animals.
     * Отправляет SQL запросы на создание таблиц данных на сервер,
     * В запросе осуществляется проверка существование таблиц с таким именем, если таблиц не существует, создаёт её
     * @params - no-params
     */
    public static void creatingTable(){
        try(Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();

            String createTablePets = "CREATE TABLE IF NOT EXISTS Pets (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, animal_name VARCHAR (25), animal_type VARCHAR (25), birthdate DATE, commands VARCHAR(100));";
            statement.executeUpdate(createTablePets);

            String createTablePackAnimals = "CREATE TABLE IF NOT EXISTS Pack_animals (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, animal_name VARCHAR (25), animal_type VARCHAR (25), birthdate DATE, commands VARCHAR(100));";
            statement.executeUpdate(createTablePackAnimals);

            System.out.println("Таблицы Pets и Pack_Animals созданы успешно!");
        } catch (SQLException e) {
            System.out.println("\u001B[31m Ошибка при создании таблиц: " + e.getMessage());
        }
    }
}
