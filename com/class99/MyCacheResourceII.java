package com.class99;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Method 2: use lock, await and signal
public class MyCacheResourceII {
    int num = 0;
    int count = 0;
    int capacity = 5;

    Lock lock = new ReentrantLock();
    // create 2 condition array to notify
    Condition productCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();

    // produce method
    public void product() {
        lock.lock();
        // check if needs to be wait
        try {
            while (count == capacity) {
                productCondition.await();
            }
            num++;
            count++;
            System.out.println(Thread.currentThread().getName()+
            " produce a number " + num + "，rest number in thread poll："+count);
            // await consumer condition
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void consume() {
        lock.lock();
        try {
            // check if consumer needs to wait
            while (count == 0) {
                consumerCondition.await();
            }

            // work
            num--;
            count--;
            System.out.println(Thread.currentThread().getName()+
            " consume a number " + num + "，rest number in thread poll："+count);
            productCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
