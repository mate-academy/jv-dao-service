package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.ManufacturerService;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements mate.jdbc.service.ManufacturerService {
    private static final String GET_MANUFACTURER_BY_ID_EXCEPTION =
            "Can`t get Manufacturer by id - %s";

    @Inject
    private ManufacturerService manufacturerService;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerService.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerService.get(id).orElseThrow(() -> new RuntimeException(
                String.format(GET_MANUFACTURER_BY_ID_EXCEPTION, id)));
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
