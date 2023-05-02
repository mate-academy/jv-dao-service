package mate.jdbc.model;

import lombok.Data;

@Data
public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;
    private boolean isDeleted;

    public Driver(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public Driver(Long id, String name, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
}
