package com.tian.zone.controller.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dto.article.ArticleDTO;
import com.tian.zone.service.article.ArticleService;

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

	@Autowired
	private ArticleService articleService;
	@RequestMapping("/home")
	public ModelAndView toHome(ModelAndView model){
		LOGGER.info("to home");
		List<ArticleDTO> articles = articleService.getAllArticle();
		model.setViewName("home");
		model.addObject("articles", articles);
		LOGGER.info("model:"+JSONObject.toJSONString(model));
		return model;
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
