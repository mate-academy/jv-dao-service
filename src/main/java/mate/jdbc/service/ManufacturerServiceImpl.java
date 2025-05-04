package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Injector;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private static final Injector INJECTOR = Injector.getInstance("mate");
    private final ManufacturerDao manufacturerDao;

    public ManufacturerServiceImpl() {
        this.manufacturerDao = (ManufacturerDao) INJECTOR.getInstance(ManufacturerDao.class);
    }

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        Optional<Manufacturer> manufacturerOptional = manufacturerDao.get(id);
        return manufacturerOptional.orElseThrow((Supplier<RuntimeException>) ()
                -> new DataProcessingException("could not retrieve manufacturer with id: "
            + id, null));
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
