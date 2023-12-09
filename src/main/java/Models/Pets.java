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
    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getAnimalName() {
        return animalName;
    }

    @Override
    public String getAnimalType() {
        return animalType;
    }

    @Override
    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public String getCommands() {
        return commands;
    }
}
