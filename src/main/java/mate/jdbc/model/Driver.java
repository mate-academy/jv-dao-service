package mate.jdbc.model;

public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Driver)) {
            return false;
        }

        Driver driver = (Driver) o;

        return (id == driver.id || id != null && id.equals(driver.id))
                && (name == driver.name || name != null && name.equals(driver.name))
                && (licenseNumber == driver.licenseNumber || licenseNumber != null
                && licenseNumber.equals(driver.licenseNumber));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (licenseNumber != null ? licenseNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Driver{"
                + "id=" + id
                + ", name='" + name
                + '\'' + ", licenseNumber='"
                + licenseNumber
                + '\''
                + '}';
    }
}
