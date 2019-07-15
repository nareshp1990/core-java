package com.naresh.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private ReentrantLock implicitLock = new ReentrantLock();
    private String name;
    private Double balance = 10000.0;

    public ReentrantLock getImplicitLock() {
        return implicitLock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean debit(double amount){

        if (amount>balance){
            System.out.println(Thread.currentThread().getName() + " :: " +name + " says ::"+ amount + " grater than current balance" );
            return false;
        }
        this.balance = this.balance - amount;
        System.out.println(Thread.currentThread().getName() + " :: " + name + " says ::"+ amount + " Debited Successfully" );
        return true;

    }

    public void credit(double amount){

        this.balance = this.balance + amount;
        System.out.println(Thread.currentThread().getName() + " :: " + name + " says ::"+ amount + " Credited Successfully" );

    }

}
