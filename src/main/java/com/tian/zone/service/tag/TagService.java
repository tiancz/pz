package com.tian.zone.service.tag;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tian.zone.dto.article.TagDTO;

/**
 * <p>Title:TagService</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年6月6日 上午12:18:37
 **/
public interface TagService {
	public List<TagDTO> tagList(List<Integer> ids);
	public JSONObject addTag(TagDTO tag);
}
