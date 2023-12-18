package com.example.demo.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

//	    @GetMapping("/")
//	    public String home() {
//	        return "home";
//	    }
//
	    @GetMapping("/user")
	    public String user(@AuthenticationPrincipal OAuth2User principal) {
	        // Access user details from principal
	        // For example, principal.getAttribute("id"), principal.getAttribute("name"), etc.
	       // return "Welcome to the app";
	    	return " Welcome user to fb";
	    }
	
//	@GetMapping("/")
//    public String home(Principal principal) {
//		//Map<String,Object> details=(Map<String,Object>) ((OAuth2Authentication) principal).get
//		
//		return "welcome to fblogin";
		
	}
        
    
	
	
	
	
	

