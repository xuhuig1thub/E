package test.designepattern.state;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 1:55
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }

}
