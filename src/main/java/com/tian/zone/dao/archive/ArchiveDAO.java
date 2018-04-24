package com.tian.zone.dao.archive;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>Title:ArchiveDAO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年4月24日 下午11:46:35
 **/
public interface ArchiveDAO {
	public JSONObject getYear();
	public JSONObject getMonth(String year);
}
