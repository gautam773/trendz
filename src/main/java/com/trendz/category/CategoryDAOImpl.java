package com.trendz.category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Repository
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;


	@Transactional
	public void insert(Category c) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(c);
	}

@Transactional
	public void update(Category c) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(c);
	}

	@Transactional
	public void delete(int cid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from Category c where c.id=:id").setInteger("id",cid).executeUpdate();
	}

	@Transactional
	public Category getCategory(int cid) {
		// TODO Auto-generated method stub
			List<Category> list=sessionFactory.getCurrentSession().createQuery("from Category c where c.id = :id").setInteger("id", cid).list();
			
			if(!list.isEmpty())
			{
				return list.get(0);
				
			}else
				
			return null;
			
			
		}
	
	
	@Transactional
	public List<Category> ListCategory() {
		// TODO Auto-generated method stub
		List<Category> list = sessionFactory.getCurrentSession().createQuery("from Category c").list();
		return list;
	}

	@Transactional
	public Category getCategoryWithMaxId() {
		// TODO Auto-generated method stub
		List<Category> list = sessionFactory.getCurrentSession().createQuery("from Category p where p.id = (select max(p1.id) from Category p1)").list();
		
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		else
			return null;
	}


	
}
