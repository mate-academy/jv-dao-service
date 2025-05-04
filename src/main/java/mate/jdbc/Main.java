package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverOne = new Driver();
        driverOne.setName("Andrii");
        driverOne.setLicenseNumber("122444");

        Driver driverTwo = new Driver();
        driverTwo.setName("Oleksandr");
        driverTwo.setLicenseNumber("224880");

        Driver driverThree = new Driver();
        driverThree.setName("Volodymyr");
        driverThree.setLicenseNumber("224557");

        DriverService driverService = new DriverServiceImpl();

        System.out.println("Creating new driver: " + driverOne.getName());
        driverService.create(driverOne);
        System.out.println("Creating new driver: " + driverTwo.getName());
        driverService.create(driverTwo);
        System.out.println("Creating new driver: " + driverThree.getName());
        driverService.create(driverThree);

        System.out.println("All drivers list: ");
        System.out.println(driverService.getAll());

        System.out.println("Update driver " + driverOne.getName() + " license number");
        driverOne.setLicenseNumber("457888");
        driverService.update(driverOne);

        System.out.println("All drivers list: ");
        System.out.println(driverService.getAll());

        System.out.println("Delete driver: " + driverThree.getName()
                + " with id: " + driverThree.getId());
        System.out.println(driverService.delete(driverTwo.getId()));

        System.out.println("All drivers list: ");
        System.out.println(driverService.getAll());

        System.out.println(driverService.get(55L));
    }
}
