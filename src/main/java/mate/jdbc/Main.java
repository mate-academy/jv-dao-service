package mate.jdbc;

import java.util.Arrays;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // Test ManufacturerService
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer peugeot = new Manufacturer(null, "Peugeot", "France");
        Manufacturer renault = new Manufacturer(null, "Renault", "France");
        Manufacturer bmw = new Manufacturer(null, "BMW", "Germany");
        Manufacturer volkswagen = new Manufacturer(null, "Volkswagen", "Germany");
        Manufacturer ford = new Manufacturer(null, "Ford", "USA");
        Manufacturer[] manufacturers = {peugeot, renault, bmw, volkswagen, ford};
        Arrays.stream(manufacturers).forEach(manufacturerService::create);
        System.out.println(manufacturerService.getAll());
        System.out.println();

        Manufacturer manufacturerGetBmw = manufacturerService.get(bmw.getId());
        System.out.println(manufacturerGetBmw);
        Manufacturer manufacturerGetRenault = manufacturerService.get(renault.getId());
        System.out.println(manufacturerGetRenault);
        System.out.println();

        boolean deleteRenault = manufacturerService.delete(renault.getId());
        boolean deleteFord = manufacturerService.delete(ford.getId());
        System.out.println(deleteRenault);
        System.out.println(deleteFord);
        System.out.println(manufacturerService.getAll());
        System.out.println();

        Manufacturer zaz = new Manufacturer(volkswagen.getId(), "Zaz", "Ukraine");
        manufacturerService.update(zaz);
        System.out.println(manufacturerService.get(zaz.getId()));
        System.out.println(manufacturerService.getAll());
        System.out.println();

        System.out.println("-----------------------------------------------------------------");

        // Test DriverService
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverVova = new Driver(null, "Vova", "13148837");
        Driver driverValera = new Driver(null, "Valera", "14541328");
        Driver driverDima = new Driver(null, "Dima", "77777722");
        Driver driverOleg = new Driver(null, "Oleg", "15552666");
        Driver[] drivers = {driverVova, driverValera, driverDima, driverOleg};
        Arrays.stream(drivers).forEach(driverService::create);
        System.out.println(driverService.getAll());
        System.out.println();

        Driver getDriverVova = driverService.get(driverVova.getId());
        Driver getDriverValera = driverService.get(driverValera.getId());
        System.out.println(getDriverVova);
        System.out.println(getDriverValera);
        System.out.println();

        boolean deleteDriverVova = driverService.delete(driverVova.getId());
        boolean deleteDriverValera = driverService.delete(driverValera.getId());
        System.out.println(deleteDriverVova);
        System.out.println(deleteDriverValera);
        List<Driver> driverList = driverService.getAll();
        System.out.println(driverList);
        System.out.println();

        Driver driver = new Driver(driverDima.getId(), "Maks", "1245218");
        driverService.update(driver);
        List<Driver> driverServiceAll = driverService.getAll();
        System.out.println(driverServiceAll);
    }
}
