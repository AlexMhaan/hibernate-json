package dao;


import entities.Employee;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public List<Employee> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();

        session.close();
        return employees;
    }

    @Override
    public Employee findById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.find(Employee.class, id);

        session.close();
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(employee);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return employee;
    }

    @Override
    public boolean deleteById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Employee employee = this.findById(id);
            session.remove(employee);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public void saveEmployees(List<Employee> employees) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            session.beginTransaction();
            for (Employee employee : employees)
                session.persist(employee);
            session.getTransaction().commit();

        }catch (RuntimeException e){

//            e.printStackTrace();
            if(session.getTransaction() != null && session.getTransaction().isActive())
                session.getTransaction().rollback();
//            throw e;

        }finally {

            if(session != null)
                session.close();

        }

    }
}
