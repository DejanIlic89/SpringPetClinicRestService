package com.comtrade.mapper;

import java.util.List;

import com.comtrade.dto.PosetaDTO;
import com.comtrade.entity.Poseta;

public interface PosetaMapper {
	
	public List<PosetaDTO> listaPoseta(List<Poseta> listaPoseta);

	public Poseta toPoseta(PosetaDTO posetaDTO);

	public PosetaDTO toPosetaDto(Poseta poseta);

}
