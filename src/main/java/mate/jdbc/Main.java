package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    
    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService = (ManufacturerService) 
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        //Main should only contain invocation of Service methods, no Dao methods allowed in main.
        //Do not forget about Dependency Injection. Use your annotations.
        
    }
}
