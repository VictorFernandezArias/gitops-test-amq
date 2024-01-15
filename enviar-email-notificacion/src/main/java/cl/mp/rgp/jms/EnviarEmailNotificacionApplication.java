package cl.mp.rgp.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication
@EnableScheduling
public class EnviarEmailNotificacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviarEmailNotificacionApplication.class, args);
	}


}
