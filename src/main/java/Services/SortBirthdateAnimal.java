package Services;

import Database.DataBaseConnection;
import UI.App;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SortBirthdateAnimal {

    /**
     * Метод сортировки данных в таблице, на основании SQL-запроса, и вывода информации в консоль
     * @param titleTable - строковое значение наименования таблицы
     */
    private void displaySortedBirthdate(String titleTable) {
        System.out.println("Сортировка по возрастанию даты рождения для таблицы " + titleTable + ":\n");

        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT id, animal_name, animal_type, birthdate FROM " + titleTable + " ORDER BY birthdate;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String animalName = resultSet.getString("animal_name");
                String animalType = resultSet.getString("animal_type");
                String birthdate = resultSet.getString("birthdate");

                System.out.println("id: " + id + ", Имя: " + animalName + ", Дата рождения: " + birthdate);
            }
        } catch (SQLException e) {
            System.out.println("\u001B[31mОшибка при получении данных из таблицы " + titleTable + ": " + e.getMessage());
        }
    }

    /**
     * Метод сортировки по дате рождения данных в объединенной таблице (Pets и PackAnimals), на основании SQL-запроса и
     * вывода информации на консоль
     */
    private void displaySortedBirthdateAllAnimals() {
        System.out.println("Сортировка по возрастанию даты рождения для всех животных:\n");

        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String query = "SELECT id, animal_name, animal_type, birthdate " +
                    "FROM " +
                    "(SELECT id, animal_name, animal_type, birthdate " +
                    "FROM Pets " +
                    "UNION ALL " +
                    "SELECT id, animal_name, animal_type, birthdate " +
                    "FROM Pack_animals) AS UnionTable" +
                    " ORDER BY `birthdate`;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String animalName = resultSet.getString("animal_name");
                String animalType = resultSet.getString("animal_type");
                String birthdate = resultSet.getString("birthdate");

                System.out.println("ID " + id + ", Вид животного: " + animalType + ", Имя: " + animalName + ", Дата рождения: " + birthdate);
            }
        } catch (SQLException e) {
            System.out.println("\u001B[31mОшибка при получении данных из базы данных: " + e.getMessage());
        }
    }

    /**
     * Меню выбора метода сортировки, на основании ответа от пользователя
     */
    public void sortByBirthdate () {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(""" 
                    \u001B[32m****************************************************
                    \t\tМеню сортировки
                    Выберите таблицу для сортировки (Выбор осуществляется вводом номера пункта меню.):\n
                    1. Общая сортировка всей базы данных;
                    2. Сортировка таблицы Домашних животных;
                    3. Сортировка таблицы Вьючных животных;
                    4. Выход из меню сортировки.
                    ***************************************************** \u001B[37m""");

            int selectingMenuItem;
            while (true) {
                System.out.println("Введите номер пункта меню: ");

                try {
                    selectingMenuItem = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\u001B[31m Номер пункта меню должен быть числом. Попробуйте снова." + e.getMessage());
                }
            }

            switch (selectingMenuItem) {
                case 1:
                    displaySortedBirthdateAllAnimals();
                    break;
                case 2:
                    displaySortedBirthdate("Pets");
                    break;
                case 3:
                    displaySortedBirthdate("Pack_Animals");
                    break;
                case 4:
                    App.runApp();
                    break;
                default:
                    System.out.println("\u001B[31m Ошибка! Введенное число не соответствует номеру пункта меню!");
            }
        } while (true);


    }


}
