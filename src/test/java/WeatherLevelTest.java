import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WeatherLevelTest {

    private static final String API_KEY = "258489e1caa7536430a9525ad426a131";

    private WeatherLevel weatherLevel;

    @BeforeMethod
    public void beforeMethod() {
        weatherLevel = new WeatherLevel(API_KEY);
    }

    @Test
    public void returnsLevelFiveForExistingZipCode() {
        int level = weatherLevel.getLevel("31785", Locale.GERMANY);
        Assert.assertEquals(level, 5);
    }

    @Test
    public void returnsLevelThreeForExistingZipCode() {
        int level = weatherLevel.getLevel("100-2101", Locale.JAPAN);
        Assert.assertEquals(level, 2);
    }

    @Test
    public void returnsMinusOneForNonExistingZipCode() {
        int level = weatherLevel.getLevel("9999999", Locale.CANADA);
        Assert.assertEquals(level, -1);
    }
}
