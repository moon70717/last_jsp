package util;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.last.jsp.common.MybatisSqlSessionFactory;

public class GenerateSQL {

	public static String generateSql(String tableName) {
		return "select * from "+tableName;
	}
	
	public static void main(String[]args) {
		try(SqlSession ss=MybatisSqlSessionFactory.getSS()){
			String sql=generateSql("user_info");
			String tableName="user_info";
			List<Map<String,String>> colList=ss.selectList("common.selectTable",tableName);
			String selectSql="";
			String updateSql="";
			String deleteSql="";
			String insertSql="";
			for(Map<String,String> m:colList) {
				selectSql+=m.get("colName")+",";
				insertSql+=m.get("colName")+",";
				updateSql+=m.get("colName")+"=?,";
			}
			System.out.println(colList.get(0).get("colName"));
			selectSql="select "+selectSql.substring(0,selectSql.length()-1)+" from "+tableName;
			System.out.println(selectSql);
			insertSql="insert into "+tableName+"("+insertSql.substring(0,insertSql.length()-1)+") values(?,?,?,?,?,?,now(),?)";
			System.out.println(insertSql);
			updateSql="update "+tableName+" set "+updateSql.substring(0,updateSql.length()-1)+"where uino=?";
			System.out.println(updateSql);
			deleteSql="delete from "+tableName+" where uino=?";
			System.out.println(deleteSql);
		}
	}
	
	public String mkSelect(String tableName) {
		String selectSql="";
		List<Map<String,String>> colList=getColList(tableName);
		for(Map<String,String> m:colList) {
			selectSql+=m.get("colName")+",";
		}
		selectSql="select "+selectSql.substring(0,selectSql.length()-1)+" from "+tableName;
		return selectSql;
	}
	
	public List<Map<String,String>> getColList(String tableName){
		try(SqlSession ss=MybatisSqlSessionFactory.getSS()){
			return ss.selectList("common.selectTable",tableName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
