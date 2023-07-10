package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.app.Entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class MovieDTO {
	
	@NotBlank
	private String MName;
	@NotBlank
	private Category category;
	@NotBlank
	@Future
	private LocalDate RDate;
	@NotBlank
	private double budget;
	@NotBlank
	private String Director;
	@NotBlank
	private double Duration;
	
	private String Actors;
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
	public MovieDTO(@NotBlank String mName, @NotBlank Category category, @NotBlank @Future LocalDate rDate,
			@NotBlank double budget, @NotBlank String director, @NotBlank double duration, @NotBlank String actors) {
		super();
		MName = mName;
		this.category = category;
		RDate = rDate;
		this.budget = budget;
		Director = director;
		Duration = duration;
		Actors = actors;
	}
	public MovieDTO() {
		
	}
	
	

}
