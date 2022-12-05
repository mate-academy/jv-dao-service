package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return connectToManufacturersTable.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return connectToManufacturersTable.get(id).orElse(null);
    }

    @Override
    public List<Manufacturer> getAll() {
        return connectToManufacturersTable.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return connectToManufacturersTable.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return connectToManufacturersTable.delete(id);
    }
}
