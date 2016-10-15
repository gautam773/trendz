package com.trendz.userrole;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;



@Repository
@EnableTransactionManagement
public class UserroleDAOImpl implements UserroleDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void insert(Userrole ur) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(ur);
	}

	@Transactional
	public void update(Userrole ur) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(ur);
	}

	@Transactional
	public void delete(int urid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("delete from Userrole ur where ur.id = id").setInteger("id", urid).executeUpdate();
	}



	@Transactional
	public List<Userrole> ListUserrole() {
		// TODO Auto-generated method stub
		List<Userrole> list = sessionFactory.getCurrentSession().createQuery("from Userrole ur").list();
		return list;
	}

	@Transactional
	public Userrole getUserRole(int urid) {
		// TODO Auto-generated method stub
		List<Userrole> list =sessionFactory.getCurrentSession().createQuery("from Userrole ur where ur.Role = :id").setInteger("id", urid).list();
		if(!list.isEmpty())
		{
			return list.get(0);
		}
		else
		return null;
	}

	
	
	
}
