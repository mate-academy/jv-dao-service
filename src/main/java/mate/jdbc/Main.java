package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        initManufacture();
        initDriver();
    }

    private static void initManufacture() {
        ManufacturerService manufacturerService =
                (ManufacturerService) INJECTOR.getInstance(ManufacturerService.class);
        Manufacturer fordManufacturer = new Manufacturer("Ford Motor", "USA");
        Manufacturer porscheManufacturer = new Manufacturer("Porsche", "Germany");
        manufacturerService.create(fordManufacturer);
        manufacturerService.create(porscheManufacturer);
        fordManufacturer.setName("Tesla");
        manufacturerService.update(fordManufacturer);
        manufacturerService.delete(porscheManufacturer.getId());
    }

    private static void initDriver() {
        DriverService manufacturerDriver =
                (DriverService) INJECTOR.getInstance(DriverService.class);
        Driver sofaDriver = new Driver("Sofa", "qir2389235");
        Driver harisDriver = new Driver("Haris", "lin9873558");
        manufacturerDriver.create(sofaDriver);
        manufacturerDriver.create(harisDriver);
        sofaDriver.setLicenseNumber("qir1839994");
        manufacturerDriver.update(sofaDriver);
        manufacturerDriver.delete(sofaDriver.getId());
    }
}
