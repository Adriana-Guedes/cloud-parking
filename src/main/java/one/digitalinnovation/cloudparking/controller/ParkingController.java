package one.digitalinnovation.cloudparking.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.cloudparking.constantes.Messages;
import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;


@Tag(name= Messages.SWAGGER_TAG_PARKING_ENDPOINT)
@RestController
@RequestMapping("/parking")
public class ParkingController {


	
	private  final ParkingService parkingService ;
	
	
	private  final ParkingMapper  parkingMapper; 
	
	
	//CONSTRUTOR DE INJEÇÃO DE DEPENDENCIA 
	public ParkingController(ParkingService parkingService, ParkingMapper  parkingMapper ) {
		this.parkingService = parkingService;
		this.parkingMapper = parkingMapper;
	}

	
	
	
	//RESPONSE ENTITY É UM RECURSO DO SPRING ( EXEMPLO RESULTADO 200, 400 ETC) E DENTRO DELE ENCAPSULADO A LISTA
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@GetMapping
	public ResponseEntity<List<ParkingDTO>> findAll() {
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
		
		}
	
	@Operation(description = Messages.SWAGGER_GET)
	@GetMapping("/{id}")
	public  ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
			Parking parking = parkingService.findById(id);
			ParkingDTO result = parkingMapper.toParkingDTO(parking);
			return ResponseEntity.ok(result);//RETORNA 200
		
		}
	
	
	
	//RETORNA UM OBJETO COMPLETO, MAS PARA CRIAR, SOLICITA SOMENTE ALGUNS ATRIBUTOS CONFORME PARKINGCREATEDTO
	@Operation(description = Messages.SWAGGER_INSERT)
	@PostMapping
	public  ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
			var parkingCreate  = parkingMapper.ToParkingCreate(dto);
			//CONVERTE PARA OBJETO DOMINIO
			var parking = parkingService.create(parkingCreate);
			//DEPOIS CONVERTE PARA DTO
			var result = parkingMapper.toParkingDTO(parking);
			//RETORNO A URI DO OBJETO CRIADO
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		
		}
	
	
	@Operation(description = Messages.SWAGGER_UPDATE)
	@PutMapping("/{id}")
	public  ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingCreateDTO) {
			Parking parkingUpdate  = parkingMapper.ToParkingCreate(parkingCreateDTO);
			Parking parking = parkingService.update(id, parkingUpdate);
			return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
		
		}
	
	
	@Operation(description = Messages.SWAGGER_DELETE)
	@DeleteMapping ("/{id}")
	public  ResponseEntity delete(@PathVariable String id) {
			parkingService.delete(id);
			return ResponseEntity.noContent().build();
		
		}
	
	//METODO DE SAIDA DO ESTACIONAMENTO
	@PostMapping("/{id}")
	public  ResponseEntity<ParkingDTO> exit(@PathVariable String id) {
			Parking parking = parkingService.exit(id);
			return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
		
		}
	
	
		
	}
		
		
	

