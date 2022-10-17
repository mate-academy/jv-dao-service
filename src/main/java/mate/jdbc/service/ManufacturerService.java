package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
@Inject
public class ManufacturerService {
    private ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();

    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    public Manufacturer get(Long id) {
        return manufacturerDao.get(id).get();
    }

    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }
}
