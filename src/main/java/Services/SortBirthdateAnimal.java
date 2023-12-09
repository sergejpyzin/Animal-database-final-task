package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SortBirthdateAnimal {

    public static void displaySortedBirthdate(String titleTable) {
        System.out.println("Сортировка по возрастанию для таблицы " + titleTable + ":");

        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT animal_name, animal_type, birthdate FROM " + titleTable + " ORDER BY birthdate;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String animalName = resultSet.getString("animal_name");
                String animalType = resultSet.getString("animal_type");
                String birthdate = resultSet.getString("birthdate");

                System.out.println("ID: " + id + ", Имя: " + animalName + ", Дата рождения: " + birthdate);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных из таблицы " + titleTable + ": " + e.getMessage());
        }
    }

    public static void sortByBirthdate () {
        displaySortedBirthdate("Pets");
        displaySortedBirthdate("Pack_Animals");
    }
}
