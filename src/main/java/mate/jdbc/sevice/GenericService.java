package mate.jdbc.sevice;

import java.util.List;

public interface GenericService<R> {
    R create(R r);

    R get(Long id);

    List<R> getAll();

    R update(R r);

    boolean delete(Long id);
}
