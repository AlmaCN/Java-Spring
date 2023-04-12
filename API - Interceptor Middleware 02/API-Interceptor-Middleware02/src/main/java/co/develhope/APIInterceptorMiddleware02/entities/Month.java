package co.develhope.APIInterceptorMiddleware02.entities;

/**
 * Ho creato l'entita Month con le variabili int monthNumber, String englishName, String italianName e String
 * germanName, aggiungendo construttori, getters e setters.
 */
public class Month {

    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public Month() {
    }

    public Month(int monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }
}
