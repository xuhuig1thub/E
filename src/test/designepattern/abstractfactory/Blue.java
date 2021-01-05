package test.designepattern.abstractfactory;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:30
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fille() method.");
    }
}
