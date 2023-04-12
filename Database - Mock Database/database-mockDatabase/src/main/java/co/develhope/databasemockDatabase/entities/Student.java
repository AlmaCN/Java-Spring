package co.develhope.databasemockDatabase.entities;

import javax.persistence.*;

/**
 * Ho inizializzato il progetto da Spring con le dependencies Web, DevTools, Jpa e H2.
 * Ho modificato il file application da properties a yml ed ho aggiunto le righe necessarie per far comunicare il
 * codice con il database.
 * Ho creato la classe Student annotandola con Entity e con Table, dandole il nome 'students' nel database.
 */
@Entity
@Table(name = "students")
public class Student {

    /**
     * Ho poi creato le variabili:
     * - id, annotandola con Id e GeneratedValue,
     * - firstName,
     * - lastName,
     * - email, annotandola con Column - unique=true.
     *
     * Successivamente ho fatto partire il codice, mi sono connessa con il database attraverso Firefox ed ho
     * visualizzato la tabella come da esempio.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
