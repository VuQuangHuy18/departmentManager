package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")

	private String name;
	// orphanRemoval = true
	// một tập cha có chứa 1 list các tập con
	// khi nó bị xóa khỏi tập cha cũng bị xóa ra khỏi csdl
	// @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true,cascade =
	// CascadeType.ALL)
//	
//	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
//	//@JoinColumn(name ="department_id")
//	private List<Employee> employees;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "this is department";
	}

}
