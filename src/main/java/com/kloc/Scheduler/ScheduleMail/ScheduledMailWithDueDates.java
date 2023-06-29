package com.kloc.Scheduler.ScheduleMail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kloc.Scheduler.Entity.SalesPerson;
@Component
public class ScheduledMailWithDueDates 
{
	@Autowired 
	private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") 
    private String sender;
    private SalesPerson sales=new SalesPerson();
    
    // Method 1
    // To send a simple email
    public String sendSimpleMail(SalesPerson details)
    {
    	sales.setDate(details.getDate());
    	sales.setSalesPerson_Email(details.getSalesPerson_Email());
    	sales.setSalesPerson_name(details.getSalesPerson_name());
    	sales.setUser(details.getUser());
    	return ScheduledMailWithDueDates();
    }
    @Scheduled(cron="0 53 11 29 6 ?")
    public String ScheduledMailWithDueDates()
    {
    	if(this.sales.getDate().equals( LocalDate.now()))
        {
    		 try {
            	 
    	            // Creating a simple mail message
    	            SimpleMailMessage mailMessage
    	                = new SimpleMailMessage();
    	 
    	            // Setting up necessary details
    	            mailMessage.setFrom(sender);
    	            mailMessage.setTo(sales.getSalesPerson_Email());
    	            mailMessage.setCc(sales.getUser().getUser_email());
    	            mailMessage.setText("");
    	            mailMessage.setSubject("");
    	            
    	            // Sending the mail
    	            javaMailSender.send(mailMessage);
    	            return "Mail Sent Successfully...";
    	        }
    	 
    	        // Catch block to handle the exceptions
    	        catch (Exception e) {
    	            return "Error while Sending Mail";
    	        }
        }
       return null;
    }
}
