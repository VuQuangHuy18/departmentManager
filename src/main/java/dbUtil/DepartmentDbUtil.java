package dbUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.NativeQuery;

import entity.Department;
import entity.Employee;

public class DepartmentDbUtil {
	private SessionFactory sessionFactory;

	// xíu thử dùng khối static xem sao nhé

	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	// get all department
	public List<Department> getDepatments() throws Exception {
		Session session = sessionFactory.openSession();
		NativeQuery<Department> query = session.createNativeQuery("select * from department", Department.class);
		List<Department> listDepartment = query.getResultList();

		return listDepartment;

	}

	public void deleteDepartment(String departmentID) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(session.get(Department.class, departmentID));

		session.getTransaction().commit();
		session.close();

	}

	public Department getDepartment(String departmentID) throws Exception {
		Session session = sessionFactory.openSession();

		Department temDepartment = session.get(Department.class, departmentID);

		session.close();

		return temDepartment;

	}

	public void addDepartment(Department department) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(department);
		session.getTransaction().commit();

		System.out.println("add successfull");

		session.close();

	}

	public void updateDepartment(Department department) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.update(department);

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Employee> getListEmployees(String DepartmentID) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Department department = getDepartment(DepartmentID);

		if (department != null) {
			List<Employee> listEmployee = new ArrayList<>();
			listEmployee = department.getEmployees();
			return listEmployee;
		}

		session.getTransaction().commit();
		session.close();

		return null;
	}

}