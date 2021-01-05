package test.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2021-01-05 22:09
 */
public class AtomicInteger1 {
    public static void main(String[] args) throws InterruptedException {
        IntegerTest();
        AtomicIntegerTest();
    }
    private static void IntegerTest() throws InterruptedException {

        final Integer[] noncasi = new Integer[]{ 0 };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        noncasi[0]++;
                    }
                }
            });
            thread.start();
        }

        while (Thread.activeCount() > 2) {
            Thread.sleep(10);
        }
        System.out.println(noncasi[0]);
    }
    private static void AtomicIntegerTest() throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(0);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        atomicInteger.getAndIncrement();
                    }
                }
            });
            thread.start();
        }
        while (Thread.activeCount() > 2) {
            Thread.sleep(10);
        }
        System.out.println(atomicInteger.get());
    }
}
