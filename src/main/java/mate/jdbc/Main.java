package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer chevrolet = new Manufacturer("Chevrolet", "USA");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        Manufacturer honda = new Manufacturer("Honda", "Japan");
        manufacturerService.create(chevrolet);
        manufacturerService.create(ford);
        manufacturerService.create(honda);
        //                  DB
        // id=1, name=Chevrolet, country=USA
        // id=2, name=Ford, country=USA
        // id=3, name=Honda, country=Japan
        System.out.println(manufacturerService.get(2L));
        //  |__ ford
        manufacturerService.delete(3L);
        // |__ honda is_Deleted=true
        chevrolet.setName("Chevrolet 2022 bumbleBee");
        manufacturerService.update(chevrolet);
        // |__ id=1, name=Chevrolet 2022 bumbleBee, country=USA
        manufacturerService.getAll().forEach(System.out::println);
        // |- Manufacturer{id=1, name='Chevrolet 2022 bumbleBee', country='USA'}
        // |- Manufacturer{id=2, name='Ford', country='USA'}

        System.out.println("Drivers: \n");
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver dmytro = new Driver("Dmytro", "DMT5430725430RLJG");
        Driver max = new Driver("Max", "MXTT55432745866539CS");
        Driver dan = new Driver("Denis", "DNS785999214146NS");
        driverService.create(dmytro);
        driverService.create(max);
        driverService.create(dan);
        //                  DB
        // id=1 name=Dmytro, licenseNumber=DMT5430725430RLJG
        // id=2 name=Max, licenseNumber=MXTT55432745866539CS
        // id=3 name=name=Denis, licenseNumber=DNS785999214146NS
        System.out.println(driverService.get(1L));
        // |__ dmytro
        driverService.delete(1L);
        max.setName("Maxine");
        driverService.update(max);
        // |__ id=2, name=Maxine, licenseNumber=MXTT55432745866539CS
        driverService.getAll().forEach(System.out::println);
        //  Driver{id=2, name='Maxine', licenseNumber='MXTT55432745866539CS'}
        //  Driver{id=3, name='Denis', licenseNumber='DNS785999214146NS'}
    }
}
