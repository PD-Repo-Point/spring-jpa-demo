package pd.workshop.springjpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "employee_id") // Foreign Key
    private Employee employee;

    @Column
    private String title;

    public EmployeeProfile(String username, String password, String email, Employee employee, String title) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.employee = employee;
        this.title = title;
    }
}
