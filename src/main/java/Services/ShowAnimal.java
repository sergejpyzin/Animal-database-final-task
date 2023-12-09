package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAnimal {

    /**
     * Метод вывода в консоль списка элементов таблицы Pets
     */
    private void showPets() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Pets";
            System.out.println("\nДомашние животные:");
            withdrawalFromDatabase(connection, query);
        } catch (SQLException e) {
            System.out.println("\u001B[31m Ошибка при получении данных из таблицы Pets: " + e.getMessage());
        }
    }

    /**
     * Метод вывода в консоль элементов таблицы PackAnimals
     */
    private void showPackAnimals() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT * FROM Pack_Animals";
            System.out.println("\nВьючные животные:");
            withdrawalFromDatabase(connection, query);
        } catch (SQLException e) {
            System.out.println("\u001B[31m Ошибка при получении данных из таблицы Pack_Animals: " + e.getMessage());
        }
    }

    /**
     * Метод обработки данных полученных из базы данных на основании SQL-запроса
     * @param connection - экземпляр класса Connection
     * @param query - строковое значение SQL-запроса
     * @throws SQLException - ошибка подключения к базе данных
     */
    private void withdrawalFromDatabase(Connection connection, String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String animalName = resultSet.getString("animal_name");
            String animalType = resultSet.getString("animal_type");
            String birthdate = resultSet.getString("birthdate");
            String commands = resultSet.getString("commands");

            System.out.println("id: " + id + ", Имя: " + animalName + ", Вид: " + animalType + ", День рождения: " + birthdate + "," +
                    " Выполняемые команды: " + commands);
        }
    }

    /**
     * Метод вывода в консоль списка элементов таблиц Pets и PackAnimals
     */
    public void showAnimals(){
        showPets();
        showPackAnimals();
    }
}
