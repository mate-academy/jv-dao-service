package mate.jdbc.model;

import java.util.Objects;

public class Driver {
    private long id;
    private String name;
    private String licenceNumber;

    public Driver(String name, String licenceNumber) {
        this.name = name;
        this.licenceNumber = licenceNumber;
    }

    public Driver(long id, String name, String licenceNumber) {
        this.id = id;
        this.name = name;
        this.licenceNumber = licenceNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
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
        if (id != driver.id) {
            return false;
        }
        if (!Objects.equals(name, driver.name)) {
            return false;
        }
        return Objects.equals(licenceNumber, driver.licenceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, licenceNumber);
    }

    @Override
    public String toString() {
        return "Driver{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", licenceNumber='" + licenceNumber + '\''
            + '}';
    }
}
