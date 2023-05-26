package pd.workshop.springjpademo.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class RetiredEmployee extends Employee{
    private Boolean pension;
    private Integer yearsOfService;

    public RetiredEmployee(Boolean pension, Integer yearsOfService) {
        this.pension = pension;
        this.yearsOfService = yearsOfService;
    }

    public RetiredEmployee(Long id,
                           String fName,
                           String lName,
                           Integer yearsExperience,
                           List<Company> companies,
                           Boolean pension) {
        super(id, fName, lName, yearsExperience, companies);
        this.pension = pension;
        this.yearsOfService = yearsOfService;
    }
}
