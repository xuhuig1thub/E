package test.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 14:17
 */
public class Executors1 {
     int num =10;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executors1 e=new Executors1();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + " is running..."+e.num++);
            });
        }
        FutureTask<Integer> futureTask=new FutureTask<Integer>(()->{
            return ++e.num;
        });
        for (int i = 0; i < 5; i++) {
            executorService.execute(futureTask);
            System.out.println("futureTask.get()="+futureTask.get());
        }

        executorService.shutdown();
    }

}
