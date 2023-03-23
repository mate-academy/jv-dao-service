package mate.jdbc.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import mate.jdbc.dao.ManufacturedDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturedService;

@Service
public class ManufacturedServiceImpl implements ManufacturedService {
    @Inject
    private ManufacturedDao manufacturedDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturedDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturedDao.get(id).orElseThrow(()
                -> new NoSuchElementException("Can`t get manufacturer by id "));
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
