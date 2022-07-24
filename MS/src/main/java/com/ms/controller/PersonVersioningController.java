package com.ms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.versioning.Name;
import com.ms.versioning.PersonV1;
import com.ms.versioning.PersonV2;

@RestController
public class PersonVersioningController {

//	@GetMapping("v1/person")
//	public PersonV1 presonV1()
//	{
//		return new PersonV1("Mit");
//	}
	
	@GetMapping(value = "/person/param",params="version=1")
	public PersonV1 presonV1()
	{
		return new PersonV1("Mit");
	}
	
	//param/version1
	@GetMapping(value = "person/param",params="version=2")
	public PersonV2 presonV2()
	{
		return new PersonV2(new Name("Mitkumar","Baghel"));
	}
	
	//key & value
	@GetMapping(value = "person/headers",headers ="X-API-version=2")
	public PersonV2 headerV2()
	{
		return new PersonV2(new Name("Mitkumar","Baghel"));
	}
	
	@GetMapping(value = "person/headers",headers ="X-API-version=1")
	public PersonV1 headerV1()
	{
		return new PersonV1("Mit");
	}
	
	
	@GetMapping(value = "person/producers",produces ="application/vnd.company.app-v1+json")
	public PersonV2 producesV2()
	{
		return new PersonV2(new Name("Mitkumar","Baghel"));
	}
	
	@GetMapping(value = "person/producers",produces ="application/vnd.company.app-v2+json")
	public PersonV1 producesV1()
	{
		return new PersonV1("Mit");
	}
	
	
}
