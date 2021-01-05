package test.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 20:00
 */
public class TryLock1 {

    public static void main(String[] args) {

        System.out.println("开始");
        final Lock lock = new ReentrantLock();
        new Thread() {
            @Override
            public void run() {
                String tName = Thread.currentThread().getName();
                if (lock.tryLock()) {
                    System.out.println(tName + "获取到锁！");
                } else {
                    System.out.println(tName + "获取不到锁！");
                    return;
                }
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        System.out.println(tName + ":" + i);
                    }
                } catch (Exception e) {
                    System.out.println(tName + "出错了！！！");
                } finally {
                    System.out.println(tName + "释放锁！！");
                    lock.unlock();
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                String tName = Thread.currentThread().getName();

                try {
                    if (lock.tryLock(6L, TimeUnit.SECONDS)) {
                        System.out.println(tName + "获取到锁！");
                    } else {
                        System.out.println(tName + "获取不到锁！");
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(tName + ":" + i);
                    }

                } catch (Exception e) {
                    System.out.println(tName + "出错了！！！");
                } finally {
                    System.out.println(tName + "释放锁！！");
                    lock.unlock();
                }
            }
        }.start();

        System.out.println("结束");
    }
}
