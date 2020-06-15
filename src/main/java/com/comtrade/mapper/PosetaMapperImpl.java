package com.comtrade.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.comtrade.dto.PosetaDTO;
import com.comtrade.entity.Poseta;

@Component
public class PosetaMapperImpl implements PosetaMapper {

	@Override
	public List<PosetaDTO> listaPoseta(List<Poseta> listaPoseta) {
		List<PosetaDTO> listaPosetaDto = new ArrayList<PosetaDTO>();
		for(Poseta p : listaPoseta) {
			PosetaDTO pdto = new PosetaDTO();
			pdto.setIdPosete(p.getId());
			pdto.setDatum_posete(p.getLocalDate());
			pdto.setOpis(p.getOpis());
			listaPosetaDto.add(pdto);
		}
		return listaPosetaDto;
	}

	@Override
	public Poseta toPoseta(PosetaDTO posetaDTO) {
		Poseta poseta = new Poseta();
		poseta.setId(posetaDTO.getIdPosete());
		poseta.setOpis(posetaDTO.getOpis());
		poseta.setLocalDate(posetaDTO.getDatum_posete());
		return poseta;
	}

	@Override
	public PosetaDTO toPosetaDto(Poseta poseta) {
		PosetaDTO posetaDto = new PosetaDTO();
		posetaDto.setIdPosete(poseta.getId());
		posetaDto.setOpis(poseta.getOpis());
		posetaDto.setDatum_posete(poseta.getLocalDate());
		return posetaDto;
	}

}
