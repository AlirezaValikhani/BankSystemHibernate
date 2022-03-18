package servies;

import models.Account;
import org.hibernate.SessionFactory;
import repositories.AccountRepository;
import repositories.SessionFactorySingleton;

import java.util.List;

public class AccountService implements BaseService<Account,Long>{
    protected SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public Account save(Account account) {
        try(var session = sessionFactory.getCurrentSession()){
            var transaction = session.beginTransaction();
            try{
                accountRepository.save(account);
                transaction.commit();
                return account;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public Account update(Account account) {
        try(var session = sessionFactory.getCurrentSession()){
            var transaction = session.beginTransaction();
            try{
                accountRepository.update(account);
                transaction.commit();
                return account;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(Account account) {
        try(var session = sessionFactory.getCurrentSession()){
            var transaction = session.beginTransaction();
            try{
                accountRepository.delete(account);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public Account findById(Long id) {
        try(var session = sessionFactory.getCurrentSession()){
            var transaction = session.beginTransaction();
            try{
                Account account = accountRepository.findById(id);
                transaction.commit();
                return account;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public List<Account> findAll() {
        var session = sessionFactory.openSession();
            var transaction = session.beginTransaction();
            try{
                List<Account> accounts = accountRepository.findAll();
                transaction.commit();
                return accounts;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
    }
}
