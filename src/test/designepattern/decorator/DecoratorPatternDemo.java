package test.designepattern.decorator;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 1:21
 * 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
 * 这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 * 我们通过下面的实例来演示装饰器模式的用法。其中，我们将把一个形状装饰上不同的颜色，同时又不改变形状类。
 * 介绍
 * 意图：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承随着扩展功能的增多，子类会很膨胀。
 * 何时使用：在不想增加很多子类的情况下扩展类。
 * 如何解决：将具体功能职责划分，同时继承装饰者模式。
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

//        System.out.println("Circle with normal border");
        circle.draw();

//        System.out.println("\nCircle of red border");
        redCircle.draw();

//        System.out.println("\nRectangle of red border");
        redRectangle.draw();

    }
}
