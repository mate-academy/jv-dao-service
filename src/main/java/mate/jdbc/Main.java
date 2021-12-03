package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerDao = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer ferrari = new Manufacturer();
        ferrari.setCountry("Italy");
        ferrari.setName("Ferrari");
        manufacturerDao.create(ferrari);

        Manufacturer porsche = new Manufacturer();
        porsche.setCountry("Germany");
        porsche.setName("Porsche");
        manufacturerDao.create(porsche);

        Manufacturer koenigsegg = new Manufacturer();
        koenigsegg.setCountry("Sweden");
        koenigsegg.setName("Koenigsegg");
        manufacturerDao.create(koenigsegg);

        System.out.println(manufacturerDao.get(3L));
        manufacturerDao.getAll().forEach(System.out::println);

        porsche.setCountry("Ukraine");
        manufacturerDao.update(porsche);

        manufacturerDao.getAll().forEach(System.out::println);

        manufacturerDao.delete(2L);

        manufacturerDao.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver eugene = new Driver();
        eugene.setName("Eugene");
        eugene.setLicenseNumber("888");
        driverService.create(eugene);

        Driver andrew = new Driver();
        andrew.setName("Andrew");
        andrew.setLicenseNumber("777");
        driverService.create(andrew);

        Driver daniel = new Driver();
        daniel.setName("Daniel");
        daniel.setLicenseNumber("666");
        driverService.create(daniel);

        System.out.println(driverService.get(2L));
        driverService.getAll().forEach(System.out::println);

        daniel.setLicenseNumber("88");
        driverService.update(daniel);

        driverService.getAll().forEach(System.out::println);

        driverService.delete(3L);

        driverService.getAll().forEach(System.out::println);
    }
}
