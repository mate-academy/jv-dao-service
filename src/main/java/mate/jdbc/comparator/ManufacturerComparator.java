package mate.jdbc.comparator;

import java.util.Comparator;
import mate.jdbc.model.Manufacturer;

public class ManufacturerComparator implements Comparator<Manufacturer> {
    @Override
    public int compare(Manufacturer manufacturer1, Manufacturer manufacturer2) {
        int countryCompare = manufacturer1.getCountry().compareTo(manufacturer2.getCountry());
        if (countryCompare != 0) {
            return countryCompare;
        }
        return manufacturer1.getName().compareTo(manufacturer2.getName());
    }
}
