package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    /**
     * Метод
     * @return
     * @throws SQLException
     */
    public static Connection getConnection () throws SQLException {
        String URL = DatabaseConfig.getDatabaseUrl();
        String USER = DatabaseConfig.getDatabaseUser();
        String PASSWORD = DatabaseConfig.getDatabasePassword();

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
