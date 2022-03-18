package repositories;

import models.Account;
import org.hibernate.Session;

import java.util.List;

public class AccountRepository extends BaseRepositoryImpl<Account>{
    private Session session;

    @Override
    public Account save(Account account) {
        return super.save(account);
    }

    @Override
    public Account update(Account account) {
        return super.update(account);
    }

    @Override
    public void delete(Account account) {
        super.delete(account);
    }

    public Account findById(Long id){
        var session = sessionFactory.getCurrentSession();
        /*return session
                .createQuery("SELECT a from models.Account a WHERE a.id = :id",Account.class)
                .setParameter("id",id)
                .getSingleResult();*/
        return session.find(Account.class,id);
    }

    public List<Account> findAll(){
        var session = sessionFactory.getCurrentSession();
        return session
                .createQuery("SELECT a from models.Account a ",Account.class)
                .list();
    }
}
