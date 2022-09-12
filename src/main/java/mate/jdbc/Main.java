package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
//        Manufacturer vw = new Manufacturer();
//        vw.setName("VW");
//        vw.setCountry("Germany");
//
//        Manufacturer honda = new Manufacturer();
//        honda.setCountry("Japan");
//        honda.setName("Honda");
//
//        manufacturerService.create(vw);
//        manufacturerService.create(honda);
//        System.out.println(manufacturerService.getAll());
//        Manufacturer ford = new Manufacturer();
//        ford.setName("Ford");
//        ford.setCountry("America");
//        manufacturerService.create(ford);
//        ford.setCountry("USA");
//        manufacturerService.update(ford);
//        manufacturerService.get(ford.getId());
//        manufacturerService.delete(ford.getId());

    }
}
