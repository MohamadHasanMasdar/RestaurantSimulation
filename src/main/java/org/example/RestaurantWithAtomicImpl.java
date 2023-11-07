package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantWithAtomicImpl implements Restaurant {

    public static AtomicInteger currentCustomers = new AtomicInteger(0);
    public static final AtomicInteger maximumCapacity = new AtomicInteger(Restaurant.maximumCapacity);

    @Override
    public void increaseCurrentCustomers() {
        currentCustomers.getAndIncrement();
        System.out.println("restaurant current customers number is " + currentCustomers);
    }

    @Override
    public void decreaseCurrentCustomers() {
        currentCustomers.getAndDecrement();
        System.out.println("restaurant current customers number is " + currentCustomers);
    }

    @Override
    public boolean hasRestaurantEnoughCapacity() {
        boolean result = true;
        if (currentCustomers.get() >= maximumCapacity.get()) {
            System.out.println("current: " + currentCustomers.get() + " && " + " max: " + maximumCapacity.get());
            result = false;
        }

        return result;
    }
}
