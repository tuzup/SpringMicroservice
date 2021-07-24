package com.universal.rest.webservices.filtered;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteredResources {
	
	
	
	@GetMapping("/show-filtered")
	public SomeBean showFilteredResource() {
		return new SomeBean("Data1","Data2","Data3");
	}
	
	@GetMapping("/show-filtered-list")
	public List<SomeBean> showFilteredListResource() {
		return Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value1","value2","value3"));
		
	}
	
	//Dynamic filtering - we need to send only data1 and data2 
	@GetMapping("/show-filtered-dynamic")
	public MappingJacksonValue showFilteredDynamicResource() {
		SomeBean someBean =  new SomeBean("Data1","Data2","Data3");
		Set<String>filteringParams = new HashSet<String>(Arrays.asList("data1", "data2"));
		MappingJacksonValue mapping = DynamicFiltering(someBean,filteringParams);
		return mapping; 
	}

	private MappingJacksonValue DynamicFiltering(SomeBean someBean, Set<String>filteringParams) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filteringParams);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}

}
