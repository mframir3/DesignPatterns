package Observer;

import Composite.Manufacturer;

public class Observer {
    Manufacturer home;
    
    public Observer(Manufacturer home) {
        this.home = home;
    }
    
    public void update(int price) {
        home.addToWallet(price);
    }

    public void updateTarget(Manufacturer target) {
        home = target;
    }
}
