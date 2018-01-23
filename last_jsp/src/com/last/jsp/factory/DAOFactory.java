package com.last.jsp.factory;

import java.util.HashMap;
import java.util.Map;

import com.last.jsp.DAO.DAO;
import com.last.jsp.DAO.impl.MenuDAOImpl;
import com.last.jsp.DAO.impl.UserDAOImpl;

public class DAOFactory {

	private static Map<String, DAO> DAOMap = new HashMap<String, DAO>();

	private DAOFactory() {

	}

	public static DAOFactory getInstance() {
		return new DAOFactory();
	}

	private void initIntance(String DAOName) {
		if(DAOName.equals("menu")) {
			DAOMap.put(DAOName, new MenuDAOImpl());
		} else if(DAOName.equals("user")) {
			DAOMap.put(DAOName, new UserDAOImpl());
		}
	}
	
	public DAO getDAO(String DAOName) {
		if(!DAOMap.containsKey(DAOName)) {
			initIntance(DAOName);
		}
		return DAOMap.get(DAOName);
	}
	
}
