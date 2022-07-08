package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Injector;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufecturersDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufecturersDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufecturersDao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufecturersDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return manufecturersDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufecturersDao.delete(id);
    }
}
