package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.CarDriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.CarDriver;
import mate.jdbc.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private CarDriverDao carDriverDao;

    @Override
    public CarDriver create(CarDriver carDriver) {
        return carDriverDao.create(carDriver);
    }

    @Override
    public CarDriver get(Long id) {
        return carDriverDao.get(id).get();
    }

    @Override
    public List<CarDriver> getAll() {
        return carDriverDao.getAll();
    }

    @Override
    public CarDriver update(CarDriver carDriver) {
        return carDriverDao.update(carDriver);
    }

    @Override
    public boolean delete(Long id) {
        return carDriverDao.delete(id);
    }
}
