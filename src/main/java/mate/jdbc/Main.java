package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Driver firstDriver = new Driver(null, "John Anyperson", "917044");
        Driver secondDriver = new Driver(null, "Robert De Niro", "265216");
        Driver thirdDriver = new Driver(null, "Daniel Morales", "419310");
        Driver fourthDriver = new Driver(null, "Ryan Gosling", "108988");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        driverService.create(thirdDriver);
        driverService.create(fourthDriver);
        firstDriver.setName("John Tobedeleted");
        driverService.update(firstDriver);
        System.out.println(driverService.get(firstDriver.getId()));
        driverService.delete(firstDriver.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer firstManufacturer = new Manufacturer(null, "Mercedes-Benz", "Germany");
        Manufacturer secondManufacturer = new Manufacturer(null, "Toyota", "Japan");
        Manufacturer thirdManufacturer = new Manufacturer(null, "Ford", "USA");
        Manufacturer fourthManufacturer = new Manufacturer(null, "Rolls-Royce", "UK");
        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        manufacturerService.create(thirdManufacturer);
        manufacturerService.create(fourthManufacturer);
        thirdManufacturer.setName("Chevrolet");
        manufacturerService.update(thirdManufacturer);
        System.out.println(manufacturerService.get(thirdManufacturer.getId()));
        manufacturerService.delete(thirdManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
