package com.trendz.product;

import java.util.List;


public interface ProductService {
	
public void insert(Product p);
	
	public void update(Product p);
	
	public void delete(int pid);
	
	public Product getProduct(int pid);
	
	public List<Product> ListProducts();
	
	public Product getProductWithMaxId();

}
