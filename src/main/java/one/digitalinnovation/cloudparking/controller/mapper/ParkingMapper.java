package one.digitalinnovation.cloudparking.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.model.Parking;


//RESPONSAVEL PARA FAZER A CONVERSÃO DE PARKINGdto PARA PARKINGLIST  DO GETALL DO PARKINGsERVICE
@Component
public class ParkingMapper {
	
	private ModelMapper MODEL_MAPPER = new ModelMapper();
	
	//ESSE METODO VAI CRIAR O OBJETO E PASSAR TODOS OS ATRIBUTO PARA O OUTRO OBJETO, OU SEJA, CONVERTE DE ENTITY PARA DTO
	public ParkingDTO toParkingDTO(Parking parking) {
		return MODEL_MAPPER.map(parking, ParkingDTO.class );//VAI RETORNAR O OBJETO DO PARKING(ENTITY) PARA UM DTO
	}
	

	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList){
		return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
		
	}
	
	//CONVERSÃO DE DTO PARA ENTITY
	public Parking ToParking (ParkingDTO dto){
		return MODEL_MAPPER.map(dto, Parking.class);
	}
	
	public Parking  ToParkingCreate(ParkingCreateDTO dto) {
		return MODEL_MAPPER.map(dto, Parking.class);
		
	}

}
