package pd.workshop.springjpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company implements Serializable {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipcode;
    @Column
    private String country;

    public Company(String name) {
        this.name = name;
    }
}
