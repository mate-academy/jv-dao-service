package mate.jdbc.service.manufacturer;

import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Inject
    private ManufacturerDaoImpl manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Optional<Manufacturer> get(Long id) {
        return manufacturerDao.get(id);
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
