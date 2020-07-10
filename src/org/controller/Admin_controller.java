package org.controller;

/**
 * 这里可以得到管理员表的数据
 * 修改完成
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dao.DBBean;
import org.entity.Administrator;

public class Admin_controller {
	
	
	/**
	 * 查很多条数据
	 * 从Administrator表中获取所有的管理员信息
	 * @return student的数组
	 */
	public static ArrayList<Administrator> getList(){
		ArrayList<Administrator> Ad_list=new ArrayList<Administrator>();
		String sql="select * from  Administrator";
		DBBean jdbc=new DBBean();
		ResultSet rs=null;
		rs=jdbc.executeQuery(sql);
		
        try {
        	
			while(rs.next())
			{
				Administrator bi=new Administrator();
				bi.setAno(rs.getString("ano"));
				bi.setAname(rs.getString("aname"));
				bi.setPassword(rs.getInt("password"));
				Ad_list.add(bi);
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
        return Ad_list;
	}

	/**
	 * 查一条数据
	 * 获取指定Ano的管理员
	 * @param Ano 学号
	 * @return 一个Administrator对象
	 */
	public static Administrator getById(String id){
		String sql="select * from administrator where ano='%s'";
		DBBean jdbc=new DBBean();
		
		ResultSet rs=jdbc.executeQuery(String.format(sql, id)); //防止SQL注入
		Administrator bi=new Administrator();
        try {
			if(rs.next())
			{
				bi.setAno(rs.getString("ano"));
				bi.setAname(rs.getString("aname"));
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
	 * @param Administrator 一条管理员的信息
	 * @return 修改的结果：1代表成功，0代表没有更新
	 */
	public static int update(Administrator one){
		int result=0;
		String sql = "update administrator set aname='%s',password=%d where ano='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, one.getAname(),one.getPassword(),one.getAno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 删除指定id的管理员
	 * @param id 学号
	 * @return 删除的结果：1代表成功，0代表没有删除
	 */
	public static int delete(String id){
		int result=0;
		String sql="delete from administrator where ano=%s";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, id));
		jdbc.close();
		return result;
	}
	
	/**
	 * 增加一个管理员
	 * @param Administrator 一条管理员的信息
	 * @return 新增的结果：1代表成功，0代表没有增加
	 */
	public static int add(Administrator one){
		int result=0;
		String sql = "insert into administrator(ano,aname,password) values('%s','%s',%d)";
		DBBean jdbc=new DBBean();
		
		result=jdbc.executeUpdate(String.format(sql, one.getAno(),one.getAno(),one.getPassword()));
		jdbc.close();
		return result;
	}
}
