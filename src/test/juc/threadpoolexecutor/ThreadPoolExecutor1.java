package test.juc.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 17:24
 */
public class ThreadPoolExecutor1 {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 30;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(30),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 1; i <=100; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable runnable =  new MyRunnable("" + i);
            //执行Runnable
            executor.execute(runnable);
            System.out.println("***"+i);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }



}

