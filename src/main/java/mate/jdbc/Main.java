package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer bmwManufacturer = new Manufacturer("BMW", "GERMANY");
        Manufacturer seatManufacturer = new Manufacturer("SEAT", "SPAIN");
        manufacturerService.create(bmwManufacturer);
        manufacturerService.create(seatManufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(bmwManufacturer.getId()));
        Manufacturer audiManufacturer = new Manufacturer();
        audiManufacturer.setId(bmwManufacturer.getId());
        audiManufacturer.setName("AUDI");
        audiManufacturer.setCountry("GERMANY");
        manufacturerService.update(audiManufacturer);
        manufacturerService.delete(seatManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bobDriver = new Driver("Bob", "12345");
        Driver djonDriver = new Driver("Djon", "67891");
        driverService.create(bobDriver);
        driverService.create(djonDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(bobDriver.getId()));
        Driver mikeDriver = new Driver();
        mikeDriver.setId(djonDriver.getId());
        mikeDriver.setName("Mike");
        mikeDriver.setLicenseNumber("34567");
        driverService.update(mikeDriver);
        driverService.delete(bobDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
