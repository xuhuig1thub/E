package test.dynamicproxy;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-12 21:55
 */
public class Bye implements ByeInterface {
    @Override
    public void sayBye() {
        System.out.println("Bye zhanghao!");
    }
}
