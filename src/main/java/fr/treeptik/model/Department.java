package fr.treeptik.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	


	private String name;
	
	@OneToMany(mappedBy="department")
	List<Employe> employees;




	public Department() {
		super();
	}



	public Department(Integer id, String name, List<Employe> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}



	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Employe> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employe> employees) {
		this.employees = employees;
	}
	
	
	

}
