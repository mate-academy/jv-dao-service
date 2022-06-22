package mate.jdbc.model;

public class Driver {
    private Long id;
    private String name;
    private String license;

    public Driver() {
    }

    public Driver(String name, String license) {
        this.name = name;
        this.license = license;
    }

    public Driver(Long id, String name, String license) {
        this.id = id;
        this.name = name;
        this.license = license;
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Driver{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", license='" + license + '\''
                + '}';
    }
}
