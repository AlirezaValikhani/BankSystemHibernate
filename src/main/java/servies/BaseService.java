package servies;

import models.BaseModel;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface BaseService<T extends BaseModel,ID> {
    T save(T t);
    T update(T t);
    void delete(T t);
    T findById(ID id);
    List<T> findAll();
}
