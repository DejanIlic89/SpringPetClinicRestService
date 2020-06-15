package com.comtrade.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ImeEntity extends BazniEntitet {

	private String ime;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
}
