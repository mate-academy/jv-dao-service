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
        Driver vitalii = new Driver("Vitalii", "111511");
        Driver igor = new Driver("Igor", "201115");
        driverService.create(vitalii);
        driverService.create(igor);
        driverService.getAll().forEach(System.out::println);

        igor.setLicenseNumber("100150");
        driverService.update(igor);
        driverService.delete(igor.getId());

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer alfaRomeo = new Manufacturer("AlfaRomeo", "Italy");
        Manufacturer citroen = new Manufacturer("Citroen", "France");
        manufacturerService.create(alfaRomeo);
        manufacturerService.create(citroen);

        manufacturerService.delete(citroen.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
