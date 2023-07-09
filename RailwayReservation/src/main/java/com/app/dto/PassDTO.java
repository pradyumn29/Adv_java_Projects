package com.app.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.app.entities.Railway;
import com.app.entities.ReservationType;

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

public class PassDTO {
	@NotBlank
	private String PName;
	@NotBlank
	private String Pnum;
	@Email
	private String email;
	@Pattern(regexp = "^(=?.*[A-Za-Z])(=?.*[!@#$%&])(=?.*/d).{8,}$")
	private String password;
	@NotBlank
	private double Amount;
	@NotBlank
	private String StartPoint;
	@NotBlank
	private String EndPoint;
	@NotBlank
	private LocalDateTime StartDateTime;
	@NotBlank     
	private LocalDateTime EndDateTime;
	
	private ReservationType SType;
	private long AssignedRail;

}
