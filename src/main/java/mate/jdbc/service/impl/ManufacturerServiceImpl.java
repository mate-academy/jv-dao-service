package mate.jdbc.service.impl;

import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

import java.util.List;
import java.util.Optional;

public class ManufacturerServiceImpl implements ManufacturerService {
    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return null;
    }

    @Override
    public Optional<Manufacturer> read(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Manufacturer> readAll() {
        return null;
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
