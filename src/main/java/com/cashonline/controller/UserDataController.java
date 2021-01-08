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

import com.cashonline.dto.ResponseBody;
import com.cashonline.dto.UserDataDTO;
import com.cashonline.service.UserDataService;
import com.cashonline.util.Util;

@RestController
@RequestMapping("/cashonline/user-data")
public class UserDataController {

	@Autowired
	@Qualifier("userDataService")
	private UserDataService service;

	@Autowired
	@Qualifier("util")
	private Util util;
	
	@PutMapping("")
	public ResponseEntity<ResponseBody> insert(@RequestBody @Validated UserDataDTO userData) {
		return ResponseEntity.ok().headers(util.getHeaders("insert")).body(service.insert(userData));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseBody> delete(@PathVariable("id") long id) {
		return ResponseEntity.ok().headers(util.getHeaders("delete")).body(service.delete(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseBody> get(@PathVariable("id") long id) {
		return ResponseEntity.ok().headers(util.getHeaders("get")).body(service.get(id));
	}

}
