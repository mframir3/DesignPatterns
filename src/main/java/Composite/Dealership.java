package Composite;
import Factory.*;
import Observer.Observer;

public class Dealership {
    private Storage carHold;
    private Car[] lot;
    private Observer observer;

    /**Produces a dealership with a specified carHold to pull from and observer to update price.
     * 
     * @param carHold carHold for this object to pull cars from
     * @param observer observer to update parent manufacturer from
     */
    public Dealership(Storage carHold, Observer observer) {
        this.carHold = carHold;
        lot = new Car[30];
        this.observer = observer;
    }

    /**Sells a car if the specified parameters are met.
     * 
     * @param type car type the "customer" wants
     * @param color color the "customer" wants
     * @param price "customer's" price range
     * @return
     */
    public boolean sell(CarType type, Color color, int price) {
        for (int i = 0; i < lot.length; i++) {
            if (lot[i] != null && lot[i].getColor() == color 
                    && lot[i].getType() == type && lot[i].getPrice() <= price) {
                observer.update(lot[i].getPrice());
                lot[i] = null;
                return true;
            }
        }
        return false;
    }

    /**Restocks the dealership from the specified carHold.
     * 
     * @return
     */
    public boolean restock() {
        for (int i = 0; i < lot.length; i++) {
            if (lot[i] == null) {
                lot[i] = carHold.get();
            }
        }

        for (int i = 0; i < lot.length; i++) {
            if (lot[i] == null) {
                return false;
            }
        }

        return true;
    }

    public void updateObservers(Manufacturer target) {
        observer.updateTarget(target);
    }

}
