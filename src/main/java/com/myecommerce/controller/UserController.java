package com.myecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myecommerce.dto.ResponseBody;
import com.myecommerce.entity.User;
import com.myecommerce.service.UserService;

@RestController
@RequestMapping("/myecommerce/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated User user) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertUser");
		return ResponseEntity.ok().headers(header).body(service.insert(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteUser");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}
	
	@GetMapping("/username/{userName}")
	public ResponseEntity<ResponseBody> getByUsername(@PathVariable("userName") String userName) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getUserByUsername");
		return ResponseEntity.ok().headers(header).body(service.getByUsername(userName));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ResponseBody> getByEmail(@PathVariable("email") String email) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getUserByEmail");
		return ResponseEntity.ok().headers(header).body(service.getByEmail(email));
	}
	
	@GetMapping("/check/{userName}/{password}")
	public ResponseEntity<ResponseBody> check(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "check");
		return ResponseEntity.ok().headers(header).body(service.check(userName, password));
	}
}
