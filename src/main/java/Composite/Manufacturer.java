package Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Factory.*;
import Observer.Observer;

public class Manufacturer {
    int wallet;
    int worth;
    String name;
    Manufacturer parent;
    List<Manufacturer> children;
    List<CarFactory> factories;
    Storage carHold;
    List<Dealership> dealerships; 

    /**Constructs Manufacturer with the specified parameters.
     * 
     * @param type Vehicle type
     * @param name Name of the company
     * @param price Price of the vehicles originally produced
     * @param worth Company's net worth
     */
    public Manufacturer(CarType type, String name, int price, int worth) {
        this.name = name;
        children = new ArrayList<Manufacturer>();
        factories = new ArrayList<CarFactory>();
        factories.add(new CarFactory(price, type));
        carHold = new Storage();
        dealerships = new ArrayList<Dealership>();
        dealerships.add(new Dealership(carHold, new Observer(this)));
        this.worth = worth;
        wallet = 0;
        carHold = new Storage();
    }

    public void addManufacturer(Manufacturer child) {
        children.add(child);
    }

    public void addFactory(CarFactory factory) {
        factories.add(factory);
    }

    public void addDealership(Dealership in) {
        dealerships.add(in);
    }

    /**All factories create vehicles with a color specified.
     * 
     * @param color color of the vehicle to produce
     */
    public void produce(Color color) {
        for (CarFactory factory : factories) {
            carHold.add(factory.produce(color));
        }

        for (Manufacturer item : children) {
            item.produce(color);
        }
    }

    public String getName() {
        return name;
    }

    public List<Manufacturer> getChilds() {
        return children;
    }

    public List<CarFactory> getFactories() {
        return factories;
    }

    public Storage getCarHold() {
        return carHold;
    }

    /**Returns true if the Manufacturer is a child.
     * 
     * @return
     */
    public boolean isChild() {
        if (parent == null) {
            return false;
        } else {
            return true;
        }
    }

    public void addChild(Manufacturer child) {
        children.add(child);
    }

    public int getWallet() {
        return wallet;
    }

    public int getWorth() {
        return worth;
    }

    public void addParent(Manufacturer parent) {
        this.parent = parent;
    }

    public Manufacturer getParent() {
        return parent;
    }

    public void addToWallet(int price) {
        wallet += price;
    }

    /**Sends "customers" to every dealer with random values to purchase.
     * 
     * @return
     */
    public int sell() {
        int count = 0;
        Random ran = new Random();
        for (Dealership i : dealerships) {
            if (i.sell(CarType.getRandomCarType(), 
                    Color.getRandomColor(), ran.nextInt(5000) + 25000)) {
                count++;
            }
        }

        return count;
    }

    /**Gives the ability for Manufacturers to purchase others they can afford.
     * 
     * @param target The manufacturer that will be purchased
     */
    public void buy(Manufacturer target) {
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

    private void updateObservers(Manufacturer target) {
        for (Dealership i : dealerships) {
            i.updateObservers(target);
        }        
    }

    public boolean owns(Manufacturer target) {
        return children.contains(target);
    }

    /**Restocks all of the dealerships. 
     */
    public void restock() {
        for (Dealership i : dealerships) {
            i.restock();
        }        
    }
}
