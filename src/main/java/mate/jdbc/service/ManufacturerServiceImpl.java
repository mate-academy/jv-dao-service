package mate.jdbc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerDao.get(id);
        if (optionalManufacturer.isPresent()) {
            return optionalManufacturer.get();
        }
        return null;
    }

    @Override
    public List<Manufacturer> getAll() {
        List<Manufacturer> allManufacturers = new ArrayList<>();
        allManufacturers = manufacturerDao.getAll();
        return allManufacturers;
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
