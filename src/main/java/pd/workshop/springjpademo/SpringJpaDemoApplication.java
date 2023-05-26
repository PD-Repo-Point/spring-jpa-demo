package pd.workshop.springjpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pd.workshop.springjpademo.entity.Company;
import pd.workshop.springjpademo.entity.Employee;
import pd.workshop.springjpademo.entity.Salary;
import pd.workshop.springjpademo.repository.EmployeeRepository;
import pd.workshop.springjpademo.repository.EmployeeRepositoryImpl;

@SpringBootApplication
public class SpringJpaDemoApplication {

	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("default");

		EntityManager entityManager= entityManagerFactory.createEntityManager();

		EmployeeRepositoryImpl employeeRepository
				= new EmployeeRepositoryImpl(entityManager);

		// Created the employee details
		Employee employee = new Employee();
		employee.setFName("John");
		employee.setLName("Doe");
		employee.setYearsExperience(20);
		employee.setSalary(new Salary(54000.00, true));
		employee.setCompany(new Company("MyCompany"));

		// Created the employee1 details
		Employee employee1 = new Employee();
		employee1.setFName("Ananya");
		employee1.setLName("Chatterjee");
		employee1.setYearsExperience(10);
		employee1.setSalary(new Salary(40000.00, true));
		employee1.setCompany(new Company("MyCompany"));

		// Created the employee2 details
		Employee employee2 = new Employee();
		employee2.setFName("Akansha");
		employee2.setLName("Chatterjee");
		employee2.setYearsExperience(13);
		employee2.setSalary(new Salary(54000.00, true));
		employee2.setCompany(new Company("MyCompany"));

		// Saving the Data
		employeeRepository.save(employee);
		employeeRepository.save(employee1);

		// Retrieving the employee by ID
		System.out.println(employeeRepository.getEmployeeById(1l).get());

		// Deleting the employee - employee1
		employeeRepository.deleteEmployee(employee2);

		entityManager.close();
		entityManagerFactory.close();
	}
}
