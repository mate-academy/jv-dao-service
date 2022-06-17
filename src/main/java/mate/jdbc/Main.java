package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufactureService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Manufacturer firstManufacturer = new Manufacturer(1L,"BMW","Germany");
        Driver firstDriver = new Driver(1L,"James","KE7863");
        manufactureService.create(firstManufacturer);
        driverService.create(firstDriver);
        System.out.println("Manufacturer from DB : "
                + manufactureService.get(firstManufacturer.getId()));
        System.out.println("Driver from DB : "
                + driverService.get(firstDriver.getId()));
        manufactureService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
        Manufacturer secondManufacturer = new Manufacturer(2L,"Tesla","USA");
        Driver secondDriver = new Driver(2L,"Clark","DF3589");
        manufactureService.update(secondManufacturer);
        driverService.update(secondDriver);
        System.out.println(manufactureService.delete(firstManufacturer.getId()));
        System.out.println(driverService.delete(firstDriver.getId()));
    }
}
