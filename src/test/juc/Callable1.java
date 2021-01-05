package test.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 13:25
 */
public class Callable1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable=()->{
            System.out.println(Thread.currentThread().getName()+"*******come in callable");
            TimeUnit.SECONDS.sleep(3);
            return 1024;
        };
        Callable<Integer> callableC=()->{
            System.out.println(Thread.currentThread().getName()+"*******come in callable");
            TimeUnit.SECONDS.sleep(3);
            return 1024;
        };

        FutureTask<Integer> futureTask=new FutureTask<>(callable);
        FutureTask<Integer> futureTaskC=new FutureTask<>(callableC);
        Thread t1=new Thread(futureTask,"A");
        Thread t2=new Thread(futureTask,"B");
        Thread t3=new Thread(futureTaskC,"C");
        t1.start();
        t2.start();
        t3.start();
        int result01=100;
        System.out.println("++++");
        int result02=futureTask.get();
        int result03=futureTaskC.get();
        System.out.println("*****result:"+(result01+result02)+"----"+result03);
    }
}
