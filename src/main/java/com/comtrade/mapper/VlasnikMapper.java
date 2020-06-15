package com.comtrade.mapper;

import com.comtrade.dto.VlasnikDTO;
import com.comtrade.entity.Vlasnik;

public interface VlasnikMapper {
	
	VlasnikDTO toVlasnikDTO(Vlasnik vlasnik);
	
	VlasnikDTO toVlasnikDTOPoseta(Vlasnik vlasnik);
}
