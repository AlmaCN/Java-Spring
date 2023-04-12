package co.develhope.hybernateexercise.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Ho creato la classe Enrollments annotandola con Entity e Table
 */
@Entity
@Table
public class Enrollments {

    /**
     * Le ho dato le variabili id, Lista di Course e Lista di Student
     * L'id l'ho annotato con Id e con GeneratedValue per far creare a Hybernate un valore in automatico
     * Lista di Course l'ho annotata con OneToMany (perche uno Student puo avere piu Courses)
     * Lista di Srudent l'ho annotata con OneToMany (perche un Course puo avere piu Students)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Course> courses;

    @OneToMany
    private List<Student> students;
}
