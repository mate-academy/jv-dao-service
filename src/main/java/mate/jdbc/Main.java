package mate.jdbc;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.impl.ManufacturerDaoImpl;
import mate.jdbc.model.Manufacturer;

public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("ukraine");
        new ManufacturerDaoImpl().create(manufacturer);
    }
}
