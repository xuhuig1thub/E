package test.juc.waitnotify1;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-10 1:22
 */
public class IncreaseThread extends Thread {

    private MyObj myObj;

    public IncreaseThread(MyObj myObj) {
        this.myObj = myObj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; ++i) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            myObj.increase();
        }
    }
}
