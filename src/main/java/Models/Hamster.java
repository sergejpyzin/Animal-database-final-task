package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hamster extends Pets {

    private String animalName;
    private String animalType;
    private String birthdate;
    private String commands;
}
