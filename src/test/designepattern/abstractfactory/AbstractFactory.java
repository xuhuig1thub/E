package test.designepattern.abstractfactory;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:30
 */
public abstract class AbstractFactory {
    abstract Shape getShape(String shape);
    abstract Color getColor(String color);
}