package test.juc;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 2:44
 */
public class SemaPhore1 {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);

    new Thread(()->{
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"acquire");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"release");
            semaphore.release();
        }

    },String.valueOf(1)).start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"acquire");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+"release");
                semaphore.release();
            }

        },String.valueOf(2)).start();


        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"acquire");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+"release");
                semaphore.release();
            }

        },String.valueOf(3)).start();

        for (int i=4;i<7;i++)
        {
            final int tempInt=i;
            new Thread(()->{

                System.out.println("********"+tempInt);
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"acquire");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName()+"release");
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }

    }
}
