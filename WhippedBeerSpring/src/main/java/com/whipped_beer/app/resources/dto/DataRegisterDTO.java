package com.whipped_beer.app.resources.dto;

import java.time.LocalDate;

import com.whipped_beer.app.entities.Data;

public class DataRegisterDTO {

	
	private Integer id;
	private double temperatura;
	private LocalDate criadoEm;
	
	
	
	public DataRegisterDTO(Data data) {
		this.id = data.getId();
		this.temperatura = data.getTemperatura();
		this.criadoEm = data.getCriadoEm();
	}

	public DataRegisterDTO() {} 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public LocalDate getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}
	public double getTemperatura() {
		// TODO Auto-generated method stub
		return temperatura;

	}
	
	
	
}
