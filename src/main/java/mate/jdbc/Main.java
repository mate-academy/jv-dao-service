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
    private static final Long SECOND_ID = 2L;
    private static final Long THIRD_ID = 3L;
    private static final ManufactureService manufactureService =
            (ManufactureService) injector.getInstance(ManufactureService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        testManufacturerService();
        clear(MANUFACTURERS_DB);
        testDriverService();
        clear(DRIVERS_DB);
    }

    private static void testDriverService() {
        Driver bob = driverService.create(
                new Driver("Bob", "NY12345678"));
        Driver john = driverService.create(
                new Driver("John", "FL12345678"));
        Driver alice = driverService.create(
                new Driver("Alice", "NE12345678"));
        System.out.println(driverService.get(SECOND_ID));
        System.out.println(driverService.get(THIRD_ID));
        Driver aliceToEmma = driverService.update(
                new Driver(THIRD_ID, "Emma", "TE12345678"));
        driverService.delete(SECOND_ID);
        driverService.getAll().forEach(System.out::println);
    }

    private static void testManufacturerService() {
        Manufacturer volkswagen = manufactureService.create(
                new Manufacturer("Volkswagen", "Germany"));
        Manufacturer hyundai = manufactureService.create(
                new Manufacturer("Hyundai", "South Korea"));
        Manufacturer cherry = manufactureService.create(
                new Manufacturer("Cherry", "China"));
        System.out.println(manufactureService.get(SECOND_ID));
        System.out.println(manufactureService.get(THIRD_ID));
        Manufacturer cherryToHaval = manufactureService.update(
                new Manufacturer(THIRD_ID, "Haval", "China"));
        manufactureService.delete(SECOND_ID);
        manufactureService.getAll().forEach(System.out::println);
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
