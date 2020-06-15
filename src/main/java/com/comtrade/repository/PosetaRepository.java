package com.comtrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comtrade.entity.Poseta;

@Repository
public interface PosetaRepository extends JpaRepository<Poseta, Integer> {

	Poseta findPosetaById(Integer idPosete);

}
