package pd.workshop.springjpademo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import pd.workshop.springjpademo.entity.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository{


    EntityManager entityManager;

    // Injecting the entityManager
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Employee> save(Employee employee) {

        entityManager.getTransaction().begin();

        if(employee.getId() == null){
            if(employee.getEmployeeProfile() !=null)
                entityManager.persist(employee.getEmployeeProfile());
            entityManager.persist(employee); // only will run insert
        }
        else{
            System.out.println("It is merged");
            employee = entityManager.merge(employee); // will run insert query and update query
        }

        entityManager.getTransaction().commit();
        return Optional.empty();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);

        return  employee != null ? Optional.of(employee) : Optional.empty();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();

        if(entityManager.contains(employee)){
            System.out.println("Employee Removed  .....");
            entityManager.remove(employee); // will run delete query
        } else {
            System.out.println("Employee Not found .....");
            entityManager.merge(employee);
        }
        entityManager.getTransaction().commit();
    }
    // JPQL -> JPA -> Queries

    public List<String> getEmployeesByExperience(Integer yOfExp){
        Query jpqlQuery = entityManager.createQuery(
                "SELECT e.fName FROM Employee as e WHERE e.yearsExperience > :yearsOfExperience ORDER BY e.lName"
        );
        jpqlQuery.setParameter("yearsOfExperience", yOfExp);
        List<String> employeeList = jpqlQuery.getResultList();

        return employeeList;

    }

    public List<Employee> getEmployeesByExperienceNativeQuery(Integer yOfExp){
        Query nativeQuery = entityManager.createNativeQuery(
                "SELECT * FROM Employee WHERE yearsExperience > :yearsOfExperience ORDER BY lName", Employee.class
        );
        nativeQuery.setParameter("yearsOfExperience", yOfExp);
        List<Employee> employeeList = nativeQuery.getResultList();

        return employeeList;

    }
}
