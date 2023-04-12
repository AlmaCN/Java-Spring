package co.develhope.ServiziEmail1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ho creato la classe student con le variabili id, name, surname ed email
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id;
    private String name;
    private String surname;
    private String email;
}
