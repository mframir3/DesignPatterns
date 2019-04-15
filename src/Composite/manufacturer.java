package Composite;

import java.util.List;

import Factory.*;

public class manufacturer {
    String name;
    manufacturer parent;
    List<manufacturer> childs;
    List<CarFactory> factories;
    Storage carHold;
    List<dealership> dealerships; 

    public manufacturer(CarType type, String name, int price) {
        this.name = name;
        factories.add(new CarFactory(price, type));
        carHold = new Storage();
        dealerships.add(new dealership(carHold));
    }

    public void addManufacturer(manufacturer child) {
        childs.add(child);
    }

    public void addFactory(CarFactory factory) {
        factories.add(factory);
    }

    public void produce(String color) {
        for(CarFactory factory : factories) {
            carHold.add(factory.produce(color));
        }

        for(manufacturer item : childs) {
            item.produce(color);
        }
    }

    public String getName() {
        return name;
    }

    public List<manufacturer> getChilds() {
        return childs;
    }

    public List<CarFactory> getFactories() {
        return factories;
    }

    public Storage getCarHold() {
        return carHold;
    }

    public boolean isChild() {
        if(parent == null) {
            return false;
        }

        else {
            return true;
        }
    }
    
    public void addParent(manufacturer parent) {
        this.parent = parent;
    }
    
    public manufacturer getParent() {
        return parent;
    }
}
