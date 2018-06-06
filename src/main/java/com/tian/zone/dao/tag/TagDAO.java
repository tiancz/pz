package com.tian.zone.dao.tag;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dto.article.TagBlogDTO;
import com.tian.zone.dto.article.TagDTO;

/**
 * <p>Title:TagDAO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月23日 下午10:35:26
 **/
public interface TagDAO {
	public JSONObject tagList(JSONObject obj);
	public int addTagBlog(String sql, TagBlogDTO tagBlog);
	public int addTag(String sql, TagDTO tag);
	public JSONObject getTagsByBlogId(JSONObject obj);
}
