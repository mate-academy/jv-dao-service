package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        //Test manufacturer
        Manufacturer audi = manufacturerService.create(
                new Manufacturer("Audi", "Germany"));
        Manufacturer mazda = manufacturerService.create(
                new Manufacturer("Mazda", "Japan"));
        Manufacturer tesla = manufacturerService.create(
                new Manufacturer("Tesla", "U.S."));
        System.out.println(manufacturerService.get(audi.getId()));
        tesla.setCountry("France");
        manufacturerService.delete(mazda.getId());
        System.out.println(manufacturerService.getAll());
        manufacturerService.update(tesla);
        System.out.println(manufacturerService.getAll());
        manufacturerService.getAll().forEach(m -> manufacturerService.delete(m.getId()));
        //Test driver
        Driver testDriver1 = new Driver("Sasha", "NDFU957054SM9IJ");
        Driver testDriver2 = new Driver("Dasha", "GHFU859024SM8IJ");
        driverService.create(testDriver1);
        driverService.create(testDriver2);
        System.out.println(driverService.get(testDriver1.getId()));
        System.out.println(driverService.delete(testDriver2.getId()));
        testDriver2.setName("Mukola");
        System.out.println(driverService.update(testDriver2));
        driverService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(d -> driverService.delete(d.getId()));
    }
}
