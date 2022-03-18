package repositories;

import models.Account;
import models.Employee;

import java.util.List;

public class EmployeeRepository extends BaseRepositoryImpl<Employee>{
    @Override
    public Employee save(Employee employee) {
        return super.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return super.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        super.delete(employee);
    }

    public Employee findById(Long id){
        var session = sessionFactory.getCurrentSession();
        return session.find(Employee.class,id);
    }

    public List<Employee> findAll(){
        var session = sessionFactory.getCurrentSession();
        return session
                .createQuery("SELECT e from models.Employee e ",Employee.class)
                .list();
    }
}
