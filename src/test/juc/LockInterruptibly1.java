package test.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 19:41
 */
public class LockInterruptibly1 {
    private Lock lock = new ReentrantLock();

    public void doBussiness() {
        String tName = Thread.currentThread().getName();

        try {
            System.out.println(tName + " 开始获取锁");
            lock.lockInterruptibly();//可以让线程在等待锁的时候就响应interrupt(),而普通的lock.lock()必须要线程得到锁后才能响应interrupt()
//            lock.lock();
            System.out.println(tName + " 得到锁");
            System.out.println(tName + " 开工干活");
            for (int i=0; i<5; i++) {
                Thread.sleep(1000);
                System.out.println(tName + " : " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(tName + " 被中断");
        } finally {
            try {
                lock.unlock();
                System.out.println(tName + " 释放锁");
            } catch (Exception e) {
                System.out.println(tName + " : 没有得到锁的线程运行结束");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        LockInterruptibly1 l = new LockInterruptibly1();

        Thread t0 = new Thread(
                new Runnable() {
                    public void run() {
                        l.doBussiness();
                    }
                }
        );

        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        l.doBussiness();
                    }
                }
        );

        // 启动线程t1
        t0.start();
        Thread.sleep(10);
        // 启动线程t2
        t1.start();
        Thread.sleep(100);
        // 线程t1没有得到锁，中断t1的等待
        t1.interrupt();
    }
}
