package com.tian.zone.service.moment.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dao.moment.MomentDAO;
import com.tian.zone.dto.moment.MomentDTO;
import com.tian.zone.service.moment.MomentService;

/**
 * <p>Title:MomentServiceImpl</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年10月5日 下午6:34:34
 **/
@Service
public class MomentServiceImpl implements MomentService {

	private static final Logger log = LoggerFactory.getLogger(MomentServiceImpl.class);
	
	@Autowired
	private MomentDAO momentDAO;
	
	@Override
	public JSONObject add(JSONObject req) {
		log.info("moment add req:"+JSONObject.toJSONString(req));
		MomentDTO momentDTO = new MomentDTO();
		momentDTO = JSONObject.toJavaObject(req, MomentDTO.class);
		LocalDateTime ld = LocalDateTime.now();
		String date = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		momentDTO.setDateCreated(date);
		int result = momentDAO.insert(momentDTO);
		JSONObject respOjb = new JSONObject();
		respOjb.put("result", result);
		return respOjb;
	}

	@Override
	public JSONObject delete(JSONObject req) {
		log.info("moment delete req:"+JSONObject.toJSONString(req));
		MomentDTO momentDTO = new MomentDTO();
		momentDTO = JSONObject.toJavaObject(req, MomentDTO.class);
		int result = momentDAO.delete(momentDTO);
		JSONObject respOjb = new JSONObject();
		respOjb.put("result", result);
		return respOjb;
	}

	@Override
	public JSONObject all() {
		log.info("moment get all");
		List<MomentDTO> result = momentDAO.getAll();
		JSONObject respOjb = new JSONObject();
		respOjb.put("result", result);
		return respOjb;
	}

}
