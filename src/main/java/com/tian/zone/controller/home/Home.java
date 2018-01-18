package com.tian.zone.controller.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public @ResponseBody JSONObject toHome(){
		LOGGER.info("to home");
		JSONObject resp = new JSONObject();
		List<ArticleDTO> articles = articleService.getAllArticle();
		resp.put("articles", articles);
		LOGGER.info("resp:"+JSONObject.toJSONString(resp));
		return resp;
	}
	
}
