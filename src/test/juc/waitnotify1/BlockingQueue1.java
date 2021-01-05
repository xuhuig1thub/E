package test.juc.waitnotify1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 3:50
 */
public class BlockingQueue1 {
    private  int num=1;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        while(num>0){
            condition.await();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"\t  "+num);
        condition.signal();
        lock.unlock();
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        while(num==0){
            condition.await();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"\t  "+num);
        condition.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        BlockingQueue1 p=new BlockingQueue1();
        for (int i=0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t  "+"**");
                try {
                    p.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


        for (int i=5;i<10;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t  "+"**");
                try {
                    p.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }


}
