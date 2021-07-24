package com.universal.rest.webservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
//GET Method 
//URI - /hello-world


@RestController 
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-international")
	public String helloWorldInterNationalized(
			@RequestHeader(name="Accept-Language", required=false) Locale locale
			) {
		return messageSource.getMessage("good.morning.message", null, "Default Message",locale);
	} 
	
	@GetMapping(path = "/hello-world-international-two")
	public String helloWorldInterNationalizedTwo() {
		return messageSource.getMessage("good.morning.message", null, "Default Message",LocaleContextHolder.getLocale());
	} 
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World","Hi I am Sunny");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World", String.format("Hi I am %s",name));
	}
}
