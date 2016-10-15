package com.trendz.product;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO {

	 @Autowired
	 SessionFactory sessionFactory;
		
		@Transactional
		public void insert(Product p) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().save(p);
		}

		@Transactional
		public void update(Product p) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().update(p);
		}

		@Transactional
		public void delete(int pid) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().createQuery("delete from Product p where p.id = :id").setInteger("id", pid).executeUpdate();
		}

		@Transactional
		public Product getProduct(int pid) {
			// TODO Auto-generated method stub
			List<Product> list = sessionFactory.getCurrentSession().createQuery("from Product p where p.id = :id").setInteger("id", pid).list();
			
			if(!list.isEmpty())
			{
				return list.get(0);
			}
			else
				return null;
		}

		@Transactional
		public List<Product> ListProducts() {
			// TODO Auto-generated method stub
			List<Product> list = sessionFactory.getCurrentSession().createQuery("from Product p").list();
			return list;
			
		}

		@Transactional
		public Product getProductWithMaxId() {
			// TODO Auto-generated method stub
			List<Product> list = sessionFactory.getCurrentSession().createQuery("from Product p where p.id = (select max(p1.id) from Product p1)").list();
			
			if(!list.isEmpty())
			{
				return list.get(0);
			}
			else
				return null;
		}

		}




