package Composite;
import Factory.*;

public class dealership {
    private Storage carHold;
    private Car lot[];

    public dealership(Storage carHold) {
        this.carHold = carHold;
        lot = new Car[30];
    }
    
    public boolean sell(CarType type, Color color) {
        for(int i = 0; i < lot.length; i++) {
            if(lot[i].getColor() == color && lot[i].getType() == type) {
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
