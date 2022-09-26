package com.program.desafio.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.program.desafio.entities.User;
import com.program.desafio.repositories.UserRepository;

@Configuration
public class UserConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		
		User d1 = new User(1L,BigDecimal.valueOf(103.45), LocalDateTime.now());
		User d2 = new User(1L,BigDecimal.valueOf(104.45), LocalDateTime.now());
		
		userRepository.saveAll(Arrays.asList(d1, d2));		
				
		
	}	

}
