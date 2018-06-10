package com.tian.zone.service.category.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.category.CategoryDAO;
import com.tian.zone.dto.article.CategoryDTO;
import com.tian.zone.service.category.CategoryService;

/**
 * <p>Title:CategoryServiceImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月19日 下午11:23:20
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryDAO categoryDAO;
	public JSONObject categoryList(JSONObject obj){
		return categoryDAO.categoryList(obj);
	}
	
	@Override
	public JSONObject createCategory(JSONObject req) {
		CategoryDTO category = new CategoryDTO();
		String name = req.getString("name");
		String parentId = req.getString("parentId");
		if(!ObjectUtils.isEmpty(name)){
			category.setName(name);
		}
		if(!ObjectUtils.isEmpty(parentId)){
			category.setParentId(parentId);
		}
		int result = categoryDAO.createCategory(category);
		log.info("insert category's result:"+JSONObject.toJSONString(result));
		return null;
	}
}
