package mate.jdbc.services.impl;

import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.impl.ManufacturerDaoImpl;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.ManufacturerService;

@Service
public class ManufactureServiceImpl implements ManufacturerService {
    @Inject
    private static final ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerDao.get(id);
        if (optionalManufacturer.isEmpty()) {
            throw new RuntimeException("Cant find manufacture by id: " + id);
        }
        return optionalManufacturer.get();
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }
}
