package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("--------MANUFACTURER--------");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer bohdan = new Manufacturer();
        bohdan.setName("Bohdan");
        bohdan.setCountry("Ukraine");
        System.out.println(manufacturerService.create(bohdan));
        Manufacturer mercedes = new Manufacturer();
        mercedes.setName("Mercedes");
        mercedes.setCountry("Germany");
        System.out.println(manufacturerService.create(mercedes));
        Manufacturer mitsubishi = new Manufacturer();
        mitsubishi.setName("Mitsubishi");
        mitsubishi.setCountry("Japan");
        System.out.println(manufacturerService.create(mitsubishi));
        System.out.println(manufacturerService.delete(mercedes.getId()));
        mitsubishi.setName("Mazda");
        manufacturerService.update(mitsubishi);

        System.out.println(manufacturerService.get(bohdan.getId()));

        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("--------DRIVER--------");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver yura = new Driver();
        yura.setName("Yura");
        yura.setLicenseNumber("123456");
        System.out.println(driverService.create(yura));
        Driver otto = new Driver();
        otto.setName("Otto");
        otto.setLicenseNumber("654987");
        System.out.println(driverService.create(otto));
        Driver hirohito = new Driver();
        hirohito.setName("Hirohito");
        hirohito.setLicenseNumber("456123");
        System.out.println(driverService.create(hirohito));
        System.out.println(driverService.delete(otto.getId()));
        hirohito.setName("Akihito");
        driverService.update(hirohito);

        System.out.println(driverService.get(yura.getId()));

        driverService.getAll().forEach(System.out::println);
    }
}
