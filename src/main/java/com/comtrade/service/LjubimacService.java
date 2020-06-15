package com.comtrade.service;

import java.util.List;

import com.comtrade.dto.LjubimacDTO;
import com.comtrade.entity.Ljubimac;

public interface LjubimacService {
	public List<Ljubimac> getListaLjubimaca();

	public LjubimacDTO save(Ljubimac ljubimac);

	public void deleteAll(List<LjubimacDTO> lista);

	public LjubimacDTO updateLjubimca(Integer idVlasnika, Integer idLjubimacTip, LjubimacDTO ljubimacDTO);
}
