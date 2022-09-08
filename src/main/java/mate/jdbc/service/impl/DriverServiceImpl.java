package mate.jdbc.service.impl;

import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

import java.util.List;
import java.util.Optional;

public class DriverServiceImpl implements DriverService {
    @Override
    public Driver create(Driver driver) {
        return null;
    }

    @Override
    public Optional<Driver> read(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Driver> readAll() {
        return null;
    }

    @Override
    public Driver update(Driver driver) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
