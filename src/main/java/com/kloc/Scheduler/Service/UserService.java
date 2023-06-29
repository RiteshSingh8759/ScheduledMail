package com.kloc.Scheduler.Service;

import java.util.List;
import com.kloc.Scheduler.Entity.User;

public interface UserService 
{
	User saveUser(User user);
	List<User> getAllUser();
}
