package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountingAnimals {


    public static int countingAnimaInTable(String titleTable) {

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
            System.out.println("Ошибка в подсчете животных в таблице " + titleTable + ": " + e.getMessage());
        }

        return count;
    }

    public void countingAnimals() {
        int totalNumbersAnimals = countingAnimaInTable("Pets") + countingAnimaInTable("PackAnimals");
        System.out.println("Общее количество животных : " + totalNumbersAnimals);
    }
}
