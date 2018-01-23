package com.last.jsp.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.last.jsp.DAO.UserDAO;
import com.last.jsp.DAO.impl.UserDAOImpl;
import com.last.jsp.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO uDAO= new UserDAOImpl();
	@Override
	public void getUserList(HttpServletRequest req) {
		req.setAttribute("userList", uDAO.getUserList());
	}

}
