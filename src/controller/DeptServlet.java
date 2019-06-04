package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Dept;
import bean.Page;
import service.ServiceFactory;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DeptServlet.do")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String method=request.getParameter("method");
	if(method==null||method.equals("findAll")) {
		findAll(request,response);
	}if(method.equals("addDept")) {
		addDept(request,response);
	}if(method.equals("delDept")) {
		delDept(request,response);
	}if(method.equals("getDept")) {
		getDept(request,response);
	}if(method.equals("editDept")) {
		editDept(request,response);
	}
		
		
	
	
	}

	private void editDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Integer deptno=Integer.parseInt(request.getParameter("deptno"));
			String dname=request.getParameter("dname");
			String loc=request.getParameter("loc");
			Dept dept=new Dept(deptno,dname,loc);
			ServiceFactory.getDeptService().editDept(dept);
			response.sendRedirect("DeptServlet.do?method=findAll");
			
			
	}

	private void getDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer deptno=Integer.parseInt(request.getParameter("deptno"));
		Dept depts=ServiceFactory.getDeptService().getDept(deptno);
		request.setAttribute("depts", depts);
		request.getRequestDispatcher("editDept.jsp").forward(request, response);
	}

	private void delDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer deptno=Integer.parseInt(request.getParameter("deptno"));
		ServiceFactory.getDeptService().deleteDept(deptno);
		response.sendRedirect("DeptServlet.do?method=findAll");
	}

	private void addDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
			 String deptno=request.getParameter("deptno");
			String dname=request.getParameter("dname");
			String loc=request.getParameter("loc");
			Dept dept=new Dept();
			dept.setDeptno(Integer.parseInt(deptno));
			dept.setDname(dname);
			dept.setLoc(loc);
			ServiceFactory.getDeptService().addDept(dept);
			response.sendRedirect("DeptServlet.do?method=findAll");
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page page=new Page();
		String thePage=request.getParameter("thePage");
		if(thePage==null) {
			thePage="1";
		}
		page.setThePage(Integer.parseInt(thePage));
		page.setPageRow(4);
		List<Dept>depts=ServiceFactory.getDeptService().getAllDeptByPage(page);
			request.setAttribute("depts", depts);
			request.setAttribute("page", page);
			request.getRequestDispatcher("DeptList.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
