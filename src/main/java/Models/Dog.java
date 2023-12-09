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
public class Dog extends Pets {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;

    /**
     * Статический метод создания экземпляра класса Dog.
     * Наследник класса Pets
     * @return - экземпляр класса Dog
     */
    public static Dog creatingDog () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя собаки: ");
        String animalName = scanner.nextLine();

        String animalType = "Dog";

        System.out.println("Введите дату рождения собаки (гггг-мм-дд): ");
        String birthdate = scanner.nextLine();

        System.out.println("Введите команды для собаки через запятую (например, Sit, Stay, Fetch, Bark, Paw, Roll): ");
        String commands = scanner.nextLine();

        return new Dog (animalName, animalType, birthdate, commands);
    }

}
