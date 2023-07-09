package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Long>{

	Optional<Passenger> findByEmailAndPassword(String Email,String PassWord);
}
