package com.tian.zone.service.archive;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>Title:ArchiveService</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年4月24日 下午11:39:45
 **/
public interface ArchiveService {
	public JSONObject getYear(JSONObject req);
	public JSONObject getMonth(JSONObject req);
}
