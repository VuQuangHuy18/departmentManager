package dbUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Department;
import entity.Employee;

public class EmployeeDbUtil {

	private SessionFactory sessionFactory;

	// xíu thử dùng khối static xem sao nhé

	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	public void deleteEmployee(String id) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
        Employee employee =session.get(Employee.class, "3");
		session.delete(session.get(Employee.class, "3"));
		

		session.getTransaction().commit();
		session.close();
		System.out.println("delete thanh cong");

	}

	public Employee getEmployee(String id) throws Exception {
		Session session = sessionFactory.openSession();

		Employee employee = session.get(Employee.class, id);

		session.close();

		return employee;

	}

	public void addEmployee(String departmentID, Employee employee) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Department department = new Department();
		department.setId(Integer.parseInt(departmentID));
		employee.setDepartment(department);

		session.save(employee);
		session.getTransaction().commit();

		System.out.println("add successfull");

		session.close();

	}

	public void updateEmployee(Employee employee) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(employee);

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
