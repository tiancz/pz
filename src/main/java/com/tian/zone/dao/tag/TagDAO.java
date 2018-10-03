package com.tian.zone.dao.tag;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tian.zone.dto.article.TagBlogDTO;
import com.tian.zone.dto.article.TagDTO;

/**
 * <p>Title:TagDAO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年1月23日 下午10:35:26
 **/
public interface TagDAO {
	public List<TagDTO> getTags(@Param("ids")List<Integer> ids);
	public int insertBlogTag(TagBlogDTO tagBlog);
	public int insertTag(TagDTO tag);
	public List<TagBlogDTO> getTagsByBlogId(String blogId);
}
