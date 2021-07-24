package com.universal.rest.webservices.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universal.rest.webservices.user.User;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{

}
