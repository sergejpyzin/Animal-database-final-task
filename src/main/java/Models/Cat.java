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
public class Cat extends Pets {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;

    /**
     * Статический метод создания экземпляра класса Cat.
     * Наследник класса Pets
     * @return - экземпляр класса Cat
     */
    public static Cat creatingCat () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя кота/кошки: ");
        String animalName = scanner.nextLine();

        String animalType = "Cat";

        System.out.println("Введите дату рождения кота/кошки (гггг-мм-дд): ");
        String birthdate = scanner.nextLine();

        System.out.println("Введите команды для кота/кошки через запятую (например, Sit, Stay, Pounce, Scratch, Mew, Jump): ");
        String commands = scanner.nextLine();

        return new Cat (animalName, animalType, birthdate, commands);
    }

}
