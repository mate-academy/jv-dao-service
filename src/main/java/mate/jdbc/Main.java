package mate.jdbc;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate");
    private static final int INDEX_TO_GET_MANUFACTURER = 2;
    private static final int INDEX_TO_DELETE = 1;
    private static final int INDEX_OF_MANUFACTURER_TO_UPDATE = 1;
    private static final String NEW_NAME_TO_UPDATE = "Volkswagen Aktiengesellschaft";
    private static final int INDEX_TO_GET_DRIVER = 2;
    private static final int INDEX_TO_DELETE_DRIVER = 1;
    private static final int INDEX_OF_DRIVER_TO_UPDATE = 1;
    private static final String NEW_NUMBER_TO_UPDATE = "ВХР 145739";

    public static void main(String[] args) {
        ManufacturerService manufacturerDao =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Volkswagen", "Germany"),
                new Manufacturer("Daimler", "UK"),
                new Manufacturer("General Motors", "USA"),
                new Manufacturer("Toyota", "Japan")
        );
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerDao.create(manufacturer);
        }
        manufacturers = manufacturerDao.getAll();
        manufacturers.forEach(System.out::println);
        long idToGetManufacturer = manufacturers.get(INDEX_TO_GET_MANUFACTURER).getId();
        System.out.println("manufacturerDao.get(" + idToGetManufacturer + ") = "
                + manufacturerDao.get(idToGetManufacturer));
        Manufacturer manufacturerToUpdate =
                manufacturers.get(INDEX_OF_MANUFACTURER_TO_UPDATE);
        manufacturerToUpdate.setName(NEW_NAME_TO_UPDATE);
        System.out.println(
                "manufacturerDao.update(manufacturers.get("
                        + INDEX_OF_MANUFACTURER_TO_UPDATE + ")) = "
                        + manufacturerDao.update(manufacturerToUpdate));
        long idToDelete = manufacturers.get(INDEX_TO_DELETE).getId();
        System.out.println("manufacturerDao.delete(" + idToDelete + ") = "
                + manufacturerDao.delete(idToDelete));

        DriverDao driverDao =
                (DriverDao) injector.getInstance(DriverDao.class);
        List<Driver> drivers = List.of(
                new Driver("Леонiд", "BXR 753555"),
                new Driver("Михайло", "ВХТ 175696"),
                new Driver("Данило", "BAA 990640"),
                new Driver("Ростислав", "BXX 456235")
        );
        for (Driver driver : drivers) {
            driverDao.create(driver);
        }
        drivers = driverDao.getAll();
        drivers.forEach(System.out::println);
        long idToGetDriver = drivers.get(INDEX_TO_GET_DRIVER).getId();
        System.out.println("driverDao.get(" + idToGetDriver + ") = "
                + driverDao.get(idToGetDriver));
        Driver driverToUpdate =
                drivers.get(INDEX_OF_DRIVER_TO_UPDATE);
        driverToUpdate.setLicenseNumber(NEW_NUMBER_TO_UPDATE);
        System.out.println(
                "driverDao.update(manufacturers.get("
                        + INDEX_OF_DRIVER_TO_UPDATE + ")) = "
                        + driverDao.update(driverToUpdate));
        long idOfDriverToDelete = drivers.get(INDEX_TO_DELETE_DRIVER).getId();
        System.out.println("driverDao.delete(" + idOfDriverToDelete + ") = "
                + driverDao.delete(idOfDriverToDelete));
    }
}
