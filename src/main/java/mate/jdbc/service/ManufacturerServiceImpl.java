package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.manufacturer.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        long id = manufacturerDao.getAll().stream()
                .filter(e -> e.getName().contains(manufacturer.getName())
                        && e.getCountry().contains(manufacturer.getCountry()))
                .mapToLong(Manufacturer::getId)
                .min().orElse(0);
        if (id != 0 && manufacturerDao.get(id).isPresent()) {
            return manufacturerDao.get(id).get();
        }
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerDao.get(id).orElseThrow();
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
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
