package pd.workshop.springjpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pd.workshop.springjpademo.entity.*;
import pd.workshop.springjpademo.repository.EmployeeRepository;
import pd.workshop.springjpademo.repository.EmployeeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

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
		/*Employee employee = new Employee();
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
		employeeRepository.deleteEmployee(employee2);*/


		// RELATIONSHIP
		// one-to-one
		/*Employee employee = new Employee();
		employee.setFName("John");
		employee.setLName("Doe");
		employee.setYearsExperience(20);
		employee.setSalary(new Salary(54000.00, true));
		employee.setCompany(new Company("MyCompany"));
		employee.setEmployeeProfile(
				new EmployeeProfile(
						"myusername",
						"mypassword",
						"myemail@email.com",
						employee,
						"DevOps Engineer"
				));

		employeeRepository.save(employee);*/

		// one-to-many bidirectional
		/*Employee employee = new Employee();
		employee.setFName("John");
		employee.setLName("Doe");
		employee.setYearsExperience(20);
		employee.setSalaries(generatedSalaries());
		employee.setEmployeeProfile(
				new EmployeeProfile(
						"myusername",
						"mypassword",
						"myemail@email.com",
						employee,
						"DevOps Engineer"
				));
		employeeRepository.save(employee);*/

		// many-to-many relationship
		/*ActiveEmployee employee = new ActiveEmployee();
		employee.setFName("John");
		employee.setLName("Doe");
		employee.setYearsExperience(20);
		employee.setSalaries(generatedSalaries());
		employee.setCompanies(generatedCompanies());
		employee.setEmployeeProfile(
				new EmployeeProfile(
						"myusername",
						"mypassword",
						"myemail@email.com",
						employee,
						"DevOps Engineer"
				));
		employeeRepository.save(employee);*/

		// ---- JPQL ----
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
		employeeRepository.save(employee2);

		/*employeeRepository.getEmployeesByExperience(10)
				.stream().forEach(System.out::println);*/
		employeeRepository.getEmployeesByExperienceNativeQuery(10)
				.stream().forEach(System.out::println);

		entityManager.close();
		entityManagerFactory.close();
	}

	public static List<Salary> generatedSalaries(){
		Salary currentSalary = new Salary(34000.00,true);
		Salary historicalSalary1 = new Salary(30000.00,false);
		Salary historicalSalary2 = new Salary(25000.00,false);

		List<Salary> salaries = new ArrayList<>();
		salaries.add(currentSalary);
		salaries.add(historicalSalary1);
		salaries.add(historicalSalary2);

		return salaries;
	}

	public static List<Company> generatedCompanies(){
		Company company1 = new Company("Google", "USA");
		Company company2 = new Company("Amazon", "USA");

		List<Company> companies = new ArrayList<>();
		companies.add(company1);
		companies.add(company2);

		return companies;
	}
}
