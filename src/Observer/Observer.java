package Observer;

import Composite.manufacturer;

public class Observer {
    manufacturer home;
    
    public Observer(manufacturer home) {
        this.home = home;
    }
    
    public void update(int price) {
        home.addToWallet(price);
    }

    public void updateTarget(manufacturer target) {
        home = target;
    }
}
