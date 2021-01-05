package test.designepattern.abstractfactory;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:29
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fille() method.");
    }
}
