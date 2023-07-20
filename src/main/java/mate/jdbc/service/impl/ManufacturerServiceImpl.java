package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.exception.DataProcessingException;
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
        return manufacturerDao.get(id)
                .orElseThrow(() ->
                        new DataProcessingException("Can't get manufacturer by the id" + id));
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

    public Manufacturer createDefaultManufacturer() {
        Manufacturer defaultManufacturer = new Manufacturer();
        defaultManufacturer.setName("Mercedes");
        defaultManufacturer.setCountry("Germany");
        return defaultManufacturer;
    }
}
