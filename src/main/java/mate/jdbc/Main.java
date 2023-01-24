package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Tesla", "USA"),
                new Manufacturer("Jeep", "USA"),
                new Manufacturer("Skoda", "Czech Republic"),
                new Manufacturer("Volvo Cars", "Sweden"),
                new Manufacturer("Mini", "United Kingdom"));
        manufacturers.forEach(manufacturer -> System.out.println(
                manufacturerService.create(manufacturer) + " was created"));
        Manufacturer extraManufacturer = manufacturerService.get(
                manufacturers.get(0).getId());
        System.out.println(extraManufacturer + " was successfully deleted: "
                + manufacturerService.delete(extraManufacturer.getId()));
        Manufacturer wrongManufacturer = manufacturerService.get(
                manufacturers.get(1).getId());
        wrongManufacturer.setName("Dodge");
        System.out.println(manufacturerService.update(wrongManufacturer) + " was updated");
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers = List.of(
                new Driver("Olena", "84762195"),
                new Driver("Vitalii", "63597245"),
                new Driver("Polina", "85631479"),
                new Driver("Roman", "92375489"),
                new Driver("Mykola", "19754358"));
        drivers.forEach(driver -> System.out.println(
                driverService.create(driver) + " was created"));
        Driver extraDriver = driverService.get(
                drivers.get(0).getId());
        System.out.println(extraDriver + " was successfully deleted: "
                + driverService.delete(extraDriver.getId()));
        Driver wrongDriver = driverService.get(
                drivers.get(1).getId());
        wrongDriver.setName("Tetiana");
        System.out.println(driverService.update(wrongDriver) + " was updated");
        driverService.getAll().forEach(System.out::println);
    }
}
