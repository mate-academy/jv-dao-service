package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        manufacturerService.create(Manufacturer.builder().name("randomName").country("randomCountry")
                .build());
        manufacturerService.get(1L);
        manufacturerService.update(Manufacturer.builder().id(1L).name("updatedName").country(
                "updatedCountry").build());
        manufacturerService.delete(2L);
        manufacturerService.getAll().forEach(System.out::println);

        driverService.create(Driver.builder().name("randomName").licenseNumber("randomNumber")
                .build());
        driverService.get(1L);
        driverService.update(Driver.builder().id(1L).name("updatedName").licenseNumber(
                "updatedNumber").build());
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);
    }
}
