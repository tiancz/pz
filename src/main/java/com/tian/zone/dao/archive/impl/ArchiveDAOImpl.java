package com.tian.zone.dao.archive.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.BaseDAO;
import com.tian.zone.dao.archive.ArchiveDAO;
import com.tian.zone.dto.article.CategoryDTO;

/**
 * <p>Title:ArchiveDAOImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年4月24日 下午11:47:05
 **/
@Repository("archiveDAO")
public class ArchiveDAOImpl extends BaseDAO implements ArchiveDAO {

	private static final Logger log = LoggerFactory.getLogger(ArchiveDAOImpl.class);
	
	@Override
	public JSONObject getYear() {
		JSONObject result = new JSONObject();
		List<CategoryDTO> list = CDUtil().selectList("getYear");
		result.put("dataList", list);
		log.info("result:"+JSONObject.toJSONString(list));
		return result;
	}

	@Override
	public JSONObject getMonth(String year) {
		JSONObject result = new JSONObject();
		List<String> list = CDUtil().selectList("getMonth",year);
		result.put("dataList", list);
		log.info("result:"+JSONObject.toJSONString(list));
		return result;
	}

}
