package test.designepattern.Builder;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:38
 */
public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }

}
