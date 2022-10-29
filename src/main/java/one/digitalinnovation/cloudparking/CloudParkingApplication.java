package one.digitalinnovation.cloudparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//@ComponentScan(basePackages = {"one.digitalinnovation.cloudparking.service"})

//ESSA NOTAÇÃO REALIZA O MAPEAMENTO DA CONTROLLER
//@ComponentScan(basePackages = {"one.digitalinnovation.cloudparking.controller"})



//ESSA NOTAÇÃO SIGNIFICA QUE SERÁ UMA APLICAÇÃO DO TIPO SPRING, ONDE SERA REALIZADO A INJEÇÃO DE DEPENDENCIA
@SpringBootApplication

public class CloudParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudParkingApplication.class, args);
	}

}
