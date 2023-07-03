package com.kloc.Scheduler.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class User
{
	// This class will be storing user information
	// In user there can be salesperson,manager,Developer
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int User_id;
	private String User_name;
	private String User_email;
	@OneToMany(mappedBy ="user")
	@JsonManagedReference
	private List<SalesPerson> salesperson;
}
