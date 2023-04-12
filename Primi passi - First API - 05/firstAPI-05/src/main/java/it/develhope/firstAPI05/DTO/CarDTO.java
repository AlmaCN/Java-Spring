package it.develhope.firstAPI05.DTO;

import jakarta.validation.constraints.NotBlank;

/**
 * Ho creato una classe DTO chiamata CarDTO
 */
public class CarDTO {

    /**
     * Le ho assengato tre variabili, id, modelName e price. Le prime due le ho annotate come obbligarie.
     * Ho poi create getters, setters, costruttore e metodo toString().
     */
    @NotBlank(message = "Mandatory")
    private String id;
    @NotBlank(message = "Mandatory")
    private String modelName;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id='" + id + '\'' +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                '}';
    }

    public CarDTO(String id, String modelName, double price) {
        this.id = id;
        this.modelName = modelName;
        this.price = price;
    }
}
