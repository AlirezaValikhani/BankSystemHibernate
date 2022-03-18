package repositories;

import models.CreditCard;

public class CreditCardRepository extends BaseRepositoryImpl<CreditCard> {
    @Override
    public CreditCard save(CreditCard creditCard) {
        return super.save(creditCard);
    }

    @Override
    public CreditCard update(CreditCard creditCard) {
        return super.update(creditCard);
    }

    @Override
    public void delete(CreditCard creditCard) {
        super.delete(creditCard);
    }
}
