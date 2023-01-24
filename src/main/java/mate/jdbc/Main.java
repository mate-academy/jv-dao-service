package mate.jdbc;

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
        Manufacturer manufacturerKia = new Manufacturer();
        manufacturerKia.setName("KIA");
        manufacturerKia.setCountry("Japan");
        System.out.println(manufacturerService.create(manufacturerKia));
        Manufacturer manufacturerAlfaRomeo = new Manufacturer();
        manufacturerAlfaRomeo.setName("Alfa Romeo");
        manufacturerAlfaRomeo.setCountry("italy");
        System.out.println(manufacturerService.create(manufacturerAlfaRomeo));
        System.out.println(manufacturerService.delete(manufacturerAlfaRomeo.getId()));
        manufacturerKia.setCountry("South Korea");
        manufacturerService.update(manufacturerKia);
        System.out.println(manufacturerService.get(manufacturerKia.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driverOne = new Driver();
        driverOne.setName("DriverOne");
        driverOne.setLicenseNumber("12345");
        driverService.create(driverOne);
        driverService.getAll().forEach(System.out::println);
        driverOne.setLicenseNumber("1234");
        driverService.update(driverOne);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driverOne.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
