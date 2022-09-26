package com.program.desafio.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.program.desafio.entities.User;
import com.program.desafio.repositories.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/users")
@Api(value="API REST USERS")
@CrossOrigin(origins="*")
public class UserResource {
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping
	@ApiOperation(value= "estatísticas das transações que aconteceram" )
	public ResponseEntity <List<User>> findAll() {
		List<User> result = repository.findAll();
		return ResponseEntity.ok(result);
	}	
	
	@PostMapping
	@ApiOperation(value= "transação consiste de um valor e uma dataHora de quando ela aconteceu")
	public ResponseEntity<User> insert(@RequestBody User user) {	
		user = repository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
				
	}	
	
	@DeleteMapping(value="/id")
	@ApiOperation(value= "Apaga todos os dados de transação")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		repository.deleteAll();
		return ResponseEntity.noContent().build();
		
	}	
	
}
