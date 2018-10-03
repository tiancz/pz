package com.tian.zone.service.category;

import java.util.List;

import com.tian.zone.dto.article.CategoryDTO;

/**
 * <p>Title:CategoryService</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月19日 下午11:21:08
 **/
public interface CategoryService {
	public List<CategoryDTO> categoryList();
	
	public int createCategory(CategoryDTO category);
}
