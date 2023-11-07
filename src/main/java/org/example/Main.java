package org.example;

public class Main {


    public static Customer customer1, customer2, customer3;
    public static void main(String[] args) {

        customer1 = new Customer("c1");
        customer2 = new Customer("c2");
        customer3 = new Customer("c3");

        customer1.start();
        customer2.start();
        customer3.start();
//        customer.join();
    }
}