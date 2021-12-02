package mate.jdbc.model;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;

}
