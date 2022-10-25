package one.digitalinnovation.cloudparking.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;



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
	@GetMapping
	public ResponseEntity<List<ParkingDTO>> findAll() {
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
		
		}
	
	
	@GetMapping("/{id}")
	public  ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
			Parking parking = parkingService.findById(id);
			ParkingDTO result = parkingMapper.toParkingDTO(parking);
			return ResponseEntity.ok(result);//RETORNA 200
		
		}
	
	
	
	//RETORNA UM OBJETO COMPLETO, MAS PARA CRIAR, SOLICITA SOMENTE ALGUNS ATRIBUTOS CONFORME PARKINGCREATEDTO
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
		
	}
		
		
	

