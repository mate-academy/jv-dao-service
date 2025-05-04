package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver alonso = new Driver();
        alonso.setName("Fernando Alonso");
        alonso.setLicenseNumber("BE2005ES");
        driverService.create(alonso);
        Driver hamilton = new Driver();
        hamilton.setName("Lewis Hamilton");
        hamilton.setLicenseNumber("BT2010UK");
        driverService.create(hamilton);
        Driver schumacher = new Driver();
        schumacher.setName("Mick Schumacher");
        schumacher.setLicenseNumber("AI2055GE");
        driverService.create(schumacher);
        System.out.println(driverService.get(alonso.getId()));
        driverService.delete(schumacher.getId());
        driverService.update(new Driver(hamilton.getId(), "Amanda Hamilton", "CR1990XA"));
        driverService.getAll().forEach(System.out::println);
    }
}
