package test.juc.threadpoolexecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-26 1:45
 */
public class Compare_Syn_CAS {

    public static final int THREAD_SIZE = 100;
    public static final long TIMES = (long)1e7;
    public static final Object lock = new Object();
    public static AtomicLong cnt1 = new AtomicLong(0);
    public static long cnt2 = 0L;

    public static void CountCAS() throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZE);
        long start = System.currentTimeMillis();

        for (int i = 0; i < THREAD_SIZE; i ++) {
            executorService.submit(() -> {
                for (long j = 0; j < TIMES; j ++) cnt1.getAndIncrement();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void CountSyn() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZE);
        long start = System.currentTimeMillis();

        for (int i = 0; i < THREAD_SIZE; i ++) {
            executorService.submit(() -> {
                for (long j = 0L; j < TIMES; j ++) {
                    synchronized (lock) {
                        cnt2++;
                    }
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) throws InterruptedException {
        CountCAS();
        System.out.println("============");
        CountSyn();
    }
}