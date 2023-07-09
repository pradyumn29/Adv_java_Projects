package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Long>{

}
