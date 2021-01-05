package test.designepattern.Builder;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:38
 */
public class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }

}
