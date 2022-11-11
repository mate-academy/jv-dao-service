package mate.jdbc.service.impl;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        Optional<Manufacturer> manufacturer = dao.get(id);
        try {
            return manufacturer.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new DataProcessingException("Couldn't get a manufacturer by id: " + id, e);
        }
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
