package com.tian.zone.dao.tag.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.BaseDAO;
import com.tian.zone.dao.tag.TagDAO;
import com.tian.zone.dto.article.TagBlogDTO;
import com.tian.zone.dto.article.TagDTO;

/**
 * <p>Title:TagDAOImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月23日 下午10:36:12
 **/
@Repository("tagDAO")
public class TagDAOImpl extends BaseDAO implements TagDAO {
	private static final Logger log = LoggerFactory.getLogger(TagDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	public JSONObject tagList(JSONObject obj){
		JSONObject result = new JSONObject();
		List<TagDTO> list = new ArrayList<>();
		if(!ObjectUtils.isEmpty(obj)){
			List<Integer> ids = (List<Integer>)obj.get("ids");
			list = CDUtil().selectList("getTagsById",ids);
		}else{
			list = CDUtil().selectList("getTags");
		}
		result.put("dataList", list);
		log.info("result:"+JSONObject.toJSONString(list));
		return result;
	}
	public int addTagBlog(String sql, TagBlogDTO tagBlog) {
		return CDUtil().insert(sql, tagBlog);
	}
	public int addTag(String sql, TagDTO tag){
		return CDUtil().insert(sql, tag);
	}
	public JSONObject getTagsByBlogId(JSONObject obj){
		JSONObject result = new JSONObject();
		log.info("getTagsByBlogId tag'req:"+JSONObject.toJSONString(obj));
		String blogId = obj.getString("blogId");
		List<TagBlogDTO> list = CDUtil().selectList("getTagsByBlogId",blogId);
		result.put("dataList", list);
		log.info("result:"+JSONObject.toJSONString(list));
		return result;
	}
}
