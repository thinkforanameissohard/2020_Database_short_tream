package org.controller;
/**
 * 这里可以得到成绩表的数据
 * 修改完成
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dao.DBBean;
import org.entity.Sc;

public class Sc_controller {
	
	
	/**
	 * 查很多条数据
	 * 从sc表中获取tno老师带的班所有的学生成绩信息
	 * @return sc的数组
	 */
	public static ArrayList<Sc> getList(String id){
		ArrayList<Sc> Sc_list=new ArrayList<Sc>();
		String sql="select * from sc where tno='%s'";
		DBBean jdbc=new DBBean();
		ResultSet rs=null;
		rs=jdbc.executeQuery(String.format(sql, id));
		
        try {
        	
			while(rs.next())
			{
				Sc bi=new Sc();
				bi.setSno(rs.getString("sno"));
				bi.setCcontent(rs.getString("ccontent"));
				bi.setCno(rs.getString("cno"));
				bi.setResults(rs.getString("results"));
				bi.setTno(rs.getString("tno"));
				
				Sc_list.add(bi);
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
        return Sc_list;
	}

	/**
	 * 查一条数据
	 * 获取指定sno的cno课的成绩
	 * @param sno 学号,tno 教师号
	 * @return 一个sc对象
	 */
	public static Sc getById(Sc id){
		String sql="select * from sc where sno='%s' and tno='%s' and cno='%s'";
		DBBean jdbc=new DBBean();
		
		ResultSet rs=jdbc.executeQuery(String.format(sql, id.getSno(),id.getTno(),id.getCno())); //防止SQL注入
		Sc bi=new Sc();
        try {
			if(rs.next())
			{
				bi.setSno(rs.getString("sno"));
				bi.setCcontent(rs.getString("ccontent"));
				bi.setCno(rs.getString("cno"));
				bi.setResults(rs.getString("results"));
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
	 * @param sc 一条成绩的信息
	 * @return 修改的结果：1代表成功，0代表没有更新
	 */
	public static int update(Sc one){
		int result=0;
		String sql = "update sc set results='%s',ccontent='%s' where sno='%s' and tno='%s' and cno='%s'";
		
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, one.getResults(),one.getCcontent(),one.getSno(),one.getTno(),one.getCno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 删除指定id的成绩
	 * @param id 学号
	 * @return 删除的结果：1代表成功，0代表没有删除
	 */
	public static int delete(Sc id){
		int result=0;
		String sql="delete from sc where  sno='%s' and tno='%s' and cno='%s'";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, id.getSno(),id.getTno(),id.getCno()));
		jdbc.close();
		return result;
	}
	
	/**
	 * 增加一个成绩
	 * @param sc 一条成绩的信息
	 * @return 新增的结果：1代表成功，0代表没有增加
	 */
	public static int add(Sc one){
		int result=0;
		String sql = "insert into sc(sno,cno,tno,results,ccontent) values('%s','%s','%s','%s','%s')";
		DBBean jdbc=new DBBean();
		result=jdbc.executeUpdate(String.format(sql, one.getSno(),one.getCno(),one.getTno(),one.getResults(),one.getCcontent()));
		jdbc.close();
		return result;
	}
}
