package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.dao.ManufacturerDao;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private final ManufacturerDao manufecturersDao = (ManufacturerDao) injector
            .getInstance(ManufacturerDao.class);

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
