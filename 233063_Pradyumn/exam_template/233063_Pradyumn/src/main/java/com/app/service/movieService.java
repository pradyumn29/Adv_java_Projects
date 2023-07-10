package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.Entity.Category;
import com.app.Entity.Movie;
import com.app.dto.MovieDTO;

@Service
@Transactional
public interface movieService {
	List<Movie> getAllMovies();
	
	String AddMovie(MovieDTO movie);
	
	String UpdateeMovie(long id,MovieDTO movie);

//	Movie findDirector(String Director);
	
	Movie getbyId(long id);
	
	Movie getByCategory(Category category);
}
