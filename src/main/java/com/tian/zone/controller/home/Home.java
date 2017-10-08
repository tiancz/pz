package com.tian.zone.controller.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title:Home</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2017年10月8日 下午3:45:04
 **/
@Controller
@RequestMapping("/home")
public class Home {
	private static final Logger LOGGER = LoggerFactory.getLogger(Home.class);

	@RequestMapping("/home")
	public String toHome(){
		LOGGER.info("to home");
		String url = "";
		url = "home";
		return url;
	}
}
