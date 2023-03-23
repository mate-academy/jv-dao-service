package mate.jdbc.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import mate.jdbc.dao.ManufacturedDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturedServiceImpl implements ManufacturedDao {
    @Inject
    private static ManufacturedDao manufacturedDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturedDao.create(manufacturer);
    }

    @Override
    public Optional<Manufacturer> get(Long id) {
        return Optional.ofNullable(manufacturedDao.get(id).orElseThrow(()
                -> new NoSuchElementException("Can`t get manufacturer by id ")));
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturedDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturedDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturedDao.delete(id);
    }
}
