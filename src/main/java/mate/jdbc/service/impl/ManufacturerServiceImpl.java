package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        if (manufacturerDao.get(id).isEmpty()) {
            throw new RuntimeException("Couldn't get manufacturer by id " + id
                    + ". Manufacturer does not exist");
        }
        return manufacturerDao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        List<Manufacturer> manufacturers = manufacturerDao.getAll();
        if (manufacturers.isEmpty()) {
            throw new RuntimeException("Couldn't get list of manufacturers. Data base is empty");
        }
        return manufacturers;
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
