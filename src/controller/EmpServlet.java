package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Dept;
import bean.Emp;
import service.ServiceFactory;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method= request.getParameter("method");
		if(method==null||method.equals("findAll")) {
			findAll(request,response);
		}else if(method.equals("findAll2")) {
			findAll2(request,response);
		}else if(method.equals("addEmp")) {
			addEmp(request,response);
		}else if(method.equals("turnDept")) {
			turnDept(request,response);
		}else if(method.equals("turnDeptDo")) {
			turnDeptDo(request,response);
		}
	
	
	}

	private void turnDeptDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String empno=request.getParameter("empno");
			String deptno=request.getParameter("deptno");
			ServiceFactory.getEmpService().turnDept(Integer.parseInt(empno),Integer.parseInt(deptno));
			response.sendRedirect("EmpServlet.do?method=findAll");
	}

	private void turnDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno=request.getParameter("empno");
		Emp emp=ServiceFactory.getEmpService().getEmp(Integer.parseInt(empno));
		List<Dept>depts =ServiceFactory.getDeptService().getAllDept();
		request.setAttribute("emp", emp);
		request.setAttribute("depts", depts);
		request.getRequestDispatcher("turnDept.jsp").forward(request, response);
	}

	private void addEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String empno=request.getParameter("empno");
		String ename=request.getParameter("ename");
		String job=request.getParameter("job");
		String mgr=request.getParameter("mgr");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String date=request.getParameter("date");
		String sal=request.getParameter("sal");
		String comm=request.getParameter("comm");
		String deptno=request.getParameter("deptno");
		Emp emp=new Emp(Integer.parseInt(empno), ename, job, Integer.parseInt(mgr), 
				new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(date)), Double.parseDouble(sal), 
				Double.parseDouble(comm), Integer.parseInt(deptno));
		ServiceFactory.getEmpService().addEmp(emp);
		response.sendRedirect("EmpServlet.do?method=findAll");
	}

	private void findAll2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Emp> emps=ServiceFactory.getEmpService().getAllEmp();
		request.setAttribute("emps", emps);
		List<Dept>depts=ServiceFactory.getDeptService().getAllDept();
		request.setAttribute("depts", depts);
		request.getRequestDispatcher("AddList.jsp").forward(request, response);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Emp> emps=ServiceFactory.getEmpService().getAllEmp();
		request.setAttribute("emps", emps);
		List<Dept> depts=ServiceFactory.getDeptService().getAllDept();
		request.setAttribute("depts", depts);
		request.getRequestDispatcher("EmpList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
