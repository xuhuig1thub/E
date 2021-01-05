package test.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 3:05
 */
public class BlockingQueue1 {
   static  ReentrantLock lock=new ReentrantLock();
   static Condition condition1=lock.newCondition();
   static Condition condition2=lock.newCondition();
    public static void main(String[] args) throws InterruptedException {

//        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);

//        addAndRemove(blockingQueue);
//        offer(blockingQueue);
//        offer_time(blockingQueue);
        putTake(blockingQueue);
//        testSynchrononusQueue();
    }

    private static void testSynchrononusQueue() {
        SynchronousQueue<String> SynchronousQueue=new SynchronousQueue<String>();
//        new Thread(()->{
//            System.out.println(SynchronousQueue.add("1"));
//            System.out.println(Thread.currentThread().getName()+"\t add 1");
//            System.out.println(SynchronousQueue.add("2"));
//            System.out.println(Thread.currentThread().getName()+"\t add 2");
//            System.out.println(SynchronousQueue.add("3"));
//            System.out.println(Thread.currentThread().getName()+"\t add 3");
//        },"A").start();

//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+"\t offer 1");
//            System.out.println(SynchronousQueue.offer("1"));
//            System.out.println(Thread.currentThread().getName()+"\t offer 2");
//            System.out.println(SynchronousQueue.offer("2"));
//            System.out.println(Thread.currentThread().getName()+"\t offer 3");
//            System.out.println(SynchronousQueue.offer("3"));
//        },"A").start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                SynchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                SynchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                SynchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println( Thread.currentThread().getName()+"= " + SynchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println( Thread.currentThread().getName()+"= " + SynchronousQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println( Thread.currentThread().getName()+"= " + SynchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }


    private static void addAndRemove(BlockingQueue<String> blockingQueue) {
        for (int i=1;i<4;i++){
            final int tempInt=i;
            new Thread(()->{
                System.out.print(blockingQueue.add(tempInt+"--"));
                System.out.println(Thread.currentThread().getName()+"---"+tempInt);
            },String.valueOf(tempInt)).start();
        }
        for (int i=1;i<4;i++){
            final int tempInt=i;
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread"+Thread.currentThread().getName()+"--blockingQueue.element() = " + blockingQueue.element());
                System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
            },String.valueOf(tempInt)).start();
        }
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("x"));

//        System.out.println("blockingQueue.element() = " + blockingQueue.element());
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
    }

    private static void offer(BlockingQueue<String> blockingQueue) {
        for (int i=1;i<7;i++){
            final int tempInt=i;
            new Thread(()->{
                System.out.println("blockingQueue.remainingCapacity() = " + blockingQueue.remainingCapacity());


                    System.out.print(blockingQueue.offer(tempInt + "--"));
                    System.out.println(Thread.currentThread().getName() + "---" + tempInt);

            },String.valueOf(tempInt)).start();
        }

        for (int i=1;i<7;i++){
            final int tempInt=i;
            new Thread(()->{


                    System.out.println("thread"+Thread.currentThread().getName()+"--blockingQueue.remainingCapacity() = " + blockingQueue.remainingCapacity());

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"--blockingQueue.peek() = " + blockingQueue.peek());
                    System.out.println("blockingQueue.remove() = " + blockingQueue.poll());



            },String.valueOf(tempInt)).start();
        }



        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));
        System.out.println("blockingQueue.peek() = " + blockingQueue.peek());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
    }

    private static void offer_time(BlockingQueue<String> blockingQueue) throws InterruptedException {
        System.out.println(blockingQueue.offer("a", 3, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 3, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 3, TimeUnit.SECONDS));
        new Thread(()->{
            System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        },String.valueOf("new")).start();
        System.out.println(blockingQueue.offer("x", 1, TimeUnit.SECONDS));
        System.out.println("blockingQueue.peek() = " + blockingQueue.peek());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
    }


    private static void putTake(BlockingQueue<String> blockingQueue) throws InterruptedException {

        for (int i=1;i<7;i++){
            final int tempInt=i;
            new Thread(()->{
                System.out.println("putthread"+Thread.currentThread().getName()+"--blockingQueue.remainingCapacity() = " + blockingQueue.remainingCapacity());
                try {
                    blockingQueue.put(tempInt + "--");
                    System.out.println(Thread.currentThread().getName() + "---put" + tempInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },String.valueOf(tempInt)).start();
        }

        for (int i=7;i<13;i++){
            final int tempInt=i;
            new Thread(()->{
                System.out.println("takethread"+Thread.currentThread().getName()+"--blockingQueue.remainingCapacity() = " + blockingQueue.remainingCapacity());
                try {
                    System.out.println("blockingQueue.take( ) = " + blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },String.valueOf(tempInt)).start();
        }



//        try {
//            blockingQueue.put("a");
//            blockingQueue.put("b");
//            blockingQueue.put("c");
//            blockingQueue.put("x");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }





}
