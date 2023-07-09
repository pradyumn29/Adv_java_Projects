package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PassDTO;
import com.app.entities.Passenger;
import com.app.service.PassengerService;

@RestController
@RequestMapping("/Passenger")
public class PassengerController {
	
	@Autowired
	private PassengerService PServ;
	
	@GetMapping
	public List<Passenger> DisplayPassenger(){
		return PServ.getAllPassenger();
	}
	
	@PostMapping
	public ResponseEntity<?> InsertPassenger(@RequestBody @Valid PassDTO pass){
		
		return new ResponseEntity<>(PServ.AddPassenger(pass), HttpStatus.CREATED);
	}

}
