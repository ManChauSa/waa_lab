package lab_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private  String city;
    private String state;
    private  Integer zipCode;

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Student> students;
}
