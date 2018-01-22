package com.tian.zone.controller.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.service.category.CategoryService;

/**
 * <p>Title:CategoryController</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月19日 下午11:20:00
 **/
@Controller
@RequestMapping("/category")
public class CategoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/categoryList.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject categoryList(){
		JSONObject resp = new JSONObject();
		resp = categoryService.categoryList(new JSONObject());
		return resp;
	}
}
