package com.tian.zone.controller.tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.service.tag.TagService;

/**
 * <p>Title:TagController</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年6月6日 上午12:17:11
 **/
@Controller
@RequestMapping("/tag")
public class TagController {
	private static final Logger log = LoggerFactory.getLogger(TagController.class);
	@Autowired
	private TagService tagService;
	
	@RequestMapping(value="/tagList.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject tagList(){
		JSONObject resp = new JSONObject();
		resp = tagService.tagList(new JSONObject());
		return resp;
	}

	@RequestMapping(value="/addTag.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject addTag(@RequestBody JSONObject req){
		JSONObject resp = new JSONObject();
		log.info("前端请求："+JSONObject.toJSONString(req));
		resp = tagService.addTag(req);
		return resp;
	}
}
