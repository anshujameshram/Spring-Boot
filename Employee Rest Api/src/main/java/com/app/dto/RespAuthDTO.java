package com.app.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespAuthDTO {
	private String firstName;	
	private String lastName;	
	private LocalDate joinDate;
	private double salary;	
	private String location;	
	private String department;
	//getters from entity
}
