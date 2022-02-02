package com.example.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.pojo.Employee;

public class Test 
{
	private static final String PERSISTENCE_UNIT_NAME = "TestPersistence";
	  private static EntityManagerFactory factory;
	  public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    Query q = em.createQuery("Select e from Employee e");
	    List<Employee> employeeList = q.getResultList();
	    for (Employee employee : employeeList) {
	      System.out.println(employee);
	    }
	    System.out.println("Size: " + employeeList.size());
	    // create new todo
	    em.getTransaction().begin();
	    Employee emp = new Employee();
	    emp.setName("Mukesh");
	    emp.setEmail("m@gmail.com");
	    emp.setDepartment("Finance");
	    em.persist(emp);
	    em.getTransaction().commit();
	    em.close();
	    

	  }

}
