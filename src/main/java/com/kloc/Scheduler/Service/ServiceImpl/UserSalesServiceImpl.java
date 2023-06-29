package com.kloc.Scheduler.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloc.Scheduler.Entity.SalesPerson;
import com.kloc.Scheduler.Entity.User;
import com.kloc.Scheduler.Exception.MailException;
import com.kloc.Scheduler.Repository.SalesPersonRepository;
import com.kloc.Scheduler.Repository.UserRepository;
import com.kloc.Scheduler.ScheduleMail.ScheduledMailWithDueDates;
import com.kloc.Scheduler.Service.SalesPersonService;
import com.kloc.Scheduler.Service.UserService;
@Service
public class UserSalesServiceImpl implements SalesPersonService,UserService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SalesPersonRepository salesPersonRepository;
	@Autowired
	private ScheduledMailWithDueDates scheduleMail;
	@Override
	public User saveUser(User user) 
	{
		return userRepository.save(user);	
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public SalesPerson saveSalesPerson(SalesPerson salesperson,int user_id) 
	{
		salesperson.setUser(userRepository.findById(user_id).get());
		SalesPerson sales= salesPersonRepository.save(salesperson);
		System.out.println(scheduleMail.sendSimpleMail(sales));
		return sales;
	}

	@Override
	public List<SalesPerson> getAllSalesPerson() {
		return salesPersonRepository.findAll();
	}

	@Override
	public SalesPerson updateByDueDate(SalesPerson salesperson,int id) 
	{
		SalesPerson sales=salesPersonRepository.findById(id).orElseThrow(()-> new MailException("salesPerson","id", id));
		sales.setDate(salesperson.getDate());
		sales.setSalesPerson_Email(salesperson.getSalesPerson_Email());
		sales.setSalesPerson_name(salesperson.getSalesPerson_name());
		SalesPerson sales1= salesPersonRepository.save(sales);
		scheduleMail.sendSimpleMail(sales1);
		return sales1;
	}

}
