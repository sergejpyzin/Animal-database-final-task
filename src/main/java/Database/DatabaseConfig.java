package Database;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final String CONFIG_FILE = "database.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.out.println("\u001B[31m Извините, но файл " + CONFIG_FILE + " не найден!");
                System.exit(1);
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод получения URL адреса из конфигурационного файла
     * @return - URL
     */
    public static String getDatabaseUrl() {
        return properties.getProperty("db.url");
    }

    /**
     * Метод получения имени пользователя адреса из конфигурационного файла
     * @return - USER
     */
    public static String getDatabaseUser() {
        return properties.getProperty("db.user");
    }

    /**
     * Метод получения пароля из конфигурационного файла
     * @return - PASSWORD
     */

    public static String getDatabasePassword() {
        return properties.getProperty("db.password");
    }
}

