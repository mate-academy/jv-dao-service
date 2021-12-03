package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver jora = new Driver();
        jora.setName("Жорик");
        jora.setLicenseNumber("BC575Q6");
        Driver valentin = new Driver();
        valentin.setName("Valentin");
        valentin.setLicenseNumber("SD628F6");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(jora);
        driverService.create(valentin);
        System.out.println("**************");
        System.out.println("All drivers ->");
        driverService.getAll().forEach(System.out::println);
        System.out.println("**************");
        System.out.println("New license");
        System.out.println(driverService.get(jora.getId()));
        jora.setLicenseNumber("SF523FD");
        System.out.println(driverService.get(jora.getId()));
        System.out.println("**************");
        System.out.println("Get driver ->");
        System.out.println(driverService.get(valentin.getId()));
        System.out.println("**************");
        System.out.println("Delete driver ->");
        driverService.delete(valentin.getId());
        driverService.getAll().forEach(System.out::println);
        System.out.println("**************");

        Manufacturer daewoo = new Manufacturer();
        daewoo.setName("Daewoo");
        daewoo.setCountry("South Korea");
        Manufacturer skoda = new Manufacturer();
        skoda.setName("Skoda");
        skoda.setCountry("Czech");

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(daewoo);
        manufacturerService.create(skoda);
        System.out.println("**************");
        System.out.println("All car ->");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Set new country");
        System.out.println(manufacturerService.get(daewoo.getId()));
        daewoo.setCountry("Ukraine");
        manufacturerService.update(daewoo);
        System.out.println(manufacturerService.get(daewoo.getId()));
        System.out.println("**************");
        System.out.println("Get driver by id");
        System.out.println(manufacturerService.get(daewoo.getId()));
        System.out.println("***************");
        System.out.println("Delete driver");
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(daewoo.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
