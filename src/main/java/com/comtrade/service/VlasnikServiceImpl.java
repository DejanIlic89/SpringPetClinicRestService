package com.comtrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.dto.VlasnikDTO;
import com.comtrade.entity.Vlasnik;
import com.comtrade.exception.EntityNotFoundException;
import com.comtrade.mapper.VlasnikMapper;
import com.comtrade.repository.VlasnikRepository;

@Service
public class VlasnikServiceImpl implements VlasnikService {
	
	private final VlasnikRepository vlasnikRepository;
	private final VlasnikMapper vlasnikMapper;
	
	@Autowired
	public VlasnikServiceImpl(VlasnikRepository vlasnikRepository, VlasnikMapper vlasnikMapper) {
		super();
		this.vlasnikRepository = vlasnikRepository;
		this.vlasnikMapper = vlasnikMapper;
	}

	@Override
	@Transactional
	public Vlasnik save(Vlasnik vlasnik) {
		return vlasnikRepository.save(vlasnik);
	}

	@Override
	@Transactional
	public Vlasnik findVlasnikById(Integer id) {
		Vlasnik vlasnik = vlasnikRepository.findVlasnikById(id);
		if(vlasnik==null) {
			throw new EntityNotFoundException("Id za trazenog vlasnika ne postoji " + id); 
		}
		return vlasnik;
	}

	@Override
	@Transactional
	public List<Vlasnik> findVlasnikByPrezime(String prezime) {
		List<Vlasnik> lista = vlasnikRepository.findVlasnikByPrezime(prezime);
		if(lista.size()==0) {
			throw new EntityNotFoundException("Ne postoji nijedan vlasnik za dato prezime!");
		}
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vlasnik> findAll() {
		List<Vlasnik> listaVlasnika = vlasnikRepository.findAll();
		if(listaVlasnika.size()==0) {
			throw new EntityNotFoundException("Ne postoji nijedan vlasnik!");
		}
		return listaVlasnika;
	}

	@Override
	@Transactional
	public Vlasnik update(Integer id, Vlasnik vlasnik) {
		Vlasnik vlasnik1 = vlasnikRepository.findVlasnikById(id);
		if(vlasnik1==null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za dati id " + id);
		}
		if(!vlasnik.equals(vlasnik1)) {
			vlasnik.setId(id);
			vlasnik1 = vlasnikRepository.save(vlasnik);
		}
		return vlasnik1;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Vlasnik vlasnik1 = vlasnikRepository.findVlasnikById(id);
		if(vlasnik1==null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za dati id " + id);
		}
		vlasnikRepository.delete(vlasnik1);
	}

	@Override
	@Transactional
	public VlasnikDTO findVlasnikByDTOId(Integer id) {
		Vlasnik vlasnik1 = vlasnikRepository.findVlasnikById(id);
		if(vlasnik1==null) {
			throw new EntityNotFoundException("Ne postoji vlasnik za dati id " + id);
		}
		return vlasnikMapper.toVlasnikDTO(vlasnik1);
	}

}
