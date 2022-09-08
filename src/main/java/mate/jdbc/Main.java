package mate.jdbc;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao =
                (ManufacturerDao) injector.getInstance(ManufacturerDao.class);
        Manufacturer nissan = new Manufacturer();
        nissan.setName("Nissan");
        nissan.setCountry("Japan");
        manufacturerDao.create(nissan);

        Manufacturer porsche = new Manufacturer();
        porsche.setName("Porsche");
        porsche.setCountry("Germany");
        manufacturerDao.create(porsche);

        Manufacturer audi = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        manufacturerDao.create(audi);

        Manufacturer hyundai = new Manufacturer();
        hyundai.setName("Hyundai");
        hyundai.setCountry("South_Korean");
        manufacturerDao.create(hyundai);

        Manufacturer ford = new Manufacturer();
        ford.setName("Ford");
        ford.setCountry("United_States");
        manufacturerDao.create(ford);

        manufacturerDao.getAll().forEach(System.out::println);
        System.out.println("---------------------------- Create cars" + System.lineSeparator());

        nissan.setName("Ford");
        nissan = manufacturerDao.update(nissan);
        System.out.println("Update car -> " + nissan);

        System.out.println("Get car -> " + manufacturerDao.get(hyundai.getId()));

        System.out.println("Delete car -> " + manufacturerDao.delete(audi.getId()));

        manufacturerDao.getAll().forEach(System.out::println);

        System.out.println("----------------------------------------------");

        DriverDao driverDao = (DriverDao) injector.getInstance(DriverDao.class);

        Driver rostyslav = new Driver();
        rostyslav.setName("Rostyslav");
        rostyslav.setLicenseNumber("95A555999");
        driverDao.create(rostyslav);

        Driver vadym = new Driver();
        vadym.setName("Vadym");
        vadym.setLicenseNumber("85B255999");
        driverDao.create(vadym);

        Driver valentyn = new Driver();
        valentyn.setName("Valentyn");
        valentyn.setLicenseNumber("87R455999");
        driverDao.create(valentyn);

        driverDao.getAll().forEach(System.out::println);
        System.out.println("---------------------------- Create driver" + System.lineSeparator());

        rostyslav.setLicenseNumber("66666666");
        rostyslav = driverDao.update(rostyslav);
        System.out.println("Update driver -> " + rostyslav);

        System.out.println("Get driver -> " + driverDao.get(vadym.getId()));

        System.out.println("Delete driver -> " + driverDao.delete(valentyn.getId()));

        manufacturerDao.getAll().forEach(System.out::println);

    }
}
