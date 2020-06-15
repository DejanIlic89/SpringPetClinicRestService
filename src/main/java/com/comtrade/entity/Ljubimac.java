package com.comtrade.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ljubimac extends ImeEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vlasnika")
	private Vlasnik vlasnik;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tip")
	private LjubimacTip ljubimacTip;
	
	@OneToMany(mappedBy = "ljubimac", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Poseta> listaPoseta;
	
	@ManyToMany(mappedBy = "listaLjubimaca")
	private Set<Veterinar> listaVeterinara;

	public Set<Veterinar> getListaVeterinara() {
		return listaVeterinara;
	}

	public void setListaVeterinara(Set<Veterinar> listaVeterinara) {
		this.listaVeterinara = listaVeterinara;
	}

	public List<Poseta> getListaPoseta() {
		return listaPoseta;
	}

	public void setListaPoseta(List<Poseta> listaPoseta) {
		this.listaPoseta = listaPoseta;
	}

	public Vlasnik getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Vlasnik vlasnik) {
		this.vlasnik = vlasnik;
	}

	public LjubimacTip getLjubimacTip() {
		return ljubimacTip;
	}

	public void setLjubimacTip(LjubimacTip ljubimacTip) {
		this.ljubimacTip = ljubimacTip;
	}
	
	public void addPoseta(Poseta poseta) {
		listaPoseta.add(poseta);
		poseta.setLjubimac(this);
	}
	
	public void removePoseta(Poseta poseta) {
		listaPoseta.remove(poseta);
		poseta.setLjubimac(null);
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
		Ljubimac other = (Ljubimac) obj;
		if (this.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!this.getId().equals(other.getId()))
			return false;
		return true;
	}
	
}
