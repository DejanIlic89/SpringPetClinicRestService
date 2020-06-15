package com.comtrade.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Veterinar extends ImeEntity {
	
	private String prezime;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_specijalnost")
	private Specijalnost specijalnost;
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "veterinar_ljubimac", 
			joinColumns = @JoinColumn(name="id_veterinar"), 
			inverseJoinColumns = @JoinColumn(name="id_ljubimac"))
	private Set<Ljubimac> listaLjubimaca;
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Specijalnost getSpecijalnost() {
		return specijalnost;
	}
	public void setSpecijalnost(Specijalnost specijalnost) {
		this.specijalnost = specijalnost;
	}
	public Set<Ljubimac> getListaLjubimaca() {
		return listaLjubimaca;
	}
	public void setListaLjubimaca(Set<Ljubimac> listaLjubimaca) {
		this.listaLjubimaca = listaLjubimaca;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veterinar other = (Veterinar) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
}
