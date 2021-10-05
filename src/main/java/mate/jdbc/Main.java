package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver misha = driverService.create(new Driver("Misha", "abc2345"));
        driverService.delete(misha.getId());
        Driver pavlo = driverService.create(new Driver("Pavlo", "abc23456"));
        pavlo.setLicenseNumber("abc1122");
        driverService.update(pavlo);
        System.out.println(driverService.get(2L));
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("audi", "Germany"));
        System.out.println(manufacturerService.get(5L));
        Manufacturer audi = manufacturerService.get(5L);
        audi.setName("Audi Plus");
        manufacturerService.update(audi);
        Manufacturer volkswagen = manufacturerService.get(4L);
        manufacturerService.delete(volkswagen.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
