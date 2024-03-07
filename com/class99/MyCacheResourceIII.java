package com.class99;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// method 3: use blocking queue
public class MyCacheResourceIII {
    private BlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
    // add resource to the pool
    public void add() throws InterruptedException {
    
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            blockingQueue.put(1);
            System.out.println("Product "+Thread.currentThread().getName()+
                    " produce a resource，current thread pool has "+blockingQueue.size()+" threads");
        
    }

    public void remove() {
        try {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object take = blockingQueue.take();
            System.out.println("Product "+Thread.currentThread().getName()+
                    " produce a resource，current thread pool has "+blockingQueue.size()+" threads");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyCacheResourceIII myCacheIII = new MyCacheResourceIII();
        for (int i = 1; i <= 5 ; i++) {
            new Thread(()->{
                while(true){
                    try {
                        myCacheIII.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 2 ; i++) { // 2 consumer
            new Thread(()->{
                while (true){//循环消费
                    myCacheIII.remove();
                }
            },String.valueOf(i)).start();
        }

    }
}
