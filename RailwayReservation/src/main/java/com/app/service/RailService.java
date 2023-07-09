package com.app.service;

import java.util.List;

import com.app.dto.RailDTO;
import com.app.entities.Railway;

public interface RailService {
	
	List<Railway> getAllRail();
	
	String addRail(RailDTO Rail);
	String UpdateRail(long id,RailDTO rail);
	String deleteRail(long id);

}
