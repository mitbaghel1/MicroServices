package com.ms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.UserBo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {

	@Autowired
	private MessageSource messageSource;
	
	static List<UserBo> userBoList=new ArrayList();
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required = false) Locale locale) 
	{
		return messageSource.getMessage("good.morning.message",null,"Default Message1", locale);
	}
	
	@PostMapping(path = "/user_info/{id}")
	public ResponseEntity<UserBo> user_info(@PathVariable("id") String id
			,@RequestBody UserBo userBo) 
	{
		int idc=Integer.parseInt(id);
		userBo.setDateOfBirth(new Date());
		userBo.setFirstName("Mit");
		userBo.setId(idc);
		userBoList.add(userBo);
		return  ResponseEntity.ok(userBo);
	}
	
	@GetMapping(path = "/user_getAllList")
	public ResponseEntity<List<UserBo>> user_info() 
	{
		return  ResponseEntity.ok(userBoList);
	}
}
