package UI;

import Database.CreateDatabase;
import Database.CreateTables;
import Services.*;

import java.util.Scanner;

public class App {

    /**
     * Основное меню взаимодействия с базой данных
     */
    public static void runApp() {
        CreateDatabase createDatabase = CreateDatabase.createDatabase();
        CreateTables.creatingTable();

        Scanner scanner = new Scanner(System.in);


        int selectingMenuItem;
        while (true) {


            System.out.println("\u001B[32m **************************************************************");
            System.out.println("""
                    \t\tМЕНЮ
                    1. Добавление животного в базу данных;
                    2. Вывести список всех животных в базе данных;
                    3. Вывести список команд животного (выбор животного осуществляется по его id);
                    4. Подсчитать количество всех животных в базе данных;
                    5. Добавить команды животному;
                    6. Сортировка животных по дате рождения;
                    7. Выход.
                    \t\t Выбор пункта меню осуществляется вводом номера меню (\u001B[31mВНИМАНИЕ! ВВОДИТЬ НЕОБХОДИМО ТОЛЬКО ЦИФРЫ!\u001B[32m)
                    """);
            System.out.println("\u001B[32m ****************************************************************** \u001B[37m");

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
                    AddingAnimal addingAnimal = new AddingAnimal();
                    addingAnimal.addingAnimal();
                    break;
                case 2:
                    ShowAnimal showAnimal = new ShowAnimal();
                    showAnimal.showAnimals();
                    break;
                case 3:
                    ShowCommands showCommands = new ShowCommands();
                    showCommands.showCommands();
                    break;
                case 4:
                    CountingAnimals countingAnimals = new CountingAnimals();
                    countingAnimals.countingAnimals();
                    break;
                case 5:
                    AddingNewCommands newCommands = new AddingNewCommands();
                    newCommands.learnNewCommand();
                    break;
                case 6:
                    SortBirthdateAnimal sortBirthdateAnimal = new SortBirthdateAnimal();
                    sortBirthdateAnimal.sortByBirthdate();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("\u001B[31m Ошибка! Введенное число не соответствует номеру пункта меню!");

            }

        }
    }
}
