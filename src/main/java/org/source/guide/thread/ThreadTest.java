package org.source.guide.thread;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new RunableTarget());
        thread1.start();
        Thread.sleep(3000);
        thread1.interrupt();
        Thread.currentThread().join();
    }
}

class RunableTarget implements Runnable{
    static int i = 0;
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + "测试" + (i++));
            try {
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().isInterrupted());

                Thread.sleep(1000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().isInterrupted());

            }
            if(Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " isInterrupted");
                break;
            }
        }
    }
}
