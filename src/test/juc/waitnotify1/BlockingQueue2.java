package test.juc.waitnotify1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 13:01
 */
public class BlockingQueue2 {
    private volatile boolean FLAG=true;
    private AtomicInteger atomicInteger =new AtomicInteger();
    BlockingQueue<String> blockingQueue;

    public BlockingQueue2(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data=null;
        boolean succ;
        while(FLAG){
            data =atomicInteger.incrementAndGet()+"";
            succ=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(succ){
                System.out.println("insert "+data+" success");
            }else{
                System.out.println("insert "+data+" fail");
            }
            TimeUnit.SECONDS.sleep(1);
//            TimeUnit.SECONDS.sleep(5);
        }
        System.out.println(Thread.currentThread().getName()+"\t STOP ,the BOSS called FLAG=false");
    }

    public void myConsumer() throws Exception{
        String result=null;
        while(FLAG){
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase("")){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"\t no cake ,exiting");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t consuming queue"+result+"  success");
        }
    }
    private void stop() {
    FLAG=false;
    }

    public static void main(String[] args) {
        BlockingQueue2 b=new BlockingQueue2(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t  prod thread launched success");
            try {
                b.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t consuming thread launched success");

            try {
                b.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"sonsumer").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t  prod thread launched success");
            try {
                b.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod2").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t consuming thread launched success");
            try {
                b.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"sonsumer2").start();


        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println();
            System.out.println();
            System.out.println("5 SECONGS expired");
            b.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
