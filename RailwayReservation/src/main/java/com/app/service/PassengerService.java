package com.app.service;

import java.util.List;

import com.app.dto.LoginDTO;
import com.app.dto.PassDTO;
import com.app.entities.Passenger;

public interface PassengerService  {
	
	List<Passenger> getAllPassenger();
	
	String AddPassenger(PassDTO Pass);
	
	String UpdatePass(long id,PassDTO pass);
	
	PassDTO AuthenticatePassenger(LoginDTO request);
	
	String DeletePass(long PId,long RId);

}
