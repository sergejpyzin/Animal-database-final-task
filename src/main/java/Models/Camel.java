package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Camel extends PackAnimals {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;

}