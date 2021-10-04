package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver petro = new Driver("Petro Mykolayovych", "AA7777BP");
        Driver ostap = new Driver("Ostap Andrievich", "AA0000BP");
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        driverService.create(petro);
        driverService.create(ostap);
        System.out.println(driverService.get(2L));
        Driver updateOstap = new Driver("Ostap Andrievich", "AI1111IA");
        updateOstap.setId(ostap.getId());
        System.out.println(driverService.update(updateOstap));
        driverService.delete(updateOstap.getId());
        System.out.println("-----Drivers-----");
        driverService.getAll().forEach(System.out::println);
    }
}
