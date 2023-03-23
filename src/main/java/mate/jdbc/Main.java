package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);
    static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        Driver driverVasyl = new Driver();
        driverVasyl.setName("Vasyl");
        driverVasyl.setLicenseNumber("B129814");
        Driver driverKhrystyna = new Driver();
        driverKhrystyna.setName("Khrystyna");
        driverKhrystyna.setLicenseNumber("K786242");

        driverService.create(driverVasyl);
        driverService.create(driverKhrystyna);
        driverService.getAll().forEach(System.out::println);
        driverVasyl.setLicenseNumber("G143567");
        driverService.update(driverVasyl);
        driverService.delete(driverKhrystyna.getId());
        driverService.getAll().forEach(System.out::println);

        Manufacturer zaz = new Manufacturer();
        zaz.setName("ZAZ");
        zaz.setCountry("Ukraine");
        manufacturerService.create(zaz);
        Manufacturer jaguar = new Manufacturer();
        jaguar.setName("Jaguar");
        jaguar.setCountry("UK");
        manufacturerService.create(jaguar);
        Manufacturer ford = new Manufacturer();
        ford.setName("Ford");
        ford.setCountry("Germany");
        manufacturerService.create(ford);
        ford.setCountry("USA");
        manufacturerService.update(ford);
        System.out.println(ford.getId());
        manufacturerService.delete(zaz.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
