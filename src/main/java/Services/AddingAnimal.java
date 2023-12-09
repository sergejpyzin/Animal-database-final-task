package Services;

import Models.*;

import java.util.Scanner;

public class AddingAnimal {

    public void addingAnimal (){

        Animals newAnimal;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вид животного (dog, cat, hamster, horse, camel, donkey):");
        String typeAnimal = scanner.nextLine();

        switch (typeAnimal.toLowerCase()) {
            case "dog" :
                newAnimal = Dog.creatingDog();
                DatabaseOperations.addAnimalToDatabase(newAnimal);
                break;
            case "cat":
                newAnimal = Cat.creatingCat();
                DatabaseOperations.addAnimalToDatabase(newAnimal);
                break;
            case "hamster":
                newAnimal = Hamster.creatingHamster();
                DatabaseOperations.addAnimalToDatabase(newAnimal);
                break;
            case "horse":
                newAnimal = Horse.creatingHorse();
                DatabaseOperations.addAnimalToDatabase(newAnimal);
                break;
            case "camel":
                newAnimal = Camel.creatingCamel();
                DatabaseOperations.addAnimalToDatabase(newAnimal);
                break;
            case "donkey":
                newAnimal = Donkey.creatingDonkey();
                DatabaseOperations.addAnimalToDatabase(newAnimal);
                break;
            default:
                System.out.println("Ошибка! Проверьте правильность введения вида животного!");
        }
    }
}
