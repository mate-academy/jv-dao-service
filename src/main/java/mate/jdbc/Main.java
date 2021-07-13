package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");
    public static final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    public static void main(String[] args) {
        Driver bohdan = new Driver("Bohdan", "00700700");
        Driver kate = new Driver("Kateryna", "77077077");

        Driver createdBohdan = driverService.create(bohdan);
        Driver createdKate = driverService.create(kate);
        System.out.println(createdBohdan
                + System.lineSeparator()
                + createdKate
                + System.lineSeparator());

        Driver driverGotById = driverService.get(bohdan.getId());
        System.out.println(driverGotById + System.lineSeparator());

        kate.setName("Kate");
        kate.setLicenseNumber("12345678");
        Driver updatedKate = driverService.update(kate);

        boolean isDeleted = driverService.delete(bohdan.getId());

        driverService.getAll().forEach(System.out::println);
    }
}
