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

        Manufacturer Daewoo = new Manufacturer(null,"Daewoo", "Ukraine");
        Manufacturer rangeRover = new Manufacturer(null,"Range Rover", "USA");
        Manufacturer honda = new Manufacturer(null,"Honda", "Japan");

        manufacturerService.create(Daewoo);
        manufacturerService.create(rangeRover);
        manufacturerService.create(honda);
        System.out.println(manufacturerService.getAll());

        rangeRover.setCountry("Canada");

        manufacturerService.update(rangeRover);
        System.out.println(manufacturerService.get(rangeRover.getId()));
        System.out.println(manufacturerService.getAll());

        manufacturerService.delete(rangeRover.getId());
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver johnLysenko = new Driver(null, "John Lysenko", "AA 11111");
        Driver marichkaKononenko = new Driver(null, "Marichka Kononenko", "АВ 22222");
        Driver harryShevchenco = new Driver(null, "Harry Shevchenco", "CA 33333");

        driverService.create(johnLysenko);
        driverService.create(marichkaKononenko);
        driverService.create(harryShevchenco);
        System.out.println(driverService.getAll());

        johnLysenko.setName("Nazar Nesterenko");

        driverService.update(johnLysenko);
        System.out.println(driverService.get(johnLysenko.getId()));
        System.out.println(driverService.getAll());

        driverService.delete(johnLysenko.getId());
        System.out.println(driverService.getAll());
    }
}
