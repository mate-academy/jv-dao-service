package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver billDriver = new Driver("Bill", "764587");
        Driver bobDriver = new Driver("Bob", "763445");
        Driver aliceDriver = new Driver("Alice", "333668");

        driverService.create(billDriver);
        driverService.create(bobDriver);
        driverService.create(aliceDriver);

        System.out.println(driverService.get(bobDriver.getId()));

        aliceDriver.setLicenseNumber("555555");
        driverService.update(aliceDriver);
        System.out.println(driverService.get(aliceDriver.getId()));

        driverService.delete(billDriver.getId());

        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Manufacturer audiManufacturer = new Manufacturer("Audi", "Germany");
        Manufacturer toyotaManufacturer = new Manufacturer("Toyota", "Japan");
        Manufacturer seatManufacturer = new Manufacturer("Seat", "Spain");

        manufacturerService.create(audiManufacturer);
        manufacturerService.create(toyotaManufacturer);
        manufacturerService.create(seatManufacturer);

        System.out.println(manufacturerService.get(audiManufacturer.getId()));

        seatManufacturer.setCountry("Italy");
        manufacturerService.update(seatManufacturer);

        manufacturerService.delete(toyotaManufacturer.getId());

        manufacturerService.getAll().forEach(System.out::println);
    }
}
