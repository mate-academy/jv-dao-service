package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverLicenseNumberValidator;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        DriverLicenseNumberValidator validator =
                (DriverLicenseNumberValidator) injector
                        .getInstance(DriverLicenseNumberValidator.class);

        Driver lewis = driverService.create(new Driver("Lewis Hamilton",
                validator.validate("162373433163")));
        Driver max = driverService.create(new Driver("Max Verstappen",
                validator.validate("765837321131")));
        Driver fernando = driverService.create(new Driver("Fernando Alonso",
                validator.validate("312646302892")));

        System.out.println("get driver: " + driverService.get(lewis.getId()));

        System.out.println("delete driver: " + fernando.getName() + " = "
                + driverService.delete(fernando.getId()));

        max.setLicenseNumber("173483514871");
        Driver updatedMaxsLicense = driverService.update(max);
        System.out.println("update driver: " + updatedMaxsLicense);

        driverService.getAll().forEach(e -> System.out.println("All drivers: " + e));
    }
}
