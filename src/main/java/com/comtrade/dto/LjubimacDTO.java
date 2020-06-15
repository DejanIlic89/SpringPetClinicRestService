package com.comtrade.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class LjubimacDTO {
	
	private int id;
	@NotBlank(message = "Ime mora imati vrednost!")
	private String ime;
	private List<PosetaDTO> listaPoseta;
	
	public List<PosetaDTO> getListaPoseta() {
		return listaPoseta;
	}
	public void setListaPoseta(List<PosetaDTO> listaPoseta) {
		this.listaPoseta = listaPoseta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
}
