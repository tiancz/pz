package com.tian.zone.service.category.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<CategoryDTO> categoryList(){
		return categoryDAO.categoryList();
	}
	
	@Override
	public int createCategory(CategoryDTO category) {
		int result = categoryDAO.insertCategory(category);
		log.info("insert category's result:"+JSONObject.toJSONString(result));
		return 0;
	}
}
