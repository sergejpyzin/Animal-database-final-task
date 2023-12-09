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
public class Horse extends PackAnimals {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;

    public static Horse creatingHorse () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя лошади: ");
        String animalName = scanner.nextLine();

        String animalType = "Horse";

        System.out.println("Введите дату рождения лошади (гггг-мм-дд): ");
        String birthdate = scanner.nextLine();

        System.out.println("Введите команды для лошади через запятую (например,  Walk, Trot, Canter, Gallop, Run, Jump): ");
        String commands = scanner.nextLine();

        return new Horse (animalName, animalType, birthdate, commands);
    }
}
