package com.garth.tcg.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController  {

	@GetMapping("/")
	public String index(){
		return "Welcome to TCGCardDatabase!";
	}
}
