package co.exercises.swagger02.entities;

/**
 * Ho creato la classe ArithmeticOperation a cui ho dato le variabili name, minNumberOfOperands, description ed un
 * array di properties.
 * Ho poi creato costruttore, setters e getters.
 */
public class ArithmeticOperation {

    private String name;
    private int minNumberOfOperands;
    private String description;
    private String[] properties;

    public ArithmeticOperation(String name, int minNumberOfOperands, String description, String[] properties) {
        this.name = name;
        this.minNumberOfOperands = minNumberOfOperands;
        this.description = description;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinNumberOfOperands() {
        return minNumberOfOperands;
    }

    public void setMinNumberOfOperands(int minNumberOfOperands) {
        this.minNumberOfOperands = minNumberOfOperands;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getProperties() {
        return properties;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }
}
