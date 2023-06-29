package com.kloc.Scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulingMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingMailApplication.class, args);
	}

}
