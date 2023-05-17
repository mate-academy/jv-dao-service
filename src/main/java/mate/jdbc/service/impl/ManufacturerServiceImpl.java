package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        checkManufacturer(manufacturer, "CREATE", false);
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerDao.get(id).orElseThrow(() ->
                new RuntimeException("Can't find in DB manufacturer with ID: " + id));
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        checkManufacturer(manufacturer, "UPDATE", true);
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }

    private void checkManufacturer(Manufacturer manufacturer, String operation, boolean isId) {
        if (manufacturer == null) {
            throw new RuntimeException("Operation " + operation + " is failed! "
                    + "Manufacturer can't be NULL");
        }
        if (manufacturer.getId() == null && isId) {
            throw new RuntimeException("Operation " + operation + " is failed! "
                    + "It requires manufacturer's ID but actual is NULL: " + manufacturer);
        }
        if (manufacturer.getName() == null || manufacturer.getCountry() == null
                || manufacturer.getName().isBlank() || manufacturer.getCountry().isBlank()) {
            throw new RuntimeException("Operation " + operation + " is failed! "
                    + "The fields: 'name' and 'country' can't be empty or NULL"
                    + System.lineSeparator() + "Accepted manufacturer is: " + manufacturer);
        }
    }
}
