package com.comtrade.service;

import java.util.List;

import com.comtrade.entity.LjubimacTip;

public interface LjubimacTipService {
	List<LjubimacTip> listaTipova();

	LjubimacTip findLjubimacTipById(Integer idLjubimacTip);
}
