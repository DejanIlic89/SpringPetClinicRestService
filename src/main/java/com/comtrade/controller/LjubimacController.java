package com.comtrade.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comtrade.dto.LjubimacDTO;
import com.comtrade.dto.LjubimacFasada;
import com.comtrade.dto.VlasnikDTO;
import com.comtrade.entity.LjubimacTip;
import com.comtrade.mapper.LjubimacMapper;
import com.comtrade.service.LjubimacService;
import com.comtrade.service.LjubimacTipService;
import com.comtrade.service.ValidatorService;
import com.comtrade.service.VlasnikService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/ljubimci")
public class LjubimacController {
	
	Logger logger = LoggerFactory.getLogger(LjubimacController.class);
	
	private final LjubimacMapper ljubimacMapper;
	private final LjubimacService ljubimacService;
	private final LjubimacTipService ljubimacTipService;
	private final VlasnikService vlasnikService;
	private final LjubimacFasada ljubimacFasada;
	private final ValidatorService validatorService;
	
	@Autowired
	public LjubimacController(LjubimacMapper ljubimacMapper, LjubimacService ljubimacService, 
			VlasnikService vlasnikService, LjubimacTipService ljubimacTipService, LjubimacFasada ljubimacFasada, ValidatorService validatorService) {
		super();
		this.ljubimacMapper = ljubimacMapper;
		this.ljubimacService = ljubimacService;
		this.vlasnikService = vlasnikService;
		this.ljubimacTipService = ljubimacTipService;
		this.ljubimacFasada = ljubimacFasada;
		this.validatorService = validatorService;
	}
	
	@GetMapping
	public ResponseEntity<List<LjubimacDTO>> findAll() {
		logger.trace("findAll for pets method accessed");
		List<LjubimacDTO> ljubimacDTOs = ljubimacMapper.toLjubimacDTOs(ljubimacService.getListaLjubimaca());
		return new ResponseEntity<List<LjubimacDTO>>(ljubimacDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/vlasnik/{id}/listaLjubimaca")
	public ResponseEntity<VlasnikDTO> listaLjubimacaZaVlasnika(@PathVariable Integer id) {
		VlasnikDTO vlasnikDTO = vlasnikService.findVlasnikByDTOId(id);
		return new ResponseEntity<VlasnikDTO>(vlasnikDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/listaTipova")
	public ResponseEntity<List<LjubimacTip>> findAllTypes() {
		List<LjubimacTip> ljubimacTypes = ljubimacTipService.listaTipova();
		return new ResponseEntity<List<LjubimacTip>>(ljubimacTypes, HttpStatus.OK);
	}
	
	@PostMapping(value = "/kreirajLjubimca/vlasnik/{idVlasnika}/tip/{idLjubimacTip}")
	public ResponseEntity<?> kreirajLjubimca(@PathVariable Integer idVlasnika, @PathVariable Integer idLjubimacTip, @Valid @RequestBody LjubimacDTO ljubimacDTO, BindingResult bindingResult) {
		ResponseEntity<?> errorMap = validatorService.validacijaService(bindingResult);
		if(errorMap != null) return errorMap;
		ljubimacDTO = ljubimacFasada.save(idVlasnika, idLjubimacTip, ljubimacDTO);
		return new ResponseEntity<LjubimacDTO>(ljubimacDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/obrisiLjubimce")
	public ResponseEntity<String> obrisiLjubimce(@RequestBody List<LjubimacDTO> lista) {
		ljubimacService.deleteAll(lista);
		return new ResponseEntity<String>("Obrisani ljubimci", HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateLjubimca/vlasnik/{idVlasnika}/tip/{idLjubimacTip}")
	public ResponseEntity<?> updateLjubimca(@PathVariable Integer idVlasnika, @PathVariable Integer idLjubimacTip, @RequestBody LjubimacDTO ljubimacDTO) {
		return new ResponseEntity<LjubimacDTO>(ljubimacService.updateLjubimca(idVlasnika, idLjubimacTip, ljubimacDTO), HttpStatus.OK);
	}
}
