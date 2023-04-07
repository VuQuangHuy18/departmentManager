package app;

import java.util.ArrayList;
import java.util.List;

import dbUtil.DepartmentDbUtil;
import entity.Department;
import entity.Employee;

public class testDeparmentDAO {
	public static void main(String[] args) {
		DepartmentDbUtil departmentDbUtil;

		try {

//			List<Employee> lstEmployee = new ArrayList<>();
//			lstEmployee.add(new Employee(1, "hihi",new Department()));
//			lstEmployee.add(new Employee(2, "haha",new Department()));
			departmentDbUtil = new DepartmentDbUtil();
			departmentDbUtil.setup();

			// add a department

			// departmentDbUtil.addDepartment(new Department(1,"Kinh doanh quốc tế"));

			// delete a department by String id
			// departmentDbUtil.deleteDepartment("3");

			/*
			 * //update department departmentDbUtil.updateDepartment(new
			 * Department(2,"Cong nghe thong tin"));
			 */

			
			for (Employee employee : departmentDbUtil.getListEmployees("2")) {
				System.out.println(employee.toString());
				
			}
			
			/*
			 * // test getList Employee for (Employee employee :
			 * departmentDbUtil.getListEmployees("2")) {
			 * System.out.println(employee.toString());
			 * 
			 * }
			 */

			// List<Department> listDepartment = departmentDbUtil.getDepatments();

			// listDepartment.get(1).getEmployees().remove(1);

			// System.out.println(listDepartment.get(0).getEmployees().get(0).toString());

//			
//			Department tempDepartment = new Department();
//			tempDepartment.setId(3);
//			 Employee employee = new Employee();
//			 employee.setName("Vu Quang Huy");
//			 employee.setDepartment(tempDepartment);
//			
//			departmentDbUtil.addEmployee(employee);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
