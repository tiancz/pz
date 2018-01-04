package com.tian.zone.controller.article;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dto.article.ArticleDTO;
import com.tian.zone.service.article.ArticleService;

/**
 * <p>Title:ArticleController</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月4日 下午11:08:31
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;
	@RequestMapping("/articleDetial.do")
	public ModelAndView articleDetail(HttpServletRequest request,ModelAndView model){
		LOGGER.info("article id:"+request.getParameter("id"));
		ArticleDTO article = articleService.getArticleDetail((String)request.getParameter("id"));
		model.setViewName("note/noteDetail");
		model.addObject("article", article);
		LOGGER.info("model:"+JSONObject.toJSONString(model));
		return model;
	}
}
