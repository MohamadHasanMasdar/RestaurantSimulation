package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RestaurantWithLockImpl implements Restaurant {

    private int currentCustomers = 0;

    public static Lock restaurantCapacityLock = new ReentrantLock();

    @Override
    public void increaseCurrentCustomers() {
        restaurantCapacityLock.lock();
        currentCustomers++;
        System.out.println("restaurant current customers number is " + currentCustomers);
        restaurantCapacityLock.unlock();
    }

    @Override
    public void decreaseCurrentCustomers() {
        restaurantCapacityLock.lock();
        currentCustomers--;
        System.out.println("restaurant current customers number is " + currentCustomers);
        restaurantCapacityLock.unlock();
    }

    @Override
    public boolean hasRestaurantEnoughCapacity() {
        restaurantCapacityLock.lock();
        boolean result = true;
        if (currentCustomers >= maximumCapacity)
            result = false;
        restaurantCapacityLock.unlock();

        return result;
    }
}
