package com.trendz.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDAO {

	@Autowired
	Cart getCartById(int cartId);
	
	Cart getCartByUsername(String Username);
	
	String checkUsername(String Username);

    void update(Cart cart);
    
    void add(Cart cart);
    
    void delete(int i);
    
    void deleteByProductId(int pid);
    
    public List<Cart> getAllItems();
}
