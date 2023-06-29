package com.kloc.Scheduler.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kloc.Scheduler.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	

}
