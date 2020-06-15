package com.comtrade.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comtrade.dto.LjubimacDTO;
import com.comtrade.entity.Ljubimac;

@Component
public class LjubimacMapperImpl implements LjubimacMapper {
	
	@Autowired
	private PosetaMapper posetaMapper;

	@Override
	public LjubimacDTO toLjubimacDTO(Ljubimac ljubimac) {
		LjubimacDTO ljubimacDto = new LjubimacDTO();
		ljubimacDto.setId(ljubimac.getId());
		ljubimacDto.setIme(ljubimac.getIme());
		return ljubimacDto;
	}

	@Override
	public List<LjubimacDTO> toLjubimacDTOs(List<Ljubimac> listLjubimac) {
		List<LjubimacDTO> listaLjubimacDTO = new ArrayList<LjubimacDTO>();
		for (Ljubimac ljubimac : listLjubimac) {
			LjubimacDTO ljubimacDto = new LjubimacDTO();
			ljubimacDto.setId(ljubimac.getId());
			ljubimacDto.setIme(ljubimac.getIme());
			listaLjubimacDTO.add(ljubimacDto);
		}
		return listaLjubimacDTO;
	}

	@Override
	public Ljubimac toLjubimac(LjubimacDTO ljubimacDTO) {
		Ljubimac ljubimac = new Ljubimac();
		ljubimac.setId(ljubimacDTO.getId());
		ljubimac.setIme(ljubimacDTO.getIme());
		return ljubimac;
	}

	@Override
	public List<Ljubimac> toLjubimacList(List<LjubimacDTO> lista) {
		List<Ljubimac> listaLjubimaca = new ArrayList<Ljubimac>();
		for (LjubimacDTO ljubimacDTO : lista) {
			Ljubimac ljubimac = new Ljubimac();
			ljubimac.setId(ljubimacDTO.getId());
			ljubimac.setIme(ljubimacDTO.getIme());
			listaLjubimaca.add(ljubimac);
		}
		return listaLjubimaca;
	}

	@Override
	public List<LjubimacDTO> toLjubimacDTOsPoseta(List<Ljubimac> listLjubimac) {
		List<LjubimacDTO> listaLjubimacDTO = new ArrayList<LjubimacDTO>();
		for (Ljubimac ljubimac : listLjubimac) {
			LjubimacDTO ljubimacDto = new LjubimacDTO();
			ljubimacDto.setId(ljubimac.getId());
			ljubimacDto.setIme(ljubimac.getIme());
			ljubimacDto.setListaPoseta(posetaMapper.listaPoseta(ljubimac.getListaPoseta()));
			listaLjubimacDTO.add(ljubimacDto);
		}
		return listaLjubimacDTO;
	}
	
}
