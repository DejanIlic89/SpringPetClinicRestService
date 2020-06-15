package com.comtrade.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comtrade.dto.VlasnikDTO;
import com.comtrade.entity.Vlasnik;

@Component
public class VlasnikMapperImpl implements VlasnikMapper {
	
	private final LjubimacMapper ljubimacMapper;
	
	@Autowired
	public VlasnikMapperImpl(LjubimacMapper ljubimacMapper) {
		super();
		this.ljubimacMapper = ljubimacMapper;
	}

	@Override
	public VlasnikDTO toVlasnikDTO(Vlasnik vlasnik) {
		VlasnikDTO vlasnikDto = new VlasnikDTO();
		vlasnikDto.setId(vlasnik.getId());
		vlasnikDto.setImeVlasnika(vlasnik.getIme());
		vlasnikDto.setListaLjubimaca(ljubimacMapper.toLjubimacDTOs(vlasnik.getListaLjubimaca()));
		return vlasnikDto;
	}
	
	@Override
	public VlasnikDTO toVlasnikDTOPoseta(Vlasnik vlasnik) {
		VlasnikDTO vlasnikDto = new VlasnikDTO();
		vlasnikDto.setId(vlasnik.getId());
		vlasnikDto.setImeVlasnika(vlasnik.getIme());
		vlasnikDto.setListaLjubimaca(ljubimacMapper.toLjubimacDTOsPoseta(vlasnik.getListaLjubimaca()));
		return vlasnikDto;
	}

}
