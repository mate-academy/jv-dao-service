package mate.jdbc;

import static mate.jdbc.util.TestUtil.printAllDriver;
import static mate.jdbc.util.TestUtil.printAllManufacturer;
import static mate.jdbc.util.TestUtil.testCreateDriver;
import static mate.jdbc.util.TestUtil.testCreateManufacturer;
import static mate.jdbc.util.TestUtil.testDeleteDriver;
import static mate.jdbc.util.TestUtil.testDeleteManufacturer;
import static mate.jdbc.util.TestUtil.testGetDriver;
import static mate.jdbc.util.TestUtil.testGetManufacturer;
import static mate.jdbc.util.TestUtil.testUpdateDriver;
import static mate.jdbc.util.TestUtil.testUpdateManufacturer;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.util.ConnectionUtil;

public class Main {
    private static final Injector injector = Injector.getInstance(Main.class.getPackageName());

    public static void main(String[] args) {
        System.out.println("INFO           DB: " + ConnectionUtil.getUrl());
        System.out.println("INFO         User: " + ConnectionUtil.getUserName());
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        //Start test Manufacturers functional
        startTestManufacturer(manufacturerService);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        //Start test Drivers functional
        startTestDriver(driverService);
    }

    private static void startTestManufacturer(ManufacturerService manufacturerService) {
        final Manufacturer audi = new Manufacturer("AUDI", "Germany");
        final Manufacturer bmw = new Manufacturer("BMW", "Germany");
        final Manufacturer chevrolet = new Manufacturer("Chevrolet", "Germany");
        System.out.println("\n#################################################################");
        System.out.println("#################### MANUFACTURES TEST ##########################");
        System.out.println("#################################################################");
        printAllManufacturer(manufacturerService);
        //create
        testCreateManufacturer(manufacturerService, audi, bmw, chevrolet);
        printAllManufacturer(manufacturerService);
        //get
        testGetManufacturer(manufacturerService);
        printAllManufacturer(manufacturerService);
        //update
        testUpdateManufacturer(manufacturerService);
        printAllManufacturer(manufacturerService);
        //delete
        testDeleteManufacturer(manufacturerService);
        printAllManufacturer(manufacturerService);
    }

    private static void startTestDriver(DriverService driverService) {
        final Driver andry = new Driver("Andry", "123456789");
        final Driver oksana = new Driver("Oksana", "666");
        final Driver oleg = new Driver("Oleg", "987654321");
        System.out.println("\n################################################################");
        System.out.println("####################### DRIVER TEST ############################");
        System.out.println("################################################################");
        //getAll
        printAllDriver(driverService);
        //create
        testCreateDriver(driverService, andry, oksana, oleg);
        printAllDriver(driverService);
        //get
        testGetDriver(driverService);
        printAllDriver(driverService);
        //update
        testUpdateDriver(driverService);
        printAllDriver(driverService);
        //delete
        testDeleteDriver(driverService);
        printAllDriver(driverService);
    }
}
