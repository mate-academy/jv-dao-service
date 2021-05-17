package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver maks = new Driver();
        maks.setName("Maksym");
        maks.setLicenseNumber("8800535");

        Driver serj = new Driver();
        serj.setName("Serj");
        serj.setLicenseNumber("8800536");

        Driver artem = new Driver();
        artem.setName("Artem");
        artem.setLicenseNumber("8700537");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver maksDriver = driverService.create(maks);
        Driver serjDriver = driverService.create(serj);
        Driver artemDriver = driverService.create(artem);
        System.out.println("Created drivers: " + maksDriver
                + " " + serjDriver + " " + artemDriver);

        driverService.getAll().forEach(System.out::println);

        Driver driver = driverService.get(serj.getId());
        System.out.println("Get driver by id: " + driver);

        artem.setLicenseNumber("8800537");
        Driver updatedDriver = driverService.update(artem);
        System.out.println("Update artem driver: " + updatedDriver);

        boolean deleteDriver = driverService.delete(maks.getId());
        System.out.println("Delete driver: " + deleteDriver);

        Manufacturer sanos = new Manufacturer();
        sanos.setName("Sanos");
        sanos.setCountry("North Macedonia");

        Manufacturer skoda = new Manufacturer();
        skoda.setName("Skoda");
        skoda.setCountry("Czech Republic");

        Manufacturer acura = new Manufacturer();
        acura.setName("Acura");
        acura.setCountry("Japan");

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer sanosManufacturer = manufacturerService.create(sanos);
        Manufacturer skodaManufacturer = manufacturerService.create(skoda);
        Manufacturer acuraManufacturer = manufacturerService.create(acura);
        System.out.println("Created manufacturers: " + sanosManufacturer
                + " " + skodaManufacturer + " " + acuraManufacturer);

        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer getAcuraManufacturer = manufacturerService.get(acura.getId());
        System.out.println("Get Acura manufacturer: " + getAcuraManufacturer);

        skoda.setName("Škoda");
        Manufacturer updateSkodaManufacturer = manufacturerService.update(skoda);
        System.out.println("Update Škoda manufacturer: " + updateSkodaManufacturer);

        boolean deleteAcuraManufacturer = manufacturerService.delete(acura.getId());
        System.out.println("Delete manufacturer from DB: " + deleteAcuraManufacturer);
    }
}
