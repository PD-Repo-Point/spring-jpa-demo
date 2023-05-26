package pd.workshop.springjpademo.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private Long id;
    @Column
    private String fName;
    @Column
    private String lName;
    @Column
    private Integer yearsExperience;
    @Transient
    private Double totalCompensation;
    @Column
    private Salary salary;
    @Column
    private Company company;

    @OneToOne(mappedBy = "employee")
    private EmployeeProfile employeeProfile;

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private List<Salary> salaries = new ArrayList<>();


    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name="employee_company",
                joinColumns = @JoinColumn(name = "employee_id"),
                inverseJoinColumns = @JoinColumn(name = "company_id"))
    private List<Company> companies = new ArrayList<>();

    public Employee(Long id, String fName, String lName, Integer yearsExperience, Double totalCompensation, List<Salary> salaries, List<Company> companies) {
    }

    public Employee(Long id, String fName, String lName, Integer yearsExperience, List<Company> companies) {
    }
}
