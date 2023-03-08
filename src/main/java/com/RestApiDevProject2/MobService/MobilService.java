package com.RestApiDevProject2.MobService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApiDevProject2.Entity.Mobile;
import com.RestApiDevProject2.MDao.MobileDao;
;

@Service
public class MobilService {
	
	@Autowired
	MobileDao mdao;

	public List<Mobile> getAllMobile()
	{
		List<Mobile> getAllMobile = mdao.getAllMobile();
		return getAllMobile;
	}

	public List<Mobile> showBetweenMobile() {
		List<Mobile> mbile = mdao.showBetweenmobile();
		return mbile;
	}

	public String insertRecord(int mobileid, int price, int speed) {
		 String show = mdao.showBetweenmobile(mobileid,price,speed);
		 return show;
	}
	
	
		

}
