package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    public void setConnectToDriversTable(DriverDao connectToDriversTable) {
        this.connectToDriversTable = connectToDriversTable;
    }

    @Override
    public Driver create(Driver driver) {
        return connectToDriversTable.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return connectToDriversTable.get(id).orElse(null);
    }

    @Override
    public List<Driver> getAll() {
        return connectToDriversTable.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return connectToDriversTable.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return connectToDriversTable.delete(id);
    }
}
