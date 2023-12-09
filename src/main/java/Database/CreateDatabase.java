package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    public static CreateDatabase createDatabase() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS human_friends";
            statement.executeUpdate(sql);
            System.out.println("База данных human_friends создана успешно!");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании базы данных: " + e.getMessage());
        }
        return null;
    }
}
