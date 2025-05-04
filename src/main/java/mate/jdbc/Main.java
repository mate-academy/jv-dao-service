package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver karl = new Driver(null, "Karl", "1421421");
        System.out.println(driverService.create(karl));
        driverService.getAll()
                .forEach(System.out::println);
        System.out.println(driverService.get(2L));
        driverService.delete(5L);
        Driver melisa = new Driver();
        melisa.setName("Melisa");
        melisa.setLicenseNumber("21121");
        Long id = driverService.create(melisa).getId();
        driverService.update(new Driver(id, "Mel", "0000"));

    }
}
