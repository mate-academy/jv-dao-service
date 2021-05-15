package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufactureService;

public class Main {

    public static void main(String[] args) {
        Manufacturer sony = new Manufacturer();
        sony.setName("Sony");
        sony.setCountry("Europe");

        Manufacturer philips = new Manufacturer();
        philips.setName("Philips");
        philips.setCountry("Japan");

        Driver utility = new Driver();
        utility.setName("Utility");
        utility.setLicenseNumber("#3421a");

        Driver game = new Driver();
        game.setName("Rust Driver");
        game.setLicenseNumber("#5123b");

        Injector injector = Injector.getInstance("mate.jdbc");
        ManufactureService manufactureService =
                (ManufactureService) injector.getInstance(ManufactureService.class);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        //C
        Manufacturer sonyManufacturer = manufactureService.create(sony);
        Manufacturer philipsManufacturer = manufactureService.create(philips);
        System.out.println("Create manufacturers: " + sonyManufacturer + " " + philipsManufacturer);

        Driver utilityDriver = driverService.create(utility);
        Driver gameDriver = driverService.create(game);
        System.out.println("Create drivers: " + utilityDriver + " " + gameDriver);
        //R
        List<Manufacturer> allManufacturers = manufactureService.getAll();
        System.out.println("Get all manufacturers from DB: " + allManufacturers);
        Manufacturer getPhilips = manufactureService.get(philips.getId());
        System.out.println(getPhilips);

        List<Driver> allDrivers = driverService.getAll();
        System.out.println("Get all drivers from DB: " + allDrivers);
        Driver getGame = driverService.get(game.getId());
        System.out.println(getGame);
        //U
        sony.setCountry("Ukraine");
        Manufacturer updateSony = manufactureService.update(sony);
        System.out.println("Update data from DB: " + updateSony);

        utility.setLicenseNumber("#$2512agS");
        Driver updateUtility = driverService.update(utility);
        System.out.println("Update data from DB: " + updateUtility);
        //D
        boolean deletedManufacturer = manufactureService.delete(sony.getId());
        System.out.println(deletedManufacturer);

        boolean deletedDriver = driverService.delete(utility.getId());
        System.out.println(deletedDriver);
    }
}
