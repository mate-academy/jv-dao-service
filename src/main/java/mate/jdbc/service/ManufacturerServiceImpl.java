package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Manufacturer;

@Inject
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();

    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    public Manufacturer get(Long id) {
        try {
            return manufacturerDao.get(id).orElseThrow();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get manufacturer by id " + id, e);
        }
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
