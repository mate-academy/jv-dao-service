package mate.jdbc;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = new ManufacturerDaoImpl();
        System.out.println("Create: " + manufacturerDao.create(
                new Manufacturer(7L, "Actros", "Germany")));
        System.out.println("GetAll: " + manufacturerDao.getAll());
        System.out.println("Delete: " + manufacturerDao.delete(7L));
        System.out.println("Update: " + manufacturerDao.update(
                new Manufacturer(6L, "Iveco", "Italy")));
        System.out.println("Get: " + manufacturerDao.get(1L));
    }
}
