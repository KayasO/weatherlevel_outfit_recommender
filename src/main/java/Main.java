import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        WeatherLevel weatherLevel = new WeatherLevel("258489e1caa7536430a9525ad426a131");
        String zipCode = "31785";
        Locale locale = Locale.GERMANY;
        int level = weatherLevel.getLevel(zipCode, locale);

        System.out.println("Zipcode: " + zipCode);
        System.out.println("Place: " + locale);
        System.out.println("Level: " + level);

        // "100-2101", Locale.JAPAN
        // "31785",    Locale.GERMANY
    }
}