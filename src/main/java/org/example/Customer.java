package org.example;

import org.example.Enums.CustomerStates;

public class Customer extends Thread{

    private CustomerStates state;
    private String name;
    private Restaurant restaurant = new RestaurantWithAtomicImpl();


    public Customer(String name){
        this.name = name;
    }

    public void run() {
        movingToRestaurant();
    }

    private void movingToRestaurant() {
        state = CustomerStates.starting;
        System.out.println(name + " is " + state.name());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(name + " cant move right now");
        }

        enterToRestaurant();
    }

    public void enterToRestaurant(){
        state = CustomerStates.entered;
        System.out.println(name + " is " + state.name());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(name + " cant enter to restaurant right now");
        } finally {
            orderFood();
        }
    }

    public void orderFood() {

        if (restaurant.hasRestaurantEnoughCapacity()) {
            restaurant.increaseCurrentCustomers();
            state = CustomerStates.placedOrder;
            System.out.println(name + " is " + state.name());
//            CookSynchronizedImpl cook = new CookSynchronizedImpl(name);

            try {
                cook.start();
                cook.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                eatingFood();
            }
        } else {
            System.out.println("sorry! there is not enough space for " + name);
        }
    }

    public void eatingFood() {
        state = CustomerStates.receivedOrder;
        System.out.println(name + " is " + state.name() + " and start to eat");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println(name + " cant eat food right now");
        } finally {
            leaving();
        }
    }

    public void leaving(){
        state = CustomerStates.leaving;
        System.out.println(name + " is " + state.name());
        restaurant.decreaseCurrentCustomers();
    }
}
