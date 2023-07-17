package mate.jdbc.model;

import java.util.Objects;

public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;
    private boolean isDeleted;

    public Driver() {
    }

    public Driver(Long id, String name, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return id;
    }

    public Driver setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Driver setName(String name) {
        this.name = name;
        return this;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Driver setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Driver driver = (Driver) o;

        if (isDeleted != driver.isDeleted) {
            return false;
        }
        if (!Objects.equals(id, driver.id)) {
            return false;
        }
        if (!Objects.equals(name, driver.name)) {
            return false;
        }
        return Objects.equals(licenseNumber, driver.licenseNumber);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (licenseNumber != null ? licenseNumber.hashCode() : 0);
        result = 31 * result + (isDeleted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Driver{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", licenseNumber='" + licenseNumber + '\''
                + ", isDeleted=" + isDeleted
                + '}';
    }
}
