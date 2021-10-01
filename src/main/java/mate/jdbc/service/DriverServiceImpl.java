package mate.jdbc.service;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
@Log4j2
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        log.info("DriverService [create] method called for {}", driver);
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        log.info("DriverService [get] method was called for id {}", id);
        return driverDao.get(id).get();
    }

    @Override
    public List<Driver> getAll() {
        log.info("DriverService [getAll] method was called");
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        log.info("DriverService [update] method was called for driver {}", driver);
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        log.info("DriverService [delete] method was called for id {}", id);
        return driverDao.delete(id);
    }
}
