package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbUtil.DepartmentDbUtil;
import dbUtil.EmployeeDbUtil;
import entity.Department;
import entity.Employee;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DepartmentDbUtil departmentDbUtil;
	EmployeeDbUtil employeeDbUtil;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			departmentDbUtil = new DepartmentDbUtil();
			departmentDbUtil.setup();
			
			employeeDbUtil = new EmployeeDbUtil();
			
			

			// read the "command" parameter
			String theCommand = request.getParameter("command");
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}

			switch (theCommand) {
			case "LIST":
				listDepartments(request, response);
				break;
			case "ADD":
				addCat(request, response);
				break;
			case "LOAD":
				loadCat(request, response);
				break;
			case "UPDATE":
				updateDepartment(request, response);
				break;
			case "SON":
				getAllSon(request, response);
				break;
			case "DELETE":
				deleteDepartment(request, response);
				break;
				
			case "DELETESON":
				deleteSon(request, response);
				break;

			default:
				listDepartments(request, response);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void deleteSon(HttpServletRequest request, HttpServletResponse response) throws Exception{
		employeeDbUtil.setup();
		employeeDbUtil.deleteEmployee("hi");
		
	}

	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("catId");
		departmentDbUtil.deleteDepartment(id);

		listDepartments(request, response);

	}

	private void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("catId"));
		String name = request.getParameter("name");

		Department department = new Department();
		department.setId(id);
		department.setName(name);

		departmentDbUtil.updateDepartment(department);

		// send them back to the " list student" page
		System.out.println("update done");

		listDepartments(request, response);

	}

	private void loadCat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("catId");

		Department department = departmentDbUtil.getDepartment(id);

		request.setAttribute("THE_DEPARTMENT", department);

		// send to jsp page: update-student-from.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-department-form.jsp");
		dispatcher.forward(request, response);

	}

	private void addCat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");

		departmentDbUtil.addDepartment(new Department(name));

		// catDbUtil.addCat(new Cat(name, species, Double.parseDouble(price)));

		listDepartments(request, response);

	}

	private void listDepartments(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Department> departments = departmentDbUtil.getDepatments();

		// add student to the request
		request.setAttribute("DEPARTMENTS", departments);

		// send to JSP page (view)

		RequestDispatcher dispatcher = request.getRequestDispatcher("list-Department.jsp");
		System.out.println("is done");
		dispatcher.forward(request, response);

	}

	private void getAllSon(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("catId");

		List<Employee> employees = departmentDbUtil.getListEmployees(id);

		request.setAttribute("idDepartment", id);
		request.setAttribute("EMPLOYEES", employees);

		// send to jsp page: update-student-from.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-Employee.jsp");
		dispatcher.forward(request, response);

	}

}
