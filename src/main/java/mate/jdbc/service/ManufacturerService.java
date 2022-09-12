package mate.jdbc.service;

import mate.jdbc.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    Manufacturer create(Manufacturer manufacturer);

    Manufacturer get(Long id);

    List<Manufacturer> getAll();

    boolean delete(Long id);

    Manufacturer update(Manufacturer manufacturer);
}
