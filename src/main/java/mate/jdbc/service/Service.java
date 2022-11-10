package mate.jdbc.service;

import java.util.List;

public interface Service<E, K> {
    E create(E e);

    E get(K id);

    List<E> getAll();

    E update(E e);

    boolean delete(K id);
}
