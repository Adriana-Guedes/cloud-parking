package one.digitalinnovation.cloudparking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//ISSO SUBSTITUI O CODIGO DE ERRO DE RETORNO APENAS PELO TEXTINHO DA EXCEÇÃO
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException {
	
	public ParkingNotFoundException(String id) {
		super("Parking not found with id: " + id);
	}

}
