package com.trendz.cont;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trendz.user.User;
import com.trendz.user.UserService;


@Controller
public class JspController {

	@Autowired
	UserService us;
	
	
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/")
	public String index()
	{
		
		System.out.println("At main page");
		
		return  ("index");
	
	}
	@RequestMapping ("/head")
	public String head()
	{
		return "head";
	}
	
	@RequestMapping ("/head-meta")
	public String head_meta()
	{
		return "head-meta";
	}
	
	@RequestMapping ("/product")
	public String product()
	{
		return "product";
	}
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView("login");
		
		return mav ;
	}
	


	

	@RequestMapping("/signup")
	public ModelAndView signup()
	{
		ModelAndView mav = new ModelAndView("signup");
				
		mav.addObject("User", new User());
		return mav;
	}
	@RequestMapping(value="/AddUser", method = RequestMethod.POST)
	public ModelAndView AddUser(@Valid @ModelAttribute ("User") User i , BindingResult bind)
	{
		ModelAndView mav = new ModelAndView("signup");
		
		if( bind.hasErrors() )
		{
			System.out.println("Bind Errors");
			mav.addObject("User", i);
		}
		else
		{
			if( i.getPassword().equals(i.getCpassword()) )
			{
				List<User> list = us.ListUser();
				
				boolean usermatch= false;
							
				
				for( User u : list )
				{
					System.out.println(u.getUsername());
					System.out.println(i.getUsername());
					
					if( u.getUsername().equals(i.getUsername()) )
					{
						usermatch= true;
						break;
					}
				}
				
				if( usermatch == false )
				{
					us.insert(i);
					
					mav.addObject("User", new User());
					
					mav.addObject("success", "User Created Successfully");
				}	
				else
				{
					mav.addObject("User", i);
					
					mav.addObject("error", "User Already Exists");
				}
			}
			else
			{
				mav.addObject("User", i);
				
				mav.addObject("error", "Password Mismatch");
			}
		}
		
		return mav;
	}
	
}

