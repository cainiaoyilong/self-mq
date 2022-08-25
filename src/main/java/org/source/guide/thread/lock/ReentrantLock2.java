package org.source.guide.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReentrantLock2 implements Lock {

    private Sync sync;

    public ReentrantLock2(){
        sync = new Sync();
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            int state = super.getState();
            Thread current = Thread.currentThread();
            if(state == 0){
                if(super.compareAndSetState(0,arg)){
                    super.setExclusiveOwnerThread(current);
                    return true;
                }
            }
            if(current == super.getExclusiveOwnerThread()){
                int ns = state + arg;
                setState(ns);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            Thread current = Thread.currentThread();
            if(current != super.getExclusiveOwnerThread()){
                return false;
            }
            int state = super.getState();
            int ns = state - arg;
            boolean free = false;
            if(ns ==0){
                free = true;
                this.setExclusiveOwnerThread(null);
            }
            setState(ns);
            return free;
        }
    }
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
