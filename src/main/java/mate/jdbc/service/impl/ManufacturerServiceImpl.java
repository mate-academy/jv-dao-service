package mate.jdbc.service.impl;

import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Inject
   private ManufacturerDao manufacturerDao;

    public ManufacturerServiceImpl(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    @Override
    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Optional<Manufacturer> getManufacturer(Long id) {
        return manufacturerDao.get(id);
    }

    @Override
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }
}
