package com.tian.zone.service.article.impl;

import java.util.ArrayList;
import java.util.List;

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
}
