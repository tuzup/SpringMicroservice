 package com.universal.rest.webservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.universal.rest.webservices.exception.UserNameEmptyException;
import com.universal.rest.webservices.exception.UserNotFoundException;

@RestController
 public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> reteieveAllUsers(){
		List<User> user = service.findAll();
		if(user.isEmpty()) {
			throw new UserNotFoundException("Sorry, no user data present in the database");
		}
		return user;
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> reteieveUser(@PathVariable int id){
		User user = service.findOne(id);
		if(user == null)
			throw new UserNotFoundException("User Not Found with the given UserId : "+id); 
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).reteieveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		if(user.getName()==null) {
			throw new UserNameEmptyException("User name cannot be empty");
		}
		User savedUser = service.save(user);
		URI location =  ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = service.deleteById(id);
		if(user == null)
			throw new UserNotFoundException("User Not Found with the given UserId : "+id); 
	}
	

}
