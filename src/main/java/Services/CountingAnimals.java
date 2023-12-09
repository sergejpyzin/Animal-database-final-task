package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountingAnimals {


    /**
     * Метод подсчета количества элементов таблицы на основании SQL-запроса
     * @param titleTable - строковое наименование таблицы
     * @return - целочисленное значение количества элементов таблицы
     */
    private int countingAnimaInTable(String titleTable) {

        int count = 0;

        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT COUNT(*) AS count FROM " + titleTable;
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                count = resultSet.getInt("count");
                System.out.println("Количество животных в таблице " + titleTable + ": " + count);
            }
        } catch (SQLException e) {
            System.out.println("\u001B[31m Ошибка в подсчете животных в таблице " + titleTable + ": " + e.getMessage());
        }

        return count;
    }

    /**
     * Метод вывода в консоль общего количества элементов двух таблиц
     */
    public void countingAnimals() {
        int totalNumbersAnimals = countingAnimaInTable("Pets") + countingAnimaInTable("PackAnimals");
        System.out.println("Общее количество животных : " + totalNumbersAnimals);
    }
}
