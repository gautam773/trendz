package com.trendz.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO cDAO;

	
	public void insert(Category c) {
		// TODO Auto-generated method stub
		cDAO.insert(c);
		
	}


	public void update(Category c) {
		// TODO Auto-generated method stub
		cDAO.update(c);
		
	}

	
	public void delete(int cid) {
		// TODO Auto-generated method stub
		cDAO.delete(cid);
	}

	
	public Category getCategory(int cid) {
		// TODO Auto-generated method stub
		return cDAO.getCategory(cid);
	}

	
	public List<Category> ListCategory() {
		// TODO Auto-generated method stub
		return cDAO.ListCategory();
	}
	
	public Category getCategoryWithMaxId()
	{
		return cDAO.getCategoryWithMaxId();
	}
}
