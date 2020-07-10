package org.controller;
/**
 * 这里可以得到学生表的数据
 * 修改完成
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dao.DBBean;
import org.entity.Course;

public class Cour_controller {
	
	
	/**
	 * 查很多条数据
	 * 从course表中获取tno老师所有的课程信息
	 * @return course的数组
	 */
	public static ArrayList<Course> getList(String tno){
		ArrayList<Course> Stu_list=new ArrayList<Course>();
		String sql="select * from course join teacher on teacher.tno=course.tno where course.tno='%s'";
		DBBean jdbc=new DBBean();
		ResultSet rs=null;
		rs=jdbc.executeQuery(String.format(sql, tno));
		
        try {
        	
			while(rs.next())
			{
				Course bi=new Course();
				bi.setCno(rs.getString("cno"));
				bi.setCname(rs.getString("cname"));
				bi.setCoutline(rs.getString("coutline"));
				bi.setCredits(rs.getInt("credits"));
				bi.setTno(rs.getString("tno"));
				bi.setCplan(rs.getString("cplan"));
				
				Stu_list.add(bi);
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
        return Stu_list;
	}

	/**
	 * 查一条数据
	 * 获取指定cno的课程
	 * @param cno 课程号
	 * @return 一个Course对象
	 */
	public static Course getById(String id){
		String sql="select * from course where cno='%s'";
		DBBean jdbc=new DBBean();
		
		ResultSet rs=jdbc.executeQuery(String.format(sql, id)); //防止SQL注入
		Course bi=new Course();
        try {
			if(rs.next())
			{
				bi.setCno(rs.getString("cno"));
				bi.setCname(rs.getString("cname"));
				bi.setCoutline(rs.getString("coutline"));
				bi.setCredits(rs.getInt("credits"));
				bi.setTno(rs.getString("tno"));
				bi.setCplan(rs.getString("cplan"));
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
	 * @param Course 一条课程的信息
	 * @return 修改的结果：1代表成功，0代表没有更新
	 */
	public static int update(Course one){
		int result=0;
		String sql = "update course set cname='%s',coutline='%s',credits=%d,cplan='%s' where cno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, one.getCname(),one.getCoutline(),one.getCredits(),one.getCplan(),one.getCno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 删除指定id的课程
	 * @param id 课程号
	 * @return 删除的结果：1代表成功，0代表没有删除
	 */
	public static int delete(String id){
		int result=0;
		/*String sql="delete from course where cno='%s'";*/
		String sql="delete_course @cno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, id));
		jdbc.close();
		return result;
	}
	
	/**
	 * 增加一个课程
	 * @param Course 一条课程的信息
	 * @return 新增的结果：1代表成功，0代表没有增加
	 */
	public static int add(Course one){
		int result=0;
		String sql = "insert into course(cno,cname,coutline,credits,cplan,tno) values('%s','%s','%s',%d,'%s','%s')";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql,one.getCno(),one.getCname(),one.getCoutline(),one.getCredits(),one.getCplan(),one.getTno()));
		jdbc.close();
		return result;
	}
}
