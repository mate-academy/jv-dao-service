package mate.jdbc.services.impl;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.Service;

import java.util.List;
import java.util.Optional;

@mate.jdbc.lib.Service
public class ManufacturerService implements Service<Manufacturer> {
    @Inject
    ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Optional<Manufacturer> get(Long id) {
        return manufacturerDao.get(id);
    }

    @Override
    public List<Manufacturer> getALl() {
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
