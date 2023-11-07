package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public interface Restaurant {

    int maximumCapacity = 2;

    public void increaseCurrentCustomers();
    public void decreaseCurrentCustomers();
    public boolean hasRestaurantEnoughCapacity();
}
