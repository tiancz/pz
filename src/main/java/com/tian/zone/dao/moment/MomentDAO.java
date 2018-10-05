package com.tian.zone.dao.moment;

import java.util.List;

import com.tian.zone.dto.moment.MomentDTO;

/**
 * <p>Title:PictureDAO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2017年10月8日 下午3:41:49
 **/
public interface MomentDAO {
	public List<MomentDTO> getAll();
	
	public int insert(MomentDTO moment);
	
	public int delete(MomentDTO moment);
}
