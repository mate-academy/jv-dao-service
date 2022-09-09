package mate.jdbc;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer chery = new Manufacturer();
        chery.setName("Chery");
        chery.setCountry("China");

        Manufacturer ford = new Manufacturer();
        ford.setName("Ford");
        ford.setCountry("USA");

        ManufacturerDao manufacturerDao = (ManufacturerDao) injector
                .getInstance(ManufacturerDao.class);
        manufacturerDao.create(chery);
        manufacturerDao.create(ford);

        List<Manufacturer> manufacturers = manufacturerDao.getAll();
        manufacturers.forEach(System.out::println);

        chery = manufacturers.get(0);
        chery.setCountry("China");
        manufacturerDao.update(chery);
        System.out.println(manufacturerDao.get(chery.getId()));
        manufacturerDao.delete(chery.getId());
        manufacturerDao.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driverAndrii = new Driver(null, "Andrii", "ooa2002");
        driverService.create(driverAndrii);

        Driver deliveryJulia = new Driver(null, "Julia", "oao2007");
        driverService.create(deliveryJulia);

        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        driverService.delete(driverAndrii.getId());
        System.out.println("Driver was deleted");
        drivers.forEach(System.out::println);

        deliveryJulia.setLicenseNumber("ooo2022");
        System.out.println("Driver license number was updated");
        System.out.println(driverService.update(deliveryJulia));

        System.out.println("Getting Driver");
        System.out.println(driverService.get(deliveryJulia.getId()));
    }
}
