package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final Driver driverVasyl = new Driver("Yana Kolpakova", "1604");
        final Driver driverIgor = new Driver("Igor Dudnik", "22345678");
        final Manufacturer manufacturerDaewoo = new Manufacturer(0L,"Daewoo", "Korea");
        final Manufacturer manufacturerBmw = new Manufacturer(1L, "BMW", "Germany");
        System.out.println("CREATE: " + driverService.create(driverVasyl));
        System.out.println("GET: " + driverService.get(driverVasyl.getId()).toString());
        System.out.println("CREATE: " + driverService.create(driverIgor));
        driverService.getAll().forEach(System.out::println);
        System.out.println("UPDATE: ");
        driverIgor.setLicenseNumber("00000000");
        driverService.update(driverIgor);
        driverService.getAll().forEach(System.out::println);
        System.out.println("DELETE: ");
        driverService.delete(driverIgor.getId());
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        System.out.println("CREATE: " + manufacturerService.create(manufacturerDaewoo));
        System.out.println("GET: " + manufacturerService.get(manufacturerDaewoo.getId()));
        System.out.println("CREATE: " + manufacturerService.create(manufacturerBmw));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("UPDATE: ");
        manufacturerDaewoo.setCountry("Ukraine");
        manufacturerService.update(manufacturerDaewoo);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("DELETE: ");
        manufacturerService.delete(manufacturerDaewoo.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
