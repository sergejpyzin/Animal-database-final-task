package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donkey extends PackAnimals {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;

    public static Donkey creatingDonkey () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя осла: ");
        String animalName = scanner.nextLine();

        String animalType = "Donkey";

        System.out.println("Введите дату рождения осла (гггг-мм-дд): ");
        String birthdate = scanner.nextLine();

        System.out.println("Введите команды для осла через запятую (например,  Carry, Follow, Work, Bray, Kick): ");
        String commands = scanner.nextLine();

        return new Donkey (animalName, animalType, birthdate, commands);
    }
}
