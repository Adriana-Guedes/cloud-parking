package one.digitalinnovation.cloudparking.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;



@Configuration
public class SwaggerConfig {
	
	
	@Bean
	//METODO PADRÃO NECESSÁRIO PARA INICIALIZAR
	public OpenAPI openApi() {
		
		return new OpenAPI()
				.info(new Info()
				.title("Parking REST API")	
				.description("Spring Boot REST API for parking")
				.version("1.0.0"));
	}
	
	
	
}