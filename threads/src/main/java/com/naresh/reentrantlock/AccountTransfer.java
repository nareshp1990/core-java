package com.naresh.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class AccountTransfer {

    private ReentrantLock lock = new ReentrantLock();

    public void transfer(Account from,Account to,Double amount) {
        boolean transfer = false;
        try {
            if(lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " says accuire lock");
                boolean flag = from.debit(amount);
                if(flag)
                {
                    to.credit(amount);
                }
                System.out.println(Thread.currentThread().getName()+ " :: " + from.getName() + " says :: now balance is " + from.getBalance());
                System.out.println(Thread.currentThread().getName()+ " :: " + to.getName() + " says :: now balance is " + to.getBalance());
                transfer = true;
            }
            else {
                System.out.println(Thread.currentThread().getName() + " says fail to accuire both lock Try again");
                transfer(from,to,amount);//try again
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if(transfer) {
                lock.unlock();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Account from = new Account();
        from.setBalance(20000.0);
        from.setName("Shamik Mitra");

        Account to = new Account();
        to.setName("Samir Mitra");

        AccountTransfer transfer = new AccountTransfer();

        Runnable a = ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            transfer.transfer(from,to,200.0);
            System.out.println(Thread.currentThread().getName() +" says :: Transfer successful");
        };

        Runnable b = ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            transfer.transfer(to,from,1000.0);
            System.out.println(Thread.currentThread().getName() +" says :: Transfer successful");
        };

        for (int i=0; i<4; i++){
            executorService.submit(a);
            executorService.submit(b);
        }

    }

}
