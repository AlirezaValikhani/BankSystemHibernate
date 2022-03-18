package servies;

import models.Employee;
import org.hibernate.SessionFactory;
import repositories.EmployeeRepository;
import repositories.SessionFactorySingleton;

import java.util.List;

public class EmployeeService implements BaseService<Employee,Long>{
    protected SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    @Override
    public Employee save(Employee employee) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.save(employee);
                transaction.commit();
                return employee;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public Employee update(Employee employee) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.update(employee);
                transaction.commit();
                return employee;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(Employee employee) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.delete(employee);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public Employee findById(Long id) {
        try(var session = sessionFactory.getCurrentSession()){
            var transaction = session.beginTransaction();
            try{
                Employee employee = employeeRepository.findById(id);
                transaction.commit();
                return employee;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public List<Employee> findAll() {
        try(var session = sessionFactory.getCurrentSession()){
            var transaction = session.beginTransaction();
            try{
                List<Employee> employees = employeeRepository.findAll();
                transaction.commit();
                return employees;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }
}
