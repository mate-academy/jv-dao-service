package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Manufacturer;

public interface ManufacturerService {
    List<Manufacturer> getAll();

    Manufacturer create(Manufacturer manufacturer);

    Manufacturer get(Long id);

    Manufacturer update(Manufacturer manufacturer);

    boolean delete(Long id);
}
