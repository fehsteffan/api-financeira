package com.program.desafio.resources;


import java.lang.module.ResolutionException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.program.desafio.entities.User;
import com.program.desafio.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping
	public ResponseEntity <List<User>> findAll() {
		List<User> result = repository.findAll();
		return ResponseEntity.ok(result);
	}	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {	
		user = repository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
				
	}	
	
	@DeleteMapping(value="/id")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		repository.deleteAll();
		return ResponseEntity.noContent().build();
		
	}
	
	
}
