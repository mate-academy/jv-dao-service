# HW 03
- Create class `Driver`.
```java
public class Driver {
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
- Create Dao and Service layers for `Driver` and their implementations.
### DriverService methods:
    - Driver create(Driver driver);
    - Driver get(Long id);
    - List<Driver> getAll();
    - Driver update(Driver driver);
    - boolean delete(Long id);

- Do not forget about DB naming rules mentioned in previous homework.
- Test your code in `main`.
- Main should only contain invocation of `Service` methods, no Dao methods allowed in `main`.
- Do not forget about Dependency Injection. Use your annotations.

__You can check yourself using this__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-JDBC/dao-vs-service/dao-vs-service_checklist.html)


======================================================================================================================================================================


/*
# HW 03
- Створити клас `Драйвер`.
```java
public class Driver {
    private Long id;
    private String name;
    private String licenseNumber;
}
```
- Створення `ManufacturerService` та його впровадження. Анотації `@Service` і `@Inject` вже надано вам.
### Методи ManufacturerService:
    - Manufacturer create(Manufacturer manufacturer);
    - Manufacturer get(Long id);
    - List<Manufacturer> getAll();
    - Manufacturer update(Manufacturer manufacturer);
    - boolean delete(Long id);
- Створення рівнів Dao та Service для `Driver` та їх реалізації.
### Методи DriverService:
     - Driver create(Driver driver);
    - Driver get(Long id);
    - List<Driver> getAll();
    - Driver update(Driver driver);
    - boolean delete(Long id);

- Не забувайте про правила іменування БД, які згадувалися в попередньому домашньому завданні.
- Перевірте свій код у `main`.
- Main має містити лише виклик методів `Service`, жодних методів Dao не дозволено в `main`.
- Не забувайте про Dependency Injection. Використовуйте свої анотації.

__Ви можете перевірити себе за допомогою цього__ [контрольного списку](https://mate-academy.github.io/jv-program-common-mistakes/java-JDBC/dao-vs-service/dao-vs-service_checklist.html)
# HW 03
- Stvoryty klas `Drayver`.
```java

*/