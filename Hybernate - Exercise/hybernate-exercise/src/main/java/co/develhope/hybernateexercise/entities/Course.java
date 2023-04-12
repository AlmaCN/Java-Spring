package co.develhope.hybernateexercise.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Ho creato la classe courses annotata con Data, Entity e Table, in cui l'ho chiamata 'classes'
 */
@Data
@Entity
@Table(name = "classes")
public class Course {

    /**
     * Le ho dato le variabili id, title e descirption.
     * id l'ho annotato con Id e GeneratedValue
     * title l'ho reso non nullo
     * description l'ho reso non nullo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

}
