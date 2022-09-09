package mate.jdbc;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer chery = new Manufacturer();
        chery.setName("Chery");
        chery.setCountry("China");

        Manufacturer ford = new Manufacturer();
        ford.setName("Ford");
        ford.setCountry("USA");

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerDao.class);
        manufacturerService.create(chery);
        manufacturerService.create(ford);

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        chery = manufacturers.get(0);
        chery.setCountry("China");
        manufacturerService.update(chery);
        System.out.println(manufacturerService.get(chery.getId()));
        manufacturerService.delete(chery.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driverAndrii = new Driver("Andrii", "ooa2002");
        driverService.create(driverAndrii);

        Driver deliveryJulia = new Driver("Julia", "oao2007");
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
