package com.comtrade.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comtrade.dto.PosetaDTO;
import com.comtrade.dto.VlasnikDTO;
import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.Poseta;
import com.comtrade.entity.Vlasnik;
import com.comtrade.exception.EntityNotFoundException;
import com.comtrade.exception.EntityServerErrorException;
import com.comtrade.mapper.PosetaMapper;
import com.comtrade.mapper.VlasnikMapper;
import com.comtrade.repository.LjubimacRepository;
import com.comtrade.repository.PosetaRepository;
import com.comtrade.repository.VlasnikRepository;

@Service
public class PosetaServiceImp implements PosetaService {
	
	private final VlasnikRepository vlasnikRepository;
	private final VlasnikMapper vlasnikMapper;
	private final PosetaRepository posetaRepository;
	private final LjubimacRepository ljubimacRepository;
	private final PosetaMapper posetaMapper;
	
	@Autowired
	public PosetaServiceImp(
			VlasnikRepository vlasnikRepository, 
			VlasnikMapper vlasnikMapper, 
			PosetaRepository posetaRepository,
			LjubimacRepository ljubimacRepository,
			PosetaMapper posetaMapper
	) {
		super();
		this.vlasnikRepository = vlasnikRepository;
		this.vlasnikMapper = vlasnikMapper;
		this.posetaRepository = posetaRepository;
		this.ljubimacRepository = ljubimacRepository;
		this.posetaMapper = posetaMapper;
	}

	@Override
	@Transactional
	public VlasnikDTO vrati(Integer idVlasnika) {
		Vlasnik vlasnik = vlasnikRepository.findVlasnikById(idVlasnika);
		if(vlasnik == null) throw new EntityNotFoundException("Ne postoji vlasnik za id " + idVlasnika);
		return vlasnikMapper.toVlasnikDTOPoseta(vlasnik);
	}

	@Override
	@Transactional
	public void delete(Integer idPosete) {
		Poseta poseta = posetaRepository.findPosetaById(idPosete);
		if(poseta == null) throw new EntityNotFoundException("Ne postoji poseta za id");
		posetaRepository.delete(poseta);
	}

	@Override
	@Transactional
	public PosetaDTO update(Integer idLjubimca, PosetaDTO posetaDTO) {
		Ljubimac ljubimac = ljubimacRepository.findLjubimacById(idLjubimca);
		if(ljubimac == null) throw new EntityNotFoundException("Takav Ljubimac ne postoji");
		Poseta poseta = posetaMapper.toPoseta(posetaDTO);
		try {
			poseta.setLjubimac(ljubimac);
			poseta = posetaRepository.save(poseta);
		} catch (Exception e) {
			throw new EntityServerErrorException("Nisu update-ovani podaci");
		}
		return posetaMapper.toPosetaDto(poseta);
	}

	@Override
	@Transactional
	public PosetaDTO save(Integer idLjubimca, PosetaDTO posetaDTO) {
		Ljubimac ljubimac = ljubimacRepository.findLjubimacById(idLjubimca);
		if(ljubimac == null) throw new EntityNotFoundException("Takav Ljubimac ne postoji");
		
		Poseta poseta = posetaMapper.toPoseta(posetaDTO);
		try {
			poseta.setLjubimac(ljubimac);
			poseta = posetaRepository.save(poseta);
		} catch (Exception e) {
			throw new EntityServerErrorException("Nisu upisani podaci");
		}
		return posetaMapper.toPosetaDto(poseta);
	}

}
