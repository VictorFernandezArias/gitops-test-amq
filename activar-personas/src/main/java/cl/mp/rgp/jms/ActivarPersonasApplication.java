package cl.mp.rgp.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication
@EnableScheduling
public class ActivarPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivarPersonasApplication.class, args);
	}


}
