package com.tian.zone.controller.moment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.service.moment.MomentService;

/**
 * <p>Title:MomentController</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年10月4日 下午2:23:38
 **/
@Controller
@RequestMapping("/moment")
public class MomentController {

	private static final Logger log = LoggerFactory.getLogger(MomentController.class);

	@Autowired
	MomentService momentService;
	@RequestMapping(value="/add.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject add(@RequestBody JSONObject req){
		log.info("create a moment");
		JSONObject resp = new JSONObject();
		resp = momentService.add(req);
		return resp;
	}
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject delete(@RequestBody JSONObject req){
		log.info("delete a moment");
		JSONObject resp = new JSONObject();
		resp = momentService.delete(req);
		return resp;
	}
	@RequestMapping(value="/all.do",method=RequestMethod.POST)
	public @ResponseBody JSONObject all(){
		log.info("get all moment");
		JSONObject resp = new JSONObject();
		resp = momentService.all();
		return resp;
	}
}
