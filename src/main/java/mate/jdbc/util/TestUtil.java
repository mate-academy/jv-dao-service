package mate.jdbc.util;

import java.util.Scanner;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class TestUtil {
    //tests for MANUFACTURER
    public static void testDeleteManufacturer(ManufacturerService manufacturerService) {
        System.out.println("\n############################ DELETE #############################");
        System.out.println("\nDELETE manufacturer         please enter ID from keyboard: ");
        System.out.println("Result: " + manufacturerService.delete(setIdFromKeyboard()));
    }

    public static void testUpdateManufacturer(ManufacturerService manufacturerService) {
        System.out.println("\n############################ UPDATE #############################");
        Manufacturer newManufacturer = new Manufacturer();
        System.out.println("\nUPDATE manufacturer:    please enter ID  from keyboard: ");
        newManufacturer.setId(setIdFromKeyboard());
        System.out.println("\nUPDATE manufacturer:    please enter NAME from keyboard: ");
        newManufacturer.setName(setStringFromKeyboard());
        System.out.println("\nUPDATE manufacturer:    please enter COUNTRY from keyboard: ");
        newManufacturer.setCountry(setStringFromKeyboard());
        System.out.println("Result: " + manufacturerService.update(newManufacturer));
    }

    public static void testGetManufacturer(ManufacturerService manufacturerService) {
        System.out.println("\n############################# GET ###############################");
        System.out.println("\nINFO         please enter ID from keyboard: ");
        System.out.println("Result: " + manufacturerService.get(setIdFromKeyboard()));
    }

    public static void testCreateManufacturer(ManufacturerService manufacturersService,
                                               Manufacturer first,
                                               Manufacturer second,
                                               Manufacturer third) {
        System.out.println("\n########################### CREATE ##############################");
        System.out.println("\nINFO          create(" + first + ")");
        System.out.println("Created: " + manufacturersService.create(first));
        System.out.println("\nINFO          create(" + second + ")");
        System.out.println("Created: " + manufacturersService.create(second));
        System.out.println("\nINFO          create(" + third + ")");
        System.out.println("Created: " + manufacturersService.create(third));
    }

    public static void printAllManufacturer(ManufacturerService manufacturersService) {
        System.out.println("\n\nINFO          getAll()");
        manufacturersService.getAll().forEach(System.out::println);
    }

    //tests for DRIVER
    public static void testDeleteDriver(DriverService driverService) {
        System.out.println("\n############################ DELETE #############################");
        System.out.println("\nDELETE driver         please enter ID from keyboard: ");
        System.out.println("Result: " + driverService.delete(setIdFromKeyboard()));
    }

    public static void testUpdateDriver(DriverService driverService) {
        System.out.println("\n############################ UPDATE #############################");
        Driver newDriver = new Driver();
        System.out.println("\nUPDATE driver:    please enter ID  from keyboard: ");
        newDriver.setId(setIdFromKeyboard());
        System.out.println("\nUPDATE driver:    please enter NAME from keyboard: ");
        newDriver.setName(setStringFromKeyboard());
        System.out.println("\nUPDATE driver:    please enter LICENSE NUMBER from keyboard: ");
        newDriver.setLicenseNumber(setStringFromKeyboard());
        System.out.println("Result: " + driverService.update(newDriver));
    }

    public static void testGetDriver(DriverService driverService) {
        System.out.println("\n############################# GET ###############################");
        System.out.println("\nINFO         please enter ID from keyboard: ");
        System.out.println("Result: " + driverService.get(setIdFromKeyboard()));
    }

    public static void testCreateDriver(DriverService driverService,
                                              Driver first,
                                              Driver second,
                                              Driver third) {
        System.out.println("\n########################### CREATE #############################");
        System.out.println("\nINFO         create(" + first + ")");
        System.out.println("Created: " + driverService.create(first));
        System.out.println("\nINFO         create(" + second + ")");
        System.out.println("Created: " + driverService.create(second));
        System.out.println("\nINFO         create(" + third + ")");
        System.out.println("Created: " + driverService.create(third));
    }

    public static void printAllDriver(DriverService driverService) {
        System.out.println("\n\nINFO          getAll()");
        driverService.getAll().forEach(System.out::println);
    }

    private static Long setIdFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        while ((in.chars().filter(i -> i > 47 && i < 58).count() != in.length())
                || Long.parseLong(in) == 0) {
            System.out.println("You enter bad id, try again: ");
            in = scanner.nextLine();
        }
        return Long.parseLong(in);
    }

    private static String setStringFromKeyboard() {
        return new Scanner(System.in).nextLine();
    }
}
