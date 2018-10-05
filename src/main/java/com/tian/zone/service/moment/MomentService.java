package com.tian.zone.service.moment;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>Title:MomentService</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2017年10月8日 下午5:05:54
 **/
public interface MomentService {

	public JSONObject add(JSONObject req);
	
	public JSONObject delete(JSONObject req);
	
	public JSONObject all();
}
