package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService instance = (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob", "1111");
        Driver alice = new Driver("Alice", "2222");
        Driver jhon = new Driver("Jhon","3333");

        instance.create(bob);
        instance.create(alice);
        instance.create(jhon);

        System.out.println(instance.get(alice.getId()));

        alice.setLicenseNumber("4444");
        instance.update(alice);

        instance.delete(jhon.getId());

        instance.getAll().forEach(System.out::println);
    }
}
