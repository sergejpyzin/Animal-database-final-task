package Services;

import Models.*;

import java.util.Scanner;

public class AddingAnimal {

    /**
     * Метод создания экземпляров классов Pets и PackAnimal на основании запросов к пользователю и добавления в базу данных.
     * Считывает с консоли ответ от пользователя и на основании полученных данных создает экземпляр соответствующего класса
     * и заносит его в соответствующую таблицу базы данных
     */
    public void addingAnimal (){

        Animals newAnimal;
        AddingToDatabase addingToDatabase = new AddingToDatabase();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вид животного (dog, cat, hamster, horse, camel, donkey):");
        String typeAnimal = scanner.nextLine();

        switch (typeAnimal.toLowerCase()) {
            case "dog" :
                newAnimal = Dog.creatingDog();
                addingToDatabase.addAnimalDatabase(newAnimal);
                break;
            case "cat":
                newAnimal = Cat.creatingCat();
                addingToDatabase.addAnimalDatabase(newAnimal);
                break;
            case "hamster":
                newAnimal = Hamster.creatingHamster();
                addingToDatabase.addAnimalDatabase(newAnimal);
                break;
            case "horse":
                newAnimal = Horse.creatingHorse();
                addingToDatabase.addAnimalDatabase(newAnimal);
                break;
            case "camel":
                newAnimal = Camel.creatingCamel();
                addingToDatabase.addAnimalDatabase(newAnimal);
                break;
            case "donkey":
                newAnimal = Donkey.creatingDonkey();
                addingToDatabase.addAnimalDatabase(newAnimal);
                break;
            default:
                System.out.println("\u001B[31m Ошибка! Проверьте правильность введения вида животного!");
        }
    }
}
