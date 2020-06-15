package com.comtrade.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Poseta extends BazniEntitet {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate localDate;
	private String opis;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ljubimac")
	private Ljubimac ljubimac;
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Ljubimac getLjubimac() {
		return ljubimac;
	}
	public void setLjubimac(Ljubimac ljubimac) {
		this.ljubimac = ljubimac;
	}
	
}
