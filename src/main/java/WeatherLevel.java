import java.util.Locale;
import java.util.Optional;

import com.github.eddykaya.openweather.client.OpenWeatherClient;
import com.github.eddykaya.openweather.entities.external.CurrentWeather;

public class WeatherLevel {

    private OpenWeatherClient client;

    public WeatherLevel(String apiKey) {
        this.client = new OpenWeatherClient(apiKey);
    }

    public int getLevel(String zipCode, Locale locale) {
        Optional<CurrentWeather> currentWeather = client.fetchCurrentWeatherAt(zipCode, locale);
        int level = -1;

        if (currentWeather.isPresent()) {
            level = chooseLevel(currentWeather.get().getCurrentTemperature());
        }

        return level;
    }

    private int chooseLevel(double temperature) {
        int level;

        if (temperature > 26) {
            level = 1;
        } else if (temperature > 21) {
            level = 2;
        } else if (temperature > 15) {
            level = 3;
        } else if (temperature > 5) {
            level = 4;
        } else {
            level = 5;
        }

        return level;
    }
}
