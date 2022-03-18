package repositories;

import models.BaseModel;
import org.hibernate.SessionFactory;

public abstract class BaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T>{
    protected SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    @Override
    public T save(T t) {
        var session = sessionFactory.getCurrentSession();
                session.save(t);
                return t;
        }


    @Override
    public T update(T t) {
        var session = sessionFactory.getCurrentSession();
                session.update(t);
                return t;
        }

    @Override
    public void delete(T t) {
        var session = sessionFactory.getCurrentSession();
                session.delete(t);

        }
    }

