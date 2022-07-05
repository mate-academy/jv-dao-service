package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        //driverService.create() method check
        Driver ranjit = new Driver();
        ranjit.setId(21L);
        ranjit.setName("Ranjit");
        ranjit.setLicenseNumber("123456");
        driverService.create(ranjit);
        Driver semen = new Driver();
        semen.setId(22L);
        semen.setName("Semen");
        semen.setLicenseNumber("234567");
        driverService.create(semen);
        Driver michael = new Driver();
        michael.setId(23L);
        michael.setName("Michael");
        michael.setLicenseNumber("345678");
        driverService.create(michael);

        //driverService.update() method check
        Driver umesh = new Driver();
        umesh.setId(ranjit.getId());
        umesh.setName("Umesh");
        umesh.setLicenseNumber("54321");
        driverService.update(umesh);

        //driverService.delete() method check
        driverService.delete(semen.getId());

        //driverService.get() method check
        System.out.println(driverService.get(michael.getId()));
        System.out.println(driverService.get(ranjit.getId()));

        //driverService.getAll() method check
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        //manufacturerService.create() method check
        Manufacturer lincoln = manufacturerService.create(new Manufacturer("Lincoln", "USA"));
        Manufacturer ford = manufacturerService.create(new Manufacturer("Ford", "USA"));
        Manufacturer audi = manufacturerService.create(new Manufacturer("Audi", "Germany"));

        //manufacturerService.update() method check
        manufacturerService.update(new Manufacturer(ford.getId(), "Porsche", "Germany"));

        //manufacturerService.delete() method check
        manufacturerService.delete(audi.getId());

        //manufacturerService.get() method check
        System.out.println(manufacturerService.get(lincoln.getId()));
        System.out.println(manufacturerService.get(ford.getId()));

        //manufacturerService.getAll() method check
        manufacturerService.getAll().forEach(System.out::println);
    }
}
