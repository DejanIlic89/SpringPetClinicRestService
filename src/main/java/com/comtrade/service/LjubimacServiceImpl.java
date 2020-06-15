package com.comtrade.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.dto.LjubimacDTO;
import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.LjubimacTip;
import com.comtrade.entity.Vlasnik;
import com.comtrade.exception.EntityNotFoundException;
import com.comtrade.mapper.LjubimacMapper;
import com.comtrade.repository.LjubimacRepository;
import com.comtrade.repository.VlasnikRepository;

@Service
public class LjubimacServiceImpl implements LjubimacService {

	private final LjubimacRepository ljubimacRepository;
	private final LjubimacMapper ljubimacMapper;
	private final VlasnikRepository vlasnikRepository;
	private final LjubimacTipService ljubimacTipService;
	
	@Autowired
	public LjubimacServiceImpl(VlasnikRepository vlasnikRepository, LjubimacRepository ljubimacRepository, 
			LjubimacMapper ljubimacMapper, LjubimacTipService ljubimacTipService) {
		super();
		this.ljubimacRepository = ljubimacRepository;
		this.ljubimacMapper = ljubimacMapper;
		this.vlasnikRepository = vlasnikRepository;
		this.ljubimacTipService = ljubimacTipService;
	}

	@Override
	@Transactional
	public List<Ljubimac> getListaLjubimaca() {
		return ljubimacRepository.findAll();
	}

	@Override
	@Transactional
	public LjubimacDTO save(Ljubimac ljubimac) {
		ljubimac = ljubimacRepository.save(ljubimac);
		return ljubimacMapper.toLjubimacDTO(ljubimac);
	}

	@Override
	@Transactional
	public void deleteAll(List<LjubimacDTO> lista) {
		List<Ljubimac> listaLjubimaca = ljubimacMapper.toLjubimacList(lista);
//		ljubimacRepository.deleteAll(listaLjubimaca); //???
		for(Iterator<Ljubimac> it = listaLjubimaca.iterator(); it.hasNext();) {
			Ljubimac ljubimac = it.next();
			ljubimacRepository.deleteById(ljubimac.getId());
		}
	}

	@Override
	@Transactional
	public LjubimacDTO updateLjubimca(Integer idVlasnika, Integer idLjubimacTip, LjubimacDTO ljubimacDTO) {
		Vlasnik vlasnik1 = vlasnikRepository.findVlasnikById(idVlasnika);
		if(vlasnik1==null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za dati id " + idVlasnika);
		}
		LjubimacTip ljubimacTip = ljubimacTipService.findLjubimacTipById(idLjubimacTip);
		if(ljubimacTip == null) {
			throw new EntityNotFoundException("Ne postoji tip za id: " + idLjubimacTip);
		}
		Ljubimac ljubimac = ljubimacMapper.toLjubimac(ljubimacDTO);
		try {
			ljubimac.setLjubimacTip(ljubimacTip);
			ljubimac.setVlasnik(vlasnik1);
			ljubimacRepository.save(ljubimac);
		} catch (Exception e) {
			throw new EntityNotFoundException("Nije sacuvan podatak");
		}
		return ljubimacMapper.toLjubimacDTO(ljubimac);
	}

}
