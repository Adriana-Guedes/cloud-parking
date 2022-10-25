package one.digitalinnovation.cloudparking.service;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinnovation.cloudparking.model.Parking;


@Service
public class ParkingService {

	
	//LISTA MOKADA SUBSTIUI BANCO DE DADOS
	private static Map<String, Parking> parkingMap = new HashMap<>(); 
	
	static {
		var id  = getUIID();
		var id1  = getUIID();
		Parking parking =  new Parking(id, "DMS-1111", "SC", "CELTA", "PRETO");
		Parking parking1 = new Parking(id1, "WAS-1234", "SP", "VW GOL", "VERMELHO");
		parkingMap.put(id,  parking);
		parkingMap.put(id1, parking1);
	}
	
	
	//METODO DE LISTAR TODOS
	public List<Parking> findAll(){
		//PEGANDO TUDO QUE ESTA DENTRO DO PARKINGMAP E TRANSFORMANDO ELE NUMA LISTA
		return parkingMap.values().stream().collect(Collectors.toList());
	}
	
	
	
	
	//GERA UM ID RANDOMICAMENTE SENDO UNICO PARA CADA REQUISIÇÃO
	private static String getUIID() {
		return UUID.randomUUID().toString().replace("-", "");
		
		
	}
	
	
	//METODO DE LISTAR POR ID
	public Parking findById(String id){
			return parkingMap.get(id);
	}
	
	//METODO DE CRIAÇÃO
	
	public Parking create(Parking parkingCreate){
		String uuid = getUIID();
		parkingCreate.setId(uuid);
		parkingCreate.setEnTryDate(LocalDateTime.now());
		parkingMap.put(uuid, parkingCreate);
		return parkingCreate;
}
	
	
}
