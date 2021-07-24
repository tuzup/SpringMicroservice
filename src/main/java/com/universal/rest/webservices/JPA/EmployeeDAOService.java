 package com.universal.rest.webservices.JPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeDAOService {
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	public long insert(Employee employee){
		 entityManager.persist(employee);
		 return employee.getId();
	}
}
