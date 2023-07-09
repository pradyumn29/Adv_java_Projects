package com.app.controller;

import java.util.List;

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

import com.app.dto.RailDTO;
import com.app.entities.Railway;
import com.app.service.RailService;

@RestController
@RequestMapping("/rail")
public class RailController {

	@Autowired
	private RailService RServ;
	
	@GetMapping
	public List<Railway> ShowRail(){
		return RServ.getAllRail();
	}
	
	@PostMapping
	public ResponseEntity<?> AddRail(@RequestBody RailDTO rail) {
		
		return new ResponseEntity<>(RServ.addRail(rail),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>UpdateRail(@PathVariable long id,@RequestBody RailDTO rail){
		return new ResponseEntity<>(RServ.UpdateRail(id, rail), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public void Deleterail(@PathVariable long id) {
		RServ.deleteRail(id);
	}
}
