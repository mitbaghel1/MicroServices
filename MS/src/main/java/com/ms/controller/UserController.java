package com.ms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Post;
import com.ms.entity.UserBo;
import com.ms.repository.PostRepo;
import com.ms.repository.UserRepo;

@RestController
public class UserController {

	@Autowired
	private MessageSource messageSource;
	

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	static List<UserBo> userBoList=new ArrayList<UserBo>();
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required = false) Locale locale) 
	{
		return messageSource.getMessage("good.morning.message",null,"Default Message1", locale);
	}
	
<<<<<<< HEAD
	@PostMapping(path = "/jpa/user_info")
	public ResponseEntity<UserBo> user_info(@RequestBody UserBo userBo) 
	{
=======
	@PostMapping(path = "/user_info/{id}")
	public ResponseEntity<UserBo> user_info(@PathVariable("id") String id
			,@RequestBody UserBo userBo) 
	{
		int idc=Integer.parseInt(id);
>>>>>>> 17e73b366bffee28fcc11b80cd5af5e2968f20ba
		userBo.setDateOfBirth(new Date());
		UserBo userData=userRepo.save(userBo);
		return  ResponseEntity.ok(userData);
	}
	
	@PostMapping(path = "/jpa/findById/{id}")
	public ResponseEntity<Optional<UserBo>> findByIdUser(@PathVariable("id") String id) throws Exception
	{
		Integer idValue=Integer.parseInt(id);
		Optional<UserBo> l=userRepo.findById(idValue);
		
		if(!l.isPresent())
			throw new Exception("user is not found");
		
		return  ResponseEntity.ok(l);
	}
	
	@PostMapping(path = "/jpa/deleteById/{id}")
	public void deleteById(@PathVariable("id") String id) throws Exception
	{
		Integer idValue=Integer.parseInt(id);
		userRepo.deleteById(idValue);
	}
	
	@GetMapping(path = "/jpa/user_getAllList")
	public ResponseEntity<List<UserBo>> user_info() 
	{
		List<UserBo> l=userRepo.findAll();
		return  ResponseEntity.ok(l);
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> user_info(@PathVariable int id) throws Exception 
	{
		Optional<UserBo> l=userRepo.findById(id);
		if(!l.isPresent())
		{
			throw new Exception("User not found "+id);
		}
		
		return  l.get().getPosts();
	}
	
	@PostMapping(path = "/jpa/user/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable("id") int id,@RequestBody Post post) throws Exception
	{
		Optional<UserBo> l=userRepo.findById(id);
		if(!l.isPresent())
		{
			throw new Exception("User not found "+id);
		}
		else
		{
			UserBo userBo=l.get();
			post.setUser(userBo);
			postRepo.save(post);
		}
		return  ResponseEntity.ok(l);
	}
}
