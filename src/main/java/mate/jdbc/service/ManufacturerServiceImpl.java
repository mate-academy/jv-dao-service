package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    ManufacturerDao dao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return dao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return dao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        return dao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return dao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
