package mate.jdbc.service.impl;

import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerService manufacturerService;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerService.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerService.get(id);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerService.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerService.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerService.delete(id);
    }
}
