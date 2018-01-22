package com.last.jsp.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {

	private static SqlSessionFactory ssf;
	private static SqlSession ss;
	static {
		try(InputStream is=Resources.getResourceAsStream("conf/mybatis-config.xml")) {
			ssf=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSSF() {
		return ssf;
	}
	public static SqlSession getSS() {
		ss=ssf.openSession();
		return ss;
	}
}
