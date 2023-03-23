package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService service = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Driver driver = service.create(new Driver("Bob", "123654"));
        driver = service.create(new Driver("Misha", "228"));
        driver = service.create(new Driver("Bohdan", "mate the best"));
        driver = service.create(new Driver("Vika", "qwerty1234"));
        System.out.println(service.getAll());
        System.out.println(service.get(2L));
        System.out.println(service.delete(3L));
        System.out.println(service.getAll());
    }
}
