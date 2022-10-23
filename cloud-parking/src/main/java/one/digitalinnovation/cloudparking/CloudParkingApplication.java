package one.digitalinnovation.cloudparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



//ESSA NOTAÇÃO SIGNIFICA QUE SERÁ UMA APLICAÇÃO DO TIPO SPRING, ONDE SERA REALIZADO A INJEÇÃO DE DEPENDENCIA
@SpringBootApplication
//ESSA NOTAÇÃO REALIZA O MAPEAMENTO DA CONTROLLER
@ComponentScan(basePackages = {"one.digitalinnovation.controller"})
public class CloudParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudParkingApplication.class, args);
	}

}
