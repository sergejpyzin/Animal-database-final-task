package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShowCommands {

    /**
     * Метод получения списка команд на основании id, полученного от пользователя, элемента таблицы
     */
    public void showCommands() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя таблицы (Pets или PackAnimals): ");
        String titleTable = scanner.nextLine();

        int id;
        while (true) {
            System.out.println("Введите id животного: ");

            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e){
                System.out.println("\u001B[31m id должен быть числом. Попробуйте снова." + e.getMessage());
            }
        }

        selectCommands(titleTable, id);
    }

    /**
     * Метод вывода в консоль списка команд на основании SQL-запроса
     * @param titleTable - строковое значение наименования таблицы
     * @param id - целочисленное, неотрицательное, значение id (параметр таблицы)
     */
    private static void selectCommands (String titleTable, int id) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "SELECT Commands FROM " + titleTable + " WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String commands = resultSet.getString("commands");
                System.out.println("Список команд для животного с id " + id + ": " + commands);
            } else {
                System.out.println("Животное с id " + id + " в таблице " + titleTable + " не найдено.");
            }
        } catch (SQLException e) {
            System.out.println("\u001B[31m Ошибка при получении команд: " + e.getMessage());
        }
    }
}
