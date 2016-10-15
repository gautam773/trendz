package com.trendz.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trendz.category.Category;


    public interface CategoryDAO {
	@Autowired
	
		public void insert(Category c);
	
		public void update(Category c);
	
		public void delete(int cid);
	
		public Category getCategory(int cid);
	
		public List<Category> ListCategory();
		
		public Category getCategoryWithMaxId();
}
