package com.RestApiDevProject2.MDao;

import java.util.Collections;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.RestApiDevProject2.Entity.Mobile;




@Repository
public class MobileDao {

	@Autowired
	SessionFactory sf;

	public List<Mobile> getAllMobile() {
		Session ses = sf.openSession();

		@SuppressWarnings("deprecation")
		Criteria crtcriteia = ses.createCriteria(Mobile.class);

		@SuppressWarnings("unchecked")
		List<Mobile> list = crtcriteia.list();

		Collections.sort(list, new SortOnPrice());
		return list;

	}
	
	
	public List<Mobile> showBetweenmobile()
	{
		Session ses = sf.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria crt = ses.createCriteria(Mobile.class);
		crt.add(Restrictions.between("price", 15, 30));
		
		@SuppressWarnings("unchecked")
		List<Mobile> list = crt.list();
		
		return list;	
	}


	public String showBetweenmobile(int mobileid, int price, int speed) {
		Session ses = sf.openSession();
		
		Transaction tr = ses.beginTransaction();
		
		Mobile m = new Mobile();
		m.setMobileid(mobileid);
		m.setPrice(price);
		m.setSpeed(speed);
		ses.save(m);
		System.out.println("record inserted");
		
		tr.commit();
		ses.close();
		return "record inserted";
		
	}
	
	
	
	
	
	
	
	
	

}
