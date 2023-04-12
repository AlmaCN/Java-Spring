package co.develhope.CRUD.entities;

import javax.persistence.*;

/**
 * Ho creato la classe Car annotandola con Entity e Table. Ho poi creato le variabili id, modelName e type.
 * Annotando id con Id e GeneratedValue.
 * Ho poi creato il costruttore vuoto e quello con modelName e type, ed infine i getter ed i setter.
 */
@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String modelName;
    private String type;

    public Car() {
    }

    public Car(String modelName, String type) {
        this.modelName = modelName;
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
