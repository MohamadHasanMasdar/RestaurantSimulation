package org.example;

import org.example.Enums.CookStates;

public class CookSynchronizedImpl extends Thread {

    private CookStates state;
    private String customerName;

    public CookSynchronizedImpl(String customerName){
        this.customerName = customerName;
    }

    public void run() {
        starting();
    }

    private void starting() {
        state = CookStates.starting;
        System.out.println("cook situation: "+ state.name() + " for " + customerName);
        receiveOrder();
    }

    public void receiveOrder() {
        state = CookStates.receivedOrder;
        System.out.println("cook situation: "+ state.name() + " for " + customerName);
        startCooking();
    }

    public void startCooking() {
        state = CookStates.startedFood;
        System.out.println("cook situation: " + state.name() + " for " + customerName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("cook cannot cooking now");
        }

        state = CookStates.finishedFood;
        System.out.println("cook situation: " + state.name() + " for " + customerName);
    }
}
