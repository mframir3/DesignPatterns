package Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Factory.*;
import Observer.Observer;

public class manufacturer {
    int wallet;
    int worth;
    String name;
    manufacturer parent;
    List<manufacturer> children;
    List<CarFactory> factories;
    Storage carHold;
    List<dealership> dealerships; 

    public manufacturer(CarType type, String name, int price, int worth) {
        this.name = name;
        children = new ArrayList<manufacturer>();
        factories = new ArrayList<CarFactory>();
        factories.add(new CarFactory(price, type));
        carHold = new Storage();
        dealerships = new ArrayList<dealership>();
        dealerships.add(new dealership(carHold, new Observer(this)));
        this.worth = worth;
        wallet = 0;
        carHold = new Storage();
    }

    public void addManufacturer(manufacturer child) {
        children.add(child);
    }

    public void addFactory(CarFactory factory) {
        factories.add(factory);
    }

    public void addDealership(dealership in) {
        dealerships.add(in);
    }

    public void produce(Color color) {
        for(CarFactory factory : factories) {
            carHold.add(factory.produce(color));
        }

        for(manufacturer item : children) {
            item.produce(color);
        }
    }

    public String getName() {
        return name;
    }

    public List<manufacturer> getChilds() {
        return children;
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

    public void addChild(manufacturer child) {
        children.add(child);
    }

    public int getWallet() {
        return wallet;
    }

    public int getWorth() {
        return worth;
    }

    public void addParent(manufacturer parent) {
        this.parent = parent;
    }

    public manufacturer getParent() {
        return parent;
    }

    public void addToWallet(int price) {
        wallet += price;
    }

    public int sell() {
        int count = 0;
        for(dealership i : dealerships) {
            if(i.sell(CarType.getRandomCarType(), Color.getRandomColor())){
                count ++;
            }
        }

        return count;
    }

    public void buy(manufacturer target) {
        wallet -= target.getWorth();
        target.addParent(this);
        this.addChild(target);
        target.setWallet(0);
        target.updateObservers(this);
        worth += target.getWorth();
        System.out.println(name + " bought " + target.getName());
    }

    private void setWallet(int i) {
        wallet = i;
    }

    private void updateObservers(manufacturer target) {
        for(dealership i : dealerships) {
            i.updateObservers(target);
        }        
    }

    public boolean owns(manufacturer target) {
        return children.contains(target);
    }

    public void restock() {
        for(dealership i : dealerships) {
            i.restock();
        }        
    }
}
