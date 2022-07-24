package com.ms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ms.entity.SomeBean;

@RestController
public class FilteringController {
	
	//Static Filtering
//	@GetMapping("/filtering")
//	public SomeBean retrieveSomeBean()
//	{
//		return new SomeBean("value1","value2","value3");
//	}
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean()
	{
		SomeBean someBean=new SomeBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		
		MappingJacksonValue mappingJacVal=new  MappingJacksonValue(someBean);
		mappingJacVal.setFilters(filters);
		
		return mappingJacVal;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean()
	{
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value12","value22","value23"))  ;
	}
	//Dynamic Filtering
}
