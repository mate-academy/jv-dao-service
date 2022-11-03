package mate.jdbc.service;

import java.util.List;

public interface GenericService<T> {
    T create(T model);

    T get(Long id);

    List<T> getAll();

    T update(T model);

    boolean delete(Long id);
}
