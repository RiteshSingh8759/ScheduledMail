package com.kloc.Scheduler.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class SalesPerson 
{
	@Id
	//spijisigji
	//wepijijij
	//xsefjeisjpi
	//commit 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int SalesPerson_id;
	private String SalesPerson_name;
	private String SalesPerson_Email;
	private LocalDate date;
	@ManyToOne
	@JsonBackReference
	private User user;
}