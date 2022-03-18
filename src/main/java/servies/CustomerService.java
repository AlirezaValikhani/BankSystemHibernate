package servies;

import models.Customer;
import org.hibernate.SessionFactory;
import repositories.CustomerRepository;
import repositories.SessionFactorySingleton;

public class CustomerService implements BaseService<Customer>{
    protected SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public Customer save(Customer customer) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.save(customer);
                transaction.commit();
                return customer;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public Customer update(Customer customer) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.update(customer);
                transaction.commit();
                return customer;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(Customer customer) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.delete(customer);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }
}
