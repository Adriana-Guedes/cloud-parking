package one.digitalinnovation.cloudparking.model;

import java.time.LocalDateTime;

public class Parking {
	
	
	private String id;
	private String license; //PLACA DO CARRO
	private String state;
	private String model;
	private String color;
	private LocalDateTime enTryDate; //DATA DE ENTRADA
	private LocalDateTime exitDate;  //DATA DE SAIDA
	private Double bill;  // A CONTA
	
		
	
	
	
	public Parking() {
		super();
	}



	//CONSTRUTOR
	public Parking(String id, String license, String state, String model, String color) {
		super();
		this.id = id;
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;

	}
	
	
	
	
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
