package com.app.Entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class Movie extends BaseEntity{
	
	@Column(nullable = false)
	private String MName;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(nullable = false)
	private LocalDate RDate;
	@Column(nullable = false)
	private double budget;
	@Column(nullable = false)
	private String Director;
	@Column(nullable = false)
	private double Duration;
	@Column
	private String Actors;
	
	
	
	public Movie() {
		
	}
	public Movie(Long id, String mName, Category category, LocalDate rDate, double budget, String director,
			double duration, String actors) {
		super(id);
		MName = mName;
		this.category = category;
		RDate = rDate;
		this.budget = budget;
		Director = director;
		Duration = duration;
		Actors = actors;
	}
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDate getRDate() {
		return RDate;
	}
	public void setRDate(LocalDate rDate) {
		RDate = rDate;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public double getDuration() {
		return Duration;
	}
	public void setDuration(double duration) {
		Duration = duration;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	
	@Override
	public String toString() {
		return "Movie [MName=" + MName + ", category=" + category + ", RDate=" + RDate + ", budget=" + budget
				+ ", Director=" + Director + ", Duration=" + Duration + ", Actors=" + Actors + "]";
	}

}
