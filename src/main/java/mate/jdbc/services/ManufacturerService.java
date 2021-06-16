package mate.jdbc.services;

import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import java.util.List;
import java.util.Optional;

@Service
public interface ManufacturerService {
    Manufacturer create(Manufacturer manufacturer);

    Manufacturer get(Long id);

    List<Manufacturer> getAll();

    Manufacturer update(Manufacturer manufacturer);

    boolean delete(Long id);
}
