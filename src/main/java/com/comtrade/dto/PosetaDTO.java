package com.comtrade.dto;

import java.time.LocalDate;

public class PosetaDTO {
	
	private int idPosete;
	private LocalDate datum_posete;
	private String opis;
	public int getIdPosete() {
		return idPosete;
	}
	public void setIdPosete(int idPosete) {
		this.idPosete = idPosete;
	}
	public LocalDate getDatum_posete() {
		return datum_posete;
	}
	public void setDatum_posete(LocalDate datum_posete) {
		this.datum_posete = datum_posete;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	

}
