package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

	public HomePageController()
	{
		System.out.println("In constr of home page controller");
	}
	
	@GetMapping("/")
	public List<Integer> getNumberList()
	{
		return Arrays.asList(10,20,30,40);
	}
}
