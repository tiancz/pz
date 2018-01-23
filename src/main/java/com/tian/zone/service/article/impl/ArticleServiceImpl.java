package com.tian.zone.service.article.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		List<ArticleDTO> newArticles = new ArrayList<>();
		for (ArticleDTO articleDTO : articles) {
			articleDTO.setDateCreated(articleDTO.getDateCreated().substring(0, 10));
			articleDTO.setDateUpdated(articleDTO.getDateUpdated().substring(0, 10));
			newArticles.add(articleDTO);
		}
		return articles;
	}
	@Override
	public ArticleDTO getArticleDetail(String id) {
		ArticleDTO article = articleDao.getArticleById("getArticleByID", id);
		article.setDateCreated(article.getDateCreated().substring(0, 10));
		article.setDateUpdated(article.getDateUpdated().substring(0, 10));
		return article;
	}
	@Override
	public ArticleDTO insertArticle(ArticleDTO article) {

		Date d = new Date();
		Random r = new Random();
		
		article.setTitle(article.getTitle());
		article.setContent(article.getContent());
//		article.setCategory(tags);
		article.setId(d.getTime()+""+r.nextInt(10));
		article.setAuthor("nathanieltian");
//		yyyy-MM-dd HH:mm:ss
		article.setDateCreated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		article.setDateUpdated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		article.setCategoryId(article.getCategoryId());
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
}
