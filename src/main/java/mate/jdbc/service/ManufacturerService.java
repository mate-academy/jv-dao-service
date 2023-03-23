package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Manufacturer;

public interface ManufacturerService {
    Manufacturer create(Manufacturer manufacturer);

    List<Manufacturer> getAll();

    Manufacturer get(Long id);

    Manufacturer update(Manufacturer manufacturer);

    boolean delete(Long id);
}
