package test.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 2:24
 */
public class CyclicBarrier1 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("summon the dragon");
        });

        for(int i=1;i<=16;i++)
        {   final int temInt=i;
            new Thread(()->{

                System.out.println(Thread.currentThread().getName()+"----"+temInt);
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"--");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
