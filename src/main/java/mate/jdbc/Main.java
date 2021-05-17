package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Flight;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.FlightService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final FlightService flightService =
            (FlightService) injector.getInstance(FlightService.class);

    public static void main(String[] args) {
        Manufacturer airbus = new Manufacturer("Airbus","FRA");
        manufacturerService.create(airbus);
        Manufacturer boeing = new Manufacturer("Boeing","USA");
        manufacturerService.create(boeing);
        Manufacturer mcDonnellDouglas = new Manufacturer("McDonnell Douglas","USA");
        manufacturerService.create(mcDonnellDouglas);
        Manufacturer sukhoi = new Manufacturer("Sukhoi", "SUN");
        manufacturerService.create(sukhoi);
        Manufacturer ilyushin = new Manufacturer("Ilyushin", "SUN");
        manufacturerService.create(ilyushin);
        Flight mskToKie = new Flight("Aeroflot - Soviet airlines", "SU 0004", ilyushin.getId());
        flightService.create(mskToKie);
        Flight kieToMsk = new Flight("Aeroflot - Soviet airlines", "SU 0005", ilyushin.getId());
        flightService.create(kieToMsk);

        System.out.println("\nGET");
        System.out.println(manufacturerService.get(sukhoi.getId()));
        System.out.println(flightService.get(mskToKie.getId()));

        System.out.println("\nGET ALL after CREATE");
        manufacturerService.getAll().forEach(System.out::println);
        flightService.getAll().forEach(System.out::println);

        System.out.println("\nGET ALL after UPDATE");
        mcDonnellDouglas.setName("Boeing");
        sukhoi.setCountry("RUS");
        ilyushin.setCountry("RUS");
        manufacturerService.update(mcDonnellDouglas);
        manufacturerService.update(sukhoi);
        manufacturerService.update(ilyushin);
        manufacturerService.getAll().forEach(System.out::println);
        mskToKie.setCarrier("Aeroflot - Russian airlines");
        mskToKie.setManufacturer(boeing.getId());
        kieToMsk.setNumber("VV 1001");
        kieToMsk.setCarrier("AeroSvit - Ukrainian airlines");
        kieToMsk.setManufacturer(airbus.getId());
        flightService.update(mskToKie);
        flightService.update(kieToMsk);
        flightService.getAll().forEach(System.out::println);

        System.out.println("\nGET ALL after DELETE");
        manufacturerService.delete(mcDonnellDouglas.getId());
        sukhoi.setName("United Aircraft Corporation");
        ilyushin.setName(sukhoi.getName());
        manufacturerService.update(sukhoi);
        manufacturerService.update(ilyushin);
        manufacturerService.delete(ilyushin.getId());
        manufacturerService.getAll().forEach(System.out::println);
        mskToKie.setManufacturer(sukhoi.getId());
        kieToMsk.setNumber("PS 1001");
        kieToMsk.setCarrier("Ukraine International Airlines");
        flightService.update(mskToKie);
        flightService.update(kieToMsk);
        flightService.delete(kieToMsk.getId());
        flightService.getAll().forEach(System.out::println);

        manufacturerService.truncateTable();
        flightService.truncateTable();

    }
}
