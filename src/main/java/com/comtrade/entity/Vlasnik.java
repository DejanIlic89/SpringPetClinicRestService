package com.comtrade.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about the Vlasnik")
public class Vlasnik extends BazniEntitet {
	@NotBlank(message = "Ime mora imati vrednost!")
	@ApiModelProperty(notes = "The Vlasnik's name")
	private String ime;
	@NotBlank(message = "Prezime mora imati vrednost!")
	@ApiModelProperty(notes = "The Vlasnik's surename")
	private String prezime;
	@NotBlank(message = "Grad mora imati vrednost!")
	private String grad;
	private String adresa;
	@Size(min = 10, max = 15, message = "Unesite ispravan broj telefona!")
	private String telefon;
	@OneToMany(mappedBy = "vlasnik", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Ljubimac> listaLjubimaca = new ArrayList<Ljubimac>();
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public List<Ljubimac> getListaLjubimaca() {
		return listaLjubimaca;
	}
	public void setListaLjubimaca(List<Ljubimac> listaLjubimaca) {
		this.listaLjubimaca = listaLjubimaca;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		return prime;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vlasnik other = (Vlasnik) obj;
		if (adresa == null) {
			if (other.adresa != null)
				return false;
		} else if (!adresa.equals(other.adresa))
			return false;
		if (grad == null) {
			if (other.grad != null)
				return false;
		} else if (!grad.equals(other.grad))
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		if (telefon == null) {
			if (other.telefon != null)
				return false;
		} else if (!telefon.equals(other.telefon))
			return false;
		return true;
	}
	
	public void addLjubimac(Ljubimac ljubimac) {
		listaLjubimaca.add(ljubimac);
		ljubimac.setVlasnik(this);
	}
	
	public void removeLjubimac(Ljubimac ljubimac) {
		listaLjubimaca.remove(ljubimac);
		ljubimac.setVlasnik(null);
	}
	
}
