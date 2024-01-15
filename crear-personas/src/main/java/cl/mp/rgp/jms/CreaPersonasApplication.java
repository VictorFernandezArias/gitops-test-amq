package cl.mp.rgp.jms.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CreaPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreaPersonasApplication.class, args);
	}

}
