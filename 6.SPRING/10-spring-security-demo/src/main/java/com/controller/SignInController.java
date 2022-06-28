package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
public class SignInController {
	@GetMapping("/signin")
	public String viewLoginPage() {
		String sessionId=RequestContextHolder.currentRequestAttributes().getSessionId();
		System.out.println("Signin Controller: "+sessionId);
		return "signin";
	}
}
