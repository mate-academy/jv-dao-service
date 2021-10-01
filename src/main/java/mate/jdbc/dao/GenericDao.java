package mate.jdbc.dao;

import java.util.List;

public interface GenericDao<T> {
    T create(T t);

    T get(Long id);

    List<T> getAll();

    T update(T t);

    boolean delete(Long id);
}
