package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.CarDriver;

public interface DriverService {
    CarDriver create(CarDriver carDriver);

    CarDriver get(Long id);

    List<CarDriver> getAll();

    CarDriver update(CarDriver carDriver);

    boolean delete(Long id);
}
