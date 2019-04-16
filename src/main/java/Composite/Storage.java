package Composite;

import java.util.ArrayList;
import java.util.List;

import Factory.*;

public class Storage {
    List<Car> cars;
    
    public Storage() {
        cars = new ArrayList<Car>();
    }
    
    public void add(Car car) {
        cars.add(car);
    }
    
    public Car get() {
        if (cars.isEmpty()) {
            return null;
        }
        
        return cars.remove(0);
    }
}
