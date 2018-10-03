package com.tian.zone.service.tag.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.tag.TagDAO;
import com.tian.zone.dto.article.TagDTO;
import com.tian.zone.service.tag.TagService;

/**
 * <p>Title:TagServiceImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年6月6日 上午12:19:39
 **/
@Service
public class TagServiceImpl implements TagService {

	private static final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);
	@Autowired
	private TagDAO tagDAO;
	@Override
	public List<TagDTO> tagList(List<Integer> ids) {
		return tagDAO.getTags(ids);
	}
	@Override
	public JSONObject addTag(TagDTO tag) {
		log.info("请求："+JSONObject.toJSONString(tag));
		tagDAO.insertTag(tag);
		return JSONObject.parseObject(JSONObject.toJSONString(tag));
	}

}
