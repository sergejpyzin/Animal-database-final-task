package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAnimal {

    private void showPets() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Pets";
            System.out.println("Домашние животные:");
            withdrawalFromDatabase(connection, query);
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных из таблицы Pets: " + e.getMessage());
        }
    }

    private void showPackAnimals() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Pack_Animals";
            System.out.println("Вьючные животные:");
            withdrawalFromDatabase(connection, query);
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных из таблицы Pack_Animals: " + e.getMessage());
        }
    }

    private void withdrawalFromDatabase(Connection connection, String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

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

    public void showAnimals(){
        showPets();
        showPackAnimals();
    }
}
