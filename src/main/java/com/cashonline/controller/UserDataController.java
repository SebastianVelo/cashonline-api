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
import com.cashonline.dto.UserDataDTO;
import com.cashonline.service.UserDataService;

@RestController
@RequestMapping("/cashonline/user-data")
public class UserDataController {

	@Autowired
	@Qualifier("userDataService")
	private UserDataService service;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated UserDataDTO userData) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "insertUserData");
		return ResponseEntity.ok().headers(header).body(service.insert(userData));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "deleteUserData");
		return ResponseEntity.ok().headers(header).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		HttpHeaders header = new HttpHeaders();
		header.add("request", "getUserDataById");
		return ResponseEntity.ok().headers(header).body(service.get(id));
	}

}
