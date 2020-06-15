package com.comtrade.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.LjubimacTip;
import com.comtrade.entity.Vlasnik;
import com.comtrade.exception.EntityNotFoundException;
import com.comtrade.service.LjubimacService;
import com.comtrade.service.LjubimacTipService;
import com.comtrade.service.VlasnikService;

@Component
public class LjubimacFasadaImpl implements LjubimacFasada {
	
	private final VlasnikService vlasnikService;
	private final LjubimacService ljubimacService;
	private final LjubimacTipService ljubimacTipService;
	
	@Autowired
	public LjubimacFasadaImpl(VlasnikService vlasnikService,
			LjubimacService ljubimacService, LjubimacTipService ljubimacTipService) {
		super();
		this.vlasnikService = vlasnikService;
		this.ljubimacService = ljubimacService;
		this.ljubimacTipService = ljubimacTipService;
	}

	@Override
	public LjubimacDTO save(Integer idVlasnika, Integer idLjubimacTip, LjubimacDTO ljubimacDTO) {
		Vlasnik vlasnik = vlasnikService.findVlasnikById(idVlasnika);
		if(vlasnik==null) throw new EntityNotFoundException("Ne postoji vlasnik za id: " + idVlasnika);
		
		LjubimacTip ljubimacTip = ljubimacTipService.findLjubimacTipById(idLjubimacTip);
		if(ljubimacTip == null) throw new EntityNotFoundException("Ne postoji tip za id: " + idLjubimacTip);
		
		Ljubimac ljubimac = new Ljubimac();
		ljubimac.setIme(ljubimacDTO.getIme());
		ljubimac.setVlasnik(vlasnik);
		ljubimac.setLjubimacTip(ljubimacTip);
		LjubimacDTO ljubimacDTO2 = ljubimacService.save(ljubimac);
		return ljubimacDTO2;
	}

}
