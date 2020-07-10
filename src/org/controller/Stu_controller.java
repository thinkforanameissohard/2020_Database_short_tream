package org.controller;
/**
 * 这里可以得到学生表的数据
 * 修改完成
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dao.DBBean;
import org.entity.Student;

public class Stu_controller {
	
	
	/**
	 * 查很多条数据
	 * 从student表中获取所有的学生信息
	 * @return student的数组
	 */
	public static ArrayList<Student> getList(){
		ArrayList<Student> Stu_list=new ArrayList<Student>();
		String sql="select * from student";
		DBBean jdbc=new DBBean();
		ResultSet rs=null;
		rs=jdbc.executeQuery(sql);
		
        try {
        	
			while(rs.next())
			{
				Student bi=new Student();
				bi.setSno(rs.getString("sno"));
				bi.setSaddress(rs.getString("saddress"));
				bi.setSbirth(rs.getString("sbirth"));
				bi.setSage(rs.getInt("sage"));
				bi.setSname(rs.getString("sname"));
				bi.setPassword(rs.getInt("password"));
				
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
	 * 获取指定sno的学生
	 * @param sno 学号
	 * @return 一个Student对象
	 */
	public static Student getById(String id){
		String sql="select * from student where sno='%s'";
		DBBean jdbc=new DBBean();
		
		ResultSet rs=jdbc.executeQuery(String.format(sql, id)); //防止SQL注入
		Student bi=new Student();
        try {
			if(rs.next())
			{
				bi.setSno(rs.getString("sno"));
				bi.setSaddress(rs.getString("saddress"));
				bi.setSbirth(rs.getString("sbirth"));
				bi.setSage(rs.getInt("sage"));
				bi.setSname(rs.getString("sname"));
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
	 * @param Student 一条学生的信息
	 * @return 修改的结果：1代表成功，0代表没有更新
	 */
	public static int update(Student one){
		int result=0;
		String sql = "update student set sname='%s',sage='%s',sbirth='%s',saddress='%s',password=%d where sno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, one.getSname(),one.getSage(),one.getSbirth(),one.getSaddress(),one.getPassword(),one.getSno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 删除指定id的学生
	 * @param id 学号
	 * @return 删除的结果：1代表成功，0代表没有删除
	 */
	public static int delete(String id){
		int result=0;
//		String sql="delete from student where sno='%s'";
		String sql="delete_student @sno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, id));
		jdbc.close();
		return result;
	}
	
	/**
	 * 增加一个学生
	 * @param Student 一条学生的信息
	 * @return 新增的结果：1代表成功，0代表没有增加
	 */
	public static int add(Student one){
		int result=0;
		String sql = "insert into student(sno,sname,sage,sbirth,saddress,password) values('%s','%s',%d,'%s','%s',%d)";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, one.getSno(),one.getSname(),one.getSage(),one.getSbirth(),one.getSaddress(),one.getPassword()));
		jdbc.close();
		return result;
	}
}
