package mate.jdbc.services;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    T create(T t);

    Optional<T> get(Long id);

    List<T> getALl();

    T update(T t);

    boolean delete(Long id);
}
