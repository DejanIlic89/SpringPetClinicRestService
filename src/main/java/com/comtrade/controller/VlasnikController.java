package com.comtrade.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comtrade.entity.Vlasnik;
import com.comtrade.exception.EntityNotFoundException;
import com.comtrade.service.ValidatorService;
import com.comtrade.service.VlasnikService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/vlasnici")
public class VlasnikController {

	private final VlasnikService vlasnikService;
	private final ValidatorService validatorService;
	
	@Autowired
	public VlasnikController(VlasnikService vlasnikService, ValidatorService validatorService) {
		super();
		this.vlasnikService = vlasnikService;
		this.validatorService = validatorService;
	}
	
	@PostMapping()
	public ResponseEntity<?> kreirajVlasnika(@Valid @RequestBody Vlasnik vlasnik, BindingResult bindingResult) {
		ResponseEntity<?> errorMap = validatorService.validacijaService(bindingResult);
		if(errorMap != null) return errorMap;
		Vlasnik vlasnik2 = vlasnikService.save(vlasnik);
		return new ResponseEntity<Vlasnik>(vlasnik2, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Finds Vlasniks by id",
			notes = "Provide an id to look up specific Vlasnik",
			response = Vlasnik.class)
	public ResponseEntity<?> vratiVlasnika(@ApiParam(value = "ID value for the Vlasnik you need to retrieve", required = true) @PathVariable Integer id) {
		Vlasnik vlasnik = vlasnikService.findVlasnikById(id);
		return new ResponseEntity<Vlasnik>(vlasnik, HttpStatus.OK);
	}
	
//	@GetMapping() // pretraga vlasnika po prezimenu koristeri query params
//	public ResponseEntity<List<Vlasnik>> vratiVlasnikaPoPrezimenuQueryParams(@RequestParam(name = "prezime") String prezime) {
//		List<Vlasnik> listaVlasnika = vlasnikService.findVlasnikByPrezime(prezime);
//		return new ResponseEntity<List<Vlasnik>>(listaVlasnika, HttpStatus.OK);
//	}
	
	@GetMapping(value = "/prezime/{prezime}")
	public ResponseEntity<List<Vlasnik>> vratiVlasnikaPoPrezimenu(@PathVariable String prezime) {
		List<Vlasnik> listaVlasnika = vlasnikService.findVlasnikByPrezime(prezime);
		return new ResponseEntity<List<Vlasnik>>(listaVlasnika, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Vlasnik>> vratiListuVlasnika() {
		List<Vlasnik> listaVlasnika = vlasnikService.findAll();
		return new ResponseEntity<List<Vlasnik>>(listaVlasnika, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateVlasnik(@PathVariable Integer id, @Valid @RequestBody Vlasnik vlasnik, BindingResult bindingResult) {
		ResponseEntity<?> errorMap = validatorService.validacijaService(bindingResult);
		if(errorMap != null) return errorMap;
		return new ResponseEntity<Vlasnik>(vlasnikService.update(id, vlasnik), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteVlasnik(@PathVariable Integer id) {
		vlasnikService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	private List<Vlasnik> listaVlasnika;
//	
//	@PostConstruct
//	public void ucitajVlasnike() {
//		listaVlasnika = new ArrayList<Vlasnik>();
//		Vlasnik vlasnik = new Vlasnik();
//		vlasnik.setId(1);
//		vlasnik.setAdresa("Adresa 1");
//		vlasnik.setGrad("Bg");
//		vlasnik.setIme("Dejan");
//		vlasnik.setPrezime("Ilic");
//		vlasnik.setTelefon("0606443410");
//		listaVlasnika.add(vlasnik);
//		Vlasnik vlasnik2 = new Vlasnik();
//		vlasnik2.setId(2);
//		vlasnik2.setAdresa("Adresa 2");
//		vlasnik2.setGrad("Novi Sad");
//		vlasnik2.setIme("Milan");
//		vlasnik2.setPrezime("Ilic");
//		vlasnik2.setTelefon("0654363630");
//		listaVlasnika.add(vlasnik2);
//	}
//	
//	@GetMapping()
//	public List<Vlasnik> prikaziVlasnike() {
//		return listaVlasnika;
//	}
	
//	@GetMapping(value = "/{id}")
//	public Vlasnik vratiVlasnika(@PathVariable Integer id) {
//		if(id > listaVlasnika.size() || id < 0) {
//			throw new VlasnikNotFoundException("Vlasnik sa Id-em " + id + " ne postoji");
//		}
//		return listaVlasnika.get(id);
//	}
	
}
