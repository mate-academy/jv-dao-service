package mate.jdbc.service;

import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

import java.util.List;

@Service
public interface ManufactureService {

    Manufacturer create(Manufacturer manufacturer);

    Manufacturer get(Long id);

    List<Manufacturer> getAll();

    Manufacturer update(Manufacturer manufacturer);

    boolean delete(Long id);
}
