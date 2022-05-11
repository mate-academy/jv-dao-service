package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverAlex = new Driver("alex", "112233");
        Driver driverVin = new Driver("Vin", "223344");
        Driver driverKarl = new Driver("Karl", "334455");
        driverService.create(driverAlex);
        driverService.create(driverVin);
        driverService.create(driverKarl);
        driverAlex.setName("Alex");
        driverService.update(driverAlex);
        driverService.delete(driverKarl.getId());
        driverService.get(driverVin.getId());
        driverService.getAll();

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturerVolkswagen = new Manufacturer("Volkswagen", "Germany");
        Manufacturer manufacturerRenault = new Manufacturer("Renault", "France");
        Manufacturer manufacturerVolvo = new Manufacturer("SAAB", "Sweden");
        Manufacturer manufacturerSkoda = new Manufacturer("Skoda", "Czech Republic");
        manufacturerService.create(manufacturerVolkswagen);
        manufacturerService.create(manufacturerSkoda);
        manufacturerService.create(manufacturerRenault);
        manufacturerService.create(manufacturerVolvo);
        manufacturerService.delete(manufacturerRenault.getId());
        manufacturerVolvo.setName("Volvo");
        manufacturerService.update(manufacturerVolvo);
        manufacturerService.get(manufacturerVolkswagen.getId());
        manufacturerService.getAll();
    }
}
