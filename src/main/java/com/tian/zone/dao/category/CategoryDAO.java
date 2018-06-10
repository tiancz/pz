package com.tian.zone.dao.category;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dto.article.CategoryDTO;

/**
 * <p>Title:CategoryDAO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2017年10月8日 下午3:40:07
 **/
public interface CategoryDAO {
	public JSONObject categoryList(JSONObject obj);
	public int createCategory(CategoryDTO category);
}
