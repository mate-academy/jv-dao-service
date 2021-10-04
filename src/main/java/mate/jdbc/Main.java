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
        Manufacturer honda = new Manufacturer("Honda", "Japan");
        manufacturerService.create(honda);
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        manufacturerService.create(bmw);
        Manufacturer updateHonda = manufacturerService.get(honda.getId());
        updateHonda.setCountry("USA");
        manufacturerService.update(updateHonda);
        System.out.println(manufacturerService.getAll());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver specialDriver = new Driver("Jack", "AC889885t");
        driverService.create(specialDriver);
        Driver originDriver = new Driver();
        originDriver.setName("Mark");
        originDriver.setLicenseNumber("AB292875u");
        driverService.create(originDriver);
        driverService.delete(originDriver.getId());
        System.out.println(driverService.getAll());
    }
}
