# HW 03
- Create class `mate.jdbc.model.Driver`.
```java
public class mate.jdbc.model.Driver {
    private Long id;
    private String name;
    private String licenseNumber;
}
```
- Create `ManufacturerService` and its implementation. Annotations `@Service` and `@Inject` have already been given to you.
### ManufacturerService methods:
    - Manufacturer create(Manufacturer manufacturer);
    - Manufacturer get(Long id);
    - List<Manufacturer> getAll();
    - Manufacturer update(Manufacturer manufacturer);
    - boolean delete(Long id);
- Create Dao and Service layers for `mate.jdbc.model.Driver` and their implementations.
### DriverService methods:
    - mate.jdbc.model.Driver create(mate.jdbc.model.Driver driver);
    - mate.jdbc.model.Driver get(Long id);
    - List<mate.jdbc.model.Driver> getAll();
    - mate.jdbc.model.Driver update(mate.jdbc.model.Driver driver);
    - boolean delete(Long id);

- Do not forget about DB naming rules mentioned in previous homework.
- Test your code in `main`.
- Main should only contain invocation of `Service` methods, no Dao methods allowed in `main`.
- Do not forget about Dependency Injection. Use your annotations.

__You can check yourself using this__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-JDBC/dao-vs-service/dao-vs-service_checklist.html)
