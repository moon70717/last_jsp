package com.last.jsp.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.last.jsp.DAO.MenuDAO;
import com.last.jsp.DAO.impl.MenuDAOImpl;
import com.last.jsp.service.MenuService;

public class MenuServiceImpl implements MenuService {

	MenuDAO mdao=new MenuDAOImpl();
	
	@Override
	public void getMenuList(HttpServletRequest req) {
		req.setAttribute("menuList",mdao.selectMenuList());
	}

}
