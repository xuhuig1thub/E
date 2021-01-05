package test.designepattern.Builder;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:38
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }

}
