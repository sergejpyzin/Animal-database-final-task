package Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pets implements Animals{

    private int id;
    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;



    /**
     * Реализация метода получения поля animalName
     * @return - animalName
     */
    @Override
    public String getAnimalName() {
        return animalName;
    }

    /**
     * Реализация метода получения поля animalType
     * @return - animalType
     */
    @Override
    public String getAnimalType() {
        return animalType;
    }

    /**
     * Реализация метода получения поля birthdate
     * @return - birthdate
     */
    @Override
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Реализация метода получения поля commands
     * @return - commands
     */
    @Override
    public String getCommands() {
        return commands;
    }
}
