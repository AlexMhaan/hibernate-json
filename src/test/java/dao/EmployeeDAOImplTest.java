package dao;

import entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOImplTest {

    @Test
    void createEmployee() {

        Map<String,Object> json = new HashMap<>();

        json.put("Color", "azul");
        json.put("Model", "ROG-035");

        EmployeeDAO dao = new EmployeeDAOImpl();
        Employee employee = new Employee(
                null,
                "Pepito",
                "Pitoloco",
                "pepito@pepito.com",
                json
        );

        dao.createEmployee(employee);

        System.out.println(dao.findAll());

    }

    @Test
    void saveEmployees() {
        Map<String, Object> json = new HashMap<>();
        json.put("Model", "ROG-035");
        json.put("olor", "mar");

        EmployeeDAO dao = new EmployeeDAOImpl();

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < 200000; i++) {
            employeeList.add(new Employee(null, "Pepito", "Pitoloco", "pepito@pepito.com", null));
        }
        dao.saveEmployees(employeeList);
    }
}