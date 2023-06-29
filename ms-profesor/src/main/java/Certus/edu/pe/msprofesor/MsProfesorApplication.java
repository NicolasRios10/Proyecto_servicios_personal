package Certus.edu.pe.msprofesor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsProfesorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProfesorApplication.class, args);
	}

}
