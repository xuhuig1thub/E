package test.juc.waitnotify1;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 1:15
 */
public class MyObj {
    private int counter;

    public synchronized void increase() {
        System.out.print("incr  ");
        while (counter > 0) {
            System.out.print("incr-wait  " );
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        counter++;
        System.out.print(counter+"  ");
        notify();
    }

    public synchronized void decrease() {
        System.out.print("decr  ");
        while (counter == 0) {
            System.out.print("decr-wait  ");
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        counter--;
        System.out.print(counter+"  ");
        notify();
    }


    public static void main(String[] args) {
        MyObj myObj = new MyObj();

        Thread increaseThread = new IncreaseThread(myObj);
        Thread decreaseThread = new DecreaseThread(myObj);
        Thread increaseThread2 = new IncreaseThread(myObj);
        Thread decreaseThread2 = new DecreaseThread(myObj);
        Thread increaseThread3 = new IncreaseThread(myObj);
        Thread decreaseThread3 = new DecreaseThread(myObj);

        increaseThread.start();
        decreaseThread.start();
        increaseThread2.start();
        decreaseThread2.start();
        increaseThread3.start();
        decreaseThread3.start();
    }

}
