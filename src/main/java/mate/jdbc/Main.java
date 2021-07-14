package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufactureService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver("Petrovich", "111111");
        Driver secondDriver = new Driver("Ochkovich", "22222");
        Driver thirdDriver = new Driver("Fuflovich", "33333");
//        driverService.create(firstDriver);
//        driverService.create(secondDriver);
//        driverService.create(thirdDriver);
//        driverService.delete(4L);
//        System.out.println(driverService.get(1L));
//        firstDriver = driverService.get(1L);
//        firstDriver.setLicenseNumber("55555");
//        driverService.update(firstDriver);
        driverService.getAll().forEach(System.out::println);

        ManufactureService manufacturerService =
                (ManufactureService) injector.getInstance(ManufactureService.class);
        Manufacturer audi = new Manufacturer("audi","Germany");
        Manufacturer vw = new Manufacturer("vw","Germany");
        Manufacturer lada = new Manufacturer("lada","USSR");
//        manufacturerService.create(audi);
//        manufacturerService.create(vw);
//        manufacturerService.create(lada);
//        lada = manufacturerService.get(4L);
//        lada.setCountry("Russia");
//        manufacturerService.update(lada);
//        manufacturerService.delete(4L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
