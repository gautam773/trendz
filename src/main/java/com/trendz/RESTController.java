package com.trendz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.trendz.cart.Cart;
import com.trendz.cart.CartService;
import com.trendz.product.Product;
import com.trendz.product.ProductService;
import com.trendz.user.User;
import com.trendz.user.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:8086", maxAge = 3600)
public class RESTController {

	@Autowired
	CartService cs;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	UserService us;
	
	@CrossOrigin
    @RequestMapping(value = "/flows/deleteAllFromCart/", method = RequestMethod.POST)
    public ResponseEntity<String> deleteAllFromCart(HttpServletRequest request, HttpServletResponse response, UriComponentsBuilder ucBuilder) 
	{
        List<Cart> list = cs.getAllItems();
		
		String user = "";
		
		System.out.println("In Update Addresses");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	if (auth != null && !auth.getName().equals("anonymousUser"))
	    	{    
	    		user = auth.getName();
	    	}
		
	    	System.out.println(list);
	    	
	    	for( Cart item:list )
	    	{
			
	    		if( item.getUserName().equals(user) )
	    		{
	    			cs.delete(item.getID());
	    		}
			
	    	}
		 
	    	JSONObject res = new JSONObject();
	    	
	    	res.put("status", "updated");
	    	
        return new ResponseEntity<String>(res.toJSONString(), HttpStatus.CREATED);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/flows/updateAddresses/", method = RequestMethod.POST)
    public ResponseEntity<String> updateAddresses(HttpServletRequest request, HttpServletResponse response, @RequestBody String inputdata, UriComponentsBuilder ucBuilder) 
	{
        JSONParser jpar = new JSONParser();
        
        JSONObject jobj = new JSONObject();
        
        try
        {
        	jobj = (JSONObject)jpar.parse(inputdata);
        }
		catch(Exception e)
        {
			System.out.println("ERROR READING ADDRESSES");
        }
        
        System.out.println(jobj.get("shippingAddress").toString());
        System.out.println(jobj.get("billingAddress").toString());
        
        List<Cart> list = cs.getAllItems();
		
		String user = "";
		
		System.out.println("In Update Addresses");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	if (auth != null && !auth.getName().equals("anonymousUser"))
	    	{    
	    		user = auth.getName();
	    	}
		
	    	System.out.println(list);
	    	
	    	for( Cart item:list )
	    	{
			
	    		System.out.println(user);
	    		System.out.println(item.getUserName());
	    		
	    		System.out.println( item.getUserName().equals(user) );
	    		
	    		if( item.getUserName().equals(user) )
	    		{
	    			item.setAddress(jobj.get("shippingAddress").toString());
	    			item.setBillingAddress(jobj.get("billingAddress").toString());
	    			
	    			cs.update(item);
	    		}
			
	    	}
		 
	    	JSONObject res = new JSONObject();
	    	
	    	res.put("status", "updated");
	    	
        return new ResponseEntity<String>(res.toJSONString(), HttpStatus.CREATED);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/flows/fetchAllItems/", method = RequestMethod.POST)
    public ResponseEntity<String> fetchAllItems(HttpServletRequest request, HttpServletResponse response, UriComponentsBuilder ucBuilder) {
        
		List<Cart> list = cs.getAllItems();
		
		JSONArray jarr = new JSONArray();
		
		String user = "";
		
		System.out.println("In Fetch All Items");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	user = auth.getName();
	    }
		
		for( Cart item:list )
		{
			
			if( item.getUserName().equals(user) )
			{
				JSONObject jobj = new JSONObject();
				
				jobj.put("ProductID", item.getProductID() );
				jobj.put("ProductName", item.getName() );
				jobj.put("ProductPrice", item.getPrice() );
				jobj.put("CartId", item.getID() );
				
				System.out.println("PID: "+item.getProductID());
				
				Product p = ps.getProduct( Integer.parseInt(item.getProductID()) );
				
				/*test when product not found*/
				
				if( p == null || p.getProductImage() == null )
					jobj.put("ProductImage", "");
				else
					jobj.put("ProductImage", p.getProductImage());
				
				
				jobj.put("ProductQty", item.getQty());
				jobj.put("ShippingAddress", item.getAddress());
				jobj.put("BillingAddress", item.getBillingAddress());
				 
				jarr.add(jobj);
			}
			
		 }
		 
		System.out.println(jarr);
		
        return new ResponseEntity<String>(jarr.toString(), HttpStatus.CREATED);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/flows/getUserAddress/", method = RequestMethod.POST)
    public ResponseEntity<String> getUserAddress(HttpServletRequest request, HttpServletResponse response, UriComponentsBuilder ucBuilder) {
        
		JSONObject jobj = new JSONObject();
		
		String user = "";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	user = auth.getName();
	    }
		
	    List<User> list = us.ListUser();
	    
	    String shippingAddress = "";
	    String billingAddress = "";
	    
	    for( User u : list )
	    {
	    	if( u.getUsername().equals(user) )
	    	{
	    		shippingAddress = u.getLocation();
	    	    billingAddress = u.getLocation();
	    	    break;
	    	}
	    }
	    
	    jobj.put("shippingAddress", shippingAddress);
	    jobj.put("billingAddress", billingAddress);
	    
        return new ResponseEntity<String>(jobj.toString(), HttpStatus.CREATED);
    }
	
	@CrossOrigin
    @RequestMapping(value = "/flows/deleteFromCart/", method = RequestMethod.POST)
    public ResponseEntity<String> deleteFromCart(HttpServletRequest request, HttpServletResponse response, @RequestBody String inputdata, UriComponentsBuilder ucBuilder) {
        
		int Id = Integer.parseInt(inputdata);
		
		cs.delete(Id);
		
		List<Cart> list = cs.getAllItems();
		
		JSONArray jarr = new JSONArray();
		
		String user = "";
		
		System.out.println("In Fetch All Items");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	user = auth.getName();
	    }
		
		for( Cart item:list )
		{
			
			if( item.getUserName().equals(user) )
			{
				JSONObject jobj = new JSONObject();
				
				jobj.put("ProductID", item.getProductID() );
				jobj.put("ProductName", item.getName() );
				jobj.put("ProductPrice", item.getPrice() );
				
				Product p = ps.getProduct( Integer.parseInt(item.getProductID()) );
				
				jobj.put("ProductImage", p.getProductImage());
				jobj.put("ProductQty", item.getQty());
				jobj.put("CartId", item.getID());
				 
				jarr.add(jobj);
			}
			
		 }
		 
		System.out.println(jarr);
		
        return new ResponseEntity<String>(jarr.toString(), HttpStatus.CREATED);
    }
	
}
