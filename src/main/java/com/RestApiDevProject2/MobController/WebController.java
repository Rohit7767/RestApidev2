package com.RestApiDevProject2.MobController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("api")
public class WebController {
	
	
	@RequestMapping("welcome")
	public String Welcome()
	{
		return "welcome";
	}
	
	@RequestMapping("wel")
	public String m2()
	{
		return "mypage";
	}
	
	@GetMapping("about")
	public String aboutus()
	{
		return "First";
	}
	
	@RequestMapping("/")
	public String CategoryForm()
	{
		return "Category";
	}
	
	
	
}
