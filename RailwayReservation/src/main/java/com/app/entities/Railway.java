package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@ToString
@JsonIgnoreType
public class Railway extends BaseEntity {
	@Column
	private String rName;
    @OneToMany(mappedBy = "AssignedRail" ,fetch= FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	List<Passenger>PasList=new ArrayList<>();
    
    //helper methods
    public boolean addPass(Passenger pass) {
    	PasList.add(pass);
    	pass.setAssignedRail(this);
    	return true;
    }
    
    public boolean deletePass(Passenger pass) {
    	PasList.remove(pass);
    	pass.setAssignedRail(null);
    	return true;
    }
	

}
