package com.RestApiDevProject2.MobController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RestApiDevProject2.Entity.Mobile;
import com.RestApiDevProject2.MobService.MobilService;



@RestController
public class MobileController {

	@Autowired
	MobilService mservice;

	@GetMapping("/getData")
	public List<Mobile> getAllMobile() {
		List<Mobile> getAllMobile = mservice.getAllMobile();
		return getAllMobile;
	}
	
	@GetMapping("/show mobile")
	public List<Mobile> showMobile()
	{
		List<Mobile> list = mservice.showBetweenMobile();
		return list;
	}
	
	
	
	@GetMapping("/insert/{mobileid}/{price}/{speed}")
	public String insertMobileRecord(@PathVariable int mobileid,@PathVariable  int price,@PathVariable int speed )
	{
		String show = mservice.insertRecord(mobileid,price,speed);
		return show;
	}

}
