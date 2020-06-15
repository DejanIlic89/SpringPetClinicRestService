package com.comtrade.mapper;

import java.util.List;

import com.comtrade.dto.LjubimacDTO;
import com.comtrade.entity.Ljubimac;

public interface LjubimacMapper {

	LjubimacDTO toLjubimacDTO(Ljubimac ljubimac);
	List<LjubimacDTO> toLjubimacDTOs(List<Ljubimac> listLjubimac);
	Ljubimac toLjubimac(LjubimacDTO ljubimacDTO);
	List<Ljubimac> toLjubimacList(List<LjubimacDTO> lista);
	List<LjubimacDTO> toLjubimacDTOsPoseta(List<Ljubimac> listLjubimac);
}
