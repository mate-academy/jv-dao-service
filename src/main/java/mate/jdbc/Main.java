package mate.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufactureService;
import mate.jdbc.util.ConnectionUtil;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final String MANUFACTURERS_DB = "manufacturers";
    private static final String DRIVERS_DB = "drivers";

    public static void main(String[] args) {
        ManufactureService manufactureService =
                (ManufactureService) injector.getInstance(ManufactureService.class);
        Manufacturer volkswagen = manufactureService.create(
                new Manufacturer("Volkswagen", "Germany"));
        Manufacturer hyundai = manufactureService.create(
                new Manufacturer("Hyundai", "South Korea"));
        Manufacturer cherry = manufactureService.create(
                new Manufacturer("Cherry", "China"));
        System.out.println(manufactureService.get(2L));
        System.out.println(manufactureService.get(3L));
        Manufacturer cherryToHaval = manufactureService.update(
                new Manufacturer(3L, "Haval", "China"));
        manufactureService.delete(2L);
        manufactureService.getAll().forEach(System.out::println);
        clear(MANUFACTURERS_DB);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver bob = driverService.create(
                new Driver("Bob", "NY12345678"));
        Driver john = driverService.create(
                new Driver("John", "FL12345678"));
        Driver alice = driverService.create(
                new Driver("Alice", "NE12345678"));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.get(3L));
        Driver aliceToEmma = driverService.update(
                new Driver(3L, "Emma", "TE12345678"));
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);
        clear(DRIVERS_DB);
    }

    private static void clear(String nameDB) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement("TRUNCATE " + nameDB)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't perform truncation", e);
        }
    }
}
