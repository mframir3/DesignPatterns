package Composite;

import java.util.List;

import Factory.*;

public class Storage {
    List<Car> cars;
    
    public void add(Car car) {
        cars.add(car);
    }
    
    public Car get() {
        return cars.remove(0);
    }
}
