package org.controller;
/**
 * 这里可以得到作业表的数据
 * 修改完成
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dao.DBBean;
import org.entity.Homework;

public class Home_controller {
	
	
	/**
	 * 查很多条数据
	 * 从homework表中获取tno老师布置的作业信息
	 * @return homework的数组
	 */
	public static ArrayList<Homework> getList(String tno){
		ArrayList<Homework> Home_list=new ArrayList<Homework>();
		String sql="select * from homework join teacher on teacher.tno=homework.tno where homework.tno='%s'";
		DBBean jdbc=new DBBean();
		ResultSet rs=null;
		rs=jdbc.executeQuery(String.format(sql, tno));
		
        try {
        	
			while(rs.next())
			{
				Homework bi=new Homework();
				bi.setCno(rs.getString("cno"));
				bi.setName(rs.getString("hname"));
				bi.setHcontent(rs.getString("hcontent"));
				bi.setHtime(rs.getString("htime"));
				bi.setSno(rs.getString("sno"));
				bi.setTno(rs.getString("tno"));
				
				Home_list.add(bi);
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
        return Home_list;
	}

	/**
	 * 查一条数据
	 * 获取指定cno和tno的作业
	 * @param cno 作业号
	 * @return 一个homework对象
	 */
	public static Homework getById(Homework id){
		String sql="select * from homework where cno='%s' and tno='%s' and sno='%s'";
		DBBean jdbc=new DBBean();
		
		ResultSet rs=jdbc.executeQuery(String.format(sql, id.getCno(),id.getTno(),id.getSno())); //防止SQL注入
		Homework bi=new Homework();
        try {
			if(rs.next())
			{
				bi.setCno(rs.getString("cno"));
				bi.setName(rs.getString("hname"));
				bi.setHcontent(rs.getString("hcontent"));
				bi.setHtime(rs.getString("htime"));
				bi.setSno(rs.getString("sno"));
				bi.setTno(rs.getString("tno"));
				
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
	 * @param Homework 一条作业的信息
	 * @return 修改的结果：1代表成功，0代表没有更新
	 */
	public static int update(Homework one){
		int result=0;
		String sql = "update homework set hname='%s',htime='%s',hcontent='%s' where cno='%s' and tno='%s' and sno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql,one.getName(),one.getHtime(),one.getHcontent(),one.getCno(),one.getTno(),one.getSno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 删除指定id的作业
	 * @param id 作业号
	 * @return 删除的结果：1代表成功，0代表没有删除
	 */
	public static int delete(Homework id){
		int result=0;
		String sql="delete from homework where cno='%s' and tno='%s' and sno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, id.getCno(),id.getTno(),id.getSno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 增加一个作业
	 * @param Homework 一条作业的信息
	 * @return 新增的结果：1代表成功，0代表没有增加
	 */
	public static int add(Homework one){
		int result=0;
		String sql = "insert into homework(hname,htime,hcontent,cno,tno,sno) values('%s','%s','%s','%s','%s','%s')";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql,one.getName(),one.getHtime(),one.getHcontent(),one.getCno(),one.getTno(),one.getSno()));
		jdbc.close();
		return result;
	}
}
