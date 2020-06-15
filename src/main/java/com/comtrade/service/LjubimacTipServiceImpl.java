package com.comtrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comtrade.entity.LjubimacTip;
import com.comtrade.repository.LjubimacTipRepository;

@Service
public class LjubimacTipServiceImpl implements LjubimacTipService {
	
	private final LjubimacTipRepository ljubimacTipRepository;
	
	@Autowired
	public LjubimacTipServiceImpl(LjubimacTipRepository ljubimacTipRepository) {
		super();
		this.ljubimacTipRepository = ljubimacTipRepository;
	}

	@Override
	@Transactional
	public List<LjubimacTip> listaTipova() {
		return ljubimacTipRepository.findAll();
	}

	@Override
	@Transactional
	public LjubimacTip findLjubimacTipById(Integer idLjubimacTip) {
		return ljubimacTipRepository.findLjubimacTipById(idLjubimacTip);
	}

}
