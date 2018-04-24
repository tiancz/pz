package com.tian.zone.service.archive.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.archive.ArchiveDAO;
import com.tian.zone.service.archive.ArchiveService;

/**
 * <p>Title:ArchiveServiceImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年4月24日 下午11:40:04
 **/
@Service
public class ArchiveServiceImpl implements ArchiveService {

	private static final Logger log = LoggerFactory.getLogger(ArchiveServiceImpl.class);
	
	@Autowired
	private ArchiveDAO archiveDAO;
	@Override
	public JSONObject getYear(JSONObject req) {
		JSONObject resp = new JSONObject();
		JSONObject years = archiveDAO.getYear();
		JSONArray array = new JSONArray();
		array = years.getJSONArray("dataList");
		Set<String> result = new HashSet<>();
		for (Object obj : array) {
			String year = (String)obj;
			result.add(year.substring(0, 4));
		}
		resp.put("years", result);
		log.info("resp:"+resp.toJSONString());
		return resp;
	}

	@Override
	public JSONObject getMonth(JSONObject req) {
		JSONObject resp = new JSONObject();
		String year = req.getString("year");
		resp = archiveDAO.getMonth(year);
		log.info("resp:"+resp.toJSONString());
		return resp;
	}

}
