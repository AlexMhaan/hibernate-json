package dao;

import entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    boolean deleteById(Long id);

}
