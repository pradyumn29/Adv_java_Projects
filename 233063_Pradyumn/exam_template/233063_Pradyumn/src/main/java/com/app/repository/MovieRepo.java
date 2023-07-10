package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entity.Category;
import com.app.Entity.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
//	Optional<Movie> findbyDirector(String Director);
	Optional<Movie> findByCategory(Category Category);

}
