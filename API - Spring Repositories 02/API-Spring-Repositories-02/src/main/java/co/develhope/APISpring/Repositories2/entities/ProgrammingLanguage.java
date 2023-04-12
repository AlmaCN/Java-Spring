package co.develhope.APISpring.Repositories2.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;

/**
 * Ho creato la calsse ProgrammingLanguage che ho annotato con Entity e Table.
 */
@Entity
@Table
public class ProgrammingLanguage {

    /**
     * Ho poi aggiunto le variabili id(Id e GeneratedValue), name(not null), firstAppearance(null) e inventor(not null)
     * Ho poi aggiunto costruttore vuoto e non, e getter e setter
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Nullable
    private int firstAppearance;
    @Column(nullable = false)
    private String inventor;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(String name, int firstAppearance, String inventor) {
        this.name = name;
        this.firstAppearance = firstAppearance;
        this.inventor = inventor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(int firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }
}
