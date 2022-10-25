package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.IRepositoryOrdenes;
import com.example.demo.models.Ordenes;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class OrdenesController {
	
	@Autowired
	IRepositoryOrdenes repository;
	
	@GetMapping("/test")
	public String saludo(){
		return "Hola mundo";
	}

	@GetMapping("/ordenes")
	public ResponseEntity<List<Ordenes>> getOrdenes(){
		List<Ordenes> getData = new ArrayList<Ordenes>();
		repository.findAll().forEach(getData::add);;
		if (getData.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(getData, HttpStatus.OK);
		}
	
	@GetMapping("/orden/{id}")
	public ResponseEntity<Ordenes> getOrden(@PathVariable("id") long id){
		Optional<Ordenes> getData = repository.findById(id);
		if (getData.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(getData.get(), HttpStatus.OK);
		}

	@PostMapping("/postOrden")
	public ResponseEntity<Ordenes> createOrden(@RequestBody Ordenes dataInput) {
		try {
			Ordenes data = repository
					.save(new Ordenes( dataInput.getSucursal_id(), dataInput.getFecha(), dataInput.getTotal()));
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/putOrden/{id}")
	public ResponseEntity<Ordenes> updateOrden(@PathVariable("id") long id, @RequestBody Ordenes ordenesIn) {
		Optional<Ordenes> putData = repository.findById(id);

		if (putData.isPresent()) {
			Ordenes _obj = putData.get();
			_obj.setSucursal_id(ordenesIn.getSucursal_id());
			_obj.setFecha(ordenesIn.getFecha());
			_obj.setTotal(ordenesIn.getTotal());
			return new ResponseEntity<>(repository.save(_obj), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
