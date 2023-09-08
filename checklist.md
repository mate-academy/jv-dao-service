## Common mistakes (jv-dao-service)

* Run __`mvn clean package`__ after finish homework and before sending the solution.
* Use `PreparedStatement` over `Statement`, even for a static query with no parameters in the `getAll()` method. It's the best practice, and it's slightly faster.
* Use wrapper for id: `Long id` but not `long id`. And remember what is the difference between `==` and `equals`.
* Remember about SQL style: use uppercase for SQL keywords in your queries.

    - Wrong:
    ```sql     
        SELECT * from manufacturers WHERE is_deleted = false;   
    ```
    - Good:
    ```sql
        SELECT * FROM manufacturers WHERE is_deleted = FALSE;
    ```  
* Use aliases for table names in SQL queries with JOIN 

    - Wrong:
    ```sql  
        SELECT cars.id AS car_id, manufacturers.id AS manufacturer_id
            FROM cars
            JOIN manufacturers ON cars.manufacturer_id = manufacturers.id
          WHERE...;                     
    ```
    - Good:
    ```sql
        SELECT c.id AS car_id, m.id AS manufacturer_id
          FROM cars c
            JOIN manufacturers m ON c.manufacturer_id = m.id
          WHERE...;
    ``` 
* Use informative messages for exceptions.

    - Wrong:
    ```java
            throw new DataProcessingException("Can't get manufacturer", e);
    ```
    - Good:
    ```java
            throw new DataProcessingException("Can't get manufacturer by id " + id, e);
            throw new DataProcessingException("Can't insert manufacturer " + manufacturer, e);
    ``` 
* To display data while testing use Stream API `forEach()`, not `for` loop.
* `get()` methods in the Dao layer should return `Optional` (not in services). In the service layer better call method `orElseThrow()` on Optional and return the object. If you're not interested in throwing a specific exception, both get() and orElseThrow() will throw a NoSuchElementException if the value is absent. 
* You should not have any additional logic on the Dao layer except managing database operations. All business logic must be on service layer.
* Do not open a connection to DB on the service layer.
