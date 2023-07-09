package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.PassDTO;
import com.app.entities.Passenger;
import com.app.entities.Railway;
import com.app.repository.PassengerRepo;
import com.app.repository.RailwayRepo;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	private PassengerRepo PRepo;
	
	@Autowired
	private RailwayRepo Rrepo;
	
	@Autowired
	private ModelMapper Mapper;

	@Override
	public List<Passenger> getAllPassenger() {
	
		return PRepo.findAll();
	}

	@Override
	public String AddPassenger(PassDTO Pass) {
	    Railway rail= Rrepo.findById(Pass.getAssignedRail()).orElseThrow();
	    
	    Passenger NewPass=Mapper.map(Pass, Passenger.class);
	    
	    rail.addPass(NewPass);
	    PRepo.save(NewPass);
		
		return "Added Succesfully";
	}
	
	
	
	

}
