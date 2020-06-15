package com.comtrade.service;

import com.comtrade.dto.PosetaDTO;
import com.comtrade.dto.VlasnikDTO;

public interface PosetaService {

	public VlasnikDTO vrati(Integer idVlasnika);

	public void delete(Integer idPosete);

	public PosetaDTO update(Integer idLjubimca, PosetaDTO posetaDTO);

	public PosetaDTO save(Integer idLjubimca, PosetaDTO posetaDTO);
	
}
