package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public enum ReservationType {
 A1(5000),A2(2000),A3(1000),SLEEPER(500),GENERAL(100);
	
	private double rate;
	

}
