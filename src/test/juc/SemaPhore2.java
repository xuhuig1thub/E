package test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2021-01-05 19:26
 * Semaphore（信号量）控制共享资源的并发访问线程数。
 */
public class SemaPhore2 {

    private static final int THREAD_COUNT = 30;
      private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
      private static Semaphore semaphore = new Semaphore(10);
      public static void main(String[] args){
                 for (int i = 0; i < THREAD_COUNT; i++){
                        threadPool.execute(() ->{

                                      try {
                                                semaphore.acquire();
                                               System.out.println(Thread.currentThread().getName() + ":Save data");
                                               Thread.currentThread().sleep(1000);
                                                 semaphore.release();
                                          }catch (InterruptedException e){

                                        }
            });
                  }
                threadPool.shutdown();
           }
}
