package com.comtrade.dto;

import java.util.List;

public class VlasnikDTO {
	
	private int id;
	private String imeVlasnika;
	private List<LjubimacDTO> listaLjubimaca;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImeVlasnika() {
		return imeVlasnika;
	}
	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}
	public List<LjubimacDTO> getListaLjubimaca() {
		return listaLjubimaca;
	}
	public void setListaLjubimaca(List<LjubimacDTO> listaLjubimaca) {
		this.listaLjubimaca = listaLjubimaca;
	}
	
}
