package mate.jdbc.model;

public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;
    // keep in mind, one driver can drive several cars per day,
    // but we do not want to store a list of cars in a Driver class
}
