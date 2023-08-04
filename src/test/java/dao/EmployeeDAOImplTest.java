package dao;

import entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOImplTest {

    @Test
    void createEmployee() {

        Map<String,Object> json = new HashMap<>();

        json.put("Color", "azul");
        json.put("Number", "35");
        json.put("Model", "ROG-035");

        EmployeeDAO dao = new EmployeeDAOImpl();
        Employee employee = new Employee(
                null,
                "Pepito",
                "pepito@pepito.com",
                json
        );

        dao.createEmployee(employee);

        System.out.println(dao.findAll());

    }
}