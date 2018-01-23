package com.last.jsp.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.last.jsp.DAO.UserDAO;
import com.last.jsp.common.MybatisSqlSessionFactory;
import com.last.jsp.vo.UserInfo;

public class UserDAOImpl implements UserDAO {
	private static Logger log=Logger.getLogger(MenuDAOImpl.class);
	@Override
	public List<UserInfo> getUserList() {
		List<UserInfo> userList=new ArrayList<UserInfo>();
		try(SqlSession ss=MybatisSqlSessionFactory.getSS()){
			 userList=ss.selectList("menu.selectUser");
			 log.info("userList= "+userList);
			 return userList;
			
		}catch(Exception e) {
			log.error("err =>{}",e);
		}
		return null;
	}

}
