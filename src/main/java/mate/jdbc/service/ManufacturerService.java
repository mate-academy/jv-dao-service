package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Manufacturer;

public interface ManufacturerService {
    Manufacturer create(Manufacturer manufacturer);

    Manufacturer get(long id);

    List<Manufacturer> getAll();

    Manufacturer update(Manufacturer manufacturer);

    Boolean delete(long id);
}
