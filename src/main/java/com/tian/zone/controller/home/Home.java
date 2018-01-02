package com.tian.zone.controller.home;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

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
	
	@RequestMapping("submit.do")
	@ResponseBody
	//public String submit(@RequestBody JSONObject req){
		//LOGGER.info(JSONObject.toJSONString(req));
	public String submit(HttpServletRequest req){
		//LOGGER.info(JSONObject.toJSONString(req.getParameterNames()));
		//LOGGER.info(JSONObject.toJSONString(req.getParameterValues("ckeditor")));
		LOGGER.info(JSONObject.toJSONString(req.getParameter("ckeditor")));
		return "hello";
	}
	
}
