package org.source.guide.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[500];
        for(int i=0;i<500;i++){
            threads[i] = new Thread(new TestRunnable());
        }
        for(int i=0;i<500;i++){
            threads[i].start();
        }
        for(int i=0;i<500;i++){
            threads[i].join();
        }
        System.out.println("线程：" + (System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0;i<500;i++) {
            executorService.execute(()->{
                for(int j =0;j<1000;j++){
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("线程池：" + (System.currentTimeMillis() - start1));


    }
}

class TestRunnable implements Runnable{

    @Override
    public void run() {
        for(int i =0;i<1000;i++){
        }
    }
}
