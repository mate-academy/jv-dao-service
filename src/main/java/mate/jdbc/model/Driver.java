package mate.jdbc.model;

public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public String toString() {
        return String.format("Driver{id=%d, name='%s', licenseNumber='%s'}",
                id, name, licenseNumber);
    }
}
