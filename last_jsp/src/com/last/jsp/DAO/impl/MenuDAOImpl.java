package com.last.jsp.DAO.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.last.jsp.DAO.MenuDAO;
import com.last.jsp.common.MybatisSqlSessionFactory;

public class MenuDAOImpl implements MenuDAO {
	private static Logger log=Logger.getLogger(MenuDAOImpl.class);
	
	@Override
	public List<Map<String, String>> selectMenuList() {
		try (SqlSession ss=MybatisSqlSessionFactory.getSS()){
			return ss.selectList("menu.selectMenu");
		}catch(Exception e) {
			log.error("err =>{}",e);
		}
		return null;
	}
}
