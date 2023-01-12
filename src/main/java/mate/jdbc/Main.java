package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer1 = new Manufacturer();
        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer1.setCountry("Ukraine");
        manufacturer1.setName("VEPR");
        manufacturer2.setCountry("USA");
        manufacturer2.setName("HIMARS");
        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.getAll());
        manufacturerService.update(manufacturer2);
        //manufacturerService.delete(1L);
        System.out.println(manufacturerService.getAll());

    }
}
