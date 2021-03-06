package Mediator;

import Composite.*;
import Factory.*;
import Observer.Observer;
import java.util.Random;


public class Mediator {
    Manufacturer ford;
    Manufacturer tesla;
    Manufacturer dodge;

    /**Creates 3 different manufacturers to control.
     */
    public Mediator() {
        ford = new Manufacturer(CarType.TRUCK, "Ford", 24000, 400000);
        tesla = new Manufacturer(CarType.HYBRID, "Tesla", 40000, 400000);
        dodge = new Manufacturer(CarType.TRUCK, "Dodge", 24000, 400000);
    }

    /**Produces 30 vehicles for each manufacturer.
     */
    public void populate() {
        for (int i = 0; i < 30; i++) {
            ford.produce(Color.getRandomColor());
            tesla.produce(Color.getRandomColor());
            dodge.produce(Color.getRandomColor());
        }

        ford.restock();
        dodge.restock();
        tesla.restock();        
    }

    /**Runs a rudimentary simulation of a monopoly type game with the three manufacturers.
     * 
     * @return
     */
    public String run() {
        int i = 0;
        String winner = new String();
        Random ran = new Random();
        while (winner.equals("")) {
            System.out.println("Tick " + i + "\n"); //one iteration through the loop is a tick
            
            if (i % 20 == 10) {
                System.out.println("All manufacturers built factories");
                ford.addFactory(new CarFactory(ran.nextInt(10000) 
                        + 20000, CarType.getRandomCarType()));
                tesla.addFactory(new CarFactory(ran.nextInt(10000) 
                        + 20000, CarType.getRandomCarType()));
                dodge.addFactory(new CarFactory(ran.nextInt(10000) 
                        + 20000, CarType.getRandomCarType()));
            }

            if (i % 20 == 0  && i != 0) {
                System.out.println("All manufacturers built dealerships");
                ford.addDealership(new Dealership(ford.getCarHold(), new Observer(ford)));
                tesla.addDealership(new Dealership(tesla.getCarHold(), new Observer(tesla)));
                dodge.addDealership(new Dealership(dodge.getCarHold(), new Observer(dodge)));
            }

            if (i % 2 == 0) {
                System.out.println("Ford sold " + ford.sell() + " vehicles");
                System.out.println("Tesla sold " + tesla.sell() + " vehicles");
                System.out.println("Dodge sold " + dodge.sell() + " vehicles");
            }

            if (i % 2 == 1) {
                ford.produce(Color.getRandomColor());
                tesla.produce(Color.getRandomColor());
                dodge.produce(Color.getRandomColor());
            }

            if (ford.getWallet() >= dodge.getWorth() && !dodge.isChild()) {
                if (tesla.getWallet() >= dodge.getWorth()) {
                    if (ran.nextInt(20) > 10) {
                        ford.buy(dodge);
                    } else {
                        tesla.buy(dodge);
                    }
                }
            } else if (tesla.getWallet() >= dodge.getWorth() && !dodge.isChild()) {
                tesla.buy(dodge);
            }


            if (dodge.getWallet() >= ford.getWorth() && !ford.isChild()) {
                if (tesla.getWallet() >= ford.getWorth()) {
                    if (ran.nextInt(20) > 10) {
                        dodge.buy(ford);
                    } else {
                        tesla.buy(ford);
                    }
                }
            } else if (tesla.getWallet() >= ford.getWorth() && !ford.isChild()) {
                tesla.buy(ford);
            }


            if (ford.getWallet() >= tesla.getWorth() && !tesla.isChild()) {
                if (dodge.getWallet() >= tesla.getWorth()) {
                    if (ran.nextInt(20) > 10) {
                        ford.buy(tesla);
                    } else {
                        dodge.buy(tesla);
                    }
                }
            } else if (dodge.getWallet() >= tesla.getWorth() && !tesla.isChild()) {
                dodge.buy(tesla);
            }

            if (ford.owns(dodge) && ford.owns(tesla)) {
                winner = ford.getName();
            } else if (dodge.owns(ford) && dodge.owns(tesla)) {
                winner = dodge.getName();
            } else if (tesla.owns(ford) && tesla.owns(dodge)) {
                winner = tesla.getName();
            }

            ford.restock();
            dodge.restock();
            tesla.restock();
            i++;
        }
        return winner;
    }
}
