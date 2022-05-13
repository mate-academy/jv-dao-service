package mate.jdbc.comparator;

import java.util.Comparator;
import mate.jdbc.model.Driver;

public class DriverComparator implements Comparator<Driver> {
    @Override
    public int compare(Driver driver1, Driver driver2) {
        int nameCompare = driver1.getName().compareTo(driver2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        return driver1.getLicenseNumber().compareTo(driver2.getLicenseNumber());
    }
}
