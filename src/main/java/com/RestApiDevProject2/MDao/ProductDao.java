package com.RestApiDevProject2.MDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.RestApiDevProject2.Entity.Category;
import com.RestApiDevProject2.Entity.Product;



@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory sessf;
	
	public String saveProductInfo(Product prod)
	{
		
		Session ses = sessf.openSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(prod);
		System.out.println("record inserted into database");
		
		tx.commit();
		
		ses.close();
		return "record inserted";
		
	}

	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
	
		System.out.println("category id is " + cid);
		
		Session ses = sessf.openSession();
		
		Category ct = ses.load(Category.class, cid);
		
		List<Product> pro = ct.getProducts();
		
Transaction tx = ses.beginTransaction();
		
pro.add(product);
		System.out.println("record inserted into database");
		
		tx.commit();
		
		return product;
		
		
	}
	
	
	
}
