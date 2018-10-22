package taa.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

// unirest pour la consomation 
@SpringBootApplication
public class SpringbootApplication {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
