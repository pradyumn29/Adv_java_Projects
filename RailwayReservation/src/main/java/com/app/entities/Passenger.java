package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
@JsonIgnoreType

public class Passenger extends BaseEntity {

	@Column
	private String PName;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private long Pnum;
	@Column
	private double Amount;
	@Column
	private String StartPoint;
	@Column
	private String EndPoint;
	@Column
	private LocalDateTime StartDateTime;
	@Column
	private LocalDateTime EndDateTime;
	@Column
	@Enumerated(EnumType.STRING)
	private ReservationType SType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "railId")
	private Railway AssignedRail;
	
	

}
