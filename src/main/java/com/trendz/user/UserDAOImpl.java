package com.trendz.user;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void insert(User u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(u);
	}


	public void update(User u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(u);
	}

	
	public void delete(int uid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from User u where u.id=:id").setInteger("id",uid).executeUpdate();
	}

	
	public User getUser(int uid) {
		// TODO Auto-generated method stub
			List<User> list=sessionFactory.getCurrentSession().createQuery("from User u where u.Role=:id").setInteger("id", uid).list();
			
			if(!list.isEmpty())
			{
				return list.get(0);
				
			}else
				
			return null;
			
			
		}
	
	
	@Transactional
	public List<User> ListUser() {
		// TODO Auto-generated method stub
		List<User> list = sessionFactory.getCurrentSession().createQuery("from User U").list();
		return list;
	}


}
