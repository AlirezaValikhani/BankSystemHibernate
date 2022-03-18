package repositories;

import models.Customer;

public class CustomerRepository extends BaseRepositoryImpl<Customer>{
    @Override
    public Customer save(Customer customer) {
        return super.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return super.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        super.delete(customer);
    }
}
