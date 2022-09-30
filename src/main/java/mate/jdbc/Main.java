package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufactureService;
import mate.jdbc.service.ManufactureServiceImpl;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufactureService manufactureService
                = (ManufactureService) injector.getInstance(ManufactureServiceImpl.class);
        manufactureService.delete(1L);
        Manufacturer peugeot = new Manufacturer();
        peugeot.setCountry("France");
        peugeot.setName("Peugeot");
        manufactureService.create(peugeot);
        Manufacturer mitsubishi = new Manufacturer();
        mitsubishi.setName("Mitsubishi");
        mitsubishi.setCountry("Japan");
        mitsubishi.setId(7L);
        manufactureService.update(mitsubishi);
        manufactureService.delete(8L);
        List<Manufacturer> manufacturers = manufactureService.getAll();
        manufacturers.forEach(System.out::println);
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver oleg = new Driver();
        oleg.setName("Oleg");
        oleg.setLicenseNumber("AF548942984");
        driverService.create(oleg);
        Driver andrey = new Driver();
        andrey.setName("Andrey");
        andrey.setLicenseNumber("AF542564541");
        driverService.create(andrey);
        Driver kirill = new Driver();
        kirill.setId(2L);
        kirill.setName("Kirill");
        kirill.setLicenseNumber("AF284842864");
        driverService.update(kirill);
        driverService.delete(1L);
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
