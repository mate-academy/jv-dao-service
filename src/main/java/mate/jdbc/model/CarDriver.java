package mate.jdbc.model;

import java.util.Objects;

public class CarDriver {
    private Long id;
    private String name;
    private String licenseNumber;

    public CarDriver(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public CarDriver(Long id, String name, String licenseNumber) {
        this(name, licenseNumber);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "CarDriver{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", licenseNumber='" + licenseNumber + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDriver carDriver = (CarDriver) o;
        return Objects.equals(id, carDriver.id) && Objects.equals(name, carDriver.name)
                && Objects.equals(licenseNumber, carDriver.licenseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, licenseNumber);
    }
}
