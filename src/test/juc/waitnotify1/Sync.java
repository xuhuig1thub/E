package test.juc.waitnotify1;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 1:47
 * 多个线程访问同一个类的synchronized方法时, 都是串行执行的 ! 就算有多个cpu也不例外 ! synchronized方法使用了类java的内置锁,
 * 即锁住的是方法所属对象本身. 同一个锁某个时刻只能被一个执行线程所获取, 因此其他线程都得等待锁的释放. 因此就算你有多余的cpu可以执行,
 * 但是你没有锁, 所以你还是不能进入synchronized方法执行,如果某个线程长期持有一个竞争激烈的锁,
 * 那么将导致其他线程都因等待所的释放而被挂起, 导致CPU利用率低, 因此尽量避免单个线程对锁的长期占有 !
 */
public class Sync {
    public synchronized void A() {
        System.out.println("A");
        try {
            Thread.currentThread().sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void B() {
        System.out.println("B");
    }

    public static void main(String[] args) throws Exception {
        Sync s=new Sync();
        new Thread(){
            @Override
            public void run() {
                s.A();
            }
        }.start();
        Thread.currentThread().sleep(2000);
        new Thread(){
            @Override
            public void run() {
                s.B();
            }
        }.start();
    }
}

