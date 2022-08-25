package org.source.guide.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(()->{
            try {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("ss");
                }
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":start");
            try {
                Thread.sleep(300l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":end");
            lock.unlock();

        },"thred1");
        thread1.start();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+":start");
            try {
                Thread.sleep(300l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":end");
            lock.unlock();

        },"thred2").start();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+":start");
            try {
                Thread.sleep(300l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":end");
            lock.unlock();

        },"thred3").start();


        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+":start");
            try {
                Thread.sleep(300l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":end");
            lock.unlock();

        },"thred4").start();


        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+":start");
            try {
                Thread.sleep(300l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":end");
            lock.unlock();

        },"thred5").start();
        thread1.interrupt();

    }
}
