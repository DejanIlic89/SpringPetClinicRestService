package com.comtrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comtrade.dto.PosetaDTO;
import com.comtrade.dto.VlasnikDTO;
import com.comtrade.service.PosetaService;

@RestController
@RequestMapping(value = "/api/posete")
public class PosetaController {
	
	private final PosetaService posetaService;
	
	@Autowired
	public PosetaController(PosetaService posetaService) {
		super();
		this.posetaService = posetaService;
	}

	@GetMapping(value = "/{idVlasnika}")
	public ResponseEntity<VlasnikDTO> vratiVlasnike(@PathVariable Integer idVlasnika) {
		return new ResponseEntity<VlasnikDTO>(posetaService.vrati(idVlasnika), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{idPosete}")
	public ResponseEntity<String> obrisiPosetu(@PathVariable Integer idPosete) {
		posetaService.delete(idPosete);
		return new ResponseEntity<String>("Obrisana poseta..", HttpStatus.OK);
	}
	
	@PutMapping(value = "/updatePosete/{idLjubimca}")
	public ResponseEntity<PosetaDTO> updatePoseta(@PathVariable Integer idLjubimca, @RequestBody PosetaDTO posetaDTO) {
		return new ResponseEntity<PosetaDTO>(posetaService.update(idLjubimca, posetaDTO), HttpStatus.OK);
	}
	
	@PostMapping(value = "/createPoseta/{idLjubimca}")
	public ResponseEntity<PosetaDTO> addPoseta(@PathVariable Integer idLjubimca, @RequestBody PosetaDTO posetaDTO) {
		return new ResponseEntity<PosetaDTO>(posetaService.save(idLjubimca, posetaDTO), HttpStatus.OK);
	}

}
