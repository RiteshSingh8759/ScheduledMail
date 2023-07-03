package com.kloc.Scheduler.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kloc.Scheduler.Entity.SalesPerson;
import com.kloc.Scheduler.Entity.User;
import com.kloc.Scheduler.Service.SalesPersonService;
import com.kloc.Scheduler.Service.UserService;

@RestController
@RequestMapping("/api")
public class MainController 
{
	@Autowired
	private SalesPersonService salesPersonService;
	@Autowired
	private UserService userService;
	//sending mails to salesperson on specific date
	@PostMapping("/saveSalesPerson/{userId}")
	public ResponseEntity<SalesPerson> saveSalesPerson(@RequestBody SalesPerson salesPerson,@PathVariable(name="userId") int user_id)
	{
		return new ResponseEntity<SalesPerson>(salesPersonService.saveSalesPerson(salesPerson,user_id),HttpStatus.OK);
	}
	//saving the user
	//salesperson is mapped with user
	//sample git check
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.OK);
	}
}
