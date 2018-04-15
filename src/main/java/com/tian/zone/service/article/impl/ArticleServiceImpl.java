package com.tian.zone.service.article.impl;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.article.ArticleDAO;
import com.tian.zone.dto.article.ArticleDTO;
import com.tian.zone.service.article.ArticleService;

/**
 * <p>Title:ArticleServiceImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月3日 下午10:02:03
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Autowired
	private ArticleDAO articleDao;
	@Override
	public List<ArticleDTO> getAllArticle() {
		List<ArticleDTO> articles = articleDao.getAllArticle();
		return articles;
	}

	@Override
	public Map<String, List<ArticleDTO>> getAllArticle(JSONObject req) {
		Map<String, List<ArticleDTO>> result = new HashMap<>();
		List<ArticleDTO> articles = articleDao.getAllArticle();
		LOGGER.info("articles:"+JSONObject.toJSONString(articles));
		String type = req.getString("type");
		
		for (ArticleDTO articleDTO : articles) {
			if("time".equals(type)){
				String time = articleDTO.getDateCreated().substring(0, 7);
				if(result.containsKey(time)){
					result.get(time).add(articleDTO);
				}else{
					List<ArticleDTO> newArticles = new ArrayList<>();
					newArticles.add(articleDTO);
					result.put(time, newArticles);
				}
			}
			if("tag".equals(type)){
				String tag = articleDTO.getTag();
				if(ObjectUtils.isEmpty(tag)){
					List<ArticleDTO> newArticles = new ArrayList<>();
					newArticles.add(articleDTO);
					result.put("无标签", newArticles);
				}
				if(result.containsKey(tag)){
					result.get(tag).add(articleDTO);
				}else{
					List<ArticleDTO> newArticles = new ArrayList<>();
					newArticles.add(articleDTO);
					result.put(tag, newArticles);
				}
			}
			if("category".equals(type)){
				String category = articleDTO.getCategory();
				if(result.containsKey(category)){
					result.get(category).add(articleDTO);
				}else{
					List<ArticleDTO> newArticles = new ArrayList<>();
					newArticles.add(articleDTO);
					result.put(category, newArticles);
				}
			}
		}
		return result;
	}
	
	@Override
	public ArticleDTO getArticleDetail(String id) {
		ArticleDTO article = articleDao.getArticleById("getArticleByID", id);
		return article;
	}
	@Override
	public ArticleDTO insertArticle(ArticleDTO article) {

		article.setId(System.currentTimeMillis()+"");
		article.setAuthor("nathanieltian");
//		yyyy-MM-dd HH:mm:ss
		article.setDateCreated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		article.setDateUpdated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		/*String tags = article.getTag();
		if(tags.split(",").length==1){
			tags = "'"+tags+"'";
		}else{
			tags = "'"+tags+"'";
			tags = tags.replace(",", "','");
		}
		article.setTag(tags);*/
		/*
		List<TagDTO> tagIds = categoryService.getTagIdByName("getTagIdByTagsName", article.getTag());
		String tagId = "";
		for (TagDTO tagDTO : tagIds) {
			tagId += tagDTO.getTagId();
		}
		for(int i=0;i<tagIds.size();i++){
			if(tagIds.size()==1){
				tagId = tagIds.get(0).getTagId();
			}else if(i==0){
				tagId = tagIds.get(0).getTagId();
			}else{
				tagId = tagId+","+tagIds.get(i).getTagId();
			}
		}
		article.setTagId(tagId);
		*/
		int result = 0;
		result = articleDao.insertArticle("addArticle",article);
		if(result==0){
			LOGGER.info("insertArticle failure");
		}else{
			LOGGER.info("insert a Article");
		}
		return article;
	}
	public String getMethod(String str) {
		return "get"+str.substring(0,1).toUpperCase()+str.substring(1, str.length());
	}
	public static void main(String[] args) throws Exception {
		ArticleDTO article = new ArticleDTO();
		article.setCategory("12");
		Method getCategory = article.getClass().getMethod("getCategory");
		String str = (String)getCategory.invoke(article.getClass().newInstance(), null);
		System.out.println(str);
	}
}
