package onetomanyunim2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanyunim2.Employee;
import onetomanyunim2.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void saveEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public void saveEmployee(List<Employee> employees) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		for(Employee employee:employees) {
			entityManager.persist(employee);
		}
		entityTransaction.commit();
	}
	
	
	public void getEmployeeById(int id) {
		EntityManager entityManager=getEntityManager();
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
			System.out.println(employee);
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	
	
	public void deeleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee employee=entityManager.find(Employee.class, id);
		if(employee!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
