package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        //Testing manufacturerService
        Manufacturer zazUkraine = new Manufacturer("Ukraine", "Zaz");
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerList.add(zazUkraine);
        manufacturerList.add(bmw);
        manufacturerList.add(ford);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerList.forEach(manufacturerService::create);
        System.out.println(manufacturerService.get(ford.getId()));
        System.out.println(manufacturerService.getAll());
        zazUkraine.setName("ZAZ_UKRAINE");
        zazUkraine.setCountry("Ukraine - ONE LOVE!!!");
        System.out.println(manufacturerService.update(zazUkraine));
        System.out.println(manufacturerService.delete(ford.getId()));

        //Testing driverservice
        Driver vasya = new Driver("Vasyl Petrov", "x12kax2");
        Driver petya = new Driver("Petro Doroshenko", "asd2xa3pg");
        Driver homer = new Driver("Homer Simpson", "kemz28clq");
        List<Driver> driverList = new ArrayList<>();
        driverList.add(vasya);
        driverList.add(petya);
        driverList.add(homer);
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        driverList.forEach(driverService::create);
        System.out.println(driverService.getAll());
        driverService.get(vasya.getId());
        vasya.setName("Vasyl Petrenko");
        vasya.setLicenseNumber("new license number");
        System.out.println(driverService.update(vasya));
        System.out.println(driverService.delete(homer.getId()));
    }
}
