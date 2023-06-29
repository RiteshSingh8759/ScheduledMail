package com.kloc.Scheduler.Service;

import java.util.List;

import com.kloc.Scheduler.Entity.SalesPerson;

public interface SalesPersonService 
{
	SalesPerson saveSalesPerson(SalesPerson salesperson,int user_id);
	List<SalesPerson> getAllSalesPerson();
	SalesPerson updateByDueDate(SalesPerson salesperson,int id);
}
