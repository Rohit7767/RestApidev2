package com.RestApiDevProject2.MDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.RestApiDevProject2.Entity.Category;



@Repository
public class CategoryDao {
	
	
	@Autowired
	SessionFactory sesf;
	
	public Category saveCategory(Category categ)
	{
		
	Session ses = sesf.openSession();
	
	Transaction tx = ses.beginTransaction();
	
	ses.save(categ);
	System.out.println("record added into database");
	
	tx.commit();
	ses.close();
	return categ;
		
	}

//	get category record  from database
	public Category getCategory(int cid) {
		
		Session ses = sesf.openSession();
		
		Category category = ses.get(Category.class, cid);
		return category;	
	}
	
	
	public Category getCategory1(@PathVariable int cid)
	{
		
		Session s = sesf.openSession();
		@SuppressWarnings("deprecation")
		Criteria cr = s.createCriteria(Category.class);
		
		@SuppressWarnings("unchecked")
		List<Category> list = cr.list();
		Category category = list.get(0);
		return category;

	}
	
	
	public Category updateCategory(Category cat)
	{
		
	Session ses = sesf.openSession();
	
	Transaction tx = ses.beginTransaction();
	
	ses.update(cat);
	tx.commit();
	return cat;
	}

	public Category deleteCategory(int cid) {
		Session ses = sesf.openSession();
		Category category = ses.get(Category.class, cid);
		Transaction tx = ses.beginTransaction();
		
		ses.delete(category);
		tx.commit();
		return category;
	}
	
	public List<Category> getAllCategory() {
		
		Session s = sesf.openSession();
		
		Criteria cr = s.createCriteria(Category.class);
		List<Category> list = cr.list();
		
		return list;
	}
	
	

	
	
	
	
	

}
