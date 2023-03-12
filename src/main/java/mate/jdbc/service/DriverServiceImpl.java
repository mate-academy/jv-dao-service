package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Injector;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    private static final Injector INJECTOR = Injector.getInstance("mate");
    private final DriverDao driverDao;

    public DriverServiceImpl() {
        driverDao = (DriverDao) INJECTOR.getInstance(DriverDao.class);
    }

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        Optional<Driver> driverOptional = driverDao.get(id);
        return driverOptional.orElseThrow((Supplier<RuntimeException>) ()
                -> new DataProcessingException("could not retrieve driver with id: "
            + id, null));
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }
}
