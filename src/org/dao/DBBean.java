package org.dao;
import java.sql.*;
/**
 * 修改完成
 * 这里进行的是SQL server数据库的连接
 * @author 坂田银时
 *
 */
public class DBBean {
	private String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private String URL="jdbc:sqlserver://localhost:1521:CouseManage/?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
	private String URL="jdbc:sqlserver://localhost:1433;DatabaseName=CouseManage";
	private String USERNAME = "sa";
	private String PWD="rxy";
	private Connection conn = null;
	private Statement stmt = null;
	
	/**
	 * 连接数据库
	 * @param sql
	 * 要执行的语句 
	 * */
	public DBBean() {
		try {
			Class.forName(driverStr);
			conn = DriverManager.getConnection(URL, USERNAME,PWD);
			stmt = conn.createStatement();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * 执行更新（增删改）操作
	 * @param 
	 * SQL语句
	 * @return int
	 * 更新操作的结果 
	 */
	public int executeUpdate(String s) {
		int result = 0;
		try {
			result = stmt.executeUpdate(s);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 执行查询（查）操作
	 * @param 
	 * SQL语句
	 * @return ResultSet
	 * 查询结果  
	 */
	public ResultSet executeQuery(String s) {
		ResultSet rs = null;
		try {
			rs =  stmt.executeQuery(s);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}

	/**
	 * 关闭数据库
	 */
	public void close() {
		try
		{
			if(stmt!=null)	stmt.close();
			if(conn!=null)	conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
