package com.last.jsp.DAO;

import java.util.List;

import com.last.jsp.vo.UserInfo;

public interface UserDAO extends DAO{

	public List<UserInfo> getUserList();
}
