package org.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.controller.Admin_controller;
import org.controller.Cour_controller;
import org.controller.Home_controller;
import org.controller.Sc_controller;
import org.controller.Stu_controller;
import org.controller.Tea_controller;
import org.entity.Administrator;
import org.entity.Course;
import org.entity.Homework;
import org.entity.Sc;
import org.entity.Student;
import org.entity.Teacher;


/**
 * 删除修改直接跳转到查询界面，用查询出来的结果，表示是否操作成功
 */
@WebServlet("*.do")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");
			String actionUrl=request.getServletPath();		//获取客户请求的Servlet地址
			
			
			
			if(actionUrl.equals("/tgrade.do"))
			{
				/**
				 * 教师：查看成绩
				 */
				String sno=request.getParameter("sno");
				String cno=request.getParameter("cno");
				String tno=(String) request.getSession().getAttribute("id");
				Sc id=new Sc();
				id.setSno(sno);
				id.setTno(tno);
				id.setCno(cno);
				
				if(sno!=null && cno!=null)//查一条
				{
					Sc bi=Sc_controller.getById(id);		
					request.setAttribute("bi", bi);							
				}
				else//查所有
				{
					ArrayList<Sc> list=Sc_controller.getList(tno);  
					request.setAttribute("list", list);					
				}
				request.getRequestDispatcher("/tgrade.jsp").forward(request, response); 
			}
		    else if(actionUrl.equals("/tgeditsave.do"))
		    {
		    	/**
				 * 教师：保存成绩
				 */
				/*System.out.print(request.getParameter("ccontent")+","+request.getParameter("cno")+","+request.getParameter("sno"));
				System.out.println(","+request.getParameter("results")+","+(String)request.getSession().getAttribute("id"));
				*/
		    	Sc one=new Sc();
				one.setCcontent(request.getParameter("ccontent").trim());				
				one.setCno(request.getParameter("cno"));
				one.setSno(request.getParameter("sno"));
				one.setResults(request.getParameter("results"));
				one.setTno((String)request.getSession().getAttribute("id"));
				
				/*System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+one.getCcontent()+","+one.getCno()+","+one.getResults()+","+one.getSno()+","+one.getTno());
				*/
				Sc_controller.update(one);
				response.sendRedirect("/2020project/tgrade.do");
		    }
			else if(actionUrl.equals("/tginsert.do"))
			{
				/**
				 * 教师：添加成绩
				 */
				/*System.out.print(request.getParameter("ccontent")+","+request.getParameter("cno")+","+request.getParameter("sno"));
				System.out.println(","+request.getParameter("results")+","+(String)request.getSession().getAttribute("id"));
				*/Sc one=new Sc();
				one.setCcontent(request.getParameter("ccontent").trim());				
				one.setCno(request.getParameter("cno"));
				one.setSno(request.getParameter("sno"));
				one.setResults(request.getParameter("results"));
				one.setTno((String)request.getSession().getAttribute("id"));
				
				Sc_controller.add(one);
				response.sendRedirect("/2020project/tgrade.do");
			}
			else if(actionUrl.equals("/tgdel.do"))
			{
				/**
				 * 教师：删除指定课中的某个学生成绩
				 */
				Sc one = new Sc();
				one.setCno(request.getParameter("cno"));
				one.setSno(request.getParameter("sno"));
				one.setTno((String) request.getSession().getAttribute("id"));
				Sc_controller.delete(one);
				
				response.sendRedirect("/2020project/tgrade.do");
			}
			else if(actionUrl.equals("/thcinsert.do"))
			{
				/**
				 * 教师：添加作业或者课程
				 * [yes]
				 */
				request.getRequestDispatcher("thcinsert.jsp").forward(request, response);
			}
			else if(actionUrl.equals("/thinsert.do"))
			{	
				/**
				 * 教师：增加作业信息
				 * [yes]
				 */
				Homework one=new Homework();
				one.setCno(request.getParameter("cno"));
				one.setSno(request.getParameter("sno"));
				one.setHcontent(request.getParameter("hcontent"));
				one.setHtime(request.getParameter("htime"));
				one.setName(request.getParameter("name"));
				one.setTno((String)request.getSession().getAttribute("id"));
				Home_controller.add(one);
				
				request.getRequestDispatcher("thcinsert.jsp").forward(request, response);
				//response.sendRedirect("/2020project/thcinsert.do");
			}
			else if(actionUrl.equals("/tcinsert.do"))
			{	
				/**
				 * 教师：增加课程信息
				 * [yes]
				 */
				Course one=new Course();
				one.setCno(request.getParameter("cno"));				
				one.setCname(request.getParameter("cname"));
				one.setCoutline(request.getParameter("coutline").trim());
				one.setCplan(request.getParameter("cplan").trim());
				one.setCredits(Integer.parseInt(request.getParameter("credits")));
				one.setTno((String)request.getSession().getAttribute("id"));
				Cour_controller.add(one);
				
				request.getRequestDispatcher("thcinsert.jsp").forward(request, response);
			}
			else if(actionUrl.equals("/theditsave.do"))
			{
				/**
				 * 教师：修改作业信息
				 * [yes]
				 */
				Homework one=new Homework();
				one.setCno(request.getParameter("cno"));
				one.setSno(request.getParameter("sno"));
				one.setName(request.getParameter("hname"));
				one.setTno((String)request.getSession().getAttribute("id"));
				one.setHcontent(request.getParameter("hcoutent").trim());
				one.setHtime(request.getParameter("htime"));
				
				Home_controller.update(one);
				response.sendRedirect("/2020project/thomework.do");
			}
			else if(actionUrl.equals("/thomework.do"))
			{
				/**
				 * 教师：查看作业信息
				 * [yes]
				 */
				Homework one=new Homework();
				one.setCno(request.getParameter("cno"));				
				one.setSno(request.getParameter("sno"));
				one.setTno((String)request.getSession().getAttribute("id"));
				
				if(one.getCno()!=null && one.getSno()!=null)//查一条
				{
					Homework bi=Home_controller.getById(one);		
					request.setAttribute("bi", bi);		
					
				}
				else//查所有
				{
					ArrayList<Homework> list=Home_controller.getList(one.getTno());  
					request.setAttribute("list", list);					
				}
				request.getRequestDispatcher("thomework.jsp").forward(request, response); 
			}
			else if(actionUrl.equals("/thdel.do"))
			{
				/**
				 * 教师：删除指定作业 
				 * [yes]
				 */
				Homework id=new Homework();
				id.setCno(request.getParameter("cno"));
				id.setTno((String)request.getSession().getAttribute("id"));
				id.setSno(request.getParameter("sno"));
				
				Home_controller.delete(id);	
				
				response.sendRedirect("/2020project/thomework.do");
			}
			else if(actionUrl.equals("/ceditsave.do"))
			{
				/***
				 * 修改课程信息
				 * [yes]
				 */
				Course one=new Course();
				one.setCno(request.getParameter("cno"));				
				one.setCname(request.getParameter("cname"));
				one.setCoutline(request.getParameter("coutline").trim());
				one.setCplan(request.getParameter("cplan").trim());
				one.setCredits(Integer.parseInt(request.getParameter("credits")));
		
				Cour_controller.update(one);
				response.sendRedirect("/2020project/tbase.do");
				
			}
			else if(actionUrl.equals("/tbase.do"))
			{
				/**
				 * 教师：查询指定课程
				 * [yes]
				 */
				String cno=request.getParameter("cno");
				
				if(cno!=null)//查一条
				{
					Course bi=Cour_controller.getById(cno);		
					request.setAttribute("bi", bi);			
				}
				else//查所有
				{
					String tno=(String) request.getSession().getAttribute("id");
					ArrayList<Course> list=Cour_controller.getList(tno);  
					request.setAttribute("list", list);			
					
				}
				request.getRequestDispatcher("tbase.jsp").forward(request, response); 
			}
			else if(actionUrl.equals("/cdel.do"))
			{
				/**
				 * 教师：删除指定课程
				 * [yes]
				 */
				String cno=request.getParameter("cno");
				Cour_controller.delete(cno);	
				
				response.sendRedirect("/2020project/tbase.do");
			}
			else if(actionUrl.equals("/sbase.do"))
			{
				request.getRequestDispatcher("sbase.jsp").forward(request, response); 
			}else if(actionUrl.equals("/tbase.do"))
			{
				request.getRequestDispatcher("tbase.jsp").forward(request, response); 
			}
			else if(actionUrl.equals("/login.do"))
			{
				 request.getRequestDispatcher("login.jsp").forward(request, response); 
			}
			else if(actionUrl.equals("/judge.do"))
			{
				/**
				 * 用于用户登录
				 * 账号,密码,名字正确可以成功登录
				 */
				 try{
					   request.setCharacterEncoding("UTF-8");
					   String name=request.getParameter("name");
					   String password=request.getParameter("password");
					   String type=request.getParameter("type");
					   String T_S_Ano=request.getParameter("id");
					   
					   request.getSession().setAttribute("type", type);
					   request.getSession().setAttribute("id", T_S_Ano);
					   
					   Boolean flag=false;
					   
					   if("Admin".equals(type))
					   {
						   Administrator bi=Admin_controller.getById(T_S_Ano);
						   request.getSession().setAttribute("name", bi.getAname());
						   
						   if(bi.getAname().equals(name) && bi.getAno().equals(T_S_Ano) && bi.getPassword()==Integer.parseInt(password))
						   {
							   flag=true;
						   }
					   }
					   else if("Teacher".equals(type))
					   {
						   Teacher bi=Tea_controller.getById(T_S_Ano);
						   request.getSession().setAttribute("name", bi.getTname());
						   if(bi.getTname().equals(name) && bi.getTno().equals(T_S_Ano) && bi.getPassword()==Integer.parseInt(password))
						   {
							   flag=true;
						   }
					   }
					   else
					   {
						   Student bi=Stu_controller.getById(T_S_Ano);
						   request.getSession().setAttribute("name", bi.getSname());
						   
						   if(bi.getSname().equals(name) && bi.getSno().equals(T_S_Ano) && bi.getPassword()==Integer.parseInt(password))
						   {
							   flag=true;
						   }
					   }
					   
					   if (flag)
					   {
					 	  
						   request.getRequestDispatcher("index.jsp").forward(request, response); 
					   }
					   else
					   {
						   response.sendRedirect("fail.html");
					   }  
					 }catch(Exception e)
					 {
						 response.sendRedirect("fail.html");
					 }
				  
			}
			else if(actionUrl.equals("/student.do"))
			{		
				/**
				 * 管理员：修改学生信息
				 * [yes]
				 */
				String sno=request.getParameter("sno");//显示学生信息
				
				if(sno!=null)//查一条
				{
					Student bi=Stu_controller.getById(sno);		
					request.setAttribute("bi", bi);		
					
				}
				else//查所有
				{
					ArrayList<Student> list=Stu_controller.getList();  
					request.setAttribute("list", list);					
				}
				request.getRequestDispatcher("student.jsp").forward(request, response); 
			}
			else if(actionUrl.equals("/teacher.do"))
			{		
				/**
				 * 管理员：修改教师信息
				 * [yes]
				 */
				String tno=request.getParameter("tno");
				
				if(tno!=null)//查一条
				{
					Teacher bi=Tea_controller.getById(tno);		
					request.setAttribute("bi", bi);			
				}
				else//查所有
				{
					ArrayList<Teacher> list=Tea_controller.getList();  
					request.setAttribute("list", list);					
				}
				request.getRequestDispatcher("teacher.jsp").forward(request, response); 
			}
			else if(actionUrl.equals("/self.do"))
			{		
				/**
				 * 显示自己的信息
				 * [yes]
				 */
				String type=(String)request.getSession().getAttribute("type");
				String id=(String)request.getSession().getAttribute("id");
				
				if("Admin".equals(type))
				{
					Administrator bi=Admin_controller.getById(id);
					request.setAttribute("bi", bi);	
				}
				else if("Teacher".equals(type))
				{
					Teacher bi=Tea_controller.getById(id);
					request.setAttribute("bi", bi);	
				}
				else
				{
					Student bi=Stu_controller.getById(id);
					request.setAttribute("bi", bi);	
				}
				
				request.getRequestDispatcher("self.jsp").forward(request, response); 
			}
			else if(actionUrl.equals("/insert.do"))
			{	
				request.getRequestDispatcher("insert.jsp").forward(request, response);
			}
			else if(actionUrl.equals("/sinsert.do"))
			{	
				/**
				 * 增加学生信息
				 * [yes]
				 */
				
				Student one=new Student();
				one.setSno(request.getParameter("sno"));
				one.setSname(request.getParameter("sname"));
				one.setSaddress(request.getParameter("saddress"));
				one.setSbirth(request.getParameter("sbirth"));
				one.setSage(Integer.parseInt(request.getParameter("sage")));
				one.setPassword(Integer.parseInt(request.getParameter("password")));
				
				
				Stu_controller.add(one);
				request.getRequestDispatcher("insert.jsp").forward(request, response);
			}
			else if(actionUrl.equals("/tinsert.do"))
			{	
				/**
				 * 增加教师信息
				 * [yes]
				 */
				Teacher one=new Teacher();
				one.setTno(request.getParameter("tno"));
				one.setTname(request.getParameter("tname"));
				one.setTaddress(request.getParameter("taddress"));
				one.setTbirth(request.getParameter("tbirth"));
				one.setTage(Integer.parseInt(request.getParameter("tage")));
				one.setPassword(Integer.parseInt(request.getParameter("password")));
			
				/*System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+one.getTname());*/
				Tea_controller.add(one);
				request.getRequestDispatcher("insert.jsp").forward(request, response);
			}
			else if(actionUrl.equals("/seditsave.do")) 
			{	   
				/**
				 * 修改学生信息
				 * [yes]
				 */
				
				Student one=new Student();
				one.setSno(request.getParameter("sno"));

				one.setSname(request.getParameter("sname"));
				one.setSaddress(request.getParameter("saddress"));
				one.setSbirth(request.getParameter("sbirth"));
				one.setSage(Integer.parseInt(request.getParameter("sage")));
				one.setPassword(Integer.parseInt(request.getParameter("password")));
			
				Stu_controller.update(one);
				
				String url=request.getHeader("Referer");
				int index=url.indexOf("self");
				int index2=url.indexOf("insert");
				
				if(index!=-1)
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else if(index2!=-1)
				{
					response.sendRedirect("/2020project/sinsert.do");
				}
				else
				{
					response.sendRedirect("/2020project/student.do");
				}
			}
			else if(actionUrl.equals("/teditsave.do")) 
			{	   
				/***
				 * 修改教师信息
				 * [yes]
				 */
				Teacher one=new Teacher();
				one.setTno(request.getParameter("tno"));
				one.setTname(request.getParameter("tname"));
				one.setTaddress(request.getParameter("taddress"));
				one.setTbirth(request.getParameter("tbirth"));
				one.setTage(Integer.parseInt(request.getParameter("tage")));
				one.setPassword(Integer.parseInt(request.getParameter("password")));
			
				Tea_controller.update(one);
				String url=request.getHeader("Referer");
				int index=url.indexOf("self");
				int index2=url.indexOf("insert");
				
				if(index!=-1)
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else if(index2!=-1)
				{
					response.sendRedirect("/2020project/tinsert.do");
				}
				else
				{
					response.sendRedirect("/2020project/teacher.do");
				}
			}
			else if(actionUrl.equals("/aeditsave.do")) 
			{	   
				/**
				 * 修改管理员信息
				 * [yes]
				 */
				Administrator one=new Administrator();
				one.setAno((String) request.getSession().getAttribute("id"));
				one.setAname(request.getParameter("aname"));
				one.setPassword(Integer.parseInt(request.getParameter("password")));
								
				Admin_controller.update(one);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else if(actionUrl.equals("/sdel.do"))
			{			
				/**
				 * 删除学生
				 * [yes]
				 */
				String sno=request.getParameter("sno");
				Stu_controller.delete(sno);	
				
				response.sendRedirect("/2020project/student.do");

			}
			else if(actionUrl.equals("/tdel.do"))
			{			
				/**
				 *删除教师
				 *[yes]
				 */
				String tno=request.getParameter("tno");
				Tea_controller.delete(tno);	
				
				response.sendRedirect("/2020project/teacher.do");

			}
			else//什么操作都没有就回到主页面
			{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
