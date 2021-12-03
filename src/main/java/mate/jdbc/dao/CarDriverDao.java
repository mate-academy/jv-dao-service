package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.CarDriver;

public interface CarDriverDao {
    CarDriver create(CarDriver carDriver);

    Optional<CarDriver> get(Long id);

    List<CarDriver> getAll();

    CarDriver update(CarDriver carDriver);

    boolean delete(Long id);
}
