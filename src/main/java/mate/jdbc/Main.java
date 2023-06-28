package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {

    private final MainHelper mainHelper;

    public Main(ManufacturerService manufacturerService, DriverService driverService) {
        this.mainHelper = new MainHelper(manufacturerService, driverService);
    }

    public void run() {
        mainHelper.createManufacturer(39L, "NewValue33", "IDK");
        mainHelper.updateManufacturer(33L, "UpdatedName", "AndCountry");
        mainHelper.deleteManufacturer(14L);
        mainHelper.createDriver(44L, "Data", "Here");
        mainHelper.getDriver(3L);
        mainHelper.deleteDriver(4L);
    }

    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerService manufacturerService1 =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Main main = new Main(manufacturerService1, driverService);
        main.run();
    }
}
