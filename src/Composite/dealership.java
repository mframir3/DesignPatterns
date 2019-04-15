package Composite;
import Factory.*;
import Observer.Observer;

public class dealership {
    private Storage carHold;
    private Car lot[];
    private Observer observer;

    public dealership(Storage carHold, Observer observer) {
        this.carHold = carHold;
        lot = new Car[30];
        this.observer = observer;
    }
    
    public boolean sell(CarType type, Color color) {
        for(int i = 0; i < lot.length; i++) {
            if(lot[i].getColor() == color && lot[i].getType() == type) {
                observer.update(lot[i].getPrice());
                lot[i] = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean restock() {
        for(int i = 0; i < lot.length; i++) {
            if(lot[i] == null) {
                lot[i] = carHold.get();
            }
        }
        
        for(int i = 0; i < lot.length; i++) {
            if(lot[i] == null) {
                return false;
            }
        }
        
        return true;
    }

}
