package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.Category;
import com.app.Entity.Movie;
import com.app.dto.MovieDTO;
import com.app.service.movieService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private movieService Mserv;
	
	@GetMapping
	public List<Movie> DisplayAllmovie(){
		return Mserv.getAllMovies();
	}

	@PostMapping
	public ResponseEntity<?> Addmovie(@org.springframework.web.bind.annotation.RequestBody MovieDTO movie){
		return new ResponseEntity<>(Mserv.AddMovie(movie),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>updateMovie(@PathVariable long id,@org.springframework.web.bind.annotation.RequestBody MovieDTO movie){
		return new ResponseEntity<>(Mserv.UpdateeMovie(id,movie),HttpStatus.CREATED);
	}
//	
//	@GetMapping("/director")
//	public Movie getbyDirector(@RequestBody String Director) {
//		return Mserv.findDirector(Director);
//		
//	}
	
	@GetMapping("/{id}")
    public Movie findbyId(@PathVariable long id) {
		return Mserv.getbyId(id);
	}
	
	@GetMapping("/category")
	public Movie getByCat(@RequestBody Category cat) {
		return Mserv.getByCategory(cat);
	}
}
