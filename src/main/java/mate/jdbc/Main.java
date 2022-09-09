package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer fiat = manufacturerService.create(new Manufacturer("Fiat", "Italy"));
        Manufacturer toyota = manufacturerService.create(new Manufacturer("Toyota", "Japan"));
        Manufacturer ford = manufacturerService.create(new Manufacturer("Ford", "USA"));
        System.out.println("Create manufacturers: " + fiat + "; " + toyota + "; " + ford + ";");
        System.out.println("------------");
        boolean isDeletedFiat = manufacturerService.delete(fiat.getId());
        System.out.println("Delete Fiat: " + isDeletedFiat);
        System.out.println("------------");
        Manufacturer getToyota = manufacturerService.get(toyota.getId());
        System.out.println("Get Toyota: " + getToyota);
        System.out.println("------------");
        Manufacturer updateToyota = manufacturerService.update(new Manufacturer(toyota.getId(),
                "Toyota_Motor", toyota.getCountry()));
        System.out.println("Update Toyota to Toyota Motor: " + updateToyota);
        System.out.println("*************");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        Driver max = driverService.create(new Driver("Max", "AO567478"));
        Driver oleh = driverService.create(new Driver("Oleh", "AA997787"));
        Driver ira = driverService.create(new Driver("Ira", "AA777777"));
        System.out.println("Create drivers: " + max + ";" + oleh + ";" + ira + ";");
        System.out.println("------------");
        boolean isDeletedOleh = driverService.delete(oleh.getId());
        System.out.println("Delete driver oleh: " + isDeletedOleh);
        System.out.println("------------");
        Driver getDriverMax = driverService.get(max.getId());
        System.out.println("Get driver Max: " + getDriverMax);
        System.out.println("------------");
        Driver updateLicense = driverService.update(new Driver(ira.getId(),ira.getName(),
                "AA111111"));
        System.out.println("Update driver Ira to: " + updateLicense);
    }
}
