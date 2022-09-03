package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String PACKAGE_NAME = "mate.jdbc";

    public static void main(String[] args) {
        Injector injector = Injector.getInstance(PACKAGE_NAME);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver leclerc = new Driver();
        leclerc.setName("Charles Leclerc");
        leclerc.setLicenseNumber("777-777");
        driverService.create(leclerc);

        Driver hamilton = new Driver();
        hamilton.setName("Lewis Hamilton");
        hamilton.setLicenseNumber("333-333");
        hamilton = driverService.create(hamilton);

        Driver senna = new Driver();
        senna.setName("Ayrton Senna");
        senna.setLicenseNumber("none");
        senna = driverService.create(senna);

        System.out.println("---------After adding-----------------");
        driverService.getAll().stream().forEach(System.out::println);

        driverService.delete(senna.getId());
        System.out.println("---------After deleting---------------");
        driverService.getAll().stream().forEach(System.out::println);

        hamilton.setLicenseNumber("111-111");
        driverService.update(hamilton);
        System.out.println("---------After changing---------------");
        driverService.getAll().stream().forEach(System.out::println);

        System.out.println("--------------Get one-----------------");
        System.out.println(driverService.get(1L));
    }
}
