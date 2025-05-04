package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driverMichel = new Driver();
        driverMichel.setName("Michel Rat");
        driverMichel.setLicenseNumber("8-800-555-355");
        driverService.create(driverMichel);

        Driver driverIgor = new Driver();
        driverIgor.setLicenseNumber("345-66-5-345");
        driverIgor.setName("Igor Terech");
        driverService.create(driverIgor);

        Driver driverTaras = new Driver();
        driverTaras.setLicenseNumber("65-566-555-5-315");
        driverTaras.setName("Taras Boch");
        driverService.create(driverTaras);

        Driver driverIvan = new Driver();
        driverIvan.setLicenseNumber("45-664-555-66");
        driverIvan.setName("Ivan Hedch");
        driverService.create(driverIvan);

        driverService.delete(driverMichel.getId());
        driverTaras.setName("Mick Rock");
        driverService.update(driverTaras);
        System.out.println(driverService.get(driverIgor.getId()) + "\n");
        driverService.getAll().stream().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerVolvo = new Manufacturer();
        manufacturerVolvo.setCountry("Sweden");
        manufacturerVolvo.setName("Volvo");
        manufacturerService.create(manufacturerVolvo);

        Manufacturer manufacturerPeugeot = new Manufacturer();
        manufacturerPeugeot.setCountry("France");
        manufacturerPeugeot.setName("Peugeot");
        manufacturerService.create(manufacturerPeugeot);

        Manufacturer manufacturerBmv = new Manufacturer();
        manufacturerBmv.setCountry("Germany");
        manufacturerBmv.setName("BMV");
        manufacturerService.create(manufacturerBmv);

        Manufacturer manufacturerAudi = new Manufacturer();
        manufacturerAudi.setCountry("Germany");
        manufacturerAudi.setName("Audi");
        manufacturerService.create(manufacturerAudi);

        Manufacturer manufacturerMaserati = new Manufacturer();
        manufacturerMaserati.setCountry("Italy");
        manufacturerMaserati.setName("Maserati");
        manufacturerService.create(manufacturerMaserati);

        Manufacturer manufacturerFord = new Manufacturer();
        manufacturerFord.setCountry("Usa");
        manufacturerFord.setName("Ford");
        manufacturerService.create(manufacturerFord);

        Manufacturer manufacturerUpdate = manufacturerService.get(manufacturerBmv.getId());
        manufacturerUpdate.setName("Mercedes-Benz");
        manufacturerService.update(manufacturerUpdate);

        Manufacturer manufacturerTesla = new Manufacturer();
        manufacturerTesla.setName("Tesla");
        manufacturerTesla.setCountry("USA");
        manufacturerService.create(manufacturerTesla);

        System.out.println(manufacturerService.get(manufacturerTesla.getId()) + "\n");
        manufacturerService.delete(manufacturerFord.getId());
        manufacturerService.getAll().stream().forEach(System.out::println);
    }
}
