package co.develhope.APISpring.Repositories1.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;

/**
 * Ho creato la classe Car annotandola con Entity e Table
 */
@Entity
@Table(name = "Cars")
public class Car {

    /**
     * Ho poi creato le variabili id(Id e GeneratedValue), modelName(not null), serialNumber(not null) e
     * currentPrice(null)
     * Ho poi creato costruttore vuoto e costruttore con i paramatetri. Ed infine getter e setter
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String modelName;
    @Column(nullable = false)
    private String serialNumber;
    @Nullable
    private double currentPrice;

    public Car() {
    }

    public Car(String modelName, String serialNumber, double currentPrice) {
        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.currentPrice = currentPrice;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
