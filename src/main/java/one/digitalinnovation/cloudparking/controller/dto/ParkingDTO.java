package one.digitalinnovation.cloudparking.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;




//ESSA NOTAÇÃO DE JSON REMOVE OS NULL DA VISUALIZAÇÃO
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {

	private String id;
	private String license; //PLACA DO CARRO
	private String state;
	private String model;
	private String color;
	@JsonFormat(pattern =  "dd/MM/YYYY  HH:mm")
	private LocalDateTime enTryDate; //DATA DE ENTRADA
	@JsonFormat(pattern = "dd/MM/YYYY  HH:mm")
	private LocalDateTime exitDate;  //DATA DE SAIDA
	private Double bill;  // A CONTA
	

	
	
	//GETTERS AND SETTERS
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LocalDateTime getEnTryDate() {
		return enTryDate;
	}
	public void setEnTryDate(LocalDateTime enTryDate) {
		this.enTryDate = enTryDate;
	}
	public LocalDateTime getExitDate() {
		return exitDate;
	}
	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	
	
	
	
	
}
