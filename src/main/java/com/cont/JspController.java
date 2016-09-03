package com.cont;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JspController {

	@RequestMapping("/")
	public String index()
	{
		
		System.out.println("At main page");
		
		return  ("index");
	
	}
	
}
