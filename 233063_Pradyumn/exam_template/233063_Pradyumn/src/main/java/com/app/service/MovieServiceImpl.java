package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Category;
import com.app.Entity.Movie;
import com.app.dto.MovieDTO;
import com.app.exception_handler.MovieNotFoundException;
import com.app.repository.MovieRepo;
@Service
@Transactional
public class MovieServiceImpl implements movieService{
	
	@Autowired
	private MovieRepo Mrepo;
	
	@Autowired
	private ModelMapper Mapper;

	@Override
	public List<Movie> getAllMovies() {
		
		return Mrepo.findAll();
	}

	@Override
	public String AddMovie(MovieDTO movie) {
	     Movie mov=Mapper.map(movie,Movie.class);  
	     Mrepo.save(mov);
	     return "movie inserted";
	}

	@Override
	public String UpdateeMovie(long id, MovieDTO movie1) {
		Movie mov=Mrepo.findById(id).orElseThrow(()->new MovieNotFoundException("wrong id"));
		Movie movie=Mapper.map(movie1, Movie.class);
		mov.setCategory(movie.getCategory());
		mov.setRDate(movie.getRDate());
		mov.setDirector(movie.getDirector());
		mov.setDuration(movie.getDuration());
		mov.setActors(movie.getActors());
		
		return "Updated";
	}
//
//	@Override
//	public Movie findDirector(String Director) {
//	return Mrepo.findbyDirector(Director).orElseThrow();
//	
//	}

	@Override
	public Movie getbyId(long id) {
	
		return Mrepo.findById(id).orElseThrow();
	}

	@Override
	public Movie getByCategory(Category category) {
	
		return Mrepo.findByCategory(category).orElseThrow();
	}

}
