package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.LoginDTO;
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

	@Override
	public String UpdatePass(long id, PassDTO pass) {
//	    LoginDTO login=new LoginDTO(pass.getEmail(),pass.getPassword());
//		PassDTO pass1=AuthenticatePassenger(login);
//		
//		if(pass1==pass) {
	    Passenger p=PRepo.findById(id).orElseThrow();
	    Passenger pdto=Mapper.map(pass,Passenger.class);
	    PRepo.save(pdto);
//	    p.setAmount(pdto.getAmount());
//	   // p.setAssignedRail(pdto.getAssignedRail());
//	    p.setEmail(pdto.getEmail());
//	    p.setEndDateTime(pdto.getEndDateTime()); 
//	    p.setEndPoint(pdto.getEndPoint());
	    return "updated succesfully";
//		}else {
//	    
//		return "login unsuccesfull try again";
//		}
	}

	
	//login authentication
	@Override
	public PassDTO AuthenticatePassenger(LoginDTO req) {
		     Passenger Request= PRepo.findByEmailAndPassword(req.getEmail(), req.getPassword()).orElseThrow();
		      PassDTO pass= Mapper.map(Request,PassDTO.class);
		return pass;
	}

	@Override
	public String DeletePass(long Pid,long Rid) {
		
	Passenger pass=PRepo.findById(Pid).orElseThrow();
	Railway rail=Rrepo.findById(Rid).orElseThrow();
	
	rail.deletePass(pass);		
		return "deleted";
	}
	
	 
	
	

}
