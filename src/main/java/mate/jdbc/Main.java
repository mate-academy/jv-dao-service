package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {

        Driver johnLennon = new Driver("John Lennon", "S123-456-600-12");
        Driver polMccartney = new Driver("Pol Mccartney", "K200-546-176-01");
        Driver georgeHarrison = new Driver("George Harrison", "W414-842-763-22");
        Driver ringoStarr = new Driver("Ringo Starr", "A134-746-978-75");

        driverService.create(johnLennon);
        driverService.create(polMccartney);
        driverService.create(georgeHarrison);
        driverService.create(ringoStarr);

        Manufacturer bmw = new Manufacturer("BMW", "GERMANY");
        Manufacturer lexus = new Manufacturer("LEXUS", "JAPAN");
        Manufacturer acura = new Manufacturer("ACURA", "JAPAN");
        Manufacturer rollsRoyce = new Manufacturer("ROLLS-ROYCE", "GREAT BRITAIN");

        manufacturerService.create(bmw);
        manufacturerService.create(lexus);
        manufacturerService.create(acura);
        manufacturerService.create(rollsRoyce);
    }
}
