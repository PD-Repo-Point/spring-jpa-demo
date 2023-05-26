package pd.workshop.springjpademo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class ActiveEmployee extends Employee{
    @Transient
    private Double totalCompensation;

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private List<Salary> salaries = new ArrayList<>();

    public ActiveEmployee(List<Salary> salaries, Double totalCompensation) {}

    public ActiveEmployee(Long id,
                          String fName,
                          String lName,
                          Integer yearsExperience,
                          Double totalCompensation,
                          List<Salary> salaries,
                          List<Company> companies) {
        super(id, fName, lName, yearsExperience, totalCompensation, salaries, companies);
        this.totalCompensation = totalCompensation;
    }
}
