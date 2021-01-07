package com.cashonline.controller;

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

import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.UserDTO;
import com.cashonline.service.UserService;

@RestController
@RequestMapping("/cashonline/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated UserDTO userDTO) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertUser");
		return ResponseEntity.ok().headers(header).body(service.insert(userDTO));
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
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ResponseBody> getByEmail(@PathVariable("email") String email) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getUserByEmail");
		return ResponseEntity.ok().headers(header).body(service.getByEmail(email));
	}

}
