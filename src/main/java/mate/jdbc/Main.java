package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        // test your code here
        Manufacturer manufacturerRenault = new Manufacturer();
        manufacturerRenault.setName("Renault");
        manufacturerRenault.setCountry("France");
        manufacturerService.create(manufacturerRenault);

        Manufacturer manufacturerSkoda = new Manufacturer();
        manufacturerSkoda.setName("Skoda");
        manufacturerSkoda.setCountry("Czech");
        manufacturerService.create(manufacturerSkoda);

        manufacturerService.get(manufacturerRenault.getId());
        manufacturerService.delete(manufacturerRenault.getId());

        manufacturerSkoda.setName("VW");
        manufacturerSkoda.setCountry("Germany");
        manufacturerService.update(manufacturerSkoda);

        for (Manufacturer manufacturer : manufacturerService.getAll()) {
            System.out.println(manufacturer);
        }

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver vettel = new Driver();
        vettel.setName("Sebastian Vettel");
        vettel.setLicenseNumber("484832943294sss");
        driverService.create(vettel);

        Driver leclerc = new Driver();
        leclerc.setName("Charles Leclerc");
        leclerc.setLicenseNumber("88888813123hj");
        driverService.create(leclerc);

        Driver hamilton = new Driver();
        hamilton.setName("Sir Lewis Hamilton");
        hamilton.setLicenseNumber("77777sssss");
        driverService.create(hamilton);

        driverService.get(hamilton.getId());
        driverService.delete(vettel.getId());

        for (Driver driver : driverService.getAll()) {
            System.out.println(driver);
        }

    }
}
