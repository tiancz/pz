package com.tian.zone.controller.article;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="/articleList.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject articleList(@RequestBody JSONObject req){
		LOGGER.info("req:"+JSONObject.toJSONString(req));
		req.put("type", "tag");
		JSONObject resp = new JSONObject();
		Map<String,List<ArticleDTO>> article = articleService.getAllArticle(req);
		resp.put("articles", article);
		LOGGER.info("resp:"+JSONObject.toJSONString(resp));
		return resp;
	}
	@RequestMapping(value="/articleDetial.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject articleDetail(HttpServletRequest req){
		LOGGER.info("article id:"+req.getParameter("id"));
		JSONObject resp = new JSONObject();
		ArticleDTO article = articleService.getArticleDetail(req.getParameter("id"));
		resp.put("article", article);
		LOGGER.info("resp:"+JSONObject.toJSONString(resp));
		return resp;
	}
	
	@RequestMapping(value="/addArticle.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject addArticle(@RequestBody JSONObject req){
		LOGGER.info("add a article");
		LOGGER.info("note:"+JSONObject.toJSONString(req));
		JSONObject resp = new JSONObject();
		String title = req.getString("title");
        String content = req.getString("note");
        String categoryId = req.getString("categoryId");
		ArticleDTO article = new ArticleDTO();
        article.setTitle(title);
		article.setContent(content);
		article.setCategoryId(categoryId);
		articleService.insertArticle(article);
		resp.put("article", article);
		return resp;
	}
}
