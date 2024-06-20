package com.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;


@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	SessionFactory factory;
	
	//transient object is that object which is not from db
	//persistent object is that object which is from db;
	//requestBody Annotation will apply JSON data to java object
	@PostMapping("saveUser")
	public void saveUser(@RequestBody User user) {
		Session session=factory.openSession();
		//save, update(),
		Transaction tx=session.beginTransaction();
		session.persist(user);
		tx.commit();
	}
	
	@PutMapping("updateUser")
	public void updateUser(@RequestBody User user)
	{
		Session session=factory.openSession();
		
		// session==> [save() , update()] Session object
		
		Transaction tx=session.beginTransaction();
		
				session.merge(user);// merge will decide save/update
				
		tx.commit();
		
		
	}
	

	
	
	
		@GetMapping("getUser/{username}")
		public User getUser(@PathVariable String username) {
			Session session=factory.openSession();
			
			
			User userfromdb=session.get(User.class,username);
			
			return userfromdb;
	}
		//if method is mapped with @deletemapping then client must use deleteMapping
		@DeleteMapping("deleteUser/{username}")
		public void deleteUser(@PathVariable String username) {
			Session session=factory.openSession();
			//delete()
			User userfromdb=session.get(User.class,username);
			Transaction tx=session.beginTransaction();
			session.remove(userfromdb);
			tx.commit();
	}
		
		//client can call bellow method using any request
		@RequestMapping("getAllUser")
		public List<User> getAllUser() {
			Session session=factory.openSession();
			
			Query query=session.createQuery("from User");
			return query.list();
			
	}
}
