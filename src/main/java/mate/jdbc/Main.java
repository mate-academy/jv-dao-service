package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer(null, "Alfa Romeo", "Italy");
        StringBuilder stringBuilder = new StringBuilder("Info:");
        stringBuilder.append("\nManufacturerService:")
                .append("\nCreate:\n\t")
                .append(manufacturerService.create(manufacturer))
                .append(" was created.")
                .append("\nRead(get):\n\t")
                .append(manufacturerService.get(manufacturer.getId()))
                .append("\nRead(getAll):");
        manufacturerService.getAll().forEach(m -> stringBuilder.append("\n\t").append(m));
        manufacturer.setName("Porsche");
        manufacturer.setCountry("Germany");
        stringBuilder.append("\nUpdate:\n\t")
                .append(manufacturerService.update(manufacturer))
                .append(" was updated.")
                .append("\nDelete:\n\tManufacturer ")
                .append(manufacturerService.delete(manufacturer.getId())
                        ? "successfully" : "unsuccessfully")
                .append(" deleted.");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Francesco Ravioli", "69396");
        stringBuilder.append("\nDriverService:")
                .append("\nCreate:\n\t")
                .append(driverService.create(driver))
                .append(" was created.")
                .append("\nRead(get):\n\t")
                .append(driverService.get(driver.getId()))
                .append("\nRead(getAll):");
        driverService.getAll().forEach(d -> stringBuilder.append("\n\t").append(d));
        driver.setName("Karl Schmidt");
        driver.setLicenseNumber("36963");
        stringBuilder.append("\nUpdate:\n\t")
                .append(driverService.update(driver))
                .append(" was updated.")
                .append("\nDelete:\n\tDriver ")
                .append(driverService.delete(driver.getId()) ? "successfully" : "unsuccessfully")
                .append(" deleted.");
        System.out.println(stringBuilder);
    }
}
