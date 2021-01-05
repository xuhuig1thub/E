package test.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-04 18:18
 */
public class Volatile1 extends Thread  {


   volatile  int x = 0; //此处可以将volatile去除 或者 替换为 static，经过对比可看出volatile的作用


    private void write() {
        x = 5;
    }


    private void read() {
        while (x != 5) {
        }
        if(x == 5){
            System.out.println("------stoped");
        }
    }


    public static void main(String[] args) throws Exception {
        Volatile1 example = new Volatile1();


        Thread writeThread = new Thread(new Runnable() {
            public void run() {
                example.write();
            }
        });


        Thread readThread = new Thread(new Runnable() {
            public void run() {
                example.read();
            }
        });


        readThread.start();


        TimeUnit.SECONDS.sleep(5); //记住此处一定要暂停5秒，以保证writeThread一定会在readThread中执行
        System.out.println("------");
        writeThread.start(); }}