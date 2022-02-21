package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        addingDataToDb(manufacturerService);

        createManufacturerInDb(manufacturerService);

        getManufacturerFromDb(manufacturerService);

        getAllManufacturersFromDb(manufacturerService);

        updateManufacturerInDb(manufacturerService);

        deleteManufacturerById(manufacturerService);
    }

    private static void addingDataToDb(ManufacturerService manufacturerService) {
        Manufacturer manufacturerKia = new Manufacturer();
        manufacturerKia.setName("Kia");
        manufacturerKia.setCountry("Korea");
        Manufacturer manufacturerBmv = new Manufacturer();
        manufacturerBmv.setName("BMV");
        manufacturerBmv.setCountry("Denmark");
        Manufacturer manufacturerTesla = new Manufacturer();
        manufacturerTesla.setName("Tesla");
        manufacturerTesla.setCountry("USA");
        Manufacturer manufacturerToyota = new Manufacturer();
        manufacturerToyota.setName("Toyota");
        manufacturerToyota.setCountry("China");
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(manufacturerKia);
        manufacturers.add(manufacturerBmv);
        manufacturers.add(manufacturerTesla);
        manufacturers.add(manufacturerToyota);
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerService.create(manufacturer);
        }
    }

    private static void createManufacturerInDb(ManufacturerService manufacturerService) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Mazda");
        manufacturer.setCountry("China");
        System.out.println("Created manufacturer in DB: "
                + manufacturerService.create(manufacturer));
    }

    private static void getManufacturerFromDb(ManufacturerService manufacturerService) {
        Long manufacturerTeslaId = 3L;
        System.out.println("Tesla manufacturer from DB: "
                + manufacturerService.get(manufacturerTeslaId));
    }

    private static void getAllManufacturersFromDb(ManufacturerService manufacturerService) {
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        System.out.println("All manufacturers from DB: ");
        manufacturers.forEach(System.out::println);
    }

    private static void updateManufacturerInDb(ManufacturerService manufacturerService) {
        Long manufacturerBmvId = 2L;
        Manufacturer newManufacturerForUpdate =
                new Manufacturer(manufacturerBmvId, "Volkswagen", "Denmark");
        System.out.println("Updated manufacturer in DB: "
                + manufacturerService.update(newManufacturerForUpdate));
    }

    private static void deleteManufacturerById(ManufacturerService manufacturerService) {
        Long manufacturerKiaId = 1L;
        System.out.println("Deleted manufacturer from DB by ID one: "
                + manufacturerService.delete(manufacturerKiaId));
    }
}
