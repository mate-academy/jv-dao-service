package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Dodge", "USA"),
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("Honda", "Japan"));
        manufacturers.forEach(manufacturer -> {
            manufacturer = manufacturerService.create(manufacturer);
            System.out.println(manufacturer);
        });
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(manufacturer -> {
            manufacturer.setName("e " + manufacturer.getName());
            manufacturerService.update(manufacturer);
            System.out.println(manufacturerService.get(manufacturer.getId()));
        });
        manufacturers.forEach(manufacturer ->
                System.out.println(manufacturerService.delete(manufacturer.getId())));
    }
}
