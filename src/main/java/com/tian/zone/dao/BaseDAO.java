package com.tian.zone.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * <p>Title:BaseDao</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2017年10月8日 下午3:30:19
 **/
public class BaseDAO {

	@Autowired
	@Qualifier("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory;
	
	public SqlSession session;
	
	public SqlSession CDUtil(){
		session = sqlSessionFactory.openSession();
		return session;
	}
}
