package com.tian.zone.service.article.impl;

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
import com.tian.zone.dao.tag.TagDAO;
import com.tian.zone.dto.article.ArticleDTO;
import com.tian.zone.dto.article.TagBlogDTO;
import com.tian.zone.dto.article.TagDTO;
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

	private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Autowired
	private ArticleDAO articleDao;
	@Autowired
	private TagDAO tagDAO;
	@Override
	public List<ArticleDTO> getAllArticle() {
		List<ArticleDTO> articles = articleDao.getAllArticle();
		return articles;
	}

	@Override
	public Map<String, List<ArticleDTO>> getAllArticle(JSONObject req) {
		Map<String, List<ArticleDTO>> result = new HashMap<>();
		List<ArticleDTO> articles = articleDao.getAllArticle();
		log.info("articles:"+JSONObject.toJSONString(articles));
		String type = req.getString("type");
		log.info("type:"+type);
		for (ArticleDTO articleDTO : articles) {
			if("time".equals(type)){
				String time = articleDTO.getDateCreated();
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
				}else{
					if(result.containsKey(tag)){
						result.get(tag).add(articleDTO);
					}else{
						List<ArticleDTO> newArticles = new ArrayList<>();
						newArticles.add(articleDTO);
						result.put(tag, newArticles);
					}
				}
			}
			if("category".equals(type)){
				String category = articleDTO.getCategory();
				if(ObjectUtils.isEmpty(category)){
					List<ArticleDTO> newArticles = new ArrayList<>();
					newArticles.add(articleDTO);
					result.put("未分类", newArticles);
				}else{
					if(result.containsKey(category)){
						result.get(category).add(articleDTO);
					}else{
						List<ArticleDTO> newArticles = new ArrayList<>();
						newArticles.add(articleDTO);
						result.put(category, newArticles);
					}
				}
			}
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArticleDTO getArticleDetail(String id) {
		ArticleDTO article = articleDao.getArticleById("getArticleByID", id);
		JSONObject req = new JSONObject();
		req.put("blogId", id);
		JSONObject tagJobjs = tagDAO.getTagsByBlogId(req);
		List<TagBlogDTO> tagBlogList = (List<TagBlogDTO>)tagJobjs.get("dataList");
		List<Integer> ids = new ArrayList<>();
		for (int i = 0; i < tagBlogList.size(); i++) {
			TagBlogDTO tagBlogDTO = tagBlogList.get(i);
			ids.add(Integer.valueOf(tagBlogDTO.getTagId()));
		}
		log.info("tag's id:"+JSONObject.toJSONString(ids));

		JSONObject reqTags = new JSONObject();
		List<TagDTO> tagList = new ArrayList<>();
		if(!ObjectUtils.isEmpty(ids)){
			reqTags.put("ids", ids);
			JSONObject tagObjs = tagDAO.tagList(reqTags);
			tagList = (List<TagDTO>)tagObjs.get("dataList");
		}
		log.info("tags is :"+JSONObject.toJSONString(tagList));
		String tagStr = "";
		for (int i = 0; i < tagList.size(); i++) {
			if(i==0){
				TagDTO tagDTO = tagList.get(i);
				tagStr += tagDTO.getName();
			}else{
				TagDTO tagDTO = tagList.get(i);
				tagStr += ",";
				tagStr += tagDTO.getName();
			}
		}
		article.setTag(tagStr);
		return article;
	}
	@Override
	public ArticleDTO next(String id) {
		ArticleDTO article = articleDao.getArticleById("getNextByID", id);
		return article;
	}
	@Override
	public ArticleDTO pre(String id) {
		ArticleDTO article = articleDao.getArticleById("getPreByID", id);
		return article;
	}
	@Override
	public ArticleDTO insertArticle(ArticleDTO article) {
		article.setId(String.valueOf(System.currentTimeMillis()));
		article.setAuthor("nathanieltian");
//		yyyy-MM-dd HH:mm:ss
		article.setDateCreated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		article.setDateUpdated(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		String tags = article.getTag();
		String tagArr[] = tags.split(";");
		for (int i = 0; i < tagArr.length; i++) {
			String tag = tagArr[i];
			if(!ObjectUtils.isEmpty(tag)){
				TagBlogDTO tbDto = new TagBlogDTO();
				tbDto.setTagId(tag);
				tbDto.setBlogId(article.getId());
				tagDAO.addTagBlog("createBlogTag",tbDto);
				log.info("insert a tag and blog");
			}
		}
		int result = 0;
		result = articleDao.insertArticle("addArticle",article);
		if(result==0){
			log.info("insertArticle failure");
		}else{
			log.info("insert a Article");
		}
		return article;
	}
}
