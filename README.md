# HW 02

- Create models: `Car`, `Driver` and `Manufacturer`. Use UML diagram (models) for this, see below.
- Create DAO and service layer for `Manufacturer` model. Below you can see the list of required methods.
- Add CRUD operations into `ManufacturerDao`.
- Do not forget to use your own annotation Dao.
- Return [Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html) when you can return null in DAO.
  For example: ```public Optional<Manufacturer> get(Long id);```
- Add new [injector](../content/new-injector.md) to your project.
- Add class Application with main method where you are invoking all your methods from service
- In the `main` method create instance of manufacturer service and call CRUD methods. It may look like:
```java
public class Main {
    private static final Injector injector = Injector.getInstance("YOUR_PACKAGE");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        // initialize field values using setters or constructor
        manufacturerService.save(manufacturer);
        // same for all other crud methods and for all models
    }
}
```

### Java classes structure:
- Manufacturer
```java
public class Manufacturer {
    private Long id;
    private String name;
    private String country;
}
```

- Driver

```java
import java.util.List;

public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;
    // keep in mind, one driver can drive several cars per day
    // but we do not wan't to store a list of cars in a Driver class
}
```

- Car

```java
import java.util.List;

public class Car {
    private Long id;
    private String model;
    private Manufacturer manufacturer;
    private List<Driver> drivers;
}
```

### ManufacturerDao methods:
    - Manufacturer create(Manufacturer manufacturer);
    - Optional<Manufacturer> get(Long id);
    - List<Manufacturer> getAll();
    - Manufacturer update(Manufacturer manufacturer);
    - boolean delete(Long id);

### ManufacturerService methods:
    - Manufacturer create(Manufacturer manufacturer);
    - Manufacturer get(Long id);
    - List<Manufacturer> getAll();
    - Manufacturer update(Manufacturer manufacturer);
    - boolean delete(Long id);

### UML diagram

![img](../content/taxi_models_diagram.jpg)

__You can check yourself using this__ [checklist](../checklist/03_dao_service_checklist.md)
