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
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
                System.exit(1);
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDatabaseUrl() {
        return properties.getProperty("db.url");
    }

    public static String getDatabaseUser() {
        return properties.getProperty("db.user");
    }

    public static String getDatabasePassword() {
        return properties.getProperty("db.password");
    }
}

