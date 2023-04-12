package co.develhope.hybernateexercise.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Dopo aver creato la connessione con il db mySql ho creto la classe Student, e l'ho annotata con Data, Entity e
 * Table, in cui l'ho nominata 'students'
 */
@Data
@Entity
@Table(name = "students")
public class Student {
    /**
     * Le ho assegnato le variabili id, lastName, firstName ed email.
     * L'id l'ho annotato con Id e con GeneratedValue per far creare a Hybernate un valore in automatico
     * lastName e firstName le ho rese non nulle
     * email l'ho resa unica
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column(unique = true)
    private String email;
}
