package servies;

import models.CreditCard;
import org.hibernate.SessionFactory;
import repositories.CreditCardRepository;
import repositories.SessionFactorySingleton;

public class CreditCardService implements BaseService<CreditCard> {
    protected SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private CreditCardRepository creditCardRepository;

    public CreditCardService() {
        this.creditCardRepository = new CreditCardRepository();
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.save(creditCard);
                transaction.commit();
                return creditCard;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public CreditCard update(CreditCard creditCard) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.update(creditCard);
                transaction.commit();
                return creditCard;
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(CreditCard creditCard) {
        try(var session = sessionFactory.openSession()){
            var transaction = session.beginTransaction();
            try{
                session.delete(creditCard);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                throw e;
            }
        }
    }
}
