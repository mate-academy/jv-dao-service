package mate.jdbc.service;

import java.util.List;

public interface Service<T> {
    T create(T t);

    T get(Long id);

    List<T> getAll();

    T update(T t);

    boolean delete(Long id);
}
