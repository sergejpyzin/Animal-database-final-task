package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hamster extends Pets {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;

    public static Hamster creatingHamster () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя хомяка: ");
        String animalName = scanner.nextLine();

        String animalType = "Hamster";

        System.out.println("Введите дату рождения хомяка (гггг-мм-дд): ");
        String birthdate = scanner.nextLine();

        System.out.println("Введите команды для хомяка через запятую (например,  Walk, Trot, Canter, Gallop, Run, Jump): ");
        String commands = scanner.nextLine();

        return new Hamster (animalName, animalType, birthdate, commands);
    }
}
