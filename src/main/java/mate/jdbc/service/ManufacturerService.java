package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Manufacturer;

public interface ManufacturerService {
    public Manufacturer create(Manufacturer manufacturer);

    public Manufacturer get(Long id);

    public List<Manufacturer> getAll();

    public Manufacturer update(Manufacturer manufacturer);

    public boolean delete(Long id);
}
