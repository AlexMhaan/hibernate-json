package entities;

import converters.JsonConverter;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 35, nullable = false)
    private String firstName;

    @Column(unique=true)
    private String email;

    @Convert(converter = JsonConverter.class)
    private Map<String, Object> json;

    public Employee(){}

}
