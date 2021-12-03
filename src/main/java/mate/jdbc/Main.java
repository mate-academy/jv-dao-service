package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.servive.DriverService;
import mate.jdbc.servive.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver vova = new Driver("Vovislav", "JK9000009");
        Driver julia = new Driver("Julia", "VI155343");
        Driver fred = new Driver("Fred", "CAL43573XJ");

        vova = driverService.create(vova);
        julia = driverService.create(julia);
        fred = driverService.create(fred);
        System.out.println(driverService.getAll());
        driverService.delete(julia.getId());
        vova.setName("Vasilisa");
        driverService.update(vova);
        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer pinkrocket = new Manufacturer("Pink Rocket", "Mars Confederation");
        Manufacturer apm = new Manufacturer("APM Industries", "Nauru Republic");

        pinkrocket = manufacturerService.create(pinkrocket);
        apm = manufacturerService.create(apm);
        System.out.println(manufacturerService.getAll());
        pinkrocket.setName("Big Black Rocket");
        manufacturerService.update(pinkrocket);
        manufacturerService.delete(apm.getId());
        System.out.println(manufacturerService.get(pinkrocket.getId()));
        System.out.println(manufacturerService.getAll());
    }
}
