package mate.jdbc.model;

import java.util.Objects;

public class Driver {
    private Long id;
    private String name;
    private String license_Number;

    public Driver() {
    }

    public Driver(Long id, String name, String license_Number) {
        this.id = id;
        this.name = name;
        this.license_Number = license_Number;
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

    public String getLicense_Number() {
        return license_Number;
    }

    public void setLicense_Number(String license_Number) {
        this.license_Number = license_Number;
    }

    @Override
    public String toString() {
        return "Driver{"
                + "id="
                + id + ", name='"
                + name + '\''
                + ", licenseNumber='"
                + license_Number + '\'' + '}';
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
        return Objects
                .equals(id, driver.id)
                && Objects.equals(name, driver.name)
                && Objects.equals(license_Number, driver.license_Number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, license_Number);
    }
}
