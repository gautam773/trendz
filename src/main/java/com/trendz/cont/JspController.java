package com.trendz.cont;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trendz.userrole.UserroleService;
import com.trendz.userrole.Userrole;
import com.trendz.user.User;
import com.trendz.user.UserService;


@Controller
public class JspController {

	@Autowired
	UserService us;

	@Autowired
	UserroleService urs;
	
	
	
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping("/")
	public String home()
	{
		Userrole r = urs.getUserRole(1);
		
		if( r == null )
		{
			Userrole urnew = new Userrole();
			
			urnew.setRole(1);
			urnew.setRoleName("USER");
			
			urs.insert(urnew);
		}
		
		r = urs.getUserRole(2);
		
		if( r == null )
		{
			Userrole urnew = new Userrole();
			
			urnew.setRole(2);
			urnew.setRoleName("ADMIN");
			
			urs.insert(urnew);
		}
		
		return ("index");
	}
	

	public String test()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	return "false";
	    }
	    else
	    {
	    	return "true";
	    }
		
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
	


	@RequestMapping("/index")
	public String index()
	{
		return ("index");
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

