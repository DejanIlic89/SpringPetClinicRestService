package com.comtrade.service;

import java.util.List;

import com.comtrade.dto.VlasnikDTO;
import com.comtrade.entity.Vlasnik;

public interface VlasnikService {
	
	public Vlasnik save(Vlasnik vlasnik);
	
	public Vlasnik findVlasnikById(Integer id);

	public List<Vlasnik> findVlasnikByPrezime(String prezime);

	public List<Vlasnik> findAll();

	public Vlasnik update(Integer id, Vlasnik vlasnik);

	public void delete(Integer id);

	public VlasnikDTO findVlasnikByDTOId(Integer id);
}
