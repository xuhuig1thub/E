package test.designepattern.factory;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:25
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}