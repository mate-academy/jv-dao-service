package mate.jdbc.service;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.model.Manufacturer;
import java.util.List;

public class ManufacturerServiceImpl implements ManufacturerService {
    ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(final Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(final Long id) {
        return manufacturerDao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(final Manufacturer manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(final Long id) {
        return manufacturerDao.delete(id);
    }
}
