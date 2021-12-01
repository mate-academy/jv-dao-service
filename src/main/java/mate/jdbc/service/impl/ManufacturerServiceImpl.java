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
    private ManufacturerDao dao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return dao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return dao.get(id).orElseThrow();
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
