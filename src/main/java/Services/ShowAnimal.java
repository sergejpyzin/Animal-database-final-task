package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAnimal {

    public void showPets() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Pets";
            withdrawalFromDatabase(connection, query);
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных из таблицы Pets: " + e.getMessage());
        }
    }

    public void showPackAnimals() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Pack_Animals";
            withdrawalFromDatabase(connection, query);
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных из таблицы Pack_Animals: " + e.getMessage());
        }
    }

    private void withdrawalFromDatabase(Connection connection, String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Содержимое таблицы Pets:");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String animalName = resultSet.getString("animal_name");
            String animalType = resultSet.getString("animal_type");
            String birthdate = resultSet.getString("birthdate");
            String commands = resultSet.getString("commands");

            System.out.println("ID: " + id + ", Имя: " + animalName + ", Вид: " + animalType + ", День рождения: " + birthdate + "," +
                    " Выполняемые команды: " + commands);
        }
    }
}
