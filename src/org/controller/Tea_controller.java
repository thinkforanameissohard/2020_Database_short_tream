package org.controller;
/**
 * 执行一些数据的操作
 * */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dao.DBBean;
import org.entity.Teacher;

public class Tea_controller {
	
	
	/**
	 * 查很多条数据
	 * 从Teacher表中获取所有的教师信息
	 * @return student的数组
	 */
	public static ArrayList<Teacher> getList(){
		ArrayList<Teacher> list=new ArrayList<Teacher>();
		String sql="select * from teacher";
		DBBean jdbc=new DBBean();
		ResultSet rs=null;
		rs=jdbc.executeQuery(sql);
		
        try {
        	
			while(rs.next())
			{
				Teacher bi=new Teacher();
				bi.setTno(rs.getString("tno"));
				bi.setTaddress(rs.getString("taddress"));
				bi.setTbirth(rs.getString("tbirth"));
				bi.setTage(rs.getInt("tage"));
				bi.setTname(rs.getString("tname"));
				bi.setPassword(rs.getInt("password"));
				
				list.add(bi);
			}
			 rs.close();
		} catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		jdbc.close();
        return list;
	}

	/**
	 * 查一条数据
	 * 获取指定id的教师
	 * @param id 学号
	 * @return 一个Teacher对象
	 */
	public static Teacher getById(String id){
		String sql="select * from teacher where tno='%s'";
		DBBean jdbc=new DBBean();
		
		ResultSet rs=jdbc.executeQuery(String.format(sql, id)); //防止SQL注入
		Teacher bi=new Teacher();
        try {
			if(rs.next())
			{
				bi.setTno(rs.getString("tno"));
				bi.setTaddress(rs.getString("taddress"));
				bi.setTbirth(rs.getString("tbirth"));
				bi.setTage(rs.getInt("tage"));
				bi.setTname(rs.getString("tname"));
				bi.setPassword(rs.getInt("password"));
			}
			
		}
        catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
        finally 
		{
			try {
				if(rs!=null) rs.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

        jdbc.close();
        return bi;
	}

	/**
	 * 更新一条数据
	 * @param Teacher 一条教师的信息
	 * @return 修改的结果：1代表成功，0代表没有更新
	 */
	public static int update(Teacher one){
		int result=0;
		String sql = "update teacher set tname='%s',tage=%d,tbirth='%s',taddress='%s',password=%d where tno='%s'";
		DBBean jdbc=new DBBean();
		
		result=jdbc.executeUpdate(String.format(sql, one.getTname(),one.getTage(),one.getTbirth(),one.getTaddress(),one.getPassword(),one.getTno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 删除指定id的教师
	 * @param id 学号
	 * @return 删除的结果：1代表成功，0代表没有删除
	 */
	public static int delete(String id){
		int result=0;
//		String sql="delete from teacher where tno='%s'";
		String sql="delete_teacher @tno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, id));
		jdbc.close();
		return result;
	}
	
	/**
	 * 增加一个教师
	 * @param Teacher 一条教师的信息
	 * @return 新增的结果：1代表成功，0代表没有增加
	 */
	public static int add(Teacher one){
		int result=0;
		String sql = "insert into teacher(tno,tname,tage,tbirth,taddress,password) values('%s','%s',%d,'%s','%s', %d)";
		DBBean jdbc=new DBBean();
		System.out.println();
		result=jdbc.executeUpdate(String.format(sql,one.getTno(),one.getTname(),one.getTage(),one.getTbirth(),one.getTaddress(),one.getPassword()));
		jdbc.close();
		return result;
	}
}
