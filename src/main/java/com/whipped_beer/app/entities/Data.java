package com.whipped_beer.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name ="dados")
public class Data implements Serializable {

 private static final long serialVersionUID = 1L;
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="id_dado")
 private Integer id;
 private double temperatura;
 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
 private LocalDateTime criadoEm;
 
 public Data() {}
 public Data(Integer id, double temperatura, LocalDateTime criadoEm) {
	 this.id = id;
	 this.temperatura = temperatura;
	 this.criadoEm = criadoEm;
 }
 
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public double getTemperatura() {
	return temperatura;
}
public void setTemperatura(double temperatura) {
	this.temperatura = temperatura;
}
public LocalDateTime getCriadoEm() {
	return criadoEm;
}
public void setCriadoEm(LocalDateTime criadoEm) {
	this.criadoEm = criadoEm;
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Data other = (Data) obj;
	return Objects.equals(id, other.id);
}
 
 
	
}