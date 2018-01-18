package com.tian.zone.service.article;

import java.util.List;

import com.tian.zone.dto.article.ArticleDTO;

/**
 * <p>Title:ArticleService</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2017年10月8日 下午3:37:19
 **/
public interface ArticleService {
	
	public List<ArticleDTO> getAllArticle();
	
	public ArticleDTO getArticleDetail(String id);
	
	public ArticleDTO insertArticle(ArticleDTO article);
}
