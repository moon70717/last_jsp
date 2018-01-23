package com.last.jsp.DAO;

import java.util.List;
import java.util.Map;

public interface MenuDAO extends DAO{

	public List<Map<String,String>> selectMenuList();
}
