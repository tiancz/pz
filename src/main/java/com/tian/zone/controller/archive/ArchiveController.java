package com.tian.zone.controller.archive;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.service.archive.ArchiveService;

/**
 * <p>Title:ArchiveController</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年4月24日 下午11:38:21
 **/
@Controller
@RequestMapping("/archive")
public class ArchiveController {

	private static final Logger log = LoggerFactory.getLogger(ArchiveController.class);

	@Autowired
	private ArchiveService archiveService;
	
	@RequestMapping(value="/getYear.do",method=RequestMethod.POST)
	public @ResponseBody String getYear(@RequestBody JSONObject req){
		log.info("req:"+JSONObject.toJSONString(req));
		JSONObject resp = new JSONObject();
		JSONObject article = archiveService.getYear(req);
		resp.put("article year", article);
		log.info("resp:"+JSONObject.toJSONString(resp));
		return resp.toJSONString();
	}

	@RequestMapping(value="/getMonth.do",method=RequestMethod.POST)
	public @ResponseBody String getMonth(@RequestBody JSONObject req){
		log.info("req:"+JSONObject.toJSONString(req));
		JSONObject resp = new JSONObject();
		JSONObject article = archiveService.getMonth(req);
		resp.put("article month", article);
		log.info("resp:"+JSONObject.toJSONString(resp));
		return resp.toJSONString();
	}
}
