package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Manufacturer;

public interface ManufacturerService {
    Manufacturer create(Manufacturer e);

    Manufacturer get(Long id);

    List<Manufacturer> getAll();

    Manufacturer update(Manufacturer e);

    boolean delete(Long id);
}
