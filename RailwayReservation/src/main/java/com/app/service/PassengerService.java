package com.app.service;

import java.util.List;

import com.app.dto.PassDTO;
import com.app.entities.Passenger;

public interface PassengerService  {
	
	List<Passenger> getAllPassenger();
	
	String AddPassenger(PassDTO Pass);

}
