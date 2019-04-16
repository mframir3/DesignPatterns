package Composite;

import java.util.ArrayList;
import java.util.List;

import Factory.*;

public class Storage {
    ArrayList<Car> cars;
    
    public Storage() {
        cars = new ArrayList<Car>();
    }
    
    public void add(Car car) {
        cars.add(car);
    }
    
    /**Removes and return the first car.
     * 
     * @return
     */
    public Car get() {
        if (cars.isEmpty()) {
            return null;
        }
        Car car = cars.remove(0);
        cars.remove(car);
        cars.trimToSize();
        return car;
    }
}
