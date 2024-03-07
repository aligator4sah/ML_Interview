package com.class99;

import java.util.concurrent.TimeUnit;

// Method 1: use synchronized, wait and notify
public class MyCacheResourceI {
    int num = 0; // shared resources
    // actual thread number in thread pool
    private int count = 0;
    //allowed thread number
    private int capacity = 5;
    
    Object obj= new Object();

    // producer
    public void produce() throws InterruptedException {
        synchronized(obj) {
            // check when to wait
            if (count == capacity) {
                obj.wait();
            }
            // work
            num++;
            count++;
            System.out.println(Thread.currentThread().getName()+
            " produce a number " + num + "，rest number in thread poll："+count);
            //notify other thread to compete for the lock
            obj.notifyAll();
        }
    }

    // consumer
    public void consume() throws InterruptedException {
        synchronized(obj) {
            // check if needed to wait
            if (count == 0) {
                obj.wait();
            }
            num--;
            count--;
            System.out.println(Thread.currentThread().getName()+
            " consume a number " + num + "，rest number in thread poll："+count);
            //notify other thread to compete for the lock
            obj.notifyAll();
        }
    }

    public static void main(String[] args) {
        MyCacheResourceI myCache = new MyCacheResourceI();
        // producer
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    myCache.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               
            }
        }, "Producer").start();

        // consumer 1 
        new Thread(()->{
            //let producer produce number first
            for (int i = 1; i <=10 ; i++) {
                try { TimeUnit.SECONDS.sleep(1);}
                catch (InterruptedException e) {e.printStackTrace();}
                try {
                    myCache.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer 1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    myCache.consume();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer 2").start();
    }   
}
