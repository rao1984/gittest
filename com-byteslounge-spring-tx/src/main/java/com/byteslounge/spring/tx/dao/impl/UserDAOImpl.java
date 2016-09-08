package com.byteslounge.spring.tx.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.byteslounge.spring.tx.dao.UserDAO;
import com.byteslounge.spring.tx.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		
	Session session=sessionFactory.getCurrentSession();
	session.save(user);
	}

	@Override
	@Transactional(readOnly=true)
	public User getUserById(Long userId) {
	//	throw new RuntimeException("");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}
	
	@Override
	public User getUser(String username) {
		Query query = sessionFactory.openSession().createQuery("from User where username = :username");
		query.setParameter("username", username);
		return (User) query.list().get(0);
	}
	
	//@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers1() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}
}
