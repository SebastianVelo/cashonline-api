package com.cashonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.UserDTO;
import com.cashonline.service.UserService;
import com.cashonline.util.Util;

@RestController
@RequestMapping("/cashonline/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService service;
	
	@Autowired
	@Qualifier("util")
	private Util util;

	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated UserDTO user) {
		return ResponseEntity.ok().headers(util.getHeaders("insert")).body(service.insert(user));
	}

	@PutMapping("/all")
	public ResponseEntity<ResponseBody> insertAll(@RequestBody @Validated List<UserDTO> users) {
		return ResponseEntity.ok().headers(util.getHeaders("insertAll")).body(service.insertAll(users));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		return ResponseEntity.ok().headers(util.getHeaders("delete")).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		return ResponseEntity.ok().headers(util.getHeaders("get")).body(service.get(id));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ResponseBody> getByEmail(@PathVariable("email") String email) {
		return ResponseEntity.ok().headers(util.getHeaders("getByEmail")).body(service.getByEmail(email));
	}

}
