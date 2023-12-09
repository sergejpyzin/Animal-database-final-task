package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    /**
     * Статический метод создания базы данных.
     * Отправляет SQL запрос на создание базы данных на сервер,
     * В запросе осуществляется проверка существование базы данных с таким именем, если база данных не существует, создаёт её
     * @params - no-params
     */
    public static CreateDatabase createDatabase() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS human_friends";
            statement.executeUpdate(sql);
            System.out.println("База данных human_friends создана успешно!");
        } catch (SQLException e) {
            System.out.println("\u001B[31m Ошибка при создании базы данных: " + e.getMessage());
        }
        return null;
    }
}
