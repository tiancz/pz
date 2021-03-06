package com.tian.zone.dao.article;

import java.util.List;

import com.tian.zone.dto.article.ArticleDTO;


/**
 * <p>Title:ArticleDAO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月3日 下午10:19:24
 **/
public interface ArticleDAO {
	public List<ArticleDTO> getAllArticle();

	public ArticleDTO getArticleById(String id);
	
	public ArticleDTO getNextByID(String id);
	
	public ArticleDTO getPreByID(String id);
	
	public int addArticle(ArticleDTO article);

	public int deleteArticleById(String sql,String id);
}
