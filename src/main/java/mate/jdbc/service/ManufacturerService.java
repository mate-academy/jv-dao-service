package mate.jdbc.service;

import mate.jdbc.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    Manufacturer create(Manufacturer manufacturer);

    Optional<Manufacturer> read(Long id);

    List<Manufacturer> readAll();

    Manufacturer update(Manufacturer manufacturer);

    boolean delete(Long id);
}
