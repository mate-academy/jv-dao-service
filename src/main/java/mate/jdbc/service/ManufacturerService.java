package mate.jdbc.service;

import java.util.List;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public interface ManufacturerService {
    Manufacturer create(Manufacturer manufacturer);

    Manufacturer get(Long id);

    List<Manufacturer> getAll();

    Manufacturer update(Manufacturer manufacturer);

    boolean delete(Long id);
}
