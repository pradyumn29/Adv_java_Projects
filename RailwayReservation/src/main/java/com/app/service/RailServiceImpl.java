package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.RailDTO;
import com.app.entities.Railway;
import com.app.repository.RailwayRepo;

@Service
@Transactional
public class RailServiceImpl implements RailService {
	
	@Autowired
	private RailwayRepo Rrepo;
	
	@Autowired
	private ModelMapper Mapper;

	@Override
	public List<Railway> getAllRail() {
	
		return Rrepo.findAll();
	}

	@Override
	public String addRail(RailDTO RailDto) {
	         Railway rail=Mapper.map(RailDto, Railway.class);
	         Rrepo.save(rail);
		
		return "inserted Railway";
	}

	@Override
	public String UpdateRail(long id, RailDTO rail) {
	Railway rw=Rrepo.findById(id).orElseThrow();
	Railway rwt=Mapper.map(rail, Railway.class);
	rw.setRName(rwt.getRName());
		return "updated Succesfully";
	}

	@Override
	public String deleteRail(long id) {
		if(Rrepo.existsById(id)) {
			Rrepo.deleteById(id);
		}
		
		return "deleted";
	}
	
	

}
