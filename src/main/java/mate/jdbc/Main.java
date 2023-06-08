package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static DriverService driverService;
    private static ManufacturerService manufacturerService;

    public static void main(String[] args) {
        driverService = (DriverService) injector.getInstance(DriverService.class);
        manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Driver dominicToretto = new Driver("Dominic","family");
        Driver ivanych = new Driver("Ivanych", "ekarnuyBabay");
        Driver taxiDriver = new Driver("Daniel", "Marselle");
        driverService.create(dominicToretto);
        driverService.create(ivanych);
        driverService.create(taxiDriver);
        System.out.println(driverService.get(dominicToretto.getId()));
        Driver toUpdate = new Driver(ivanych.getId(), "Sanyok", "naparnik");
        driverService.update(toUpdate);
        driverService.delete(taxiDriver.getId());
        driverService.getAll().forEach(System.out::println);
        Manufacturer audi = new Manufacturer("Audi", "Germany");
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        manufacturerService.create(audi);
        System.out.println(manufacturerService.create(bmw));
        Manufacturer cherry = new Manufacturer(audi.getId(),"Cherry", "China");
        System.out.println(manufacturerService.update(cherry));
        System.out.println(manufacturerService.delete(cherry.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
