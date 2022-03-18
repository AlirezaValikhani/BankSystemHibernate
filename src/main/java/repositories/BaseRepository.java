package repositories;

import models.BaseModel;

public interface BaseRepository<T extends BaseModel> {
    T save(T t);
    T update(T t);
    void delete(T t);
}
