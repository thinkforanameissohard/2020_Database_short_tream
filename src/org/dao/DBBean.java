package org.dao;
import java.sql.*;
/**
 * 淇敼瀹屾垚
 * 杩欓噷杩涜鐨勬槸SQL server鏁版嵁搴撶殑杩炴帴
 * @author 鍧傜敯閾舵椂
 *
 */
public class DBBean {
	private String driverStr = "com.mysql.jdbc.Driver";
	private String URL="jdbc:mysql://localhost:3306/Management?useSSL=false&useUnicode=true&characterEncoding=utf-8";
//	private String URL="jdbc:mysql://localhost:3306;DatabaseName=CouseManage";
	private String USERNAME = "admin1";
	private String PWD="123456789";
	private Connection conn = null;
	private Statement stmt = null;
	
	/**
	 * 杩炴帴鏁版嵁搴�
	 * @param sql
	 * 瑕佹墽琛岀殑璇彞 
	 * */
	public DBBean() {
		try {
			Class.forName(driverStr);
			conn = DriverManager.getConnection(URL, USERNAME,PWD);
			stmt = conn.createStatement();
		} catch (Exception ex) {
				System.out.println("数据库连接失败! ");
		}
	}

	/**
	 * 鎵ц鏇存柊锛堝鍒犳敼锛夋搷浣�
	 * @param 
	 * SQL璇彞
	 * @return int
	 * 鏇存柊鎿嶄綔鐨勭粨鏋� 
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
	 * 鎵ц鏌ヨ锛堟煡锛夋搷浣�
	 * @param 
	 * SQL璇彞
	 * @return ResultSet
	 * 鏌ヨ缁撴灉  
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
	 * 鍏抽棴鏁版嵁搴�
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
