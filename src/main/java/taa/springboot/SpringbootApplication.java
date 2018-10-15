package taa.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.net.MalformedURLException;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

// unirest pour la consomation 
@SpringBootApplication
public class SpringbootApplication {


	public static void main(String[] args) throws IOException, JSONException {
		//SpringApplication.run(SpringbootApplication.class, args);
        OpenWeatherMap owm = new OpenWeatherMap("35a65db4567ca8fcb9e54cbe84093d8e");

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Paris");

        //printing city name from the retrieved data
        System.out.println("City: " + cwd.getCityName());

        // printing the max./min. temperature
        System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                            + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");

}
