package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public interface ManufacturerService {
    Manufacturer createManufacturer(Manufacturer manufacturer);

    Optional<Manufacturer> getManufacturer(Long id);

    List<Manufacturer> getAllManufacturer();

    Manufacturer updateManufacturer(Manufacturer manufacturer);

    boolean delete(Long id);
}
