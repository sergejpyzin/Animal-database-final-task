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
public class Camel extends PackAnimals {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;

    public static Camel creatingCamel () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя верблюда: ");
        String animalName = scanner.nextLine();

        String animalType = "Camel";

        System.out.println("Введите дату рождения верблюда (гггг-мм-дд): ");
        String birthdate = scanner.nextLine();

        System.out.println("Введите команды для верблюда через запятую (например, Load, Unload, Travel, Sit, Walk): ");
        String commands = scanner.nextLine();

        return new Camel (animalName, animalType, birthdate, commands);
    }
}
