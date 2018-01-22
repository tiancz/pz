package com.tian.zone.dao.category.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.BaseDAO;
import com.tian.zone.dao.category.CategoryDAO;
import com.tian.zone.dto.article.CategoryDTO;

/**
 * <p>Title:CategoryDAOImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月19日 下午11:24:03
 **/
@Repository("categoryDAO")
public class CategoryDAOImpl extends BaseDAO implements CategoryDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	public JSONObject categoryList(JSONObject obj){
		JSONObject result = new JSONObject();
		List<CategoryDTO> list = CDUtil().selectList("getCategorys");
		result.put("dataList", list);
		LOGGER.info("result:"+JSONObject.toJSONString(list));
		return result;
	}
}
