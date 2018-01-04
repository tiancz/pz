package com.tian.zone.dao.article.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tian.zone.dao.BaseDAO;
import com.tian.zone.dao.article.ArticleDAO;
import com.tian.zone.dto.article.ArticleDTO;

/**
 * <p>Title:ArticleDAOImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月3日 下午10:32:03
 **/
@Repository("articleDao")
public class ArticleDAOImpl extends BaseDAO implements ArticleDAO {
	
	@Override
	public List<ArticleDTO> getAllArticle() {
		List<ArticleDTO> articles = new ArrayList<>();
		articles = CDUtil().selectList("getAllArticle");
		return articles;
	}

	@Override
	public int insertArticle(String sql, ArticleDTO article) {
		return CDUtil().insert(sql, article);
	}

	@Override
	public ArticleDTO getArticleById(String sql,String id) {
		ArticleDTO article = new ArticleDTO();
		article = CDUtil().selectOne(sql,id);
		return article;
	}
	
	public int deleteArticleById(String sql,String id){
		return CDUtil().delete(sql, id);
	}

}
