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

    public Employee(
            Long id,
            String firstName,
            String email,
            Map<String, Object> json
    ) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.json = json;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getJson() {
        return json;
    }

    public void setJson(Map<String, Object> json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", json=" + json + '\n' +
                '}';
    }
}
