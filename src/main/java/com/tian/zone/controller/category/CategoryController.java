package com.tian.zone.controller.category;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dto.article.CategoryDTO;
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
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/categoryList.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject categoryList(){
		JSONObject resp = new JSONObject();
		List<CategoryDTO> categoryLists = categoryService.categoryList();
		resp.put("dataList", categoryLists);
		return resp;
	}
	@RequestMapping(value="/createCategory.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject createCategory(@RequestBody JSONObject req){
		JSONObject resp = new JSONObject();
		log.info("createCategory req"+JSONObject.toJSONString(req));
		int result = categoryService.createCategory(JSONObject.toJavaObject(req, CategoryDTO.class));
		resp.put("", result);
		return resp;
	}
}
