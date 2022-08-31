package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.DriverServiceImpl;

public class Main {
    public static void main(String[] args) {
        String separator = System.lineSeparator();
        Driver driverVasyl = new Driver("Yana Kolpakova", "1604");
        Driver driverIgor = new Driver("Igor Dudnik", "22345678");
        DriverService driverService = new DriverServiceImpl();
        System.out.println(driverService.create(driverVasyl) + separator);
        System.out.println(driverService.get(driverVasyl.getId()).toString() + separator);
        System.out.println(driverService.create(driverIgor) + separator);
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        driverIgor.setLicenseNumber("00000000");
        driverService.update(driverIgor);
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        driverService.delete(driverIgor.getId());
        driverService.getAll().forEach(System.out::println);
        System.out.println();

        Manufacturer manufacturerHonda = new Manufacturer();
        Manufacturer manufacturerSuzuki = new Manufacturer();


    }
}
