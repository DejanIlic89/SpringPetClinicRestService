package com.comtrade.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Specijalnost extends ImeEntity {

	@OneToMany(mappedBy = "specijalnost", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	private List<Veterinar> listaVeterinara;

	public List<Veterinar> getListaVeterinara() {
		return listaVeterinara;
	}

	public void setListaVeterinara(List<Veterinar> listaVeterinara) {
		this.listaVeterinara = listaVeterinara;
	}
	
	public void addVeterinar(Veterinar veterinar) {
		listaVeterinara.add(veterinar);
		veterinar.setSpecijalnost(this);
	}
	
	public void removeVeterinar(Veterinar veterinar) {
		listaVeterinara.remove(veterinar);
		veterinar.setSpecijalnost(null);
	}
}
