package Services;

import Database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddingNewCommands {

    public void learnNewCommand() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название таблицы (Pets или PackAnimals): ");
        String titleTable = scanner.nextLine();

        int id;
        while (true) {
            System.out.println("Введите ID животного: ");

            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e){
                System.out.println("ID должен быть числом. Попробуйте снова." + e.getMessage());
            }

        }

        System.out.println("Введите новую команду: ");
        String newCommand = scanner.nextLine();

        addingNewCommand(titleTable, id, newCommand);
    }

    private void addingNewCommand(String titleTable, int id, String newCommand) {

        try (Connection connection = DataBaseConnection.getConnection()) {
            String query = "UPDATE " + titleTable + " SET commands = CONCAT(commands, ', ', ?) WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newCommand);
            preparedStatement.setInt(2, id);

            int Updaterow = preparedStatement.executeUpdate();

            if (Updaterow > 0) {
                System.out.println("Новая команда успешно добавлена для животного с ID " + id + " в таблицу " + titleTable);
            } else {
                System.out.println("Животное с ID " + id + " в таблице " + titleTable + " не найдено.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении новой команды: " + e.getMessage());
        }
    }
}
