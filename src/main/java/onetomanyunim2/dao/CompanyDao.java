package onetomanyunim2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanyunim2.Company;

public class CompanyDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void saveCompany(Company company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	
	public void getCompanyById(int id) {
		EntityManager entityManager=getEntityManager();
		Company company=entityManager.find(Company.class, id);
		if(company!=null) {
			System.out.println(company);
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	
	public void deeleteCompany(int id) {
		EntityManager entityManager=getEntityManager();
		Company company=entityManager.find(Company.class, id);
		if(company!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(company);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	
	public void updateCompany(int id,Company company) {
		EntityManager entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
//			id is present i can update the company
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			company.setId(id);
			company.setEmployees(dbCompany.getEmployees());
			entityManager.merge(company);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
