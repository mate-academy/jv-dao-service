## Common mistakes (jv-dao-service)

* Run __`mvn clean package`__ after finish homework and before sending the solution.
* Use `PreparedStatement` over `Statement`, even for a static query with no parameters in `getAll()` method. It's the best practice, and it's slightly faster.
* Use wrapper for id: `Long id` but not `long id`. And remember what is the difference between `==` and `equals`.
* Remember about SQL style: use uppercase for SQL keywords in your queries.
    ```sql     
       Wrong:
        SELECT * from manufacturers WHERE is_deleted = false;                    
             
       Good:
        SELECT * FROM manufacturers WHERE is_deleted = FALSE;
    ```  
* Use aliases for table names in SQL queries with JOIN 
    ```sql     
       Wrong:
        SELECT cars.id AS car_id, manufacturers.id AS manufacturer_id
            FROM cars
            JOIN manufacturers ON cars.manufacturer_id = manufacturers.id
          WHERE...;                     
             
       Good:
        SELECT c.id AS car_id, m.id AS manufacturer_id
          FROM cars c
            JOIN manufacturers m ON c.manufacturer_id = m.id
          WHERE...;
    ``` 
* Use informative messages for exceptions.
    ```
        Wrong:
            throw new DataProcessingException("Can't get manufacturer", e);
            
        Good:
            throw new DataProcessingException("Can't get manufacturer by id " + id, e);
            throw new DataProcessingException("Can't insert manufacturer " + manufacturer, e);
    ``` 
* To display data while testing use Stream API `forEach()`, not `for` loop.
* `get()` methods in Dao layer should return `Optional` (not in services). In the service layer better call method `get()` on Optional and return the object.
* You should not have any additional logic on Dao layer except managing database operations. All business logic must be on service layer.
* Do not open connection to DB on the service layer.
