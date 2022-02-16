package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        /*Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Monica");
        manufacturer.setCountry("Mexico");
        Manufacturer manufacturerMonica = manufacturerService.create(manufacturer);
        System.out.println(manufacturerMonica);*/

        /*long id = 11L;
        Optional<Manufacturer> optionalManufacturer = manufacturerService.get(id);
        System.out.println(optionalManufacturer.orElseThrow(() ->
                new NoSuchElementException("Can't find manufacturer by id: " + id)));*/

        /*List<Manufacturer> allManufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : allManufacturers) {
            System.out.println(manufacturer);
        }*/

        /*Manufacturer updateManufacturer = new Manufacturer(7L, "Chandler", "Britain");
        manufacturerService.update(updateManufacturer);*/

        /*System.out.println(manufacturerService.delete(9L));*/
    }
}
