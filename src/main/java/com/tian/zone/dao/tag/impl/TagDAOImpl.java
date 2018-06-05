package com.tian.zone.dao.tag.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.BaseDAO;
import com.tian.zone.dao.tag.TagDAO;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(TagDAOImpl.class);
	
	public JSONObject tagList(JSONObject obj){
		JSONObject result = new JSONObject();
		List<TagDTO> list = CDUtil().selectList("getTags");
		result.put("dataList", list);
		LOGGER.info("result:"+JSONObject.toJSONString(list));
		return result;
	}
}
