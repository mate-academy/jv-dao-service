package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        manufacturerDao.create(manufacturer);
        return manufacturer;
    }

    @Override
    public Manufacturer read(Long id) {
        return manufacturerDao.read(id).orElseThrow(
                () -> new RuntimeException("There are no manufacturer with this id: "
                        + id + " in the DB.")
        );
    }

    @Override
    public List<Manufacturer> readAll() {
        return manufacturerDao.readAll();
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
