package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer bmwManufacturer = new Manufacturer("BMW", "Germany");
        Manufacturer toyotaManufacturer = new Manufacturer("Toyota", "Japan");
        Manufacturer volvoManufacturer = new Manufacturer("Volvo","Sweden");
        Manufacturer fordManufacturer = new Manufacturer("Ford","USA");
        List<Manufacturer> manufacturers = List.of(
                bmwManufacturer, toyotaManufacturer, volvoManufacturer, fordManufacturer
        );

        System.out.println("\nTest manufacturerService create:");
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerService.create(manufacturer);
        }
        System.out.println(manufacturers);

        Long id = toyotaManufacturer.getId();
        System.out.println("\nTest get manufacturerService by id = " + id);
        System.out.println("return = " + manufacturerService.get(id));

        System.out.println("\nTest manufacturerService getAll:");
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        volvoManufacturer.setCountry("China");
        System.out.println("\nTest update manufacturer " + volvoManufacturer);
        System.out.println("return = " + manufacturerService.update(volvoManufacturer));

        System.out.println("\nTest delete manufacturer by id = " + id);
        System.out.println("return = " + manufacturerService.delete(id));

        Driver taras = new Driver("Taras", "12121212");
        Driver petro = new Driver("petro", "13131313");
        Driver ivan = new Driver("ivan", "98989898");
        List<Driver> drivers = List.of(taras, petro, ivan);

        System.out.println("\nTest driverService create:");
        for (Driver driver : drivers) {
            driverService.create(driver);
        }
        System.out.println(drivers);

        Long driverId = petro.getId();
        System.out.println("\nTest get driverService by id = " + driverId);
        System.out.println("return = " + driverService.get(driverId));

        System.out.println("\nTest driverService getAll:");
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        petro.setLicenseNumber("11111111");
        System.out.println("\nTest update driverService " + petro);
        System.out.println("return = " + driverService.update(petro));

        System.out.println("\nTest delete driver by id = " + driverId);
        System.out.println("return = " + manufacturerService.delete(driverId));
    }
}
