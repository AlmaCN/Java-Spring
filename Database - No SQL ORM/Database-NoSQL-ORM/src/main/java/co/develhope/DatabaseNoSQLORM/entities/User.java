package co.develhope.DatabaseNoSQLORM.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Ho creato il progetto Spring con le dependencies necessarie per la connessione con un Database MongoDB, ho aperto
 * precedentemente un account gratuito per un MongoDB e ho creato la connessione attraverso la classe
 * MongoDBConfing annotata con Configuration.
 *
 * Ho creato l'entita User, con id, firstName, lastName, email ed age.
 *
 * Ho poi creato la classee UserService in cui ho implementato due metodi, uno per la creazione di un user, ed un
 * altro per poter vedere tutto gli user creati.
 *
 * Ed infine ho creato un UserController per creare le API e poter interagire con PostMan.
 *
 * Ho creato anche un UserRepository per poter salvare i risultati dei metodi nel database.
 */

public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
    private String email;

    private int age;

    public User() {
    }

    public User(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
