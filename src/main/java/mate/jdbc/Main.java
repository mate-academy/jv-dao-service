package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.model.Pilot;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.PilotService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService MANUFACTURER_SERVICE
            = (ManufacturerService) INJECTOR.getInstance(ManufacturerService.class);
    private static final PilotService PILOT_SERVICE
            = (PilotService) INJECTOR.getInstance(PilotService.class);

    public static void main(String[] args) {
        Manufacturer airbus = new Manufacturer("Airbus","FRA");
        MANUFACTURER_SERVICE.create(airbus);
        Manufacturer boeing = new Manufacturer("Boeing","USA");
        MANUFACTURER_SERVICE.create(boeing);
        Manufacturer mcDonnellDouglas = new Manufacturer("McDonnell Douglas","USA");
        MANUFACTURER_SERVICE.create(mcDonnellDouglas);
        Manufacturer sukhoi = new Manufacturer("Sukhoi", "SUN");
        MANUFACTURER_SERVICE.create(sukhoi);
        Manufacturer ilyushin = new Manufacturer("Ilyushin", "SUN");
        MANUFACTURER_SERVICE.create(ilyushin);
        Pilot mskToKie = new Pilot("Aleksander Pushkin",
                "SU 0004", "Aeroflot - Soviet airlines", ilyushin.getId());
        PILOT_SERVICE.create(mskToKie);
        Pilot kieToMsk = new Pilot("Taras Shevchenko",
                "SU 0005", "Aeroflot - Soviet airlines", ilyushin.getId());
        PILOT_SERVICE.create(kieToMsk);

        System.out.println("\nGET");
        System.out.println(MANUFACTURER_SERVICE.get(sukhoi.getId()));
        System.out.println(PILOT_SERVICE.get(mskToKie.getId()));

        System.out.println("\nGET ALL after CREATE");
        MANUFACTURER_SERVICE.getAll().forEach(System.out::println);
        PILOT_SERVICE.getAll().forEach(System.out::println);

        System.out.println("\nGET ALL after UPDATE");
        mcDonnellDouglas.setName("Boeing");
        sukhoi.setCountry("RUS");
        ilyushin.setCountry("RUS");
        MANUFACTURER_SERVICE.update(mcDonnellDouglas);
        MANUFACTURER_SERVICE.update(sukhoi);
        MANUFACTURER_SERVICE.update(ilyushin);
        MANUFACTURER_SERVICE.getAll().forEach(System.out::println);
        mskToKie.setCarrier("Aeroflot - Russian airlines");
        mskToKie.setManufacturer(boeing.getId());
        kieToMsk.setFlightNumber("VV 1001");
        kieToMsk.setCarrier("AeroSvit - Ukrainian airlines");
        kieToMsk.setManufacturer(airbus.getId());
        PILOT_SERVICE.update(mskToKie);
        PILOT_SERVICE.update(kieToMsk);
        PILOT_SERVICE.getAll().forEach(System.out::println);

        System.out.println("\nGET ALL after DELETE");
        MANUFACTURER_SERVICE.delete(mcDonnellDouglas.getId());
        sukhoi.setName("United Aircraft Corporation");
        ilyushin.setName(sukhoi.getName());
        MANUFACTURER_SERVICE.update(sukhoi);
        MANUFACTURER_SERVICE.update(ilyushin);
        MANUFACTURER_SERVICE.delete(ilyushin.getId());
        MANUFACTURER_SERVICE.getAll().forEach(System.out::println);
        mskToKie.setName("Fedor Dostoevsky");
        mskToKie.setManufacturer(sukhoi.getId());
        kieToMsk.setFlightNumber("PS 1001");
        kieToMsk.setCarrier("Ukraine International Airlines");
        PILOT_SERVICE.update(mskToKie);
        PILOT_SERVICE.update(kieToMsk);
        PILOT_SERVICE.delete(kieToMsk.getId());
        PILOT_SERVICE.getAll().forEach(System.out::println);
    }
}
